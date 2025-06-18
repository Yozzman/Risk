package pf.yozzman.risk;

public enum TroupeType {
	SOLDAT("Soldat"),
    HUMVEE("Humvee"),
    TANK("Tank"), 
    ATOMIQUE("Atomique");

	public final String label;
    private TroupeType(String label) {
        this.label = label;
    }
    public String getLabel() {
    	return this.label;
    }
}
