package com.skilldistillery.jets;

public abstract class Jet {

	private String model;
	private double speed;
	private int range;
	private long price;

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;

	}

	public void fly() {
		System.out.println("Model: " + model + "\n" + "Speed: " + speed + "MPH"  + "\n" + "Range: " + range
				+ " miles" + "\nPrice: $" + price);
		double timeToFly = range / speed;
		System.out.println("Time to fly until fuel runs out: " + timeToFly + " hours\n");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Model: " + model + "\n" + "Speed: " + speed + "\n" + "Range: " + range;
	}

}
