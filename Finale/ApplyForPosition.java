package finale;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApplyForPosition")
public class ApplyForPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplyForPosition() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
            ResultSet rs = stmt.executeQuery( "select distinct(name) from positions" );

            while( rs.next() )
            {
                entries.add( rs.getString("name") );
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
		
		request.getRequestDispatcher( "/WEB-INF/ApplyForPosition.jsp" ).forward(
                request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd HH:mm ");
        String date = dateFormat.format(now);
		
        String[] check = request.getParameterValues( "position" );
        
        if (check == null){
        } else {
			Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
	            String username = "cs320stu61";
	            String password = "yho##wEl";
	            
	            for (String q:check){
		            String sql = "insert into jobs (position, applicant, submitted) values (?, ?, ?)";
		
		            c = DriverManager.getConnection( url, username, password );
		            PreparedStatement pstmt = c.prepareStatement( sql );
		            pstmt.setString( 1, q);
		            pstmt.setString( 2, request.getParameter("name").toString() );
		            pstmt.setString( 3, date );
		            pstmt.executeUpdate();
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
        }
        
		response.sendRedirect( "CSJobs" );
	}

}
