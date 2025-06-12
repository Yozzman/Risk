package pf.yozzman.risk;

public enum Direction {
	N("N"), // North
    S("S"), // South   
    E("E"), // East
    W("W"); // West

	public final String value;

    private Direction(String value) {
        this.value = value;
    }
}