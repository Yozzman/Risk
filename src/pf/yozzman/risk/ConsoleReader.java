package pf.yozzman.risk;

import java.util.Scanner;

public class ConsoleReader {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public Integer demanderNombreJoueur() {
		Integer nombreFinal = null;
		while (nombreFinal == null) {
			
			System.out.print("Entrer le nombre de joueur : ");
			Integer nombreEntrer = scanner.nextInt();

			if (nombreEntrer != null) {
				nombreFinal = nombreEntrer;
			} 
		}
		return nombreFinal;
	}
	
	public  String demanderNomJoueur(Joueur joueur) {
		String nomFinal = null;
		while (nomFinal == null) {
					
			System.out.print("Nom du joueur " + joueur.getId() + " : ");
			String nomEntrer = scanner.next();
			
			if (nomEntrer == null || nomEntrer.isBlank()) {
				System.out.print("Veuillez réessayer");	
			}
			
			if (nomEntrer != null) {
				nomFinal = nomEntrer;
			} 
		}
		
		return nomFinal;
	}
}
