package com.teamone.headachetracker.symptom;

import com.teamone.headachetracker.symptom.enums.HeadachePhase;
import com.teamone.headachetracker.symptom.enums.PossibleSymptom;

public class Symptom {
	private HeadachePhase headachePhase;
	private PossibleSymptom possibleSymptom;
	private String otherSymptomDescription;

	public Symptom(HeadachePhase headachePhase, PossibleSymptom possibleSymptom) {
		this.headachePhase = headachePhase;
		if(possibleSymptom == PossibleSymptom.OTHER)
			throw new IllegalArgumentException("Cannot use 'OTHER' symptom without a description.");
		
		this.possibleSymptom = possibleSymptom;
	}

	public Symptom(HeadachePhase headachePhase, PossibleSymptom possibleSymptom, String otherSymptomDescription) {
		this.headachePhase = headachePhase;
		if(possibleSymptom != PossibleSymptom.OTHER)
			throw new IllegalArgumentException("Symptom has to be 'OTHER' and must provide a description.");
		this.possibleSymptom = possibleSymptom;
		this.otherSymptomDescription = otherSymptomDescription;
	}

	public HeadachePhase getHeadachePhase() {
		return headachePhase;
	}

	public void setHeadachePhase(HeadachePhase headachePhase) {
		this.headachePhase = headachePhase;
	}

	public PossibleSymptom getPossibleSymptom() {
		return possibleSymptom;
	}

	public void setPossibleSymptom(PossibleSymptom possibleSymptom) {
		this.possibleSymptom = possibleSymptom;
	}

	public String getOtherSymptomDescription() {
		return otherSymptomDescription;
	}

	public void setOtherSymptomDescription(String otherSymptomDescription) {
		this.otherSymptomDescription = otherSymptomDescription;
	}

}
