import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Planetarium {

	public static void main(String[] args) {
		String[] satellites = new String[3];
		String formattedString = "";

		// planet object creation
		TerrestrialPlanet planetMercury = new TerrestrialPlanet("Mercury", 0.39, 58.65, 87.97, 0, null, false, false);
		TerrestrialPlanet planetVenus = new TerrestrialPlanet("Venus", 0.72, 243.1, 224.7, 0, null, false, false);
		satellites[0] = "Moon";
		TerrestrialPlanet planetEarth = new TerrestrialPlanet("Earth", 1.0, 1.0, 365.256, 1, satellites, false, true);
		satellites[0] = "Phobos";
		satellites[1] = "Deimos";
		TerrestrialPlanet planetMars = new TerrestrialPlanet("Mars", 1.524, 1.026, 687.0, 2, satellites, false, true);
		satellites[0] = "Ganymede";
		satellites[1] = "Callisto";
		satellites[2] = "Io";
		GaintPlanet planetJupiter = new GaintPlanet("Jupiter", 5.203, 0.41, 4332.71, 67, satellites, true, true);
		satellites[0] = "Titan";
		satellites[1] = "Rhea";
		satellites[2] = "Iapetus";
		GaintPlanet planetSaturn = new GaintPlanet("Saturn", 9.54, 0.426, 10759.5, 62, satellites, true, true);
		satellites[0] = "Titania";
		satellites[1] = "Oberon";
		satellites[2] = "Umbriel";
		GaintPlanet planetUranus = new GaintPlanet("Uranus", 19.19, 0.717, 30685.0, 27, satellites, true, false);
		satellites[0] = "Triton";
		satellites[1] = "Proteus";
		satellites[2] = "Nereid";
		GaintPlanet planetNeptune = new GaintPlanet("Neptune", 30.06, 0.671, 60190.0, 14, satellites, true, false);
		satellites[0] = "Charon";
		satellites[1] = "Nix";
		satellites[2] = "Hydra";
		DwarfPlanet planetPluto = new DwarfPlanet("Pluto", 39.53, 6.386, 90800.0, 5, satellites, false, false);

		// creating planets list to add to a star
		List<Planets> planets = new ArrayList<Planets>();
		planets.add(planetMercury);
		planets.add(planetVenus);
		planets.add(planetEarth);
		planets.add(planetMars);
		planets.add(planetJupiter);
		planets.add(planetSaturn);
		planets.add(planetUranus);
		planets.add(planetNeptune);
		planets.add(planetPluto);

		// creation of stars
		MainSequenceStar starSun = new MainSequenceStar("Sun", SpectralType.G, "Our Sun", 0.0, -26.75, 4.82, planets,1.0);
		planets = null;
		MainSequenceStar starSirius = new MainSequenceStar("Sirius", SpectralType.A, "Alpha Canis Majoris", 8.6, -1.46,1.43, planets, 2.02);
		planets = null;
		GaintStar starArcturus = new GaintStar("Arcturus", SpectralType.K, "Alpha Bootis", 37.0, -0.04, -0.3, planets,Gaintness.GAINT);
		planets = null;
		GaintStar starAlgol = new GaintStar("Algol", SpectralType.K, "Beta Persei", 93.0, 2.12, -0.1, planets,Gaintness.SUB_GAINT);
		planets = null;

		SupernovaStar starSanduleak = null;
		
		//Creation of celestial Visitors
		CelestialVisitor comet = null;
		CelestialVisitor Geminids = null;
		try {
			String dateString = "May 20, 1987";
			DateFormat format = new SimpleDateFormat("MMM d, yyyy");
			Date date = format.parse(dateString);
			dateString = "Jan 1, 1986";
			Date lastAppearedOn = format.parse(dateString);
			dateString = "Jan 1, 2061";
			Date nextAppearsOn = format.parse(dateString);
			starSanduleak = new SupernovaStar("Sanduleak - 69 - 202", SpectralType.B, "Supernova 1987A", 163000.0, 2.9,-15.6, planets, SupernovaType.II, date);
			// creation of celestial objects
			comet = new CelestialVisitor("Halley's Comet", lastAppearedOn, nextAppearsOn, true);
			dateString = "Dec 13, 2016";
			lastAppearedOn = format.parse(dateString);
			dateString = "Dec 13, 2017";
			nextAppearsOn = format.parse(dateString);
			Geminids = new CelestialVisitor("Geminids", lastAppearedOn, nextAppearsOn, true);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		AstroEntity[] astroEntities = {starSun,planetMercury,planetVenus,planetEarth,planetMars,planetJupiter,planetSaturn,planetUranus,
				                       planetNeptune,planetPluto,starSirius,starAlgol,starArcturus,starSanduleak,comet,Geminids};
		
		// Printing details of Planetarium
		System.out.println("Planetarium\n");
		System.out.println("**********************\n");
		
		for(AstroEntity entity: astroEntities){
			formattedString = entity.getFactualSummary();
			System.out.println(formattedString);
		}
		

	}

}
