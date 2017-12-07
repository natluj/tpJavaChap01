package tpJavaChap01;

public enum Couleur {
	/**
	 * TP30 : ENUM
	 */

	Rouge('R'),
	Vert('V'),
	Bleu('B'),
	Jaune('J'),
	Noir('N');

	private final char codeCouleur;
	
	private Couleur(char code) {
		this.codeCouleur = code;
	}
	
	public String getCodeCouleur() {
		return "" + codeCouleur;
	}

	public static Couleur getCouleurDefaut() {
		return Couleur.Noir;
	}
}

