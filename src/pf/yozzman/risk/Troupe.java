package pf.yozzman.risk;

public abstract class Troupe {
	private String nom;
	private int valeur;
	private int ID;
	
	public Troupe(String nom, int valeur, int ID) {
		this.nom = nom;
		this.valeur = valeur;
		this.ID = ID;
	}

	public String getNom() {
		return this.nom;
	}
	
	public int getValeur() {
		return this.valeur;
	}

	public int getID() {
		return this.ID;
	}

	public static class Soldat extends Troupe {
		public Soldat(int ID) {
			super("Soldat", 1, ID);
		}
	}

	public static class Humvee extends Troupe {
		public Humvee(int ID){
			super("Humvee", 5, ID);
		}
	}

	public static class Tank extends Troupe {
		public Tank(int ID) {
			super("Tank", 10, ID);
		}
	}

	public static class Atomique extends Troupe {
		public Atomique(int ID) {
			super("Atomique", 20, ID);
		}
	}
}