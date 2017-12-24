/**
 * Class for Gaint Planet Type
 *
 */
public class GaintPlanet extends Planets {

	private boolean cloudBelts;
	static final PlanetType planetType = PlanetType.GAS_GAINT;

	public GaintPlanet(String commonName, double distanceFromSun, double sideRealDay, double orbitalPeriod,
			int numberOfSatellites, String[] satellites, boolean hasRing, boolean cloudBelts) {
		super(commonName, distanceFromSun, sideRealDay, orbitalPeriod, numberOfSatellites, satellites, hasRing);
		this.cloudBelts = cloudBelts;
	}

	public boolean isCloudBelts() {
		return cloudBelts;
	}

	public void setCloudBelts(boolean cloudBelts) {
		this.cloudBelts = cloudBelts;
	}

	@Override
	public String getCelestialClassification() {
		return planetType.name(); // Returns the planet type

	}

	@Override
	public String getFactualSummary() {
		String formattedString;
		String commonName;
		commonName = this.getCommonName();
		formattedString = String.format("Name = %s \nCelestial Classification = %s \n", commonName, planetType);
		formattedString = formattedString + super.getFactualSummary();
		formattedString = formattedString + String.format("Has cloud belts  = %b \n ", cloudBelts);
		return formattedString;
	}
}
