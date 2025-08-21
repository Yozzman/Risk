package pf.yozzman.risk;

public class Pays {
	private String nom;
    private String voisinNord;
    private String voisinSud;
    private String voisinEst;
    private String voisinOuest;
    private int nombreTroupe = 1;
    private boolean possedeJoueur;
    private Joueur proprietaire;
    private Armee armee;

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
    public Joueur getProprietaire() { 
        return proprietaire; 
    }
    public Armee getArmee() {
         return armee; 
    }
    public int getNombreTroupe() {
        return nombreTroupe; 
    }

    // Les setters de la classe

	public void setNom(String nom) {
        this.nom = nom;
    }
    public void setVoisinNord(String voisinNord) { 
        this.voisinNord = voisinNord; 
    }
    public void setVoisinSud(String voisinSud) {
        this.voisinSud = voisinSud; 
    }
    public void setVoisinEst(String voisinEst) {
        this.voisinEst = voisinEst; 
    }
    public void setVoisinOuest(String voisinOuest) { 
        this.voisinOuest = voisinOuest; 
    }
    public void setPossedeJoueur(boolean possedeJoueur) {
        this.possedeJoueur = possedeJoueur;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire; 
    }
    public void setArmee(Armee armee) { 
        this.armee = armee; 
    }
    public void setNombreTroupe(int n) { 
        nombreTroupe = n; 
    }

    // Les methodes
    
    public boolean possedeTroupe() {
    	return nombreTroupe > 0;
    }
}
