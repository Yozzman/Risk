package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	public static int nombreJoueur = 0;
	private String nom;
	private int id;
	private List<Pays> paysPossedes = new ArrayList<>();
	
	public Joueur () {
		nombreJoueur++;
		this.id = nombreJoueur;
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
	
	public List<Pays> getPaysPossedes() {
        return paysPossedes;
    }

    public void addPaysPossede(Pays pays) {
        this.paysPossedes.add(pays);
    }
}
