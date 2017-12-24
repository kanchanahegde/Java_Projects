
public enum StarType {
	MAIN_SEQUENCE("Main Sequence Star"),
	GAINT_STAR("Gaint Star"),
	SUPERNOVA_STAR("Supernova Star");
	
	 private final String toString;

	    private StarType(String toString) {
	         this.toString = toString;
	    }

	    public String toString(){
	         return toString;
	    }
}
