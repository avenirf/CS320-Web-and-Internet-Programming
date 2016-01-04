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


@WebServlet("/EditCourse")
public class EditCourse extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public EditCourse() {
        super();
    }
    
    private CoursePlannerEntry getEntry( String code ) throws ServletException
    {       
        CoursePlannerEntry entry = null;
        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
            String username = "cs320stu61";
            String password = "yho##wEl";

            String sql = "select * from courses where code = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, code );
            ResultSet rs = pstmt.executeQuery();

            if( rs.next() )
                entry = new CoursePlannerEntry( rs.getString( "code" ),
                    rs.getString( "title" ), rs.getString( "pre" ) );
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

        return entry;
    }

	protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {	
		// get the entry to be edited
        String code = String.valueOf( request.getParameter( "code" ) );
        CoursePlannerEntry entry = getEntry( code );

        List<CoursePlannerEntry> enter = new ArrayList<CoursePlannerEntry>();
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
            	CoursePlannerEntry ent = new CoursePlannerEntry( rs.getString( "code" ), 
            			rs.getString( "title" ), rs.getString("pre") );
                enter.add( ent );
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
        
        request.setAttribute( "enter", enter );
        request.setAttribute( "entry", entry );
        request.getRequestDispatcher( "/WEB-INF/EditCourse.jsp" ).forward(
                request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the entry to be edited
        String code = request.getParameter( "code" );
        String code2 = request.getParameter( "code2" );

        // change the entry based on user input
        String[] check = request.getParameterValues( "checkbox" );
        StringBuilder builder = new StringBuilder();
        String title =  request.getParameter( "title" );
        
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
        
        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
            String username = "cs320stu61";
            String password = "yho##wEl";

            String sql = "update courses set code = ?, title = ?, pre = ? where code = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, code2 );
            pstmt.setString( 2, title );
            pstmt.setString( 3, pre );
            pstmt.setString( 4, code );
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
