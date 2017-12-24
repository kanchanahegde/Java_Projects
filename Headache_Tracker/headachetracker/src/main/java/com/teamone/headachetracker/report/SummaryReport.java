package com.teamone.headachetracker.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;

import com.teamone.headachetracker.headache.Headache;
import com.teamone.headachetracker.user.Patient;

public class SummaryReport implements Report {

	public static final String NEWLINE = System.lineSeparator();
	public static final double MILLI_TO_HOUR = 1000 * 60 * 60;

	public String getReport(Patient patient) {
		StringBuffer sb = new StringBuffer("Summary Report");;

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		sb.append(NEWLINE);
		
		List<Headache> headaches = patient.getHeadaches();

		Date reportStart = headaches.stream().map(Headache::getStartTime).min(Date::compareTo).get();
		Date reportEnd = headaches.stream().map(Headache::getEndTime).max(Date::compareTo).get();
		OptionalDouble avgSeverity = headaches.stream()
				.mapToDouble(h -> h.getPainDescription().getSeverity().getValue()).average();
		OptionalDouble avgDuration = headaches.stream().mapToDouble(h -> {
			return (h.getEndTime().getTime() - h.getStartTime().getTime()) / MILLI_TO_HOUR;
		}).average();

		sb.append("Start Date:");
		sb.append(format.format(reportStart.getTime()));
		sb.append(NEWLINE);
		sb.append("End Date:");
		sb.append(format.format(reportEnd.getTime()));
		sb.append(NEWLINE);
		sb.append("Headache Count:");
		sb.append(headaches.size());
		sb.append(NEWLINE);
		sb.append("Average Severity:");
		sb.append(avgSeverity.getAsDouble());
		sb.append(NEWLINE);
		sb.append("Average Duration (hours):");
		sb.append(avgDuration.getAsDouble());
		sb.append(NEWLINE);

		return sb.toString();

	}

}
