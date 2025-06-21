package pf.yozzman.risk;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ListeJoueur<T extends Joueur> extends AbstractList<T> {
	
	List<T> Joueur = new ArrayList<T>(); 
	
	public ListeJoueur() {
		
	}
	
	@Override
	public int size() {
		return Joueur.size();
	}
	
	@Override
	public T get(int index) {
		return Joueur.get(index);
	}
	
	@SuppressWarnings("unchecked")
	public void ajouterJoueur(Joueur Joueur) {
		this.Joueur.add((T) Joueur);
	}
}
