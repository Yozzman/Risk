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
        ListePays.add(new Pays("Etat de L'Ouest", null, "Amérique du Nord"));
        ListePays.add(new Pays("Etat de L'Est", null, "Amérique du Nord"));
        ListePays.add(new Pays("Groenland", null, "Amérique du Nord"));
        ListePays.add(new Pays("Ontario", null, "Amérique du Nord"));
        ListePays.add(new Pays("Quebec", null, "Amérique du Nord"));
        ListePays.add(new Pays("Mexique", null, "Amérique du Nord"));
        ListePays.add(new Pays("Brésil", null, "Amérique du Sud"));
        ListePays.add(new Pays("Perou", null, "Amérique du Sud"));
        ListePays.add(new Pays("Argentine", null, "Amérique du Sud"));
        ListePays.add(new Pays("Venezuela", null, "Amérique du Sud"));
        ListePays.add(new Pays("Colombie", null, "Amérique du Sud"));
        ListePays.add(new Pays("Egypte", null, "Afrique"));
        ListePays.add(new Pays("Afrique du Nord", null, "Afrique"));
        ListePays.add(new Pays("Afrique du Sud", null, "Afrique"));
        ListePays.add(new Pays("Madagascar", null, "Afrique"));
        ListePays.add(new Pays("Congo", null, "Afrique"));
        ListePays.add(new Pays("Afrique de l'Est", null, "Afrique"));
        ListePays.add(new Pays("Inde", null, "Asie"));
        ListePays.add(new Pays("Chine", null, "Asie"));
        ListePays.add(new Pays("Japon", null, "Asie"));
        ListePays.add(new Pays("Mongolie", null, "Asie"));
        ListePays.add(new Pays("Sibérie", null, "Asie"));
        ListePays.add(new Pays("Moyen-Orient", null, "Asie"));
        ListePays.add(new Pays("Afghanistan", null, "Asie"));
        ListePays.add(new Pays("Oural", null, "Asie"));
        ListePays.add(new Pays("Yakoutie", null, "Asie"));
        ListePays.add(new Pays("Siam", null, "Asie"));
        ListePays.add(new Pays("Tchita", null, "Asie"));
        ListePays.add(new Pays("Kamchatka", null, "Asie"));
        ListePays.add(new Pays("Grande Bretagne", null, "Europe"));
        ListePays.add(new Pays("Islande", null, "Europe"));
        ListePays.add(new Pays("Scandinavie", null, "Europe"));
        ListePays.add(new Pays("Europe Occidental", null, "Europe"));
        ListePays.add(new Pays("Ukraine", null, "Europe"));
        ListePays.add(new Pays("Europe du Sud", null, "Europe"));
        ListePays.add(new Pays("Europe du Nord", null, "Europe"));
        ListePays.add(new Pays("Australie Orientale", null, "Océanie"));
        ListePays.add(new Pays("Australie Occidentale", null, "Océanie"));
        ListePays.add(new Pays("Nouvelle-Guinée", null, "Océanie"));
        ListePays.add(new Pays("Polynésie", null, "Océanie"));
        ListePays.add(new Pays("Indonésie", null, "Océanie"));
    }
}
