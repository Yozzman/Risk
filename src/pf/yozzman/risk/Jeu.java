package pf.yozzman.risk;

public class Jeu {
	
	static ConsoleReader demandeUtilisateur = new ConsoleReader();

	static ListeJoueur<Joueur> listeJoueur = new ListeJoueur<>();
	
	public static void main(String[] args) {
		
		boolean fin = false;
		int nombreJoueur = demandeUtilisateur.demanderNombreJoueur();

		demandeUtilisateur.ajouterJoueur(nombreJoueur, listeJoueur);

		while (!fin) {
			listeJoueur.afficherNomJoueur();
			fin = true;
		}
		
	}

}
