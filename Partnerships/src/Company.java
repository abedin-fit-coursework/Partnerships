
public class Company {

	private String name;
	private String industry;
	private int estYear;

	public Company(String name, String industry, int estYear) {
		super();
		this.name = name;
		this.industry = industry;
		this.estYear = estYear;
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
	
	

}
