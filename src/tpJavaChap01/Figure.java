package tpJavaChap01;

public abstract class Figure {
	
	/**
	 * TP14 : CLASSE ABSTRAITE
	 * @return
	 */
	
	public Point getRandomPoint() {
		Point randomPoint = new Point();
		randomPoint.x = ((int) Math.random())*100;
		randomPoint.y = ((int) Math.random())*100;
		return randomPoint;
	}
	
	public abstract Figure getRandomFigure();
	
	public abstract Point getPointDOrigine();
	
	
	public abstract String getType();
	public abstract String toString();
	public abstract void affiche();
	
	public abstract Point[] getPoints();
	
	public abstract boolean couvre(Point pointInconnu);
	
	
	/**
	 * TP30 : ENUM
	 */
	public Couleur couleur;
	
	protected Couleur getCouleur() {
		return couleur;
	}

	public Figure(Couleur couleur) {
		this.couleur = couleur;
	}
	
	
}
