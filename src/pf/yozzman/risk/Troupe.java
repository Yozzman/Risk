package pf.yozzman.risk;

import java.util.Optional;

public abstract class Troupe {
	private String nom;
	private int valeur;
	
	public Troupe(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}

	public String getNom() {
		return this.nom;
	}
	
	public int getValeur() {
		return this.valeur;
	}

	class Soldat extends Troupe {
		public Soldat(int valeur) {
			super(nom, valeur);
		}
	}

	class Humvee extends Troupe {
		public Humvee(int valeur){
			super(nom, valeur);
		}
	}

	class Tank extends Troupe {
		public Tank(int valeur) {
			super(nom, valeur);
		}
	}

	class Atomique extends Troupe {
		public Atomique(int valeur) {
			super(nom, valeur);
		}
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOnPosition(Cell c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPosition(Cell[] positions) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void moveTo(String direction) {
		switch (Direction.valueOf(direction)) {
		case Direction.N: 
			gotoNorth();
			break;
		case Direction.S: 
			gotoSouth();
			break;
		case Direction.E: 
			gotoEast();
			break;
		case Direction.W:
			gotoWest();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + direction);
		}
	}
}