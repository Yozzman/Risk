package pf.yozzman.risk;

public class Pays {
	private String nom;
    private String voisinNord;
    private String voisinSud;
    private String voisinEst;
    private String voisinOuest;
    private int nombreTroupe = 0;
    private boolean possedeJoueur;

    public Pays (String nom) {
	    this.nom = nom;
	}
	
    // les getters de la classe

	public String getNom() {
		return this.nom;
	}
    public String getVoisinNord() {
        return this.voisinNord;
    }
    public String getVoisinSud() {
        return this.voisinSud;
    }
    public String getVoisinEst() {
        return this.voisinEst;
    }
    public String getVoisinOuest() {
        return this.voisinOuest;
    }
    public boolean getPossedeJoueur() {
        return possedeJoueur;
    }

    // Les setters de la classe

	public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPossedeJoueur(boolean possedeJoueur) {
        this.possedeJoueur = possedeJoueur;
    }
    
    // Les methodes
    
    public boolean possedeTroupe() {
    	return nombreTroupe <= 0;
    }
}
