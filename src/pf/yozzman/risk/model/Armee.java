package pf.yozzman.risk.model;

import java.util.ArrayList;
import java.util.List;

public class Armee {
    private String nom;
    private String nomJoueur;
    private List<Troupe> listeTroupe = new ArrayList<>();

    public Armee(String nom, String nomJoueur) {
        this.nom = nom;
        this.nomJoueur = nomJoueur;
    }

    public String getNom() {
        return this.nom;
    }

    public String getNomJoueur() {
        return this.nomJoueur;
    }

    public List<Troupe> getListeTroupe() {
        return this.listeTroupe;
    }

    public void ajouterTroupe(Troupe troupe) {
        this.listeTroupe.add(troupe);
    }
}
