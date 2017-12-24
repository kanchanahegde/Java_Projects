
public abstract class AstroEntity {
	private String commonName;
    
	
	
	public AstroEntity(String commonName) {
		this.commonName = commonName;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	
	public abstract String getCelestialClassification();
	
	public String getFactualSummary() {
		String formattedString;
		formattedString = String.format("Name = %s \n", commonName);
		return formattedString;
	}

}
