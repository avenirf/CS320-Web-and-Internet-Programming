package HW3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CoursePlanner", loadOnStartup = 0)
public class CoursePlanner extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CoursePlanner()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        
        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        };
    }

	protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
		
		List<CoursePlannerEntry> entries = new ArrayList<CoursePlannerEntry>();
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
            	CoursePlannerEntry entry = new CoursePlannerEntry( rs.getString( "code" ), 
            			rs.getString( "title" ), rs.getString("pre") );
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
        request.getRequestDispatcher( "/WEB-INF/CoursePlanner.jsp" ).forward(
                    request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }
    
}