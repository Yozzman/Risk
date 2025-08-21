package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private String nom;
    private List<Pays> listePays = new ArrayList<>();

    public Continent (String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public List<Pays> getPays() {
        return this.listePays;
    }

    public void addPays(Pays pays) {
        this.listePays.add(pays);
    }
}
