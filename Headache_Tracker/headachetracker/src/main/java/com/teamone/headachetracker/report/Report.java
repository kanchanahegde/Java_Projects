package com.teamone.headachetracker.report;
import com.teamone.headachetracker.user.Patient;

public interface Report {

	public abstract String getReport(Patient patient);
}
