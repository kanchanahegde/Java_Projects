import java.util.List;

public abstract class Stars extends AstroEntity {
	private SpectralType starType;
	private String constellationDesignation;
	private double distancefromSun;
	private double apparentMagnitude;
	private double absoluteMagnitude;
	private List<Planets> planets;

	public Stars(String commonName, SpectralType starType, String constellationDesignation, double d, double e,
			double f, List<Planets> planets) {
		super(commonName);
		this.starType = starType;
		this.constellationDesignation = constellationDesignation;
		this.distancefromSun = d;
		this.apparentMagnitude = e;
		this.absoluteMagnitude = f;
		this.planets = planets;
	}

	public String getConstellationDesignation() {
		return constellationDesignation;
	}

	public void setConstellationDesignation(String constellationDesignation) {
		this.constellationDesignation = constellationDesignation;
	}

	public double getDistancefromSun() {
		return distancefromSun;
	}

	public void setDistancefromSun(Float distancefromSun) {
		this.distancefromSun = distancefromSun;
	}

	public double getApparentMagnitude() {
		return apparentMagnitude;
	}

	public void setApparentMagnitude(Float apparentMagnitude) {
		this.apparentMagnitude = apparentMagnitude;
	}

	public double getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}

	public void setAbsoluteMagnitude(Float absoluteMagnitude) {
		this.absoluteMagnitude = absoluteMagnitude;
	}

	public SpectralType getStarType() {
		return starType;
	}

	public void setStarType(SpectralType starType) {
		this.starType = starType;
	}

	@Override
	public String getCelestialClassification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFactualSummary() {

		String formattedString;
		String planetNames = null;
		super.getFactualSummary();
		if (planets == null)
			planetNames = "None";
		else
			for (Planets p : planets) {
				if (planetNames == null) 
					planetNames = p.getCommonName();
				 else
					planetNames = planetNames + ", " + p.getCommonName();
			}
		formattedString = String.format(
				                 "Constellation Designation = %s \n" 
		                       + "Spectral Type = %s \n"
				               + "Apparent Magnitude = %.2f \n"
						       + "Absolute Magnitude = %.2f \n" 
				               + "Distance From Sun = %.2f ly\n" 
						       + "Planets= %s \n",
			            	constellationDesignation, starType, apparentMagnitude, absoluteMagnitude, distancefromSun, planetNames);
		return formattedString;

	}

}
