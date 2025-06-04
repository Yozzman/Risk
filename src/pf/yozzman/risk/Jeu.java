package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

class Pays {
    String nom;
    Joueur proprietaire;
    int troupes;

    public Pays (String nom) {
        this.nom = nom;
        this.proprietaire = null;
        this.troupes = 0;
    }

    public boolean estConquis() {
        return troupes <= 0;
    }
	public void setProprietaire (Joueur joueur) {
		this.proprietaire = joueur;
	}
	public void setTroupes (int troupes) {
		this.troupes = troupes;
	}
}

public class Jeu {
	
	static List<Continent> continents = new ArrayList<>();
	static List<Pays> carte = new ArrayList<>();
	static List<Joueur> ListeJoueurs = new ArrayList<>();
	static String[] joueurs = {"Joueur1", "Joueur2"};


	public static void main(String[] args) {
		initialiserCarte();
		assignerPays();
		ListeJoueurs.add(new Joueur("Joueur1"));
		ListeJoueurs.add(new Joueur("Joueur2"));
	}

	static void initialiserCarte() {
		//Amérique du Nord
        carte.add(new Pays("Alaska"));
		carte.add(new Pays("Canada"));
		carte.add(new Pays("Etats-Unis"));
		carte.add(new Pays("Groenland"));
		//Amérique du Sud
        carte.add(new Pays("Argentine"));
		carte.add(new Pays("Brésil"));
		carte.add(new Pays("Chili"));
		carte.add(new Pays("Pérou"));
		//Europe
        carte.add(new Pays("France"));
        carte.add(new Pays("Espagne"));
		carte.add(new Pays("Italie"));
		carte.add(new Pays("Allemagne"));
		//Asie
		carte.add(new Pays("Chine"));
		carte.add(new Pays("Inde"));
		carte.add(new Pays("Japon"));
		carte.add(new Pays("Corée"));
    }

	static void assignerPays() {
        for (int i = 0; i < carte.size(); i++) {
            carte.get(i).setProprietaire(ListeJoueurs.get(i%2));
            carte.get(i).setTroupes(5);
        }
    }
}