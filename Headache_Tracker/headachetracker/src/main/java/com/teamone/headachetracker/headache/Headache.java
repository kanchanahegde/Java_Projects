package com.teamone.headachetracker.headache;

import com.teamone.headachetracker.treatment.Medication;
import com.teamone.headachetracker.treatment.SelfHelp;

import java.util.Date;
import java.util.List;

import com.teamone.headachetracker.headache.enums.HeadacheType;
import com.teamone.headachetracker.symptom.Symptom;

public class Headache {

	public static class HeadacheBuilder {
		private Date dateOfOccurance;
		private HeadacheType headacheType;
		private Date startTime;
		private Date endTime;
		private PainDescription painDescription;
		private List<PainLocation> painLocation;
		private List<Symptom> symptoms;
		private Medication medication;
		private List<SelfHelp> selfHelp;
		private List<Trigger> triggers;

		public HeadacheBuilder(Date dateOfOccurance) {
			this.dateOfOccurance = dateOfOccurance;
		}

		public HeadacheBuilder setHeadacheType(HeadacheType headacheType) {
			this.headacheType = headacheType;
			return this;
		}

		public HeadacheBuilder setStartTime(Date startTime) {
			this.startTime = startTime;
			return this;
		}

		public HeadacheBuilder setEndTime(Date endTime) {
			this.endTime = endTime;
			return this;
		}

		public HeadacheBuilder setPainDescription(PainDescription painDescription) {
			this.painDescription = painDescription;
			return this;
		}

		public HeadacheBuilder setPainLocation(List<PainLocation> painLocation) {
			this.painLocation = painLocation;
			return this;
		}

		public HeadacheBuilder setSymptoms(List<Symptom> symptoms) {
			this.symptoms = symptoms;
			return this;
		}

		public HeadacheBuilder setMedication(Medication medication) {
			this.medication = medication;
			return this;
		}

		public HeadacheBuilder setSelfHelp(List<SelfHelp> selfHelp) {
			this.selfHelp = selfHelp;
			return this;
		}

		public HeadacheBuilder setTriggers(List<Trigger> triggers) {
			this.triggers = triggers;
			return this;
		}

		public Headache build() {

			Headache headache = new Headache();

			headache.dateOfOccurance = this.dateOfOccurance;
			headache.headacheType = this.headacheType;
			headache.startTime = this.startTime;
			headache.endTime = this.endTime;
			headache.painDescription = this.painDescription;
			headache.painLocation = this.painLocation;
			headache.symptoms = this.symptoms;
			headache.medication = this.medication;
			headache.selfHelp = this.selfHelp;
			headache.triggers = this.triggers;
			return headache;
		}

	}

	private Date dateOfOccurance;
	private HeadacheType headacheType;
	private Date startTime;
	private Date endTime;
	private PainDescription painDescription;
	private List<PainLocation> painLocation;
	private List<Symptom> symptoms;
	private Medication medication;
	private List<SelfHelp> selfHelp;
	private List<Trigger> triggers;

	private Headache() {
	}

	public Date getDateOfOccurance() {
		return dateOfOccurance;
	}

	public HeadacheType getHeadacheType() {
		return headacheType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public PainDescription getPainDescription() {
		return painDescription;
	}

	public List<PainLocation> getPainLocation() {
		return painLocation;
	}

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public Medication getMedication() {
		return medication;
	}

	public List<SelfHelp> getSelfHelp() {
		return selfHelp;
	}

	public List<Trigger> getTriggers() {
		return triggers;
	}

	
}
