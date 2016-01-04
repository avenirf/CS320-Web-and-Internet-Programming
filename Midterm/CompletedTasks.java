package cs320.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.TaskEntry;

@WebServlet("/CompletedTasks")
public class CompletedTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompletedTasks() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		List<TaskEntry> tEntry = (List<TaskEntry>) getServletContext().getAttribute(
	            "tEntry" );
		
		request.getRequestDispatcher( "CompletedTasks.jsp" ).forward(
	            request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
