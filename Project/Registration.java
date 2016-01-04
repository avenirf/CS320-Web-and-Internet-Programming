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

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registration() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{	
		request.getRequestDispatcher( "/WEB-INF/Registration.jsp" ).forward(
                request, response );
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{	
		boolean username = true;
		boolean pass = true;
		boolean rePass = true;
		
		List<RegistrationEntry> registr = new ArrayList<RegistrationEntry>();
    	
    	Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
            String userN = "cs320stu61";
            String password = "yho##wEl";

            c = DriverManager.getConnection( url, userN, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from users" );

            while( rs.next() )
            {
            	RegistrationEntry entry = new RegistrationEntry( rs.getString( "username" ), 
            			rs.getString( "password" ), rs.getString("first_name"), rs.getString("last_name") );
            	registr.add( entry );
            }
            
            for (RegistrationEntry name: registr){
    			if ( request.getParameter( "username" ).equals( name.getName() ) ) 
    			{
    				username = false;
    			}
        	}
            
            if (request.getParameter( "username" ).length() < 4 || request.getParameter( "username" ).isEmpty()){
            	username = false;
            }
            
            if (request.getParameter( "pass" ).length() < 4 || request.getParameter( "pass" ).isEmpty()){
            	pass = false;
            }
            
            if ( !request.getParameter( "pass" ).equals( request.getParameter( "rePass" ) ) ){
            	rePass = false;
            }  
            
            String userName = request.getParameter( "username" );
    		String passWord = request.getParameter( "pass" );
    		String firstName = request.getParameter( "fName" );
    		String lastName = request.getParameter( "lName" );

    		if (username && pass && rePass){
            String sql = "insert into users (username, password, first_name, last_name) values (?, ?, ?, ?)";

            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, userName );
            pstmt.setString( 2, passWord );
            pstmt.setString( 3, firstName );
            pstmt.setString( 4, lastName );
            pstmt.executeUpdate();
            
    		request.getSession().setAttribute( "user", request.getParameter( "username" ) );
    		response.sendRedirect( "CoursePlanner" );
    			
    		} else {response.sendRedirect( "Registration" );}
            
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
		    
		/*response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html>" );
        out.println( "<head><title>Registration</title>");
        out.println( "<style type='text/css'>"
        		+ "#red{"
        		+ "color: red;}" );
        out.println( "</style>" );
        out.println( "</head><body>" );
        
        out.println( "<table id='tb1' border='1'>" );
        out.println( "<form id='myForm' action='Registration' method='post'>" );
        out.println( "<tr><td>Username: *</td> <td><input type='text' name='username' /></td>" );
        if (request.getParameter( "username" ).length() < 4 || request.getParameter( "username" ).isEmpty()){
        	out.println( "<td id='red'>Username must be 4 or more haractes long!</td>" );
        	username = false;
        }
        for ( RegistrationEntry name: registr ){
			if ( request.getParameter( "username" ).equals( name.getName()) ){
				username = false;
				out.println( "<td id='red'>Username conflicts with an existing username!</td>" );
			}
        }
        
        out.println( "</tr>" );
        out.println( "<tr><td>Password: *</td> <td><input type='password' name='pass' /></td>" );
        if (request.getParameter( "pass" ).length() < 4 || request.getParameter( "pass" ).isEmpty()){
        	out.println( "<td id='red'>Password must be 4 or more haractes long!</td>" );
        	pass = false;
        }
        
        out.println( "</tr>" );
        out.println( "<tr><td>Re-type password: *</td> <td><input type='password' name='rePass' /></td>" );
        if (!request.getParameter( "pass" ).equals(request.getParameter( "rePass" ))){
        	out.println( "<td id='red'>Password and re-typed password do not match!</td>" );
        	rePass = false;
        }
        
        out.println( "</tr>" );
        out.println( "<tr><td>First Name (optional): </td> <td><input type='text' name='fName' /></td></tr>" );
        out.println( "<tr><td>Last Name (optional): </td> <td><input type='text' name='lName' /></td></tr></table> <br />" );
        out.println( "<input type='submit' name='register' value='Register' /> <br />" );
        out.println( "</form>" );

        out.println( "</body></html>" );*/
	
	}

}
