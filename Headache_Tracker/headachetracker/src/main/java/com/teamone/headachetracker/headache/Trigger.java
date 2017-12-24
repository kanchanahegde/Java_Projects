package com.teamone.headachetracker.headache;

import com.teamone.headachetracker.headache.enums.TriggerDescriptor;

public class Trigger {
	private TriggerDescriptor triggerDescriptor;
	private String otherTrigger;
	private String triggerNote;

	public Trigger(TriggerDescriptor triggerDescriptor, String triggerNote) {
		this.triggerDescriptor = triggerDescriptor;
		this.triggerNote = triggerNote;
	}

	public Trigger(TriggerDescriptor triggerDescriptor) {
		this.triggerDescriptor = triggerDescriptor;

	}

	public Trigger(String otherTrigger, String triggerNote) {
		this.otherTrigger = otherTrigger;
		this.triggerNote = triggerNote;
	}

	public Trigger(String otherTrigger) {

		this.otherTrigger = otherTrigger;
	}

	public TriggerDescriptor getTriggerDescriptor() {
		return triggerDescriptor;
	}

	public void setTriggerDescriptor(TriggerDescriptor triggerDescriptor) {
		this.triggerDescriptor = triggerDescriptor;
	}

	public String getOtherTrigger() {
		return otherTrigger;
	}

	public void setOtherTrigger(String otherTrigger) {
		this.otherTrigger = otherTrigger;
	}

	public String getTriggerNote() {
		return triggerNote;
	}

	public void setTriggerNote(String triggerNote) {
		this.triggerNote = triggerNote;
	}

}
