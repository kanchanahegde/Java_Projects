/**
 * Class for Dwarf Planet Type
 *
 */
public class DwarfPlanet extends Planets {

	private boolean shape;
	static final PlanetType planetType = PlanetType.DWARF;

	public DwarfPlanet(String commonName, double distanceFromSun, double sideRealDay, double orbitalPeriod,
			int numberOfSatellites, String[] satellites, boolean hasRing, boolean b) {
		super(commonName, distanceFromSun, sideRealDay, orbitalPeriod, numberOfSatellites, satellites, hasRing);
		this.shape = b;
	}

	public boolean getShape() {
		return shape;
	}

	public void setShape(boolean shape) {
		this.shape = shape;
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
		formattedString = formattedString + String.format("Has Irregular Shape  = %b \n ", shape);
		return formattedString;
	}

}
