package pf.yozzman.risk;

public class Troupe {
    private String nom;
    private int valeur;

    public Troupe(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    public String getNom() {
        return this.nom;
    }

    public int getValeur() {
        return this.valeur;
    }
}
