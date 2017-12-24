package com.teamone.headachetracker.user;

import java.util.ArrayList;
import java.util.List;

import com.teamone.headachetracker.report.Report;
import com.teamone.headachetracker.symptom.Symptom;

public class Neurologist {

	private String name;
	private List<Patient> patients;

	public Neurologist(String name) {
		this.name = name;
		patients = new ArrayList<Patient>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public void addPatient(Patient patient) {
		patients.add(patient);
	}

	public String viewReport(Patient patient, Report report){
		return report.getReport(patient);
	}



}
