package HW3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCourse()
    {
        super();
    }

    @SuppressWarnings({ "unused" })
	protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {	   	   	
    	List<String> entries = new ArrayList<String>();
    	
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
            String username = "cs320stu61";
            String password = "yho##wEl";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from courses" );

            while( rs.next() )
            {
            	String entry = new String( rs.getString("code"));
                entries.add( entry );
            }
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
        
        request.setAttribute( "entries", entries );
    	
        String user = (String) request.getSession().getAttribute( "user" );
        
        request.getRequestDispatcher( "/WEB-INF/AddCourse.jsp" ).forward(
                request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the user input
    	String code = request.getParameter( "code" );
        String title = request.getParameter( "title" );
        String[] check = request.getParameterValues( "checkbox" );
        StringBuilder builder = new StringBuilder();
        
        String pre;
        if (check == null){
        	pre = "";
        }else {
        	for (String prer : check) {
        		if (builder.length() > 0) {
        			builder.append(" ");
        		}
            builder.append(prer);
        	}

        	pre = builder.toString();
        }
        
        // create a new guest book entry
        //CoursePlannerEntry entry = new CoursePlannerEntry( code, title, pre );

        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
            String username = "cs320stu61";
            String password = "yho##wEl";

            String sql = "insert into courses (code, title, pre) values (?, ?, ?)";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, code );
            pstmt.setString( 2, title );
            pstmt.setString( 3, pre );
            pstmt.executeUpdate();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        // send the user back to the guest book page
        response.sendRedirect( "CoursePlanner" );
    }

}