package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	static ConsoleReader demandeUtilisateur = new ConsoleReader();

	static ListeJoueur<Joueur> listeJoueur = new ListeJoueur<>();
	
	static List<Pays> carte = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int nombreJoueur = demandeUtilisateur.demanderNombreJoueur();


		for(int i = 1; i <= nombreJoueur; i++) {
			Joueur joueurCreer = new Joueur();
			joueurCreer.setNom(demandeUtilisateur.demanderNomJoueur(joueurCreer));
			listeJoueur.ajouterJoueur(joueurCreer);
		}		
	}

}
