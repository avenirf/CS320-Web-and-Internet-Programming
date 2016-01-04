package HW3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

@WebServlet("/CoursePlanner2")
public class CoursePlanner2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoursePlanner2() 
    {
        super();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        
        List<QuarterPlan> quarterPlan = new ArrayList<QuarterPlan>();
        getServletContext().setAttribute( "quarterPlan", quarterPlan );
        
        List<String> codeList = new ArrayList();
        getServletContext().setAttribute( "codeList", codeList );
        
        List<CoursePlannerEntry> quarter = new ArrayList<CoursePlannerEntry>();
		getServletContext().setAttribute( "quarter", quarter );
		
		//int i = 0;
		getServletContext().setAttribute("i", -1);
		getServletContext().setAttribute("j", 0);
		
		/*try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        };*/
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes"})
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		//Create new session
		//HttpSession session = request.getSession(true);  
		//System.out.println("Session ID is: " + session.getId());
        
		List<CoursePlannerEntry> enter = new ArrayList<CoursePlannerEntry>();
		
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
                enter.add( entry );
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
        
        request.setAttribute( "enter", enter );
        
        List<CoursePlannerEntry> quarter = (List<CoursePlannerEntry>) getServletContext().getAttribute("quarter");
        
        List<String> codeList = (List<String>) getServletContext().getAttribute( "codeList" );
        
        List<QuarterPlan> quarterPlan = (List<QuarterPlan>) getServletContext().getAttribute( "quarterPlan" );
        
        int i = (int) getServletContext().getAttribute("i");;

        //int j = (int) getServletContext().getAttribute( "j" );
        
        String winter = "Winter";
        String spring = "Spring";
        String summer = "Summer";
        String fall = "Fall";
        List<String> quarterList = new ArrayList();
        List<String> quart = new ArrayList();
        
		int year = Calendar.getInstance().get(Calendar.YEAR);
	    getServletContext().setAttribute( "year", year );
	    
	    int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        
        String date = null; 
        
        if (week >= 1 && week <= 12){
        	date = winter;
        } else if (week >= 13 && week <= 24){
        	date = spring;
        } else if (week >= 25 && week <= 37){
        	date = summer;
        } else if (week >= 38 && week <= 52){
        	date = fall;
        }
        
        if (date.equals(winter)){
        	quarterList.add(winter);
        	quarterList.add(spring);
        	quarterList.add(summer);
        	quarterList.add(fall);
        } else if (date.equals(spring)){
        	quarterList.add(spring);
        	quarterList.add(summer);
        	quarterList.add(fall);
        	quarterList.add(winter);
        } else if (date.equals(summer)){
        	quarterList.add(summer);
        	quarterList.add(fall);
        	quarterList.add(winter);
        	quarterList.add(spring);
        } else if (date.equals(fall)){
        	quarterList.add(fall);
        	quarterList.add(winter);
        	quarterList.add(spring);
        	quarterList.add(summer);
        }
			
		for (int z=0; z < enter.size(); z++){
			for (String qr:quarterList){
				quart.add(qr + " " + (year+z));
			}
		}
        
        //reset the quarterList
		if ( quarter.isEmpty() ){
			for (CoursePlannerEntry list: enter){
				list.setFCheck();
				quarter.add(list);
			}
			Collections.copy(quarter, enter);
		}
		
        //System.out.println(codeList);
		
		String[] check = request.getParameterValues( "checkbox" );
		
		if (check == null){
        } else {
			for (String q:check){
				for (CoursePlannerEntry q2: quarter){
					if (q2.getCode().equals(q)){
						quarter.remove( q2 );
						break;
					} 
				}
			}
		}
		
		i++;
		
		if (check == null){
	    }else {
	      for (String prer : check) {
	    	  codeList.add(prer);
	      }
	    }
		
		 if (check == null){ }
	        else if( i > 1 ) {
	        	QuarterPlan plan = new QuarterPlan();
	        	plan.setQuarter(quart.get(i-1));
	        	for (CoursePlannerEntry q: enter){
	        		for (String ch: check){
	        			if (ch.equals(q.getCode())){
	        				plan.addList(q);
	        			}
	        		}
	        	}
	        		quarterPlan.add(plan);
	        }
	        
		 //show class with more than 1 prerequisite
		 if (!codeList.isEmpty()){
			for (CoursePlannerEntry q:quarter){
				if (codeList.containsAll(q.getListPre())){
					q.setTCheck();
				}
			}
		}
		
		//System.out.println(date);
		//System.out.println(i); 
		//System.out.println(j);
		//System.out.println(quart);
		//System.out.println(quarterList);
		
		getServletContext().setAttribute("i", i);
		if (i >= 1){
			request.setAttribute( "quart", quart.get(i) );
		}
		
		request.getRequestDispatcher( "/WEB-INF/CoursePlanner2.jsp" ).forward(
                request, response );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		doGet( request, response );
	}

}
