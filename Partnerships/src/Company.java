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
		partnerships = new LinkedList<PartnershipEdge>();
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

	@Override
	public String toString() {
		return "Company [name=" + name + ", industry=" + industry + ", estYear=" + estYear + "]";
	}

	public List<PartnershipEdge> getPartnerships() {
		return partnerships;
	}

	public void setPartnerships(List<PartnershipEdge> partnerships) {
		this.partnerships = partnerships;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Company) {
			if (((Company) obj).getName().equalsIgnoreCase(name)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	public boolean findCompany(Company c) {
		for (PartnershipEdge p : partnerships) {
			if (p.getPartner().equals(c)) {
				return true;
			}
		}
		return false;
	}

	public boolean add(Company partner, int noOfJointProjects) {
		if (partner == null || noOfJointProjects <= 0 || findCompany(partner)) {
			return false;
		}
		partnerships.add(new PartnershipEdge(partner, noOfJointProjects));
		return true;
	}

	public boolean remove(Company partner) {
		if(partner == null || !findCompany(partner)) {
			return false;
		}
		for (PartnershipEdge p : partnerships) {
			if(p.getPartner().equals(partner)) {
				partnerships.remove(p);
				return true;
			}
		}
		return false;
	}
	
	public boolean modify(Company partner, int newNumOfJointProjects) {
		if(partner == null || newNumOfJointProjects<=0) {
			return false;
		}
		for (PartnershipEdge p : partnerships) {
			if(p.getPartner().equals(partner)) {
				p.setNumOfJointProjects(newNumOfJointProjects);
				return true;
			}
		}
		return false;
	}
	

	
}
