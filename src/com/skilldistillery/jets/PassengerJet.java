package com.skilldistillery.jets;

public class PassengerJet extends Jet {

	public PassengerJet(String model, double speed, int range, long price) {
        super(model, speed, range, price);
    }

	public void loadCargo() {
        System.out.println("Loading cargo for " + getModel());
    }
}

