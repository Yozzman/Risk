package pf.yozzman.risk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public abstract class Cell {

	public static boolean isValid(String position) {		
		if (position.length() < 2) {
			System.err.println("bad position: " + position);
			return false;
		}
		String strY = position.substring(0,1);
		Optional<Integer> optY = Board.indexOf(strY);
		if (optY.isEmpty()) {
			return false;
		}
		int y = optY.get();
		String strX = position.substring(1);		
		int x = Integer.parseInt(strX) - 1;
		if (x < 0 || x >= Board.DIMENSION) {
			System.err.println("bad position: " + position);
			return false;
		} else if (y < 0 || y >= Board.DIMENSION) {
			System.err.println("bad position: " + position);
			return false;
		}
		return true;
	}
	
	protected final Integer x;
	protected final Integer y;
	
	protected Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public final int getX() {
		return this.x;
	}
	
	public final int getY() {
		return this.y;
	}
	
	public String getPosition() {
		return Board.LINES.get(y) + (x+1);
	}
	
	public Cell getNext(Direction direction) {
		Cell res = null;
		try {
			// new BoardCell or ShipPart by reflection (Cell is abstract and x,y are final)
			Class<?> klass = this.getClass();
			Constructor<?> constructor = klass.getConstructor(int.class, int.class);
			if (direction.equals(Direction.N)) {
				int newY = this.getY()-1;
				if (newY == -1) {
					newY = Board.DIMENSION - 1;
				}
				res = (Cell) constructor.newInstance(this.getX(), newY);
			} else if (direction.equals(Direction.S)) {
				int newY = this.getY()+1;
				if (newY == Board.DIMENSION) {
					newY = 0;
				}
				res = (Cell) constructor.newInstance(this.getX(), newY);
			} else if (direction.equals(Direction.E)) {
				int newX = this.getX()+1;
				if (newX == Board.DIMENSION) {
					newX = 0;
				}
				res = (Cell) constructor.newInstance(newX, this.getY());
			} else if (direction.equals(Direction.W)) {
				int newX = this.getX()-1;
				if (newX == -1) {
					newX = Board.DIMENSION - 1;
				}
				res = (Cell) constructor.newInstance(newX, this.getY());
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cell)) {
			return false;
		}
		Cell c = (Cell)obj;		
		return x.equals(c.getX()) && y.equals(c.getY());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
	}
}