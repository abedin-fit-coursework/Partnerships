import java.util.LinkedList;
import java.util.List;

public class Company {

	private String name;
	private String industry;
	private int estYear;
	private List<PartnershipEdge> partnerships;

	public Company(String name, String industry, int estYear) {
		super();
		this.name = name;
		this.industry = industry;
		this.estYear = estYear;
		partnerships = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public int getEstYear() {
		return estYear;
	}

	public void setEstYear(int estYear) {
		this.estYear = estYear;
	}

	public List<PartnershipEdge> getPartnerships() {
		return partnerships;
	}

	public PartnershipEdge findPartnership(Company partner) {
		if (partner == null) {
			return null;
		}
		for (PartnershipEdge e : partnerships) {
			if (e.getPartner().equals(partner)) {
				return e;
			}
		}
		return null;
	}

	public boolean hasPartner(Company partner) {
		return findPartnership(partner) != null;
	}

	public boolean addPartnership(Company partner, int numOfJointProjects) {
		if (hasPartner(partner)) {
			return false;
		}
		partnerships.add(new PartnershipEdge(partner, numOfJointProjects));
		return true;
	}

	public boolean updatePartnership(Company partner, int newNumOfJointProjects) {
		PartnershipEdge e = findPartnership(partner);
		if (e == null) {
			return false;
		}
		e.setNumOfJointProjects(newNumOfJointProjects);
		return true;
	}

	public boolean removePartnership(Company partner) {
		PartnershipEdge toDelete = findPartnership(partner);
		if (toDelete == null) {
			return false;
		}
		partnerships.remove(toDelete);
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Company) {
			return ((Company) obj).getName().equalsIgnoreCase(name);
		}
		return false;
	}

	@Override
	public String toString() {
		return name + " (" + industry + ", " + estYear + ") - Partneri: " + partnerships;
	}
	
}
