/*
 * Copyright (c) 2019, Dubois Siegfried, ODOSOS
 * Cédé à titre de licence libre autorisant l'usage de l'œuvre, dans un but pédagogique,
 * permettant l'étude de l'œuvre pour en comprendre le fonctionnement ou l'adapter à ses besoins,
 * la modification (amélioration, extension et transformation) ou incorporation de l'œuvre en une œuvre dérivée,
 * ainsi que la redistribution de l'œuvre, c'est-à-dire sa diffusion à d'autres usagers, à l'exception d'un usage commercial.
 */

package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class params extends JFrame implements ActionListener {
	public static String fonctionChoisie;
	public static boolean estPause;
	public static int dimX;
	public static int dimY;
	public static JButton btEtat;
	@SuppressWarnings("rawtypes")
	public static JComboBox fonctionChoix;
	public static JTextField tailleGrille;
	public static JTextField refresh;
	public static JTextField tailleEnX;
	public static JTextField tailleEnY;
	public static JTextField zoomFacteur;
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public params() {
		
		// on déclare la fenetre de paramètres
		this.setSize(400, 400);
		this.setTitle("Paramètres");
		this.setLocationRelativeTo(null); //position centrée
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(50,(principale.screenSize.height-400)/2);
		
		btEtat = new JButton("LANCER");
		estPause=true;
		btEtat.addActionListener(this);
		
		// taille de la grille
		tailleGrille = new JTextField();
		tailleGrille.setColumns(10);
		tailleGrille.setText("10");
		
		// refresh rate
		refresh = new JTextField();
		refresh.setColumns(20);
		refresh.setText("20");
		
		// facteur de zoom
		zoomFacteur = new JTextField();
		zoomFacteur.setColumns(10);
		zoomFacteur.setText("1");
		
		//taille en x
		tailleEnX = new JTextField();
		tailleEnX.setColumns(10);
		tailleEnX.setText(Integer.toString(principale.screenSize.width-550));
		
		//taille en y
		tailleEnY = new JTextField();
		tailleEnY.setColumns(10);
		tailleEnY.setText(Integer.toString(principale.screenSize.height-100));
		
		// liste des fonctions sélectionnables
		String[] tableauFonction = maths.listeStringFonctions;	
		fonctionChoix = new JComboBox();
		for(int i=0;i<tableauFonction.length;i++)
			fonctionChoix.addItem(tableauFonction[i]);
		
		JLabel dimensionX = new JLabel("Dimension X (en pixels)");
		JLabel dimensionY = new JLabel("Dimension Y (en pixels)");
		JLabel refreshRate = new JLabel("Taux de rafraîchissement (en ms)");
		JLabel reticuleDim = new JLabel("Ecartement du réticule (en pixels)");
		JLabel labelFonction = new JLabel("Fonction choisie");
		JLabel facteurZoom = new JLabel("Facteur de zoom");
		
		JPanel p1 = new JPanel();
		
		p1.setLayout(new javax.swing.BoxLayout(p1, BoxLayout.Y_AXIS));
		
		p1.add(dimensionX);
		p1.add(tailleEnX);
		p1.add(dimensionY);
		p1.add(tailleEnY);
		p1.add(refreshRate);
		p1.add(refresh);
		p1.add(reticuleDim);
		p1.add(tailleGrille);
		p1.add(facteurZoom);
		p1.add(zoomFacteur);
		p1.add(labelFonction);
		p1.add(fonctionChoix);
		p1.add(btEtat);
		this.getContentPane().add(p1);

		this.setVisible(true);
	}
	
	  @SuppressWarnings({ "deprecation", "static-access" })
	public void actionPerformed(ActionEvent arg0) {      
		  if(this.btEtat.getLabel()=="EN COURS") {
			  this.btEtat.setLabel("LANCER");
			  estPause = true;
			  tailleGrille.enable(true);
			  refresh.enable(true);
			  fonctionChoix.enable(true);
			  zoomFacteur.enable(true);
			  this.setVisible(true);
		  }
		  else {
			  this.btEtat.setLabel("EN COURS");
			  tailleEnX.enable(false);
			  tailleEnY.enable(false);
			  principale.pasGrille = Integer.parseInt(tailleGrille.getText());
			  dimX = Integer.parseInt(tailleEnX.getText());
			  dimY = Integer.parseInt(tailleEnY.getText());
			  principale.moniteur = new interf(dimX,dimY);
			  estPause = false;
			  tailleGrille.enable(false);
			  refresh.enable(false);
			  // ils ne sont utilisables qu'au lancement, plus après
			  fonctionChoisie = (String) fonctionChoix.getSelectedItem();
			  fonctionChoix.enable(false);
			  zoomFacteur.enable(false);
			  this.setVisible(true);
		  }
	  } 
	
	
}
