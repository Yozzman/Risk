package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

public class Jeu {

	static ConsoleReader demandeUtilisateur = new ConsoleReader();

	@SuppressWarnings("rawtypes")
	static ListeJoueur ListeJoueurs = new ListeJoueur();
	
	static List<Pays> carte = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int nombreJoueur = demandeUtilisateur.demanderNombreJoueur();
		for(int i = 1; i <= nombreJoueur; i++) {
			Joueur JoueurCreer = new Joueur();
			JoueurCreer.setNom(demandeUtilisateur.demanderNomJoueur(JoueurCreer));
			ListeJoueurs.ajouterJoueur(JoueurCreer);
		}		
	}
}