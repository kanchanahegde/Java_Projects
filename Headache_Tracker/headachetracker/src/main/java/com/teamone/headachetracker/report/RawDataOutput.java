package com.teamone.headachetracker.report;

import java.text.SimpleDateFormat;
import java.util.List;

import com.teamone.headachetracker.headache.Headache;
import com.teamone.headachetracker.headache.PainLocation;
import com.teamone.headachetracker.headache.Trigger;
import com.teamone.headachetracker.symptom.Symptom;
import com.teamone.headachetracker.symptom.enums.PossibleSymptom;
import com.teamone.headachetracker.treatment.SelfHelp;
import com.teamone.headachetracker.user.Patient;

public class RawDataOutput implements Report {

	public static final String NEWLINE = System.lineSeparator();
	
	public String getReport(Patient patient) {
		StringBuffer sb = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		sb = new StringBuffer("Raw Data Report");
		sb.append(NEWLINE);
		List<Headache> headaches = patient.getHeadaches();
		int headacheNumber = 1;
		for (Headache h : headaches) {
			sb.append("Headache Number: ");
			sb.append(headacheNumber);
			sb.append(NEWLINE);
			sb.append("Date: ");
			sb.append(dateFormat.format(h.getStartTime()));
			sb.append(NEWLINE);
			sb.append("Start Time: ");
			sb.append(timeFormat.format(h.getStartTime()));
			sb.append(NEWLINE);
			sb.append("End Time: ");
			sb.append(timeFormat.format(h.getEndTime()));
			sb.append(NEWLINE);
			sb.append("Type: ");
			sb.append(h.getHeadacheType());
			sb.append(NEWLINE);
			sb.append("Severity: ");
			sb.append(h.getPainDescription().getSeverity());
			sb.append(NEWLINE);
			sb.append("Pain Description: ");
			sb.append(h.getPainDescription().getPainDescriptor());
			sb.append(NEWLINE);

			sb.append("Location: ");
			for(PainLocation l : h.getPainLocation())
			{
				sb.append(l.getSidedness());
				sb.append("/"); 
				sb.append(l.getLocation());
				sb.append(", ");
			}
			sb.append(NEWLINE);
			sb.append("Symptoms: ");
			for(Symptom s : h.getSymptoms())
			{
				sb.append(s.getHeadachePhase());
				sb.append(" - ");
				if(s.getPossibleSymptom()==PossibleSymptom.OTHER)
					sb.append(s.getOtherSymptomDescription());
				else 
					sb.append(s.getPossibleSymptom());
				sb.append(", ");
			}
			sb.append(NEWLINE);
			sb.append("Medication: ");
			sb.append(h.getMedication().getName());
			sb.append(" , ");
			sb.append(h.getMedication().getMedicationClass());
			sb.append(" class, ");
			sb.append(h.getMedication().getDose());
			sb.append(" mg");
			sb.append(NEWLINE);
			sb.append("MedStart: ");
			sb.append(timeFormat.format(h.getMedication().getStartTime()));
			sb.append(NEWLINE);
			sb.append("MedEffective: ");
			sb.append(timeFormat.format(h.getMedication().getEffectiveTime()));
			sb.append(NEWLINE);
			sb.append("Triggers: ");
			for(Trigger t : h.getTriggers())
			{
				sb.append(t.getTriggerDescriptor());
				if(t.getTriggerNote() != null)
				{
					sb.append(" - ");
					sb.append(t.getTriggerNote());
				}
				sb.append(", ");
			}
			sb.append(NEWLINE);
			sb.append("Self-Help: ");
			if(h.getSelfHelp() == null)
				sb.append("none");
			else
				for(SelfHelp s : h.getSelfHelp())
				{
					sb.append(s.getName());
					sb.append("->");
					sb.append(s.getEffectiveness());
					sb.append(", ");
				}
			sb.append(NEWLINE);
			headacheNumber++;
			sb.append(NEWLINE);
		}

		String str = sb.toString();
		return str;
	}

}
