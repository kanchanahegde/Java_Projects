
public enum PlanetType {
	TERRESTRIAL("Terrestrial Planet"),
	GAS_GAINT("Gas Gaint Planet"),
	DWARF("Dwarf Planet");
	
	 private final String toString;

	    private PlanetType(String toString) {
	         this.toString = toString;
	    }

	    public String toString(){
	         return toString;
	    }
}
