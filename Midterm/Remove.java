package cs320.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.TaskEntry;

@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		Integer id = Integer.valueOf( request.getParameter( "id" ) );
		List<TaskEntry> tEntry = (List<TaskEntry>) getServletContext().getAttribute(
		            "tEntry" );
		 
	    for( TaskEntry entry : tEntry )
	    	if( entry.getId().equals( id ) )
	        {
	    		tEntry.remove( entry );
	            break;
	        }
		
		response.sendRedirect( "Task" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
