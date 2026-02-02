import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		PartnershipsGraph graph = new PartnershipsGraph();
		Scanner sc = new Scanner(System.in);

		while (true) {
			printMenu();

			int choice;
			while (true) {
				System.out.print("Unesite opciju (0-11): ");
				String line = sc.nextLine().trim();
				try {
					choice = Integer.parseInt(line);
					if (choice >= 0 && choice <= 11) {
						break;
					}
					System.out.println("Pogrešan unos. Broj mora biti od 0 do 11.");
				} catch (Exception e) {
					System.out.println("Pogrešan unos. Morate unijeti cijeli broj.");
				}
			}

			if (choice == 0) { // Izlaz
				System.out.println("Izlaz iz programa.");
				break;
			}

			switch (choice) {
			case 1: { // Dodaj firmu
				String name;
				while (true) {
					System.out.print("Unesite naziv firme: ");
					name = sc.nextLine().trim();
					if (name.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (graph.find(name) != null) {
						System.out.println("Firma sa tim nazivom već postoji.");
						continue;
					}
					break;
				}

				String industry;
				while (true) {
					System.out.print("Unesite oblast firme: ");
					industry = sc.nextLine().trim();
					if (industry.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (!industryExists(industry)) {
						System.out.println("Ta oblast ne postoji.");
						System.out.println("Moguće oblasti su:");
						printIndustries();
						continue;
					}
					break;
				}

				int year;
				while (true) {
					System.out.print("Unesite godinu osnivanja (1000-2026): ");
					String line = sc.nextLine().trim();
					try {
						year = Integer.parseInt(line);
						if (year >= 1000 && year <= 2026) {
							break;
						}
						System.out.println("Godina mora biti u opsegu 1000-2026.");
					} catch (Exception e) {
						System.out.println("Pogrešan unos. Morate unijeti cijeli broj.");
					}
				}

				if (graph.addCompany(name, industry, year)) {
					System.out.println("Firma je uspješno dodata.");
				} else {
					System.out.println("Dodavanje firme nije uspjelo.");
				}
				break;
			}

			case 2: { // Izmijeni naziv firme
				String oldName;
				while (true) {
					System.out.print("Unesite trenutni naziv firme: ");
					oldName = sc.nextLine().trim();
					if (oldName.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (graph.find(oldName) == null) {
						System.out.println("Firma sa tim nazivom ne postoji.");
						continue;
					}
					break;
				}

				String newName;
				while (true) {
					System.out.print("Unesite novi naziv firme: ");
					newName = sc.nextLine().trim();
					if (newName.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (oldName.equalsIgnoreCase(newName)) {
						System.out.println("Novi naziv ne smije biti isti kao stari.");
						continue;
					}
					if (graph.find(newName) != null) {
						System.out.println("Firma sa tim nazivom već postoji.");
						continue;
					}
					break;
				}

				if (graph.renameCompany(oldName, newName)) {
					System.out.println("Naziv firme je uspješno izmijenjen.");
				} else {
					System.out.println("Izmjena nije uspjela.");
				}
				break;
			}

			case 3: { // Izmijeni oblast firme
				String name;
				while (true) {
					System.out.print("Unesite naziv firme: ");
					name = sc.nextLine().trim();
					if (name.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (graph.find(name) == null) {
						System.out.println("Firma sa tim nazivom ne postoji.");
						continue;
					}
					break;
				}

				String newIndustry;
				while (true) {
					System.out.print("Unesite novu oblast: ");
					newIndustry = sc.nextLine().trim();
					if (newIndustry.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (!industryExists(newIndustry)) {
						System.out.println("Ta oblast ne postoji.");
						System.out.println("Moguće oblasti su:");
						printIndustries();
						continue;
					}
					break;
				}

				if (graph.changeCompanyIndustry(name, newIndustry)) {
					System.out.println("Oblast firme je uspješno izmijenjena.");
				} else {
					System.out.println("Izmjena nije uspjela.");
				}
				break;
			}

			case 4: { // Izmijeni godinu osnivanja firme
				String name;
				while (true) {
					System.out.print("Unesite naziv firme: ");
					name = sc.nextLine().trim();
					if (name.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (graph.find(name) == null) {
						System.out.println("Firma sa tim nazivom ne postoji.");
						continue;
					}
					break;
				}

				int year;
				while (true) {
					System.out.print("Unesite novu godinu osnivanja (1000-2026): ");
					String line = sc.nextLine().trim();
					try {
						year = Integer.parseInt(line);
						if (year >= 1000 && year <= 2026) {
							break;
						}
						System.out.println("Godina mora biti u opsegu 1000-2026.");
					} catch (Exception e) {
						System.out.println("Pogrešan unos. Morate unijeti cijeli broj.");
					}
				}

				if (graph.changeCompanyEstYear(name, year)) {
					System.out.println("Godina osnivanja je uspješno izmijenjena.");
				} else {
					System.out.println("Izmjena nije uspjela.");
				}
				break;
			}

			case 5: { // Obriši firmu
				String name;
				while (true) {
					System.out.print("Unesite naziv firme: ");
					name = sc.nextLine().trim();
					if (name.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (graph.find(name) == null) {
						System.out.println("Firma sa tim nazivom ne postoji.");
						continue;
					}
					break;
				}

				if (graph.removeCompany(name)) {
					System.out.println("Firma je obrisana.");
				} else {
					System.out.println("Brisanje nije uspjelo.");
				}
				break;
			}

			case 6: { // Dodaj partnerstvo
				while (true) {
					Company ca;
					while (true) {
						System.out.print("Unesite naziv PRVE firme: ");
						String a = sc.nextLine().trim();
						if (a.isEmpty()) {
							System.out.println("Unos ne može biti prazan.");
							continue;
						}
						ca = graph.find(a);
						if (ca == null) {
							System.out.println("Prva firma ne postoji.");
							continue;
						}
						break;
					}

					Company cb;
					while (true) {
						System.out.print("Unesite naziv DRUGE firme: ");
						String b = sc.nextLine().trim();
						if (b.isEmpty()) {
							System.out.println("Unos ne može biti prazan.");
							continue;
						}
						cb = graph.find(b);
						if (cb == null) {
							System.out.println("Druga firma ne postoji.");
							continue;
						}
						if (ca.equals(cb)) {
							System.out.println("Firma ne može biti partner sama sebi.");
							continue;
						}
						break;
					}

					if (ca.hasPartner(cb)) {
						System.out.println("Partnerstvo već postoji između ove dvije firme. Povratak na meni.");
						break;
					}

					int projects;
					while (true) {
						System.out.print("Unesite broj zajedničkih projekata (> 0): ");
						String line = sc.nextLine().trim();
						try {
							projects = Integer.parseInt(line);
							if (projects > 0) {
								break;
							}
							System.out.println("Broj mora biti veći od 0.");
						} catch (Exception e) {
							System.out.println("Pogrešan unos. Morate unijeti cijeli broj.");
						}
					}

					if (graph.addPartnership(ca.getName(), cb.getName(), projects)) {
						System.out.println("Partnerstvo je uspješno dodato.");
						break;
					} else {
						System.out.println("Dodavanje partnerstva nije uspjelo.");
					}
				}
				break;
			}

			case 7: { // Izmijeni partnerstvo
				while (true) {
					Company ca;
					while (true) {
						System.out.print("Unesite naziv PRVE firme: ");
						String a = sc.nextLine().trim();
						if (a.isEmpty()) {
							System.out.println("Unos ne može biti prazan.");
							continue;
						}
						ca = graph.find(a);
						if (ca == null) {
							System.out.println("Prva firma ne postoji.");
							continue;
						}
						break;
					}

					Company cb;
					while (true) {
						System.out.print("Unesite naziv DRUGE firme: ");
						String b = sc.nextLine().trim();
						if (b.isEmpty()) {
							System.out.println("Unos ne može biti prazan.");
							continue;
						}
						cb = graph.find(b);
						if (cb == null) {
							System.out.println("Druga firma ne postoji.");
							continue;
						}
						if (ca.equals(cb)) {
							System.out.println("Firma ne može biti partner sama sebi.");
							continue;
						}
						break;
					}

					PartnershipEdge edge = ca.findPartnership(cb);
					if (edge == null) {
						System.out.println("Partnerstvo između ove dvije firme ne postoji. Povratak na meni.");
						break;
					}

					int projects;
					while (true) {
						System.out.print("Unesite NOVI broj zajedničkih projekata (> 0): ");
						String line = sc.nextLine().trim();
						try {
							projects = Integer.parseInt(line);
							if (projects <= 0) {
								System.out.println("Broj mora biti veći od 0.");
								continue;
							}
							if (edge.getNumOfJointProjects() == projects) {
								System.out.println("Novi broj projekata ne može biti isti kao prethodni.");
								continue;
							}
							break;
						} catch (Exception e) {
							System.out.println("Pogrešan unos. Morate unijeti cijeli broj.");
						}
					}

					if (graph.updatePartnership(ca.getName(), cb.getName(), projects)) {
						System.out.println("Partnerstvo je uspješno izmijenjeno.");
						break;
					} else {
						System.out.println("Izmjena partnerstva nije uspjela.");
					}
				}
				break;
			}

			case 8: { // Obriši partnerstvo
				while (true) {
					Company ca;
					while (true) {
						System.out.print("Unesite naziv PRVE firme: ");
						String a = sc.nextLine().trim();
						if (a.isEmpty()) {
							System.out.println("Unos ne može biti prazan.");
							continue;
						}
						ca = graph.find(a);
						if (ca == null) {
							System.out.println("Prva firma ne postoji.");
							continue;
						}
						break;
					}

					Company cb;
					while (true) {
						System.out.print("Unesite naziv DRUGE firme: ");
						String b = sc.nextLine().trim();
						if (b.isEmpty()) {
							System.out.println("Unos ne može biti prazan.");
							continue;
						}
						cb = graph.find(b);
						if (cb == null) {
							System.out.println("Druga firma ne postoji.");
							continue;
						}
						if (ca.equals(cb)) {
							System.out.println("Firma ne može biti partner sama sebi.");
							continue;
						}
						break;
					}

					if (!ca.hasPartner(cb)) {
						System.out.println("Partnerstvo između ove dvije firme ne postoji. Povratak na meni.");
						break;
					}

					if (graph.removePartnership(ca.getName(), cb.getName())) {
						System.out.println("Partnerstvo je obrisano.");
						break;
					} else {
						System.out.println("Brisanje nije uspjelo.");
					}
				}
				break;
			}

			case 9: { // Metoda (b)
				String name;
				while (true) {
					System.out.print("Unesite naziv firme: ");
					name = sc.nextLine().trim();
					if (name.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (graph.find(name) == null) {
						System.out.println("Firma koju ste unijeli ne postoji.");
						continue;
					}
					break;
				}

				String industry;
				while (true) {
					System.out.print("Unesite oblast partnera: ");
					industry = sc.nextLine().trim();
					if (industry.isEmpty()) {
						System.out.println("Unos ne može biti prazan.");
						continue;
					}
					if (!industryExists(industry)) {
						System.out.println("Ta oblast ne postoji.");
						System.out.println("Moguće oblasti su:");
						printIndustries();
						continue;
					}
					break;
				}

				graph.showPartnershipStatsByIndustry(name, industry);
				break;
			}

			case 10: { // Metoda (c)
				int n;
				while (true) {
					System.out.print("Unesite broj projekata N (>= 0): ");
					String line = sc.nextLine().trim();
					try {
						n = Integer.parseInt(line);
						if (n >= 0) {
							break;
						}
						System.out.println("Broj ne može biti negativan.");
					} catch (Exception e) {
						System.out.println("Pogrešan unos. Morate unijeti cijeli broj.");
					}
				}

				graph.showPartnersWithMoreProjectsThanN(n);
				break;
			}

			case 11: { // Prikaz svega
				System.out.println("\n--- SVE FIRME I NJIHOVA PARTNERSTVA ---");
				System.out.println(graph.toString());
				break;
			}
			}
		}

		sc.close();
	}

	// Pomoćne metode

	private static void printMenu() {
		System.out.println("\n========== MENI ==========");
		System.out.println("1  - Dodaj firmu");
		System.out.println("2  - Izmijeni naziv firme");
		System.out.println("3  - Izmijeni oblast firme");
		System.out.println("4  - Izmijeni godinu osnivanja firme");
		System.out.println("5  - Obriši firmu");
		System.out.println("6  - Dodaj partnerstvo");
		System.out.println("7  - Izmijeni partnerstvo");
		System.out.println("8  - Obriši partnerstvo");
		System.out.println("9  - Broj partnerstava i projekata firme iz odabrane oblasti");
		System.out.println("10 - Partnerstva sa više od N projekata");
		System.out.println("11 - Prikaži sve");
		System.out.println("0  - Izlaz");
		System.out.println("==========================");
	}

	private static boolean industryExists(String industry) {
		String[] industries = getIndustries();
		for (String s : industries) {
			if (s.equalsIgnoreCase(industry)) {
				return true;
			}
		}
		return false;
	}

	private static void printIndustries() {
		String[] industries = getIndustries();
		for (String s : industries) {
			System.out.println("- " + s);
		}
	}

	private static String[] getIndustries() {
		return new String[] { "IT", "Finansije", "Bankarstvo", "Osiguranje", "Telekomunikacije", "Zdravstvo",
				"Farmacija", "Obrazovanje", "Trgovina", "E-trgovina", "Marketing", "Mediji", "Proizvodnja",
				"Građevinarstvo", "Energetika", "Transport", "Logistika", "Turizam", "Poljoprivreda", "Nekretnine",
				"Konsalting", "Automobilska industrija", "Prehrambena industrija" };
	}
	
}
