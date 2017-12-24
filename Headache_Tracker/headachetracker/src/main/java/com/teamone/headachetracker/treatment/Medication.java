package com.teamone.headachetracker.treatment;

import java.util.Date;

public class Medication extends Treatment {
	private String name;
	private String medicationClass;
	private int dose;
	
	public Medication(Date startTime, Date effectiveTime, int startPainLevel, int newPainLevel, String name,
			String medicationClass, int dose) {
		super(startTime, effectiveTime, startPainLevel, newPainLevel);
		this.name = name;
		this.medicationClass = medicationClass;
		this.dose = dose;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedicationClass() {
		return medicationClass;
	}

	public void setMedicationClass(String medicationClass) {
		this.medicationClass = medicationClass;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	
	

}
