package com.teamone.headachetracker.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.teamone.headachetracker.headache.Headache;
import com.teamone.headachetracker.treatment.SelfHelp;
import com.teamone.headachetracker.treatment.enums.Effectiveness;
import com.teamone.headachetracker.treatment.enums.SelfhelpDescriptor;
import com.teamone.headachetracker.user.Patient;

public class SelfHelpReport implements Report{
	public static final String NEWLINE = System.lineSeparator();
	
	public String getReport(Patient patient) {
		
		StringBuffer sb = null;
		int headacheCount = 0;
		List<ReportData> reportDataList = new ArrayList<ReportData>();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		sb = new StringBuffer("Detailed Self-help Report");
		sb.append(NEWLINE);
		List<Headache> headaches = patient.getHeadaches();
		for (Headache h : headaches) {

			if (headacheCount == 0) {
				sb.append("Start Date:");
				sb.append(format.format(h.getStartTime()));
				sb.append(NEWLINE);
			}
			List<SelfHelp> selfHelp = h.getSelfHelp();
			if(selfHelp!=null)
			{
				for(SelfHelp s : selfHelp){
					boolean inList = false;
					SelfhelpDescriptor descriptor = s.getName();
					for(ReportData d : reportDataList)
						if(d.getDescriptor() == descriptor)
						{
							double totalEffectivity = d.getAvgEffectifity() * d.getTimesUsed();
							totalEffectivity += (s.getStartPainLevel() - s.getReducedPainLevel());
							d.setTimesUsed(d.getTimesUsed() + 1);
							double avgEffectivity = totalEffectivity/d.getTimesUsed();
							d.setAvgEffectifity(avgEffectivity);
							inList = true;
						}
					if(!inList)
						reportDataList.add(new ReportData(descriptor, 1, (s.getStartPainLevel()-s.getReducedPainLevel())));				
				}
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
			sb.append("Self-Help Name: ");
			sb.append(d.getDescriptor());
			sb.append(NEWLINE);
			sb.append("Times Used: ");
			sb.append(d.getTimesUsed());
			sb.append(NEWLINE);
			sb.append("Average Effectivity: ");
			if(d.getAvgEffectifity() >= 3)
				sb.append(Effectiveness.HELPED_A_LOT);
			else if(d.getAvgEffectifity() > 0)
				sb.append(Effectiveness.HELPED_A_LITTLE);
			else if(d.getAvgEffectifity() == 0)
				sb.append(Effectiveness.DIDNOT_HELP);
			else
				sb.append(Effectiveness.MADE_IT_WORST);
			sb.append(NEWLINE);
		}
		String str = sb.toString();
		return str;

	}
	
	private class ReportData
	{
		private SelfhelpDescriptor descriptor;
		int timesUsed;
		double avgEffectifity;
		
		public ReportData(SelfhelpDescriptor descriptor, int timesUsed, double avgEffectivity)
		{
			this.setDescriptor(descriptor);
			this.timesUsed = timesUsed;
			this.avgEffectifity = avgEffectivity;
		}

		public int getTimesUsed() {
			return timesUsed;
		}

		public void setTimesUsed(int timesUsed) {
			this.timesUsed = timesUsed;
		}

		public double getAvgEffectifity() {
			return avgEffectifity;
		}

		public void setAvgEffectifity(double avgEffectifity) {
			this.avgEffectifity = avgEffectifity;
		}

		public SelfhelpDescriptor getDescriptor() {
			return descriptor;
		}

		public void setDescriptor(SelfhelpDescriptor descriptor) {
			this.descriptor = descriptor;
		}
	}

}
