package HW3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Save() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		List<CoursePlannerEntry> quarter = (List<CoursePlannerEntry>) getServletContext().getAttribute("quarter");
        List<String> codeList = (List<String>) getServletContext().getAttribute( "codeList" );
        List<QuarterPlan> quarterPlan = (List<QuarterPlan>) getServletContext().getAttribute( "quarterPlan" );
        
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat ("MM/dd/yyyy 'at' hh:mm a");
        String date = dateFormat.format(now);
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu61";
            String username = "cs320stu61";
            String password = "yho##wEl";
            
            c = DriverManager.getConnection( url, username, password );
            
            for (QuarterPlan qp:quarterPlan){
            	for (CoursePlannerEntry list :qp.getList()){
            		
            		String sql = "insert into quarter_plan (date, username, quarter, code) values (?, ?, ?, ?)";
            		PreparedStatement pstmt = c.prepareStatement( sql );
            		pstmt.setString( 1, date );
                    pstmt.setString( 2, request.getSession(true).getAttribute("user").toString() );
                    pstmt.setString( 3, qp.getQuarter() );
                    pstmt.setString( 4, list.getCode() );
                    pstmt.executeUpdate();
            		
            	}
            }
            
            /*String sql = "insert into saved_plans (date, username) values (?, ?)";
    		PreparedStatement pstmt = c.prepareStatement( sql );
    		pstmt.setString( 1, date );
            pstmt.setString( 2, request.getSession(true).getAttribute("user").toString() );
            pstmt.executeUpdate();*/
            
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
		
		quarter.clear();
        
        codeList.clear();
        
        quarterPlan.clear();
        
        getServletContext().setAttribute("i", 0);
        getServletContext().setAttribute("j", 0);
        
        //request.getSession().invalidate();
		
		response.sendRedirect( "CoursePlanner" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
