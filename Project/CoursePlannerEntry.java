package HW3;

import java.util.ArrayList;

public class CoursePlannerEntry {

    String code;

    String title;

    String pre;
    
    ArrayList<String> listPre;
    
    Boolean check = false;
    
    public CoursePlannerEntry( String code, String title, String pre )
    {
        this.code = code;
        this.title = title;
        this.pre = pre;
        
        this.listPre = new ArrayList<String>();
        
        String[] list = pre.split(" ");
        for (String str:list){
        	this.listPre.add(str);
        }
    }
    
    public CoursePlannerEntry(){
    	
    }
    
	public ArrayList<String> getListPre() {
		return listPre;
	}

	public void setListPre(ArrayList<String> listPre) {
		this.listPre = listPre;
	}

	public String getPre() {
		return pre;
	}

	public void setPre(String pre) {
		this.pre = pre;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setFCheck() {
		this.check = false;
	}
	
	public void setTCheck() {
		this.check = true;
	}
	
}
