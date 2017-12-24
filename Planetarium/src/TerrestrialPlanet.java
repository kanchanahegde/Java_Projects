/**
 * Class for Terrestrial Planet Type
 *
 */
public class TerrestrialPlanet extends Planets {

	static final PlanetType planetType = PlanetType.TERRESTRIAL;
	private boolean icecapsAtPoles;

	public TerrestrialPlanet(String commonName, double d, double e, double f, int numberOfSatellites,
			String[] satellites, boolean hasRing, boolean icecapsAtPoles) {
		super(commonName, d, e, f, numberOfSatellites, satellites, hasRing);
		this.icecapsAtPoles = icecapsAtPoles;
	}

	public boolean isIcecapsAtPoles() {
		return icecapsAtPoles;
	}

	public void setIcecapsAtPoles(boolean icecapsAtPoles) {
		this.icecapsAtPoles = icecapsAtPoles;
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
		formattedString = formattedString + String.format("Has ice caps  = %b \n ", icecapsAtPoles);
		return formattedString;

	}

}
