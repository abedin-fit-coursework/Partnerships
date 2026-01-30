
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

	public int getNumOfJointProjects() {
		return numOfJointProjects;
	}

	public void setNumOfJointProjects(int numOfJointProjects) {
		this.numOfJointProjects = numOfJointProjects;
	}

	@Override
	public String toString() {
		return partner.getName() + " - broj zajedničkih projekata: " + numOfJointProjects;
	}

}
