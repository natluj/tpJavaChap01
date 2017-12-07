package tpJavaChap01;

import java.util.HashSet;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		/**
		 * TP 10
		 */

		/**
		 * DEFINITION DU POINT
		 */
		Point p1 = new Point(2, 6);
		System.out.println(p1);

		/**
		 * DEFINITION DU ROND
		 */
		Rond rond = new Rond(p1, 3);
		rond.affiche();

		/**
		 * DEFINITION DU RECTANGLE
		 */
		Rectangle rectangle = new Rectangle(p1, 3, 5);
		rectangle.affiche();

		System.out.println("==============================================");

		/**
		 * TP 11
		 */

		FigureUtil figUtil = new FigureUtil();
		System.out.println(figUtil.getRandomPoint()); // marche que si la methode est public
		System.out.println(Math.random());
		System.out.println(figUtil.getRandomRond());
		System.out.println(figUtil.getRandomRectangle());

		// remarque : Math.random() donne un nombre entre 0 et 1...

		// System.out.println(figUtil.getRandomInt(2, 45)); //attention à
		// l'accessibilite

		/**
		 * TP 12 : HERITAGE
		 */
		System.out.println("==============================================");
		CarreFille carre = new CarreFille(p1, 4);
		carre.affiche();

		/**
		 * TP13 : EGALITE DE POINT
		 */
		System.out.println("==============================================");
		Point pointTest1 = new Point(2, 8), pointTest2 = new Point(2, 6);
		System.out.println(
				"Egalité de point : premier point " + pointTest1 + " comparé à p1 ==> " + pointTest1.equals(p1));
		System.out.println(
				"Egalité de point : deuxième point " + pointTest2 + " comparé à p1  ==> " + pointTest2.equals(p1));
		System.out.println("Egalité de point : deuxième point " + pointTest2 + " comparé au centre de rond ==> "
				+ pointTest2.equals(rond.getCentre()));

		/**
		 * TP15 : INTERFACE
		 */
		System.out.println("==============================================");
		Segment segment = new Segment(figUtil.getRandomPoint(), figUtil.getRandomInt(2, 56), true);
		System.out.println(segment);

		/**
		 * TP21
		 */
		System.out.println("==============================================");
		// Random random = new Random(); //test sur random
		// System.out.println(random.nextInt(5));
		// System.out.println(random.nextInt(5));
		// Dessin dessin = new Dessin();
		// System.out.println("truc");
		HashSet<Figure> dessinDeFigures = figUtil.genere(3);
		// System.out.println("truc");
		System.out.println("Liste des figures :");
		// System.out.println(dessinDeFigures);
		for (Figure figure : dessinDeFigures) {
			System.out.println(figure);
		}
		System.out.println("===");
		Iterator<Figure> iterator = dessinDeFigures.iterator();
		while (iterator.hasNext()) {
			Figure figure = iterator.next();
			System.out.println(figure);
		}

		/**
		 * TP22
		 */
		System.out.println("==============================================");
		Dessin dessin = new Dessin();
		dessin.setListeDesFigures(dessinDeFigures);
		Point pointInconnu = figUtil.getRandomPoint();
		System.out.println("Le point " + pointInconnu + " est sur :");
		System.out.println(figUtil.getFigureEn(pointInconnu, dessin));

		/**
		 * TP23
		 */
		System.out.println("==============================================");
		Rond rond2 = new Rond(figUtil.getRandomPoint(), figUtil.randomFigure.nextInt(50));
		Rond rond3 = new Rond(rond.getCentre(), rond.getRayon());
		System.out.println(rond.equals(rond2));
		System.out.println(rond.equals(rond3));
		// System.out.println(rond.equals(segment));
		// System.out.println(rond.equals(rectangle));

		/**
		 * TP24
		 */
		System.out.println("==============================================");

		/**
		 * TP30
		 */
		System.out.println("==============================================");
		System.out.println(figUtil.getRandomFigureColoree());

		// figUtil.imprime(dessin); //pour enregistrer un dessin de figures dans un file
		// txt

		/**
		 * DEMO : TestEcritThread
		 */
		System.out.println("==============================================");
		MonThread t1 = new MonThread("1", 15);
		MonThread t2 = new MonThread("2", 20);
		System.out.println("start");
		t1.start();
		t2.start();
		// t1.start(); // on ne peut avoir le même thread utilisé plusieurs fois ! Il
		// faut le réinitialiser avec new etc...
		// System.out.println("run");
		// t1.run();
		// t2.run();

		/**
		 * TP40 : Exception : erreur d'impression car hors limite
		 */
		System.out.println("==============================================");
		
		Rectangle rectangleHorsLimite = new Rectangle(p1, 50, 103, Couleur.Vert);
		rectangleHorsLimite.affiche();

	}

}
