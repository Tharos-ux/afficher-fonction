/*
 * Copyright (c) 2019, Dubois Siegfried, ODOSOS
 * Cédé à titre de licence libre autorisant l'usage de l'œuvre, dans un but pédagogique,
 * permettant l'étude de l'œuvre pour en comprendre le fonctionnement ou l'adapter à ses besoins,
 * la modification (amélioration, extension et transformation) ou incorporation de l'œuvre en une œuvre dérivée,
 * ainsi que la redistribution de l'œuvre, c'est-à-dire sa diffusion à d'autres usagers, à l'exception d'un usage commercial.
 */

package Main;

import java.awt.Color;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class interf extends JFrame {
	public interf(int x, int y) { // on va demander à l'utilisateur des tailles
		this.setTitle("Moniteur");
		this.setSize(x,y);
		this.setResizable(false);
		this.setLocation(500,(principale.screenSize.height-y)/2);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
	}
	public static void refresh(interf moniteur) {
		moniteur.setContentPane(new graphique());				
		moniteur.setVisible(true);
	}
}
