package pf.yozzman.risk.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pays {
    private static int prochainId = 1;
    private static final Set<Integer> idsUtilises = new HashSet<>();

    private int id;
    private String nom;
    private String voisinNord;
    private String voisinSud;
    private String voisinEst;
    private String voisinOuest;

    private int nombreTroupe = 5;
    private boolean possedeJoueur;
    private Joueur proprietaire;
    private Armee armee;

    private List<Pays> voisins = new ArrayList<>();

    private Pays(Builder builder) {
        this.id = builder.id;
        this.nom = builder.nom;
        this.voisinNord = builder.voisinNord;
        this.voisinSud = builder.voisinSud;
        this.voisinEst = builder.voisinEst;
        this.voisinOuest = builder.voisinOuest;
        this.nombreTroupe = builder.nombreTroupe;
        this.proprietaire = builder.proprietaire;

        idsUtilises.add(this.id);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getVoisinNord() {
        return this.voisinNord;
    }

    public String getVoisinSud() {
        return this.voisinSud;
    }

    public String getVoisinEst() {
        return this.voisinEst;
    }

    public String getVoisinOuest() {
        return this.voisinOuest;
    }

    public boolean getPossedeJoueur() {
        return possedeJoueur;
    }

    public void setPossedeJoueur(boolean possedeJoueur) {
        this.possedeJoueur = possedeJoueur;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur joueur) {
        this.proprietaire = joueur;
    }

    public Armee getArmee() {
        return armee;
    }

    public int getNombreTroupe() {
        return nombreTroupe;
    }

    public void setNombreTroupe(int nombreTroupe) {
        this.nombreTroupe = nombreTroupe;
    }

    public List<Pays> getVoisins() {
        return voisins;
    }

    public boolean possedeTroupe() {
        return nombreTroupe > 0;
    }

    public void addVoisin(Pays p) {
        if (p != null && !voisins.contains(p)) {
            voisins.add(p);
            p.getVoisins().add(this);
        }
    }

    public boolean estVoisin(Pays p) {
        return voisins.contains(p);
    }

    public static class Builder {
        private final String nom;
        private int id;
        private String voisinNord;
        private String voisinSud;
        private String voisinEst;
        private String voisinOuest;
        private Joueur proprietaire;
        private int nombreTroupe = 5;

        public Builder(String nom) {
            this.nom = nom;
            this.id = prochainIdNonUtilise();
        }

        public Builder avecId(int id) {
            if (idsUtilises.contains(id)) {
                throw new IllegalArgumentException("L'ID " + id + " est déjà utilisé.");
            }
            this.id = id;
            return this;
        }

        public Builder avecVoisinNord(String voisinNord) {
            this.voisinNord = voisinNord;
            return this;
        }

        public Builder avecVoisinSud(String voisinSud) {
            this.voisinSud = voisinSud;
            return this;
        }

        public Builder avecVoisinEst(String voisinEst) {
            this.voisinEst = voisinEst;
            return this;
        }

        public Builder avecVoisinOuest(String voisinOuest) {
            this.voisinOuest = voisinOuest;
            return this;
        }

        public Builder avecNombreTroupe(int nombreTroupe) {
            this.nombreTroupe = nombreTroupe;
            return this;
        }

        public Builder avecProprietaire(Joueur proprietaire) {
            this.proprietaire = proprietaire;
            return this;
        }

        public Pays build() {
            return new Pays(this);
        }

        private static int prochainIdNonUtilise() {
            while (idsUtilises.contains(prochainId)) {
                prochainId++;
            }
            return prochainId;
        }
    }
}