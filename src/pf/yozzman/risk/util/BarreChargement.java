package pf.yozzman.risk.util;

public class BarreChargement {

    public static void afficherBarre(String message, int etapes, int delaiMs) {
        ConsoleWriter.print(message + " [");

        for (int i = 0; i < etapes; i++) {
            try {
                Thread.sleep(delaiMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            ConsoleWriter.print("=");
        }

        ConsoleWriter.println("] Chargement terminé !");
       
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
    }
}
