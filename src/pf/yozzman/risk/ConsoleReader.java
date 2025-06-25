package pf.yozzman.risk;

import java.util.Scanner;

public class ConsoleReader {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public Integer demanderNombreJoueur() {
		Integer nombreFinal = null;

		while (nombreFinal == null) {

            System.out.print("Entrez le nombre de joueurs (entre 2 et 5) : ");

			try {

                int entree = Integer.parseInt(scanner.nextLine().trim());

                if (entree >= 2 && entree <= 5) {
                    nombreFinal = entree;
                } else {
					if ( entree < 2) {
                    System.out.println("Il doit y avoir au moins 2 joueurs.");
					};
					if ( entree > 5) {
                    System.out.println("Il doit y avoir au maximum 5 joueurs.");
					};
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
		}
		return nombreFinal;
	}
	
	public String demanderNomJoueur(Joueur joueur) {
		String nomFinal = null;
		while (nomFinal == null) {
					
			System.out.print("Nom du joueur " + joueur.getId() + " : ");
			String nomEntrer = scanner.next();
			
			if (nomEntrer == null || nomEntrer.trim().isEmpty()) {
				System.out.print("Veuillez réessayer");	
			}
			
			if (nomEntrer != null) {
				nomFinal = nomEntrer;
			} 
		}
		
		return nomFinal;
	}

	public void ajouterJoueur(int nombreJoueur, ListeJoueur<Joueur> listeJoueur) {
		for (int i = 1; i <= nombreJoueur; i++) {
        Joueur joueurCreer = new Joueur();
        String nom = demanderNomJoueur(joueurCreer);
        joueurCreer.setNom(nom);
        listeJoueur.ajouterJoueur(joueurCreer);
	}
}
