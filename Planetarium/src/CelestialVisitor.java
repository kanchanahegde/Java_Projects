
/**
 * Class for Celestial Visitor
 *
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CelestialVisitor extends AstroEntity implements CelestialVisitors {

	static final CelestialVisitorType celestialVisitor = CelestialVisitorType.CELESTIAL_VISITOR;
	private Date lastAppearedOn;
	private Date nextAppearsOn;
	private boolean isPredictable;

	public CelestialVisitor(String commonName, Date lastAppearedOn, Date nextAppearsOn, boolean isPredictable) {
		super(commonName);
		this.lastAppearedOn = lastAppearedOn;
		this.nextAppearsOn = nextAppearsOn;
		this.isPredictable = isPredictable;
	}

	@Override
	public Date lastAppearedOn() {

		return this.lastAppearedOn;
	}

	@Override
	public Date nextAppearsOn() {

		return this.nextAppearsOn;
	}

	@Override
	public Boolean isPredictable() {

		return this.isPredictable;
	}

	@Override
	public String getCelestialClassification() {
		return celestialVisitor.name(); // Returns the Celestial Visitor type
	}

	@Override
	public String getFactualSummary() {
		String dateNext, dateLast;
		// Converting date to string format
		DateFormat format = new SimpleDateFormat("MMM d, yyyy");
		dateLast = format.format(lastAppearedOn);
		dateNext = format.format(nextAppearsOn);
		String formattedString;

		formattedString = super.getFactualSummary();
		formattedString = formattedString + String.format(
				                               "Celestial Classification = %s \n" 
		                                     + "Is predictable = %b \n"
				                             + "Date last appeared = %s \n" 
		                                     + "Date next appears = %s \n", 
		                                     celestialVisitor, isPredictable, dateLast,dateNext);
		return formattedString;
	}

}
