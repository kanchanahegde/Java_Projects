package com.teamone.headachetracker.headache;

import com.teamone.headachetracker.headache.enums.Location;
import com.teamone.headachetracker.headache.enums.Sidedness;

public class PainLocation {
	private Location location;
	private Sidedness sidedness;

	public PainLocation(Location location, Sidedness sidedness) {
		this.location = location;
		this.sidedness = sidedness;
	}

	public Location getLocation() {
		return location;
	}

	public Sidedness getSidedness() {
		return sidedness;
	}
	
	
}
