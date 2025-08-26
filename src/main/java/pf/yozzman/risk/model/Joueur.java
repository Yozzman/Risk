package pf.yozzman.risk.model;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private static int nombreJoueur = 0;
    private static int indexCouleur = 0;

    private String nom;
    private int id;
    private Couleur couleur;
    private List<Pays> paysPossedes = new ArrayList<>();

    public Joueur () {
        nombreJoueur++;
        this.id = nombreJoueur;
        
        Couleur[] couleurs = Couleur.values();
        this.couleur = couleurs[indexCouleur % couleurs.length];
        indexCouleur++;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return this.id;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public List<Pays> getPaysPossedes() {
        return paysPossedes;
    }

    public void addPaysPossede(Pays pays) {
        this.paysPossedes.add(pays);
    }
}
