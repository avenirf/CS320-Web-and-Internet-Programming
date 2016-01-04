package finale;

public class jobsEntry {
	
	int id;
	
    String position;

    String applicant;

    String submitted;
    
    public jobsEntry( String position, String applicant, String submitted )
    {
        this.position = position;
        this.applicant = applicant;
        this.submitted = submitted;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}
    
}
