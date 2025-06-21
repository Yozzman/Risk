package pf.yozzman.risk;

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
}