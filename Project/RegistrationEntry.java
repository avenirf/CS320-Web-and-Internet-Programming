package HW3;

public class RegistrationEntry {

	String name;
	String pass;
	String fName;
	String lName;
	
	public RegistrationEntry( String name, String pass, String fName, String lName)
    {
        this.name = name;
        this.pass = pass;
        this.fName = fName;
        this.lName = lName;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
}
