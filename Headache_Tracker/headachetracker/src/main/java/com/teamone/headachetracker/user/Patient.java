package com.teamone.headachetracker.user;

import java.util.ArrayList;
import java.util.List;

import com.teamone.headachetracker.headache.Headache;

public class Patient {

	private String name;
	private Neurologist neurologist;
	private List<Headache> headaches;
	
	
	public Patient(String name) {
		this.name = name;
		this.headaches = new ArrayList<Headache>();
	}

	public String getName() {
		return name;
	}

	public Neurologist getNeurologist() {
		return neurologist;
	}

	public void setNeurologist(Neurologist neurologist) {
		this.neurologist = neurologist;
	}

	public List<Headache> getHeadaches() {
		return headaches;
	}

	public void logHeadache(Headache headache) {
		this.headaches.add(headache);
	}

}
