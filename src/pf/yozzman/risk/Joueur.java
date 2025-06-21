package pf.yozzman.risk;

public class Joueur {
	public static int nombreJoueur = 0;
	private String nom;
	private int id;
	
	public Joueur () {
		nombreJoueur++;
		this.id = nombreJoueur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getId() {
		return this.id;
	}
}