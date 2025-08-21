package pf.yozzman.risk;

public class Jeu {	
	public static void main(String[] args) {
		ConsoleReader lecteur = new ConsoleReader();
		ConsoleWriter writer = new ConsoleWriter();

		writer.clearAndPrintln("=== RISK : DISTRIBUTION DES TROUPES ET AFFICHAGE DE LA CARTE ===");

		int nombreJoueur = lecteur.demanderNombreJoueur();
        ListeJoueur joueurs = lecteur.creerJoueurs(nombreJoueur);
		
		Carte carte = new Carte();
        carte.initialiserPays();
        carte.assignerPays(joueurs);

		writer.println("=== Distribution des troupes ===");
        for (Joueur joueur : joueurs) {
            // Ici, on donne 3 renforts à chaque joueur (à ajuster selon les règles)
            carte.distribuerRenforts(joueur, 3);
        }

		ConsoleWriter.println("Le jeu RISK est lancé !");
		writer.println("\n=== Affichage de la carte ===");
        carte.afficherMiniCarte();
        writer.println("=== FIN ===");
	}

}
