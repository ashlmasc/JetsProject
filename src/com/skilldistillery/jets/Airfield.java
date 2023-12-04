package com.skilldistillery.jets;

import java.util.ArrayList;

public class Airfield {
	private ArrayList<Jet> jets;

	public Airfield() {
		this.jets = new ArrayList<>();
	}

	public void addJet(Jet jet) {
		jets.add(jet);
	}

	public void removeJet(int index) {
		jets.remove(index);
	}

	public ArrayList<Jet> getJets() {
		return jets;
	}
}