package tpJavaChap01;

public class Carre {
	
	public Point pointBasGauche,
				 pointBasDroit,
				 pointHautGauche,
				 pointHautDroit;
	int cote;
	
	
	/**
	 * DEFINITION DU CARRE
	 */
	public Carre(Point point, int cote) {
		this.pointBasGauche = point;
		this.cote = cote;
	}

	
	/**
	 * LES GETTERS
	 */
	public Point getPointBasGauche() {
		return pointBasGauche;
	}

	public Point getPointBasDroit() {
		pointBasDroit = new Point(pointBasGauche.x + getCote(), pointBasGauche.y);
		return pointBasDroit;
	}

	public Point getPointHautGauche() {
		pointHautGauche = new Point(pointBasGauche.x, pointBasGauche.y + getCote());
		return pointHautGauche;
	}

	public Point getPointHautDroit() {
		pointHautDroit = new Point(pointBasGauche.x + getCote(), pointBasGauche.y + getCote());
		return pointHautDroit;
	}

	public int getCote() {
		return cote;
	}


	/**
	 * METHODE QUI RENVOIE LES COORDONNEES DU CARRE
	 */
	public String toString() {
		return "[CARRE " + pointBasGauche + getPointHautGauche() + getPointHautDroit() + getPointBasDroit() + "]";
	}

	/**
	 * AFFICHAGE
	 */
	public void affiche() {
		System.out.println(toString());
	}

	
}


