package HW3;

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

@WebServlet("/Login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    
    //@SuppressWarnings({ "unchecked", "unused" })
    /*private RegistrationEntry getEntry( String code )
    {
    	List<RegistrationEntry> registr = (List<RegistrationEntry>) getServletContext().getAttribute(
                "registr" );
    	
        for( RegistrationEntry entry : registr )
            if( entry.getName().equals( code ) ) return entry;
        
        return null;
    }*/
    
    
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(
                request, response );
    }

    
	protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	List<RegistrationEntry> registr = new ArrayList<RegistrationEntry>();
    	
    	Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
            String username = "cs320stu61";
            String password = "yho##wEl";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from users" );

            while( rs.next() )
            {
            	RegistrationEntry entry = new RegistrationEntry( rs.getString( "username" ), 
            			rs.getString( "password" ), rs.getString("first_name"), rs.getString("last_name") );
            	registr.add( entry );
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
        
        //request.setAttribute( "registr", registr );
    	
    	boolean login = false;
    	boolean pass = false;
    	String loginName = "";
    	
    	if (request.getParameter( "username" ).length() < 4 || request.getParameter( "username" ).isEmpty()){
        	login = false;
        }
    	
    	if (request.getParameter( "password" ).length() < 4 || request.getParameter( "password" ).isEmpty()){
    		pass = false;
        }
    	
    	for (RegistrationEntry name: registr){
			if (request.getParameter( "username" ).equals( name.getName() ) 
					&& request.getParameter( "password" ).equals( name.getPass() ) ){
				login = true;
				pass = true;
				loginName = name.getName();
			}
    	}	
    	
    	if (login && pass){
    		request.getSession(true).setAttribute( "user", loginName );
			response.sendRedirect( "CoursePlanner" );
    	} else {response.sendRedirect( "Login" );}
    	
    	
    	
    		/**response.setContentType( "text/html" );
            PrintWriter out = response.getWriter();
            out.println( "<html><head><title>Login</title>"
            		+ "<style type='text/css'>"
            				+ ".topcorner{"
            				+ "position:absolute;"
            				+ "top:0;"
            				+ "right:30;}"
            				
            				+ "#red{"
                    		+ "color: red;}"
            		+ "</style>"
            		+ "</head><body>" );


            out.println( "<table id='tb1' border='1'>" );
            out.println( "<form action='Login' method='post'>" );
            out.println( "<tr><td>Username:</td> <td><input type='text' name='username' /></td>" );   
            if (request.getParameter( "username" ).length() < 4 || request.getParameter( "username" ).isEmpty()){
            	out.println( "<td id='red'>Username must be 4 or more haractes long!</td>" );
            }
            
            /*for ( RegistrationEntry name: registr ){
    			if ( request.getParameter( "username" ).equals( name.getName()) ){
    				login = false;
    				out.println( "<td id='red'>Username conflicts with an existing username!</td>" );
    			}
            }*/
            
            /*out.println( "</tr>" );
            
            out.println( "<tr><td>Password:</td> <td><input type='password' name='password' /></td>" );
            if (request.getParameter( "password" ).length() < 4 || request.getParameter( "password" ).isEmpty()){
            	out.println( "<td id='red'>Password must be 4 or more haractes long!</td>" );
            } 
            else if (getEntry(request.getParameter( "username" )) != null) {
            	RegistrationEntry entry = getEntry( request.getParameter( "username" ) );
            	if ( !request.getParameter( "password" ).equals( entry.getPass() ) ){
            		pass = false;
            		out.println( "<td id='red'>Wrong password!</td>" );
            	}
            }

            out.println( "</tr>" );
            
            out.println( "</table> <br />" );
            out.println( "<input type='submit' name='login' value='Login' /> <br />" );
            out.println( "</form>" );
            
            out.println( "<div class='topcorner'> <a href='Registration'>Registration</a> </div>" );
            
            out.println( "</body></html>" );*/
    	}
}
