package cs320.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import java.util.Date;

public class TaskEntry {
	
	Boolean completed;
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	Integer id;
	
	String message;
	
	Date dueDate;
	
	Date complitionDate;
	
	String dueSDate;
	
	String dueSComplitionDate;
	
	public TaskEntry (Integer id, String message, String dueDate ){
		this.id = id;
		this.message = message;
		try {
			this.dueDate = dateFormat.parse(dueDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.completed = true;
	}
	
	public String getDueSDate(){
		return dueSDate = dateFormat.format(dueDate);
	}
	
	public String getDueSComplitionDate(){
		return dueSComplitionDate = dateFormat.format(complitionDate);
	}
	
	public Date getComplitionDate() {
		return complitionDate;
	}

	public void setComplitionDate(Date complitionDate) {
		this.complitionDate = complitionDate;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
}
