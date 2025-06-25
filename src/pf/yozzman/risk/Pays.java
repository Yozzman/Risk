package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

public class Pays {
	private String nom;
	private String voisinNord;
    private String voisinSud;
    private String voisinEst;
    private String voisinOuest;
    private int nombreTroupe = 0;
    public String proprietaire;
    private String continent;

	public Pays (String nom, String proprietaire, String continent) {
	    this.nom = nom;
        this.proprietaire = null;
        this.continent = continent;
	}
	
    public String getNomContinent() {
        return this.continent;
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
    
    public boolean possedeTroupe() {
    	return nombreTroupe <= 0;
    }

    private List<Pays> ListePays = new ArrayList<>();
	    public void initialiserPays() {
	    ListePays.add(new Pays("Alaska", null, "Amérique du Nord"));
        ListePays.add(new Pays("Brésil", null, "Amérique du Sud"));
        ListePays.add(new Pays("Egypte", null, "Afrique"));
        ListePays.add(new Pays("Inde", null, "Asie"));
    }
}
