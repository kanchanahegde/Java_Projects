package com.teamone.headachetracker.treatment;

import java.util.Date;

import com.teamone.headachetracker.treatment.enums.Effectiveness;
import com.teamone.headachetracker.treatment.enums.SelfhelpDescriptor;

public class SelfHelp extends Treatment {
	private SelfhelpDescriptor name;
	private Effectiveness effectiveness;

	public SelfHelp(Date startTime, Date effectiveTime, int startPainLevel, int newPainLevel,
			SelfhelpDescriptor name) {
		super(startTime, effectiveTime, startPainLevel, newPainLevel);
		this.name = name;
		this.effectiveness = ((startPainLevel - newPainLevel)>=3?Effectiveness.HELPED_A_LOT:
			                  (startPainLevel - newPainLevel)>0?Effectiveness.HELPED_A_LITTLE:
			                  (startPainLevel - newPainLevel)<0?Effectiveness.MADE_IT_WORST:Effectiveness.DIDNOT_HELP);
	}

	
	public SelfhelpDescriptor getName() {
		return name;
	}

	public void setName(SelfhelpDescriptor name) {
		this.name = name;
	}

	public Effectiveness getEffectiveness() {
		return effectiveness;
	}

	public void setEffectiveness(Effectiveness effectiveness) {
		this.effectiveness = effectiveness;
	}

}
