package com.teamone.headachetracker.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.teamone.headachetracker.headache.Headache;
import com.teamone.headachetracker.treatment.Medication;
import com.teamone.headachetracker.user.Patient;

public class MedicationReport implements Report{
	public static final String NEWLINE = System.lineSeparator();
	
	public String getReport(Patient patient) {
		
		StringBuffer sb = null;
		int headacheCount = 0;
		List<ReportData> reportDataList = new ArrayList<ReportData>();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		sb = new StringBuffer("Detailed Medication Report");
		sb.append(NEWLINE);
		List<Headache> headaches = patient.getHeadaches();
		for (Headache h : headaches) {
			if (headacheCount == 0) {
				sb.append("Start Date:");
				sb.append(format.format(h.getStartTime()));
				sb.append(NEWLINE);
			}
			Medication med = h.getMedication();
			if(med!=null)
			{
				boolean inList = false;
				String name = med.getName();
				for(ReportData d : reportDataList)
					if(d.getName().equals(name))
					{
						double totalEffectivity = d.getAvgTimeToEffectivity() * d.getDosesTaken();
						totalEffectivity += med.getEffectiveTimeInHours();
						d.setDosesTaken(d.getDosesTaken() + 1);
						double avgTimeToEffectivity = totalEffectivity/d.getDosesTaken();
						d.setAvgTimeToEffectivity(avgTimeToEffectivity);
						inList = true;
					}
				if(!inList)
					reportDataList.add(new ReportData(name, med.getMedicationClass(), med.getDose(), med.getEffectiveTimeInHours(), 1));		
			}
			headacheCount++;
		}

		Headache lastHeadache = headaches.get(headaches.size() - 1);
		sb.append("End Date:");
		sb.append(format.format(lastHeadache.getEndTime()));
		sb.append(NEWLINE);
		for(ReportData d : reportDataList)
		{
			sb.append(NEWLINE);
			sb.append("Medication Name: ");
			sb.append(d.getName());
			sb.append(NEWLINE);
			sb.append("Medication Class: ");
			sb.append(d.getMedClass());
			sb.append(NEWLINE);
			sb.append("Dose: ");
			sb.append(d.getDose());
			sb.append(" mg");
			sb.append(NEWLINE);
			sb.append("Average Time to Effectivity (hours): ");
			sb.append(d.getAvgTimeToEffectivity());
			sb.append(NEWLINE);
			sb.append("Total Doses Taken: ");
			sb.append(d.getDosesTaken());
			sb.append(NEWLINE);
		}
		String str = sb.toString();
		return str;

	}

	private class ReportData
	{
		public ReportData(String name, String medClass, int dose, double avgTimeToEffectivity,  int dosesTaken) {
			this.name = name;
			this.medClass = medClass;
			this.dose = dose;
			this.dosesTaken = dosesTaken;
			this.avgTimeToEffectivity = avgTimeToEffectivity;
		}
		
		String name, medClass;
		int dose, dosesTaken;
		double avgTimeToEffectivity;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMedClass() {
			return medClass;
		}
		public void setMedClass(String medClass) {
			this.medClass = medClass;
		}
		public int getDose() {
			return dose;
		}
		public void setDose(int dose) {
			this.dose = dose;
		}
		public int getDosesTaken() {
			return dosesTaken;
		}
		public void setDosesTaken(int dosesTaken) {
			this.dosesTaken = dosesTaken;
		}
		public double getAvgTimeToEffectivity() {
			return avgTimeToEffectivity;
		}
		public void setAvgTimeToEffectivity(double avgTimeToEffectivity) {
			this.avgTimeToEffectivity = avgTimeToEffectivity;
		}
	
		
	}

}
