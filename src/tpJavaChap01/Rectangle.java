package tpJavaChap01;

public class Rectangle extends Figure implements Surfacable {
	
	public Point pointBasGauche,
				 pointBasDroit,
				 pointHautGauche,
				 pointHautDroit;
	int longueur, hauteur;
	
	
	/**
	 * LES CONSTRUCTEURS
	 */
	public Rectangle(Point point, int longueur, int hauteur) {
		super(Couleur.getCouleurDefaut());
		this.pointBasGauche = point;
		this.longueur = longueur;
		this.hauteur = hauteur;
	}
	public Rectangle(Point point, int longueur, int hauteur, Couleur couleur) {
		this(point, longueur, hauteur);
		this.couleur = couleur;
	}
	
	/**
	 * LES GETTERS
	 */
	public Point getPointBasGauche() {
		return pointBasGauche;
	}

	public Point getPointBasDroit() {
		pointBasDroit = new Point(pointBasGauche.x + getLongueur(), pointBasGauche.y);
		return pointBasDroit;
	}

	public Point getPointHautGauche() {
		pointHautGauche = new Point(pointBasGauche.x, pointBasGauche.y + getHauteur());
		return pointHautGauche;
	}

	public Point getPointHautDroit() {
		pointHautDroit = new Point(pointBasGauche.x + getLongueur(), pointBasGauche.y + getHauteur());
		return pointHautDroit;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getHauteur() {
		return hauteur;
	}
	
	
	/**
	 * METHODE QUI RENVOIE LES COORDONNEES DU RECTANGLE
	 */
	public String toString() {
		return "[" + getType() + " " + couleur.getCodeCouleur() + " " + pointBasGauche + getPointHautGauche() + getPointHautDroit() + getPointBasDroit() + "]";
	}

	/**
	 * AFFICHAGE
	 */
	public void affiche() {
		System.out.println(toString());
	}


	/**
	 * METHODE POUR VOIR SI LE POINT EST A GAUCHE DU RECTANGLE
	 */
	private boolean estAGauche(Point pointInconnu) {
		if (pointBasGauche.getX() < pointInconnu.getX()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * METHODE POUR VOIR SI LE POINT EST A DROITE DU RECTANGLE
	 */
	private boolean estADroite(Point pointInconnu) {
		if (pointHautDroit.getX() > pointInconnu.getX()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * METHODE POUR VOIR SI LE POINT EST EN HAUT DU RECTANGLE
	 */
	private boolean estEnHaut(Point pointInconnu) {
		if (pointHautDroit.getY() > pointInconnu.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * METHODE POUR VOIR SI LE POINT EST EN BAS DU RECTANGLE
	 */
	private boolean estEnBas(Point pointInconnu) {
		if (pointBasGauche.getY() < pointInconnu.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * TP14 : CLASSE ABSTRAITE
	 */
	@Override
	public String getType() {
		return "RECT";
	}

	@Override
	public Point getPointDOrigine() {
		Point centreDuRectangle = new Point();
		centreDuRectangle.x = (pointHautDroit.x)/2;
		centreDuRectangle.y = (pointHautDroit.y)/2;
		return centreDuRectangle;
	}


	@Override
	public Figure getRandomFigure() {
		FigureUtil figUtil = new FigureUtil();
		return figUtil.getRandomRectangle();
	}


	
	@Override
	public double surface() {
		return longueur*hauteur;
	}


	@Override
	public Point[] getPoints() {
		Point tableauDePointsDuRectangle[] = {this.pointBasGauche, this.pointBasDroit, this.pointHautGauche, this.pointHautDroit};
		return tableauDePointsDuRectangle;
	}


	@Override
	public boolean couvre(Point pointInconnu) {
		if (estADroite(pointInconnu)==true) {
			return false;
		}
		else if (estAGauche(pointInconnu)==true) {
			return false;
		}
		else if (estEnHaut(pointInconnu)==true) {
			return false;
		}
		else if (estEnBas(pointInconnu)==true) {
			return false;
		}
		else {
			return true;
		}
	}

/**
 * TP30 : ENUM
 */
	@Override
	public Couleur getCouleur() {
		return this.couleur;
	}





}
