package com.teamone.headachetracker.headache;

import com.teamone.headachetracker.headache.enums.PainDescriptor;
import com.teamone.headachetracker.headache.enums.Severity;

public class PainDescription {

	private Severity severity;
	private PainDescriptor painDescriptor;
	private String otherDescriptor;

	public PainDescription(Severity severity, PainDescriptor painDescriptor) {
		this.severity = severity;
		this.painDescriptor = painDescriptor;
	}

	public PainDescription(Severity severity, PainDescriptor painDescriptor, String otherDescriptor) {
		this.severity = severity;
		this.painDescriptor = painDescriptor;
		this.otherDescriptor = otherDescriptor;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public PainDescriptor getPainDescriptor() {
		return painDescriptor;
	}

	public void setPainDescriptor(PainDescriptor painDescriptor) {
		this.painDescriptor = painDescriptor;
	}

	public String getOtherDescriptor() {
		return otherDescriptor;
	}

	public void setOtherDescriptor(String otherDescriptor) {
		this.otherDescriptor = otherDescriptor;
	}

}
