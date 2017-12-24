package com.teamone.headachetracker.treatment;

import java.util.Date;

public abstract class Treatment {
	private Date startTime;
	private Date effectiveTime;
	private int startPainLevel;
	private int newPainLevel;
	public static final double MILLI_TO_HOUR = 1000 * 60 * 60;
	
	public Treatment(Date startTime, Date effectiveTime, int startPainLevel, int reducedPainLevel) {
		this.startTime = startTime;
		this.effectiveTime = effectiveTime;
		this.startPainLevel = startPainLevel;
		this.newPainLevel = reducedPainLevel;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getStartPainLevel() {
		return startPainLevel;
	}

	public void setStartPainLevel(int startPainLevel) {
		this.startPainLevel = startPainLevel;
	}

	public int getReducedPainLevel() {
		return newPainLevel;
	}

	public void setReducedPainLevel(int reducedPainLevel) {
		this.newPainLevel = reducedPainLevel;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}
	
	public double getEffectiveTimeInHours() {

		return ((effectiveTime.getTime() - startTime.getTime()) / MILLI_TO_HOUR);

	}
}
