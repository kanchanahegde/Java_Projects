package com.teamone.headachetracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teamone.headachetracker.headache.*;
import com.teamone.headachetracker.headache.enums.*;
import com.teamone.headachetracker.report.MedicationReport;
import com.teamone.headachetracker.report.RawDataOutput;
import com.teamone.headachetracker.report.SelfHelpReport;
import com.teamone.headachetracker.report.SummaryReport;
import com.teamone.headachetracker.treatment.Medication;
import com.teamone.headachetracker.treatment.SelfHelp;
import com.teamone.headachetracker.treatment.enums.SelfhelpDescriptor;
import com.teamone.headachetracker.symptom.Symptom;
import com.teamone.headachetracker.symptom.enums.*;
import com.teamone.headachetracker.user.Neurologist;
import com.teamone.headachetracker.user.Patient;

public class HeadacheTracker {
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		
		
		
		
		//Create patient
		Patient patient1 = new Patient("ABC");
		
		try {
			//HEADACHE 1
			
			List<Symptom> h1Symptoms = new ArrayList<Symptom>();
			h1Symptoms.add(new Symptom(HeadachePhase.PRODROME, PossibleSymptom.NAUSEA));
			h1Symptoms.add(new Symptom(HeadachePhase.CONCURRENT, PossibleSymptom.LIGHT_SENSITIVITY));
			h1Symptoms.add(new Symptom(HeadachePhase.CONCURRENT, PossibleSymptom.SOUND_SENSEITIVITY));
			h1Symptoms.add(new Symptom(HeadachePhase.POSTDROME, PossibleSymptom.OTHER, "fatigue"));
			List<PainLocation> h1PainLocations = new ArrayList<PainLocation>();
			h1PainLocations.add(new PainLocation(Location.OCULAR, Sidedness.LEFT_SIDE));
			List<Trigger> h1Trigger = new ArrayList<Trigger>();
			h1Trigger.add(new Trigger(TriggerDescriptor.SCENTS,"Fumes From Construction"));
			h1Trigger.add(new Trigger(TriggerDescriptor.LIGHTING,"Sun glare"));
	
			Headache headache1 = new Headache.HeadacheBuilder(format.parse("05/01/2017 07:30 AM"))
					.setHeadacheType(HeadacheType.MIGRAINE)
					.setStartTime(format.parse("05/01/2017 07:30 AM"))
					.setEndTime(format.parse("05/01/2017 11:00 AM"))
					.setPainDescription(new PainDescription(Severity.SEVEN, PainDescriptor.STABBING))
					.setPainLocation(h1PainLocations)
					.setSymptoms(h1Symptoms)
					.setMedication(new Medication(format.parse("05/01/2017 09:00 AM"),format.parse("05/01/2017 11:00 AM"), 7, 2,"MaxAlt","triptan", 5))
					.setTriggers(h1Trigger)
					.build();
			patient1.logHeadache(headache1);
			
			//HEADACHE 2
			List<Symptom> h2Symptoms  = new ArrayList<Symptom>();
			List<Trigger> h2Trigger = new ArrayList<Trigger>();
			List<PainLocation> h2PainLocations = new ArrayList<PainLocation>();
			List<SelfHelp> h2SelfHelp = new ArrayList<SelfHelp>();
			h2Symptoms.add(new Symptom(HeadachePhase.CONCURRENT, PossibleSymptom.NECK_PAIN));
			h2PainLocations.add(new PainLocation(Location.SUB_OCCIPITAL, Sidedness.BILATERAL));
			h2SelfHelp.add(new SelfHelp(format.parse("05/06/2017 07:00 PM"),
				      format.parse("05/06/2017 09:15 PM"), 5, 2,SelfhelpDescriptor.PHYSICAL_THERAPY));
			h2Trigger.add(new Trigger(TriggerDescriptor.MISSED_MEAL));
			
			
			Headache headache2 = new Headache.HeadacheBuilder(format.parse("05/06/2017 06:00 PM"))
					.setHeadacheType(HeadacheType.TENSION)
					.setStartTime(format.parse("05/06/2017 06:00 PM"))
					.setEndTime(format.parse("05/06/2017 09:15 PM"))
					.setPainDescription(new PainDescription(Severity.FIVE, PainDescriptor.DULL))
					.setPainLocation(h2PainLocations)
					.setSymptoms(h2Symptoms)
					.setSelfHelp(h2SelfHelp)
					.setMedication( new Medication(format.parse("05/06/2017 07:00 PM"), format.parse("05/06/2017 09:15 PM"), 5, 2,"Anaprox","NSAID", 550))
					.setTriggers(h2Trigger)
					.build();
		
			
			patient1.logHeadache(headache2);
			
			List<Symptom> h3Symptoms = new ArrayList<Symptom>();
			List<Trigger> h3Trigger = new ArrayList<Trigger>();
			List<PainLocation> h3PainLocations = new ArrayList<PainLocation>();
			List<SelfHelp> h3SelfHelp = new ArrayList<SelfHelp>();
			h3Symptoms.add(new Symptom(HeadachePhase.CONCURRENT, PossibleSymptom.NECK_PAIN));
			h3Symptoms.add(new Symptom(HeadachePhase.CONCURRENT, PossibleSymptom.SINUS));
			h3Symptoms.add(new Symptom(HeadachePhase.CONCURRENT, PossibleSymptom.CONGESTION));
			h3PainLocations.add(new PainLocation(Location.FRONTAL, Sidedness.BILATERAL));
			h3PainLocations.add(new PainLocation(Location.TEMPORAL, Sidedness.RIGHT_SIDE));
			h3SelfHelp.add(new SelfHelp(format.parse("05/10/2017 05:00 PM"),
				      format.parse("05/10/2017 07:00 PM"), 6, 6,SelfhelpDescriptor.BIOFEEDBACK));
			h3SelfHelp.add(new SelfHelp(format.parse("05/10/2017 05:00 PM"),
				      format.parse("05/10/2017 07:00 PM"), 6, 3,SelfhelpDescriptor.PHYSICAL_THERAPY));
			h3Trigger.add(new Trigger(TriggerDescriptor.STRESS));
			
			
			Headache headache3 = new Headache.HeadacheBuilder(format.parse("05/10/2017 04:00 PM"))
					.setHeadacheType(HeadacheType.TENSION)
					.setStartTime(format.parse("05/10/2017 04:00 PM"))
					.setEndTime(format.parse("05/10/2017 09:00 PM"))
					.setPainDescription(new PainDescription(Severity.SIX, PainDescriptor.DULL))
					.setPainLocation(h3PainLocations)
					.setSymptoms(h3Symptoms)
					.setMedication(new Medication(format.parse("05/10/2017 05:00 PM"), format.parse("05/10/2017 07:00 PM"), 6, 2,"Anaprox","NSAID", 550))
					.setSelfHelp(h3SelfHelp)
					.setTriggers(h3Trigger)
					.build();	
			
			patient1.logHeadache(headache3);
	
			List<Symptom> h4Symptoms = new ArrayList<Symptom>();
			List<Trigger> h4Trigger = new ArrayList<Trigger>();
			List<PainLocation> h4PainLocations = new ArrayList<PainLocation>();
			List<SelfHelp> h4SelfHelp = new ArrayList<SelfHelp>();
			h4Symptoms.add(new Symptom(HeadachePhase.PRODROME, PossibleSymptom.NAUSEA));
			h4Symptoms.add(new Symptom(HeadachePhase.PRODROME, PossibleSymptom.TEARING));
			h4Symptoms.add(new Symptom(HeadachePhase.CONCURRENT, PossibleSymptom.VISION_DISTURBANCES));
			h4PainLocations.add(new PainLocation(Location.OCULAR, Sidedness.LEFT_SIDE));
			h4SelfHelp.add(new SelfHelp(format.parse("05/17/2017 06:15 AM"),
				      format.parse("05/17/2017 07:30 AM"), 7, 6,SelfhelpDescriptor.SLEEP));
			h4Trigger.add(new Trigger(TriggerDescriptor.SLEEP_CYCLE_CHANGE,"Lack of sleep"));
			
			
			Headache headache4 = new Headache.HeadacheBuilder(format.parse("05/10/2017 04:00 PM"))
					.setHeadacheType(HeadacheType.MIGRAINE)
					.setStartTime(format.parse("05/17/2017 06:00 AM"))
					.setEndTime(format.parse("05/17/2017 09:00 AM"))
					.setPainDescription(new PainDescription(Severity.SEVEN, PainDescriptor.PULSATING))
					.setPainLocation(h4PainLocations)
					.setSymptoms(h4Symptoms)
					.setMedication(new Medication(format.parse("05/17/2017 06:15 AM"),format.parse("05/17/2017 07:30 AM"), 7, 2,"MaxAlt","triptan", 5))
					.setSelfHelp(h4SelfHelp)
					.setTriggers(h4Trigger)
					.build();
			
			patient1.logHeadache(headache4);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		// Create Neurologist
		Neurologist neurologist = new Neurologist("XYZ");
		//Add patient to Neurologist
		neurologist.addPatient(patient1);
        
		
		//Print Raw Data Output
		System.out.println(neurologist.viewReport(patient1, new RawDataOutput()));
		//Print Summary Report of a patient
		System.out.println(neurologist.viewReport(patient1, new SummaryReport()));
		//Print Medication Report of a patient
		System.out.println(neurologist.viewReport(patient1, new MedicationReport()));
		//Print SelfHelp Report of a patient
		System.out.println(neurologist.viewReport(patient1, new SelfHelpReport()));
		
	}
}
