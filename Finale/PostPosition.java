package finale;

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

@WebServlet("/PostPosition")
public class PostPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostPosition() {
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
		
		request.getRequestDispatcher( "/WEB-INF/PostPosition.jsp" ).forward(
                request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
			Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
	            String username = "cs320stu61";
	            String password = "yho##wEl";
	            
	            
		        String sql = "insert into positions (name) values (?)";
		
		        c = DriverManager.getConnection( url, username, password );
		        PreparedStatement pstmt = c.prepareStatement( sql );
		        pstmt.setString( 1, request.getParameter("position").toString() );
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
	        
	    	response.sendRedirect( "CSJobs" ); 
        }
}
