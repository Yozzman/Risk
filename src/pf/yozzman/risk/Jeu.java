package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	static ConsoleReader demandeUtilisateur = new ConsoleReader();

	static ListeJoueur<Joueur> listeJoueur = new ListeJoueur<>();
	
	static List<Pays> listePays = new ArrayList<>();	
	
	public static void main(String[] args) {
		
		int nombreJoueur = demandeUtilisateur.demanderNombreJoueur();
		
		demandeUtilisateur.ajouterJoueur(nombreJoueur, listeJoueur);
		
		listeJoueur.afficherNomJoueur();
		
		
	}

}
