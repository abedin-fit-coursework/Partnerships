import java.util.LinkedList;
import java.util.List;

public class PartnershipsGraph {

	private List<Company> all;

	public PartnershipsGraph() {
		super();
		all = new LinkedList<Company>();
	}

	public boolean addPartnership(Company c1, Company c2, int noOfJointProjects) {
		if (c1.add(c2, noOfJointProjects)) {
			c2.add(c1, noOfJointProjects);
		}
		return true;
	}

	public boolean removePartnership(Company c1, Company c2) {
		if (c1.remove(c2)) {
			c2.remove(c1);
		}
		return true;
	}

	public boolean modifyRelationShip(Company c1, Company c2, int newNumOfJointProjects) {
		if(c1.modify(c2, newNumOfJointProjects)) {
			c2.modify(c1, newNumOfJointProjects);
		}
		return true;
	}



	public boolean find(Company c) {
		for (Company company : all) {
			if(company.equals(c)) {
				return true;
			}
		}
		return false;
	}
	
	// Metoda koja kao ulazni argument prima godinu osnivanja, naziv firme i naziv
	// oblasti i
	// prikazuje brojfirmi iz te oblasti sa kojima je data firma partner, kao i
	// ukupan broj zajedničkih projekata.
	
	public String showPartnershipStatsByIndustry(int estYear, String name, String industry) {
		Company c = new Company(name, industry, estYear);
		if(!find(c)) {
			return "Ova kompanija ne postoji";
		}
		int sum = 0;
		int count = 0;
		for (Company company : all) {
			if(company.equals(c)) {
				for (PartnershipEdge p : c.getPartnerships()) {
					if(p.getPartner().getIndustry().equalsIgnoreCase(industry)) {
						count++;
						sum+=p.getNumOfJointProjects();
					}
				}
			}
		}
		return "Broj firmi iz te oblasti sa kojima je data firma partner: " + count + "\nBroj zajednickih projekata: " + sum;
	}
	
	//Metoda koja kao ulazni argument prima broj projekata i 
	//prikazuje sve firme koje su sarađivale na više projekata od datog broja. 
	//Za sve parove firmi prikazati i da li se bave istom oblasti.
	
	public String companiesWithMoreProjectsThanN(int noOfJointProjects) {
		if(noOfJointProjects<=0) {
			return "Broj projekata nije unijet pravilno";
		}
		int sum = 0;
		String s = "";
		for (Company company : all) {
			for (PartnershipEdge p : company.getPartnerships()) {
				sum+=p.getNumOfJointProjects();
				if(company.getIndustry().equalsIgnoreCase(p.getPartner().getIndustry())) {
					s+= "Kompanija " + company + " i kompanija " + p + " se bave istom oblascu";
				}
			}
			if(sum>noOfJointProjects) {
				s+=company.getName() + "\n";
			}
		}
		return s;
	}
	

}
