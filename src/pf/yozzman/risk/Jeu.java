package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jeu {

	static ConsoleReader demandeUtilisateur = new ConsoleReader();

	@SuppressWarnings("rawtypes")
	static ListeJoueur ListeJoueurs = new ListeJoueur();
	static List<Pays> listePays = new ArrayList<>();

	public static void main(String[] args) {
		// Vérifier qu'il y a au moins 2 joueurs
		int nombreJoueur;
		do {
			nombreJoueur = demandeUtilisateur.demanderNombreJoueur();
			if (nombreJoueur < 2) {
				System.out.println("Le jeu nécessite au moins 2 joueurs.");
			}
		} while (nombreJoueur < 2);

		// Création des joueurs
		for(int i = 1; i <= nombreJoueur; i++) {
			Joueur joueurCreer = new Joueur();
			joueurCreer.setNom(demandeUtilisateur.demanderNomJoueur(joueurCreer));
			ListeJoueurs.ajouterJoueur(joueurCreer);
		}

		// Initialisation des pays
		Pays pays = new Pays("", null, "");
		pays.initialiserPays();
		listePays = pays.getListePays();

		// Distribution aléatoire des pays
		distribuerPaysAuxJoueurs();
	}

	private static void distribuerPaysAuxJoueurs() {
		// Mélanger aléatoirement la liste des pays
		Collections.shuffle(listePays);
		
		int nombreJoueurs = ListeJoueurs.size();
		int paysParJoueur = listePays.size() / nombreJoueurs;
		int reste = listePays.size() % nombreJoueurs;
		
		int indexPays = 0;
		
		// Distribution équitable des pays aux joueurs
		for (int i = 0; i < nombreJoueurs; i++) {
			Joueur joueur = ListeJoueurs.get(i);
			int nombrePaysAJoueur = paysParJoueur + (i < reste ? 1 : 0);
			
			System.out.println("\n" + joueur.getNom() + " reçoit les pays :");
			
			for (int j = 0; j < nombrePaysAJoueur && indexPays < listePays.size(); j++) {
				Pays pays = listePays.get(indexPays);
				pays.proprietaire = joueur.getNom();
				System.out.println("- " + pays.getNom() + " (" + pays.getNomContinent() + ")");
				indexPays++;
			}
		}
	}
}