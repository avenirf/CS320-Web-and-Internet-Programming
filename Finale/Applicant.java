package finale;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/Applicant")
public class Applicant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Applicant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<jobsEntry> entries = new ArrayList<jobsEntry>();
		
		Connection c = null;
        try
        {          
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
        	String username = "cs320stu61";
        	String password = "yho##wEl";
        	
			c = DriverManager.getConnection( url, username, password );
	        Statement stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "select * from jobs ORDER BY applicant" );
	
	        while( rs.next() )
	        {
	        	jobsEntry entry = new jobsEntry( rs.getString( "position" ), 
	         		rs.getString( "applicant" ), rs.getString("submitted") );
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
		request.getRequestDispatcher( "/WEB-INF/CSJobs.jsp" ).forward(
                request, response );
         
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
