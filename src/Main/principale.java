/*
 * Copyright (c) 2019, Dubois Siegfried, ODOSOS
 * Cédé à titre de licence libre autorisant l'usage de l'œuvre, dans un but pédagogique,
 * permettant l'étude de l'œuvre pour en comprendre le fonctionnement ou l'adapter à ses besoins,
 * la modification (amélioration, extension et transformation) ou incorporation de l'œuvre en une œuvre dérivée,
 * ainsi que la redistribution de l'œuvre, c'est-à-dire sa diffusion à d'autres usagers, à l'exception d'un usage commercial.
 */

package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class principale {
	// définition des variables d'interface
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static boolean estPause = true;
	public static int pasGrille; // pas entre deux points du quadrillage
	public static int dimX; // contient la dimension du repère en X
	public static int dimY; // en Y
	public static JFrame params; // fenetre de parametres!
	public static int wttime; // taux de rafraichissement en ms
	public static float zoom; // facteur de zoom ; zoom px = 1
	public static JButton btEtat; // donne l'état et lance/met en pause
	public static interf moniteur;

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// fenetre params
		params parametre = new params();
		while (true) {
			try {
				// on actualise les variables
				wttime = Integer.parseInt(parametre.refresh.getText());
				Thread.sleep(wttime); // on actualise toutes les n ms
			} catch (InterruptedException erreur) {
				System.out.println("Arret d'exécution");
			}
			if (parametre.estPause == false) {
				pasGrille = Integer.parseInt(parametre.tailleGrille.getText());
				dimX = Integer.parseInt(parametre.tailleEnX.getText());
				dimY = Integer.parseInt(parametre.tailleEnY.getText());
				interf.refresh(moniteur);
			}
		}
	}
}
