package tpJavaChap01;

public class CarreFille extends Rectangle implements Surfacable {
	/**
	 * HERITAGE :
	 * CARRE HERITE DE RECTANGLE
	 * @author jtan
	 *
	 */

	public CarreFille(Point point, int cote) {
		super(point, cote, cote);
	}
	
	public String getType() {
		return "CAR";
	}

	public String toString() {
		return "[CARRE " + pointBasGauche + getPointHautGauche() + getPointHautDroit() + getPointBasDroit() + "]";
	}
	
	public void affiche() {
		System.out.println(toString());
	}
	
//	On peut aussi faire une methode getType pour que la methode affiche() indique CARRE ou RECT selon le retour de getType.
}
