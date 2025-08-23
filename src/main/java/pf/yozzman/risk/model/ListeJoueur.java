package pf.yozzman.risk.model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import pf.yozzman.risk.util.ConsoleWriter;

public class ListeJoueur extends AbstractList<Joueur> {
    private List<Joueur> joueurs = new ArrayList<>();

    public Joueur get(int index) {
        return joueurs.get(index);
    }

    @Override
    public int size() {
        return joueurs.size();
    }

    @Override
    public boolean add(Joueur joueur) {
        return joueurs.add(joueur);
    }

    public void afficherNomJoueur() {
        for (int i = 0; i < joueurs.size(); i++) {
            ConsoleWriter.println("Nom du joueur " + (i+1) + " : " + joueurs.get(i).getNom());
        }
    }
}
