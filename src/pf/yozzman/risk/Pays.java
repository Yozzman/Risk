package pf.yozzman.risk;

public class Pays {
	private String nom;
	private String voisinNord;
    private String voisinSud;
    private String voisinEst;
    private String voisinOuest;

	public Pays (String nom,
	        String voisinNord,
	        String voisinSud,
	        String voisinEst,
	        String voisinOuest
	    ) {
	    this.nom = nom;
        this.voisinNord = voisinNord;
        this.voisinSud = voisinSud;
        this.voisinOuest = voisinOuest;
        this.voisinEst = voisinEst;
	}
	
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
}
