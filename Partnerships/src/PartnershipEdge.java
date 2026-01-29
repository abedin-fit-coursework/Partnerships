
public class PartnershipEdge {

	private Company partner;
	private int numOfJointProjects;
	
	public PartnershipEdge(Company partner, int numOfJointProjects) {
		super();
		this.partner = partner;
		this.numOfJointProjects = numOfJointProjects;
	}

	public Company getPartner() {
		return partner;
	}

	public void setPartner(Company partner) {
		this.partner = partner;
	}

	public int getNumOfJointProjects() {
		return numOfJointProjects;
	}

	public void setNumOfJointProjects(int numOfJointProjects) {
		this.numOfJointProjects = numOfJointProjects;
	}
	
	
	
}
