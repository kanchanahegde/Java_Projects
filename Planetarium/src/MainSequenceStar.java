
/**
 * Class for Main Sequence Star Type
 *
 */
import java.util.List;

public class MainSequenceStar extends Stars {

	private double relativeMass;
	static final StarType starType = StarType.MAIN_SEQUENCE;

	public double getRelativeMass() {
		return relativeMass;
	}

	public MainSequenceStar(String commonName, SpectralType starType, String constellationDesignation, double d,
			double e, double f, List<Planets> planets, double relativeMass) {
		super(commonName, starType, constellationDesignation, d, e, f, planets);
		this.relativeMass = relativeMass;
	}

	public void setRelativeMass(float relativeMass) {
		this.relativeMass = relativeMass;
	}

	@Override
	public String getCelestialClassification() {
		return starType.name(); // Returns the Star type
	}

	@Override
	public String getFactualSummary() {
		String formattedString;
		String commonName;
		commonName = this.getCommonName();
		formattedString = String.format("Name = %s \nCelestial Classification = %s \n", commonName, starType);
		formattedString = formattedString + super.getFactualSummary();
		formattedString = formattedString + String.format("Relative Mass  = %.2f \n", relativeMass);
		return formattedString;
	}

}
