import java.util.LinkedList;
import java.util.List;

public class PartnershipsGraph {

	private List<Company> all;

	public PartnershipsGraph() {
		super();
		all = new LinkedList<>();
	}

	public boolean addCompany(String name, String industry, int estYear) {
		if (find(name) != null) {
			return false;
		}
		all.add(new Company(name, industry, estYear));
		return true;
	}

	public Company find(String name) {
		for (Company c : all) {
			if (c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return null;
	}

	public boolean renameCompany(String oldName, String newName) {
		Company c = find(oldName);
		if (c == null) {
			return false;
		}
		if (find(newName) != null) {
			return false;
		}
		c.setName(newName);
		return true;
	}

	public boolean changeCompanyIndustry(String name, String newIndustry) {
		Company c = find(name);
		if (c == null) {
			return false;
		}
		c.setIndustry(newIndustry);
		return true;
	}

	public boolean changeCompanyEstYear(String name, int newEstYear) {
		Company c = find(name);
		if (c == null) {
			return false;
		}
		c.setEstYear(newEstYear);
		return true;
	}

	public boolean removeCompany(String name) {
		Company c = find(name);
		if (c == null) {
			return false;
		}
		for (Company p : all) {
			if (p != c) {
				p.removePartnership(c);
			}
		}
		return all.remove(c);
	}

	public boolean addPartnership(String nameA, String nameB, int numOfJointProjects) {
		Company c1 = find(nameA);
		Company c2 = find(nameB);
		if (c1 == null || c2 == null) {
			return false;
		}
		if (c1 == c2) {
			return false;
		}
		if (c1.addPartnership(c2, numOfJointProjects)) {
			c2.addPartnership(c1, numOfJointProjects);
			return true;
		}
		return false;
	}

	public boolean updatePartnership(String nameA, String nameB, int newNumOfJointProjects) {
		Company c1 = find(nameA);
		Company c2 = find(nameB);
		if (c1 == null || c2 == null) {
			return false;
		}
		if (c1 == c2) {
			return false;
		}
		if (c1.updatePartnership(c2, newNumOfJointProjects)) {
			c2.updatePartnership(c1, newNumOfJointProjects);
			return true;
		}
		return false;
	}

	public boolean removePartnership(String nameA, String nameB) {
		Company c1 = find(nameA);
		Company c2 = find(nameB);
		if (c1 == null || c2 == null) {
			return false;
		}
		if (c1 == c2) {
			return false;
		}
		if (c1.removePartnership(c2)) {
			c2.removePartnership(c1);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (all.isEmpty()) {
			return "Nema firmi.";
		}
		StringBuffer sb = new StringBuffer();
		for (Company c : all) {
			sb.append(c).append("\n");
		}
		return sb.toString();
	}

	// b)

	public void showPartnershipStatsByIndustry(String name, String industry) {
		Company c = find(name);
		if (c == null) {
			System.out.println("Firma koju ste unijeli ne postoji.");
			return;
		}
		int count = 0;
		int sum = 0;
		for (PartnershipEdge e : c.getPartnerships()) {
			if (e.getPartner().getIndustry().equalsIgnoreCase(industry)) {
				count++;
				sum += e.getNumOfJointProjects();
			}
		}
		if (count == 0) {
	        System.out.println("Firma nema partnera iz oblasti - " + industry);
	        return;
	    }
		System.out.println("Firma: " + c.getName());
		System.out.println("Broj partnerskih firmi iz oblasti - " + industry + ": " + count);
		System.out.println("Ukupan broj zajedničkih projekata: " + sum);
	}

	// c)

	public void showPartnersWithMoreProjectsThanN(int n) {
	    int counter = 0;
	    for (int i = 0; i < all.size(); i++) {
	        Company a = all.get(i);
	        for (PartnershipEdge e : a.getPartnerships()) {
	            Company b = e.getPartner();
	            int j = all.indexOf(b);      
	            if (j <= i) {                
	                continue;
	            }
	            if (e.getNumOfJointProjects() > n) {
	                counter++;
	                System.out.print(a.getName() + " - " + b.getName()
	                        + " [Broj projekata: " + e.getNumOfJointProjects() + "] ");

	                if (a.getIndustry().equalsIgnoreCase(b.getIndustry())) {
	                    System.out.println("- Ista oblast");
	                } else {
	                    System.out.println("- Različita oblast");
	                }
	            }
	        }
	    }
	    if (counter == 0) {
	        System.out.println("Nema parova firmi sa više od " + n + " zajedničkih projekata.");
	    }
	}

}
