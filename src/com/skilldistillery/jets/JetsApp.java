package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApp {
	private Airfield airfield = new Airfield();
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.initializeJets();

		int choice = 0;

		do {
			app.displayUserMenu();
			System.out.print("Enter your choice: ");
			choice = app.scanner.nextInt();
			app.scanner.nextLine();

			switch (choice) {
			case 1:
				app.listFleet();
				break;
			case 2:
				app.flyAllJets();
				break;
			case 3:
				app.viewFastestJet();
				break;
			case 4:
				app.viewLongestRangeJet();
				break;
			case 5:
				app.loadAllCargoJets();
				break;
			case 6:
				app.dogfight();
				break;
			case 7:
				app.addJetToFleet();
				break;
			case 8:
				app.removeJetFromFleet();
				break;
			case 9:
				System.out.println("Exiting program. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 9);
	}

	public void initializeJets() {
		Jet passengerJet1 = new PassengerJet("Passenger Jet 1", 600, 2000, 1000000);
		Jet passengerJet2 = new PassengerJet("Passenger Jet 2", 700, 1800, 1200000);
		Jet cargoJet1 = new CargoJet("Cargo Jet 1", 500, 2500, 800000);
		Jet cargoJet2 = new CargoJet("Cargo Jet 2", 550, 2200, 900000);
		Jet fighterJet = new FighterJet("Fighter Jet 1", 1200, 800, 1500000);

		airfield.addJet(passengerJet1);
		airfield.addJet(passengerJet2);
		airfield.addJet(cargoJet1);
		airfield.addJet(cargoJet2);
		airfield.addJet(fighterJet);
	}

	public void displayUserMenu() {
		System.out.println("------------------------------------");
		System.out.println("|           Menu Options           |");
		System.out.println("------------------------------------");
		System.out.println("|  1. List fleet                   |");
		System.out.println("|  2. Fly all jets                 |");
		System.out.println("|  3. View fastest jet             |");
		System.out.println("|  4. View jet with longest range  |");
		System.out.println("|  5. Load all Cargo Jets          |");
		System.out.println("|  6. Dogfight!                    |");
		System.out.println("|  7. Add a jet to fleet           |");
		System.out.println("|  8. Remove a jet from fleet      |");
		System.out.println("|  9. Quit                         |");
		System.out.println("------------------------------------");
	}

	public void listFleet() {
		for (int i = 0; i < airfield.getJets().size(); i++) {
			System.out.println("Jet " + (i + 1) + ":");
			if (airfield.getJets().get(i) instanceof PassengerJet) {
				System.out.println("Type: Passenger Jet");
			} else if (airfield.getJets().get(i) instanceof CargoCarrier) {
				System.out.println("Type: Cargo Jet");
			} else if (airfield.getJets().get(i) instanceof CombatReady) {
				System.out.println("Type: Fighter Jet");
			}
			airfield.getJets().get(i).fly();
		}
	}

	public void flyAllJets() {
		System.out.println("\nFlying all Jets:\n");
		for (Jet jet : airfield.getJets()) {
			jet.fly();
		}
	}

	public void viewFastestJet() {
		Jet fastestJet = findFastestJet();
		System.out.println("\nFastest Jet:\n" + fastestJet);
	}

	public Jet findFastestJet() {
		Jet fastestJet = null;
		double maxSpeed = Double.MIN_VALUE;

		for (Jet jet : airfield.getJets()) {
			if (jet.getSpeed() > maxSpeed) {
				maxSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		return fastestJet;
	}

	public void viewLongestRangeJet() {
		Jet longestRangeJet = findLongestRangeJet();
		System.out.println("\nJet with Longest Range:\n" + longestRangeJet);
	}

	public Jet findLongestRangeJet() {
		Jet longestRangeJet = null;
		int maxRange = Integer.MIN_VALUE;

		for (Jet jet : airfield.getJets()) {
			if (jet.getRange() > maxRange) {
				maxRange = jet.getRange();
				longestRangeJet = jet;
			}
		}
		return longestRangeJet;
	}

	public void loadAllCargoJets() {
		System.out.println("\nLoading Cargo for all Cargo Jets:");
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void dogfight() {
		System.out.println("\nEngaging in dogfight for all Fighter Jets:");
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}
		}
	}

	public void addJetToFleet() {
		System.out.println("\nAdding a new Jet to the fleet:");
		System.out.print("Enter the Jet type (1. Passenger, 2. Cargo, 3. Fighter): ");
		int jetType = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter the Jet model: ");
		String model = scanner.nextLine();

		System.out.print("Enter the Jet speed (in MPH): ");
		double speed = scanner.nextDouble();

		System.out.print("Enter the Jet range: ");
		int range = scanner.nextInt();

		System.out.print("Enter the Jet price: ");
		long price = scanner.nextLong();

		Jet newJet = null;

		switch (jetType) {
		case 1:
			newJet = new PassengerJet(model, speed, range, price);
			break;
		case 2:
			newJet = new CargoJet(model, speed, range, price);
			break;
		case 3:
			newJet = new FighterJet(model, speed, range, price);
			break;
		default:
			System.out.println("Invalid Jet type. Jet not added to the fleet.");
		}

		if (newJet != null) {
			airfield.addJet(newJet);
			System.out.println("New Jet added to the fleet!");
		}
	}

	public void removeJetFromFleet() {
		System.out.println("\nRemoving a Jet from the fleet:");
		listFleet();
		System.out.print("Enter the number of the Jet to remove: ");
		int jetNumber = scanner.nextInt();

		if (jetNumber >= 1 && jetNumber <= airfield.getJets().size()) {
			airfield.removeJet(jetNumber - 1);
			System.out.println("Jet removed from the fleet.");
		} else {
			System.out.println("Invalid Jet number. No Jet removed.");
		}
	}
}