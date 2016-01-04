package cs320.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.TaskEntry;

@WebServlet("/Complete")
public class Complete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Complete() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings({ "unchecked"})
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		Integer id = Integer.valueOf( request.getParameter( "id" ) );
		List<TaskEntry> tEntry = (List<TaskEntry>) getServletContext().getAttribute(
		            "tEntry" );
		
		Date nowDate = new Date();
		
	    for( TaskEntry entry : tEntry )
	    	if( entry.getId().equals( id ) )
	        {
	    		entry.setCompleted(false);
	    		entry.setComplitionDate(nowDate);
	            break;
	        }
		
		response.sendRedirect( "Task" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
