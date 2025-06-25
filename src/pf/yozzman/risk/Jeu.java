package pf.yozzman.risk;

public class Jeu {

	static ConsoleReader demandeUtilisateur = new ConsoleReader();

	@SuppressWarnings("rawtypes")
	static ListeJoueur ListeJoueurs = new ListeJoueur();

	
	public static void main(String[] args) {
		
		int nombreJoueur = demandeUtilisateur.demanderNombreJoueur();
		for(int i = 1; i <= nombreJoueur; i++) {
			Joueur JoueurCreer = new Joueur();
			JoueurCreer.setNom(demandeUtilisateur.demanderNomJoueur(JoueurCreer));
			ListeJoueurs.ajouterJoueur(JoueurCreer);
		}		
	}
}