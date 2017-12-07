package tpJavaChap01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.sound.midi.ControllerEventListener;

public class FigureUtil {

	/**
	 * METHODES POUR OBTENIR DES COORDONNEES RANDOM
	 */
	// Point randomPoint;
	// Rond randomRond;
	// Rectangle randomRectangle;

	public Random randomFigure = new Random();

	public Point getRandomPoint() {
		Point randomPoint = new Point();
		randomPoint.x = getRandomInt(2, 50);
		randomPoint.y = getRandomInt(2, 50);
		return randomPoint;
	}

	public Rond getRandomRond() {
		Rond rondRandom = new Rond(getRandomPoint(), randomFigure.nextInt(100));
		return rondRandom;
	}

	public Rectangle getRandomRectangle() {
		Rectangle rectangleRandom = new Rectangle(getRandomPoint(), randomFigure.nextInt(100),
				randomFigure.nextInt(100));
		return rectangleRandom;
	}

	public Segment getRandomSegment() {
		Segment segmentRandom = new Segment(getRandomPoint(), randomFigure.nextInt(100), true);
		return segmentRandom;
	}

	public int getRandomInt(int min, int max) {
		return (int) Math.round(Math.random() * (max - min)) + min;
	}

	/**
	 * Pour obtenir un nombre aléatoire : private static int getRandomInt(int min,
	 * int max){ return (int) Math.round(Math.random() * (max - min)) + min; }
	 * 
	 * ou utiliser la classe Random.
	 */

	public Figure getRandomFigure() {
		Figure figure = null;
		int type = randomFigure.nextInt(3) + 1;
		switch (type) {
		case 1:
			figure = getRandomRectangle();
			break;

		case 2:
			figure = getRandomRond();
			break;

		case 3:
			figure = getRandomSegment();
			break;

		default:
			break;
		}
		return figure;

	}

	/**
	 * edit : cette méthode est plus spécifique que celle qui est définie
	 * ci-dessous. Celle d'en-dessous est plus générale grâce à l'ellipse (les
	 * "...").
	 * 
	 * @param figures
	 * @return
	 */
	/*
	 * public Point[] getPoints(Figure[] tableauDeFigures) { int nombreDePoints = 0;
	 * for (Figure fig : tableauDeFigures) { nombreDePoints +=
	 * fig.getPoints().length; }
	 * 
	 * Point[] tableauDePoints = new Point[nombreDePoints]; int indice = 0; for
	 * (Figure fig : tableauDeFigures) { Point[] temps = fig.getPoints(); for (int i
	 * = 0; i < temps.length; indice++) { tableauDePoints[indice] = temps[i]; } }
	 * return tableauDePoints; }
	 */

	public Point[] getPoints(Figure... figures) {
		/*
		 * int nombreDePoints = 0; for (Figure figure : figures) { nombreDePoints +=
		 * figure.getPoints().length; }
		 * 
		 * Point[] tableauDePoints = new Point[nombreDePoints]; int indiceDuTableau = 0;
		 * for (Figure figure : figures) { Point[] temps = figure.getPoints(); for (int
		 * indiceDuTableauTemporaire = 0; indiceDuTableauTemporaire < temps.length;
		 * indiceDuTableauTemporaire++,indiceDuTableau++) {
		 * tableauDePoints[indiceDuTableau] = temps[indiceDuTableauTemporaire]; } }
		 * return tableauDePoints;
		 */

		List<String> strs = new ArrayList<>();
		String strss[] = strs.toArray(new String[0]);

		List<Point> points1 = Arrays.asList(figures) // transformation du tableau en liste
				.stream() /// récupération du stream
				.flatMap(figure -> Arrays.asList(figure.getPoints()).stream()) /// j'ai récupérer tous les points des
																				/// figures
				// /!\ FlatMap car à un objet de la stream initiale (stream de figure), peut
				// correspondre 0 ou n element de la stream de sortiee (stream de Point)
				.collect(Collectors.toList()) /// action terminale => on réupère la liste de Point
		;
		Point points2[] = points1.toArray(new Point[0]); // /!\ Ce n'est pas du stream. ça transforme une collection en
															// tableau
		return points2;
	}

	/**
	 * METHODE POUR DONNER UNE LISTE A NOMBRE DE FIGURES ALEATOIRE
	 */
	public HashSet<Figure> genere(int nombreDeFigures) {
		Dessin dessin = new Dessin();
		int compteur = 0;
		while (compteur < nombreDeFigures) {
			// System.out.println(compteur);
			if (!dessin.getListeDesFigures().contains(getRandomFigure())) {
				dessin.add(getRandomFigure());
				// System.out.println("machin");
				compteur++;
			} else {
				System.out.println("La liste contient déjà la figure " + randomFigure + ".");
			}
		}
		return dessin.getListeDesFigures();
	}

	public Optional<Figure> getFigureEn(Point pointInconnu, Dessin dessin) {

		Predicate<Figure> p = new Predicate<Figure>() {
			public boolean test(Figure t) {
				return t.couvre(pointInconnu);
			}
		};

		return dessin.getListeDesFigures() // récupération de la collection
				.stream() // initialisation du stream
				// Ici j'ai un stream sur une collection de figure, donc le paramétre d'entre du
				// futur stream est une figure.
				.filter(t -> t.couvre(pointInconnu)) // utilisation de 0 1, n opération intermédiaire, qui vont influer
														// sur les données du stream
				// Ici j'ai toujours un stream sur une collection de figure, mais certaines
				// figure n'arriveront pas jusque là.
				.findAny();
		/*
		 * 
		 * Iterator<Figure> it = dessin.getListeDesFigures().iterator(); //
		 * ArrayList<Figure> figuresQuiCouvrentLePoint = new ArrayList<Figure>(); while
		 * (it.hasNext()) { Figure figure = it.next(); if
		 * (figure.couvre(pointInconnu)==true) { return Optional.of(figure); //
		 * System.out.println(figure + " couvre le point " + pointInconnu); //
		 * figuresQuiCouvrentLePoint.add(figure); } } return Optional.empty();
		 * 
		 * // Cette partie est inutile puisque la fonction s'arrête dès qu'on a retourné
		 * une figure /*if (!figuresQuiCouvrentLePoint.isEmpty()) { return
		 * figuresQuiCouvrentLePoint.get(0); } else { return null; }
		 */
	}

	/**
	 * TP30 : METHODE POUR CREER DES FIGURES ALEATOIREMENT COLOREES
	 */
	public Figure getRandomFigureColoree() {
		int choixDeCouleur = randomFigure.nextInt(5);
		Couleur listeDesCouleurs[] = Couleur.values();
		Figure figureAleatoireColoree;
		figureAleatoireColoree = getRandomFigure();
		figureAleatoireColoree.couleur = listeDesCouleurs[choixDeCouleur];
		return figureAleatoireColoree;
	}

	public static final int X_MIN = 0;
	public static final int X_MAX = 100;
	public static final int Y_MIN = 0;
	public static final int Y_MAX = 100;

	public void imprime(Dessin d) throws IOException, ImpressionHorsLimiteException {
		File file = File.createTempFile("monDessin", ".dessin");

		PrintWriter sortie = new PrintWriter(new FileOutputStream(file));

		d.getFigures().stream().forEach(f -> sortie.println(f));

		// si une figure sort de la zone d'impression ([0,100] [0,100]) alors je lève
		// l'exception ImpressionHorsLimiteException

		List<Point> listeDePointsHorsLimite = d.getFigures().stream()
				.flatMap(figure -> Arrays.asList(figure.getPoints()).stream())
				.filter(point -> point.getX() > 100 & point.getY() > 100)
				.collect(Collectors.toList());

		if (!listeDePointsHorsLimite.isEmpty()) {
			throw new ImpressionHorsLimiteException();
		} else {
			for (int x = X_MIN; x < X_MAX; x++) {
				sortie.print("=");
			}
			sortie.println();
			for (int y = Y_MIN; y < Y_MAX; y++) {
				for (int x = X_MIN; x < X_MAX; x++) {
					Optional<Figure> figure = getFigureEn(new Point(x, y), d);
					if (figure.isPresent()) {
						sortie.print(figure.get().getCouleur().getCodeCouleur());
					} else {
						sortie.print(" ");
					}
				}
				sortie.println();
			}
			System.out.println("Impression sous " + file.getAbsolutePath());
			sortie.close();

		}
	}

}

class PrintWriter {

	private OutputStream os;

	public PrintWriter(OutputStream os) {
		this.os = os;
	}

	public Object println(Figure f) {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public void println() {
		// TODO Auto-generated method stub

	}

	public void print(String str) throws IOException {
		byte[] bs = new byte[4 * str.length()];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			bs[4 * i + 0] = (byte) c;
			bs[4 * i + 1] = (byte) c;
			bs[4 * i + 2] = (byte) c;
			bs[4 * i + 3] = (byte) c;
		}
		os.write(bs);
	}

}