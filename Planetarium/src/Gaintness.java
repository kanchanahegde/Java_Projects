
public enum Gaintness {
	SUPER_GAINT("Super Gaint"), GAINT("Gaint"), SUB_GAINT("Sub Gaint");

	private final String toString;

	private Gaintness(String toString) {
		this.toString = toString;
	}

	public String toString() {
		return toString;
	}
}
