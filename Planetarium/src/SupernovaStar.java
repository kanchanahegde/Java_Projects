
/**
 * Class for Supernova Star Type
 *
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SupernovaStar extends Stars {

	private SupernovaType supernovaType;
	private Date peakBrillianceDate;
	static final StarType starType = StarType.SUPERNOVA_STAR;

	public SupernovaStar(String commonName, SpectralType starType, String constellationDesignation, double d, double e,
			double f, List<Planets> planets, SupernovaType supernovaType, Date peakBrillianceDate) {
		super(commonName, starType, constellationDesignation, d, e, f, planets);
		this.supernovaType = supernovaType;
		this.peakBrillianceDate = peakBrillianceDate;
	}

	public SupernovaType getSupernovaType() {
		return supernovaType;
	}

	public void setSupernovaType(SupernovaType supernovaType) {
		this.supernovaType = supernovaType;
	}

	public Date getPeakBrillianceDate() {
		return peakBrillianceDate;
	}

	public void setPeakBrillianceDate(Date peakBrillianceDate) {
		this.peakBrillianceDate = peakBrillianceDate;
	}

	@Override
	public String getCelestialClassification() {
		return starType.name(); // Returns the Star type
	}

	@Override
	public String getFactualSummary() {
		String date;
		// converting date to string format
		DateFormat format = new SimpleDateFormat("MMM d, yyyy");
		date = format.format(peakBrillianceDate);
		String formattedString;
		String commonName;

		commonName = this.getCommonName();
		formattedString = String.format("Name = %s \nCelestial Classification = %s \n", commonName, starType);
		formattedString = formattedString + super.getFactualSummary();
		formattedString = formattedString
				+ String.format("Supernova Type  = %s\nPeak Brilliance Date = %s \n", supernovaType, date);
		return formattedString;
	}

}
