package pf.yozzman.risk;

public interface Deplacement {
	void moveTo(String direction);
	String getDirection();
	boolean isOnPosition(Cell c); 
	void setPosition(Cell[] positions);
}