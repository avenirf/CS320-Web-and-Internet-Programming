package HW3;

import java.util.ArrayList;
import java.util.List;

public class QuarterPlan {
	
		String quarter;

		ArrayList<CoursePlannerEntry> list;

	    public QuarterPlan( String quarter, CoursePlannerEntry name )
	    {
	        this.quarter = quarter;
	        this.list = new ArrayList<CoursePlannerEntry>();
	        this.list.add(name);
	    }
	    
	    public QuarterPlan(){
	    	 this.quarter = "";
		     this.list = new ArrayList<CoursePlannerEntry>();
	    }

		public List<CoursePlannerEntry> getList() {
			return list;
		}

		public void setList( ArrayList<CoursePlannerEntry> list) {
			this.list = list;
		}
		
		public void addList (CoursePlannerEntry list){
			this.list.add(list);
		}

		public String getQuarter() {
			return quarter;
		}

		public void setQuarter(String quarter) {
			this.quarter = quarter;
		}
		
		
	}
