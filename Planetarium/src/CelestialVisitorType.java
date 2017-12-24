
public enum CelestialVisitorType {
	CELESTIAL_VISITOR("Celestial Visitor");

	private final String toString;

	private CelestialVisitorType(String toString) {
		this.toString = toString;
	}

	public String toString(){
		return toString;
	}
}
