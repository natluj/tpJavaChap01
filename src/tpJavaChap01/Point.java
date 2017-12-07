package tpJavaChap01;

public class Point {

	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * LES GETTERS
	 */
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * METHODE POUR RENVOYER LES COORDONNEES DU POINT
	 */
	public String toString() {
		return "[" + getX() + "," + getY() + "]";
	}

	/**
	 * TP11 : CLASSE ET METHODE STATIQUES
	 */
	public static final int init_x = 25, init_y = 25;

	public Point() {
		this(init_x, init_y);
	}

	/**
	 * TP13 : EGALITE DE POINT
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Point)) {
			System.out.println("L'Objet comparé n'est pas un point !");
			return false;
		}
		if (this.x == ((Point) o).getX() && this.y == ((Point) o).getY()) {
			return true;
		} else {
			return false;
		}
	}
}
