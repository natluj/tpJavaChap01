package tpJavaChap01;

import java.util.Collection;
import java.util.HashSet;
//import java.util.Iterator;

public class Dessin {
	
	/**
	 * En supposant que l'on ne veut qu'un seul exemplaire par figure sans besoin d'ordre ni de tri, on utilise HashSet.
	 */
	private HashSet<Figure> listeDesFigures;
	
	public Dessin() {
		this.listeDesFigures = new HashSet<Figure>();
	}
	
	public void setListeDesFigures(HashSet<Figure> listeDesFigures) {
		this.listeDesFigures = listeDesFigures;
	}

	public HashSet<Figure> getListeDesFigures() {
		return listeDesFigures;
	}

	public boolean add(Figure figure) {
		listeDesFigures.add(figure);
		if (listeDesFigures.contains(figure)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Collection<Figure> getFigures() {
//		HashSet<Figure> collectionDeFigures = new HashSet<Figure>();
//		Iterator<Figure> iterator = listeDesFigures.iterator();
//		while(iterator.hasNext()) {
//			Figure figure = iterator.next();
//			collectionDeFigures.add(figure);
//		}
//		return collectionDeFigures;
		return listeDesFigures;
	}
	
}
