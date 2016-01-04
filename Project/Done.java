package HW3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Done")
public class Done extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Done() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		List<CoursePlannerEntry> quarter = (List<CoursePlannerEntry>) getServletContext().getAttribute("quarter");
		
		quarter.clear();
        
        List<String> codeList = (List<String>) getServletContext().getAttribute( "codeList" );
        
        codeList.clear();
        
        List<QuarterPlan> quarterPlan = (List<QuarterPlan>) getServletContext().getAttribute( "quarterPlan" );
        
        quarterPlan.clear();
        
        getServletContext().setAttribute("i", -1);
        getServletContext().setAttribute("j", 0);
        
        //request.getSession().invalidate();
		
		response.sendRedirect( "CoursePlanner" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
