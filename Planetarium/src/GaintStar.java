
/**
 * Class for Gaint Star Type
 *
 */
import java.util.List;

public class GaintStar extends Stars {

	private Gaintness degreeOfGaintness;
	static final StarType starType = StarType.GAINT_STAR;

	public GaintStar(String commonName, SpectralType starType, String constellationDesignation, double d, double e,
			double f, List<Planets> planets, Gaintness degreeOfGaintness) {
		super(commonName, starType, constellationDesignation, d, e, f, planets);
		this.degreeOfGaintness = degreeOfGaintness;
	}

	public Gaintness getDegreeOfGaintness() {
		return degreeOfGaintness;
	}

	public void setDegreeOfGaintness(Gaintness degreeOfGaintness) {
		this.degreeOfGaintness = degreeOfGaintness;
	}

	@Override
	public String getCelestialClassification() {
		return starType.name(); // Returns the Star type
	}

	@Override
	public String getFactualSummary() {
		// TODO Auto-generated method stub
		String formattedString;
		String commonName;
		commonName = this.getCommonName();
		formattedString = String.format("Name = %s \nCelestial Classification = %s \n", commonName, starType);
		formattedString = formattedString + super.getFactualSummary();
		formattedString = formattedString + String.format("Degree of Gaintness = %s \n", degreeOfGaintness);
		return formattedString;
	}

}
