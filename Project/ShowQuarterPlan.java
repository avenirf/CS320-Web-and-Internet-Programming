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

@WebServlet("/ShowQuarterPlan")
public class ShowQuarterPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowQuarterPlan() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		List<CoursePlannerEntry> enter = new ArrayList<CoursePlannerEntry>();
		List<QuarterPlan> quarterPlan = new ArrayList<QuarterPlan>();
		List<String> savedPlans = new ArrayList<String>();
		String date = "";
		try {
			date = request.getParameter("date").toString();
			request.setAttribute("date", date);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
            
            
            String sql = "select distinct(date), username from quarter_plan where username = ?";
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, request.getSession(true).getAttribute("user").toString() );
            ResultSet rs2 = pstmt.executeQuery();
            
            while ( rs2.next() )
            {
            	String entry = rs2.getString("date");
            	savedPlans.add(entry);
            }
            
            /*String sql2 = "select distinct(quarter) from quarter_plan where username = ? and date = ?";
            PreparedStatement pstmt2 = c.prepareStatement( sql2 );
            pstmt2.setString( 1, request.getSession(true).getAttribute("user").toString() );
            pstmt2.setString( 2, request.getAttribute("date").toString() );
            ResultSet rs3 = pstmt2.executeQuery();
            
            List<String> quarters = new ArrayList();
            
            while (rs3.next() ){
            	quarters.add(rs3.getString("quarter"));           	
            }*/
            if ( !date.isEmpty() ){
				String sql3 = "select quarter, code from quarter_plan where username = ? and date = ?";
				PreparedStatement pstmt3 = c.prepareStatement( sql3 );
				pstmt3.setString( 1, request.getSession(true).getAttribute("user").toString() );
				pstmt3.setString( 2, date );
				ResultSet rs4 = pstmt3.executeQuery();
				
				while ( rs4.next() ){            	
					String code = rs4.getString("code");
					String quarter = rs4.getString("quarter");
					Boolean i = false;
					for (QuarterPlan qp:quarterPlan){
						if ( quarter.equals(qp.getQuarter()) ){
							for (CoursePlannerEntry cpe:enter){
								if( code.equals(cpe.getCode()) ){
									qp.addList(cpe);
				    			}
							}
						} else {i = true;} 
					}
					
					if (quarterPlan.isEmpty()){
						i=true;
					}
					
					if (i == true){
						QuarterPlan qPlan = new QuarterPlan();
						qPlan.setQuarter(quarter);
						for (CoursePlannerEntry cpe:enter){
							if( code.equals(cpe.getCode()) ){
								qPlan.addList(cpe);
							}
						}
						quarterPlan.add(qPlan);
					}	
				}
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
		
		System.out.println(quarterPlan);
		System.out.println(date);
        request.setAttribute( "quarterPlan", quarterPlan );
        getServletContext().setAttribute( "savedPlans", savedPlans );
        
		request.getRequestDispatcher( "/WEB-INF/ShowQuarterPlan.jsp" ).forward(
                request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
