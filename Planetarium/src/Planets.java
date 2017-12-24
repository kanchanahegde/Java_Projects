public abstract class Planets extends AstroEntity {

	private double distanceFromSun;
	private double sideRealDay;
	private double orbitalPeriod;
	private int numberOfSatellites;
	private String[] satellites = new String[3];
	private boolean hasRing;

	public Planets(String commonName, double distanceFromSun, double sideRealDay, double orbitalPeriod,
			int numberOfSatellites, String[] satellites, boolean hasRing) {
		super(commonName);
		this.distanceFromSun = distanceFromSun;
		this.sideRealDay = sideRealDay;
		this.orbitalPeriod = orbitalPeriod;
		this.numberOfSatellites = numberOfSatellites;
		if (satellites == null)
			this.satellites = satellites;
		else {
			this.satellites[0] = satellites[0];
			this.satellites[1] = satellites[1];
			this.satellites[2] = satellites[2];
		}
		this.hasRing = hasRing;
	}

	public double getDistanceFromSun() {
		return distanceFromSun;
	}

	public double getSideRealDay() {
		return sideRealDay;
	}

	public void setSideRealDay(double sideRealDay) {
		this.sideRealDay = sideRealDay;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public void setOrbitalPeriod(double orbitalPeriod) {
		this.orbitalPeriod = orbitalPeriod;
	}

	public int getNumberOfSatellites() {
		return numberOfSatellites;
	}

	public void setNumberOfSatellites(int numberOfSatellites) {
		this.numberOfSatellites = numberOfSatellites;
	}

	public String[] getSatellites() {
		return satellites;
	}

	public void setSatellites(String[] satellites) {
		this.satellites = satellites;
	}

	public boolean isHasRing() {
		return hasRing;
	}

	public void setHasRing(boolean hasRing) {
		this.hasRing = hasRing;
	}

	public void setDistanceFromSun(double distanceFromSun) {
		this.distanceFromSun = distanceFromSun;
	}

	@Override
	public String getCelestialClassification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFactualSummary() {
		super.getFactualSummary();
		String formattedString;
		String satellitesNames = null;
		if (satellites == null)
			satellitesNames = "None";
		else
			for (String s : satellites) {
				if (satellitesNames == null) {
					satellitesNames = s;
				} else if (s != null)
					satellitesNames = satellitesNames + ", " + s;
			}

		formattedString = String.format(
				                "Distance from Sun = %s AU \n"
		                      + "Sidereal Day = %.2f \n" 
				              + "Orbital Period = %.2f \n"
						      + "Has rings = %b \n" 
				              + "Number of Satellites = %d \n"
						      + "Largest Satellites   = %s \n",
					       distanceFromSun, sideRealDay, orbitalPeriod, hasRing, numberOfSatellites, satellitesNames);
		return formattedString;

	}

}
