package tpJavaChap01;


public class Rond extends Figure implements Surfacable {
	
	private Point centre;
	int rayon;

	/**
	 * LES CONSTRUCTEURS
	 */
	public Rond(Point point, int r) {
		super(Couleur.getCouleurDefaut());
		this.centre = point;
		this.rayon = r;
	}
	public Rond(Point point, int r, Couleur couleur) {
		this(point, r);
		this.couleur = couleur;
	}
	
	/**
	 * LES GETTERS
	 */
	public Point getCentre() {
		return centre;
	}

	public int getRayon() {
		return rayon;
	}

	
	/**
	 * METHODE QUI RENVOIE LES COORDONNEES DU ROND
	 */
	public String toString() {
		return "[" + getType() + " " + couleur.getCodeCouleur() + " " + centre.toString() + ", " + getRayon() + "]";
	}
	
	/**
	 * AFFICHAGE
	 */
	public void affiche() {
		System.out.println(toString());
	}
	
	
	/**
	 * CALCUL DE DISTANCE ENTRE UN POINT ET LE CENTRE POUR LA FONCTION COUVRE
	 */
	public int getDistance(Point pointAComparer) {
		int abscisse = Math.abs(pointAComparer.getX()-centre.getX()),
			ordonnee = Math.abs(pointAComparer.getY()-centre.getY()),
			distance = (int) Math.sqrt((abscisse*abscisse)+(ordonnee*ordonnee));
		return distance;
	}
	
	
	/**
	 * TP14 : CLASSE ABSTRAITE
	 */

	@Override
	public String getType() {
		return "ROND";
	}

	@Override
	public Point getPointDOrigine() {
		return centre;
	}

	@Override
	public Figure getRandomFigure() {
		FigureUtil figUtil = new FigureUtil();
		return figUtil.getRandomRond();
	}

	@Override
	public double surface() {
		return Math.PI*rayon*rayon;
	}

	@Override
	public Point[] getPoints() {
		Point tableauDePointsDuRond [] = {centre};
		return tableauDePointsDuRond;
	}

	@Override
	public boolean couvre(Point pointInconnu) {
		int distance = getDistance(pointInconnu);
		if (distance <= rayon) {
			return true;
		}
		else {
			return false;	
		}
	}
	
	
	/**
	 * TP23 : EGALITE DE FIGURE
	 */
	/**
	 * EGALITE ROND/ROND
	 * @param rondAComparer
	 * @return
	 */
	@Override
	public boolean equals(Object objetAComparer) {
		if (objetAComparer instanceof Rond) {
			Rond rondAComparer = (Rond) objetAComparer;
			if (this.centre.equals(rondAComparer.getCentre()) && this.rayon==rondAComparer.getRayon()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
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
