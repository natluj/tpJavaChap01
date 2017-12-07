package tpJavaChap01;

public class Segment extends Figure {
	
	Point pointDeDepart, pointDArrivee;
	int longueur;
	boolean estHorizontal = true;

	/**
	 * LES CONSTRUCTEURS
	 */
	public Segment(Point debut, int longueur, boolean horizontal) {
		super(Couleur.getCouleurDefaut());
		this.pointDeDepart = new Point(debut.getX(), debut.getY());
		this.pointDArrivee = new Point();
		this.longueur = longueur;
		this.estHorizontal = horizontal;
		if (estHorizontal==true) {
			pointDArrivee.x = pointDeDepart.getX() + longueur;
			pointDArrivee.y = pointDeDepart.getY();
		}
		else {
			pointDArrivee.x = pointDeDepart.getX();
			pointDArrivee.y = pointDeDepart.getY() + longueur;
		}
	}
	public Segment(Point debut, int longueur, boolean horizontal, Couleur couleur) {
		this(debut, longueur, horizontal);
		this.couleur = couleur;
	}
	
	/**
	 * METHODE POUR CALCULER LA DISTANCE HORIZONTALE
	 */
	private int getDistanceHorizontale(Point pointInconnu) {
		int distanceHorizontaleD = Math.abs(pointInconnu.getX() - pointDeDepart.getX()),
			distanceHorizontaleA = Math.abs(pointInconnu.getX() - pointDArrivee.getX()),
			distanceHorizontale = distanceHorizontaleA + distanceHorizontaleD;
		return distanceHorizontale;
	}
	
	private int getDistanceVerticale(Point pointInconnu) {
		int distanceVerticaleD = Math.abs(pointInconnu.getY() - pointDeDepart.getY()),
			distanceVerticaleA = Math.abs(pointInconnu.getY() - pointDArrivee.getY()),
			distanceVerticale = distanceVerticaleA + distanceVerticaleD;
		return distanceVerticale;
	}
	
	@Override
	public Point getPointDOrigine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		return "SEG";
	}

	@Override
	public String toString() {
		return "[" + getType() + " " + couleur.getCodeCouleur() + " " + pointDeDepart + " à " + pointDArrivee + "  ==> longueur : " + longueur + "]";
	}

	@Override
	public void affiche() {
		System.out.println(toString());
	}

	@Override
	public Figure getRandomFigure() {
		FigureUtil figUtil = new FigureUtil();
		pointDeDepart = figUtil.getRandomPoint();
		Segment segmentRandom = new Segment(pointDeDepart, figUtil.getRandomInt(2, 56), true);
		return segmentRandom;
	}

	@Override
	public Point[] getPoints() {
		Point tableauDePointDuSegment[] = {this.pointDeDepart, this.pointDArrivee};
		return tableauDePointDuSegment;
	}

	@Override
	public boolean couvre(Point pointInconnu) {
		if (estHorizontal==true) {
			int distance = getDistanceHorizontale(pointInconnu);
			if (distance==longueur) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			int distance = getDistanceVerticale(pointInconnu);
			if (distance==longueur) {
				return true;
			}
			else {
				return false;
			}
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
