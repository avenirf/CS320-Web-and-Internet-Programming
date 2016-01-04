package cs320.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.TaskEntry;

@WebServlet("/Task")
public class Task extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Task() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException 
	{
		super.init( config );

        // create some test data for display
        List<TaskEntry> tEntry = new ArrayList<TaskEntry>();
        tEntry.add( new TaskEntry( 1, "Buy grocery", "02/22/2014") );
        tEntry.add( new TaskEntry( 2, "watch the lego movie", "02/16/2014"));
        tEntry.add( new TaskEntry( 3, "Meeting with Dr. Pamula ",	"02/20/2014") );
        
        getServletContext().setAttribute( "tEntry", tEntry );
	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		Date now = new Date();
		
		getServletContext().setAttribute( "now", now );
		
		Calendar cal = Calendar.getInstance();  
		cal.setTime(now);  
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = cal.getTime(); 
		
		getServletContext().setAttribute( "tomorrow", tomorrow );
		
		// add list of songs
		List<TaskEntry> tEntry = (List<TaskEntry>) getServletContext().getAttribute(
			            "tEntry" );
		
		// get the user input
		String message = null;
		String dueDate = null;
				
		try {
			if ( !request.getParameter( "message" ).isEmpty() && !request.getParameter( "dueDate" ).isEmpty() )
			{
				message = request.getParameter( "message" );
				dueDate = request.getParameter( "dueDate" );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		        
		// rank #
		Integer rank = tEntry.size()+1;

		// create a new task entry
		TaskEntry entry = null;
		        
		if (message != null && dueDate != null)
		{
			entry = new TaskEntry( rank, message, dueDate );
		}
		        
		// add the new entry to the taskEntry
		if (entry != null)
		{
			tEntry.add( entry );
		}
		
		request.getRequestDispatcher( "Task.jsp" ).forward(
		            request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
