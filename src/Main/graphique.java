/*
 * Copyright (c) 2019, Dubois Siegfried, ODOSOS
 * Cédé à titre de licence libre autorisant l'usage de l'œuvre, dans un but pédagogique,
 * permettant l'étude de l'œuvre pour en comprendre le fonctionnement ou l'adapter à ses besoins,
 * la modification (amélioration, extension et transformation) ou incorporation de l'œuvre en une œuvre dérivée,
 * ainsi que la redistribution de l'œuvre, c'est-à-dire sa diffusion à d'autres usagers, à l'exception d'un usage commercial.
 */

package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class graphique extends JPanel implements MouseMotionListener {
	static complexe complexeCalcul;
	static String nomMth;
	static int rez;
	static int imz;
	static int posSourisX;
	static int posSourisY;
	static int memX;
	static int memY;
	static int affixeReelle;
	static int oordReelle;
	static complexe clccurseur;
	static complexe resultatcomplexe;
	
	public void paintComponent(Graphics g) {
		
		// on rebuild le graphique à chaque actualisation
		this.removeAll();
		
		// on réactualise les variables
	
		// on récupère les coordonnées du milieu
		//int pluspetit = this.getWidth()<this.getHeight()?this.getWidth():this.getHeight();
		int decalage = this.getWidth()<this.getHeight()?this.getHeight()-this.getWidth():this.getWidth()-this.getHeight();
		boolean paysage = this.getWidth()>this.getHeight();
				int x = this.getWidth()/2;
				int y = this.getHeight()/2;
		
		// on cleanse les anciens points		
		g.clearRect(0,0,principale.dimX,principale.dimY);
		
		// on trace le graphe
		if (paysage) {
			principale.zoom = y/2*Float.parseFloat(params.zoomFacteur.getText());
			g.drawOval(x/2+(decalage/4),y/2, y, y);
			g.drawString(Float.toString(convertisseur.CSG(new complexe(x,y/2)).im)+"i", x+5, y-(y/2)-5);
			g.drawString(Float.toString(convertisseur.CSG(new complexe((x+x/2)-decalage/4,y)).re), (x+(x/2)-decalage/4)+5, y-5);
		}
		else {
			principale.zoom = x/2*Float.parseFloat(params.zoomFacteur.getText());
			g.drawOval(x/2,y/2+(decalage/4), x, x);
			//g.drawString(Float.toString(convertisseur.CSG(new complexe(x,y/2-decalage/4)).im)+"i", x+5, y-(y/2)-5);
			//g.drawString(Float.toString(convertisseur.CSG(new complexe((x+x/2),y)).re), (x+(x/2)-decalage/4)+5, y-5);
		}
		g.drawLine(0, y, x*2, y);
		g.drawLine(x, 0, x, y*2);
		
		
		// antécédent
		int[] grilleX = new int[9];
		int[] grilleY = new int[9];
		
		// on définit la grille de points
		grilleX[0] = -principale.pasGrille;
		grilleY[0] = -principale.pasGrille;
		grilleX[1] = -principale.pasGrille;
		grilleY[1] = 0;
		grilleX[2] = -principale.pasGrille;
		grilleY[2] = principale.pasGrille;
		grilleX[3] = 0;
		grilleY[3] = -principale.pasGrille;
		grilleX[4] = 0;
		grilleY[4] = 0;
		grilleX[5] = 0;
		grilleY[5] = principale.pasGrille;
		grilleX[6] = principale.pasGrille;
		grilleY[6] = -principale.pasGrille;
		grilleX[7] = principale.pasGrille;
		grilleY[7] = 0;
		grilleX[8] = principale.pasGrille;
		grilleY[8] = principale.pasGrille;
		
		complexe[] antecedents = new complexe[9];
		complexe[] images = new complexe[9];
		// on trace la grille des antécédents & on calcule leurs images
		for(int i = 0; i<grilleX.length;i++) {
			clccurseur = new complexe(grilleX[i]+posSourisX,grilleY[i]+posSourisY);
			clccurseur = convertisseur.CSG(clccurseur);
			clccurseur = maths.choixFonction(params.fonctionChoisie,clccurseur);
			clccurseur = convertisseur.CGS(clccurseur);
			images[i]=clccurseur;
			antecedents[i]=new complexe(grilleX[i]+posSourisX,grilleY[i]+posSourisY);
		}
		
		g.setColor(Color.blue);
		// on print toutes les lignes
		g.drawLine((int) antecedents[0].re, (int) antecedents[0].im, (int) antecedents[1].re, (int) antecedents[1].im);
		g.drawLine((int) antecedents[1].re, (int) antecedents[1].im, (int) antecedents[2].re, (int) antecedents[2].im);
		g.drawLine((int) antecedents[2].re, (int) antecedents[2].im, (int) antecedents[5].re, (int) antecedents[5].im);
		g.drawLine((int) antecedents[1].re, (int) antecedents[1].im, (int) antecedents[4].re, (int) antecedents[4].im);
		g.drawLine((int) antecedents[0].re, (int) antecedents[0].im, (int) antecedents[3].re, (int) antecedents[3].im);
		g.drawLine((int) antecedents[3].re, (int) antecedents[3].im, (int) antecedents[4].re, (int) antecedents[4].im);
		g.drawLine((int) antecedents[4].re, (int) antecedents[4].im, (int) antecedents[5].re, (int) antecedents[5].im);
		g.drawLine((int) antecedents[3].re, (int) antecedents[3].im, (int) antecedents[6].re, (int) antecedents[6].im);
		g.drawLine((int) antecedents[4].re, (int) antecedents[4].im, (int) antecedents[7].re, (int) antecedents[7].im);
		g.drawLine((int) antecedents[5].re, (int) antecedents[5].im, (int) antecedents[8].re, (int) antecedents[8].im);
		g.drawLine((int) antecedents[6].re, (int) antecedents[6].im, (int) antecedents[7].re, (int) antecedents[7].im);
		g.drawLine((int) antecedents[7].re, (int) antecedents[7].im, (int) antecedents[8].re, (int) antecedents[8].im);
		// on print les points d'intersection
		for(int i=0;i<antecedents.length;i++) {
			g.fillRect((int) antecedents[i].re-2, (int) antecedents[i].im-2, 4, 4);
		}
		resultatcomplexe = new complexe(posSourisX,posSourisY);
		g.drawString("POS: "+convertisseur.CSG(resultatcomplexe).re+", "+convertisseur.CSG(resultatcomplexe).im, principale.dimX-210, principale.dimY-10);
		
		g.setColor(Color.red);
		// on print toutes les lignes
		g.drawLine((int) images[0].re, (int) images[0].im, (int) images[1].re, (int) images[1].im);
		g.drawLine((int) images[1].re, (int) images[1].im, (int) images[2].re, (int) images[2].im);
		g.drawLine((int) images[2].re, (int) images[2].im, (int) images[5].re, (int) images[5].im);
		g.drawLine((int) images[1].re, (int) images[1].im, (int) images[4].re, (int) images[4].im);
		g.drawLine((int) images[0].re, (int) images[0].im, (int) images[3].re, (int) images[3].im);
		g.drawLine((int) images[3].re, (int) images[3].im, (int) images[4].re, (int) images[4].im);
		g.drawLine((int) images[4].re, (int) images[4].im, (int) images[5].re, (int) images[5].im);
		g.drawLine((int) images[3].re, (int) images[3].im, (int) images[6].re, (int) images[6].im);
		g.drawLine((int) images[4].re, (int) images[4].im, (int) images[7].re, (int) images[7].im);
		g.drawLine((int) images[5].re, (int) images[5].im, (int) images[8].re, (int) images[8].im);
		g.drawLine((int) images[6].re, (int) images[6].im, (int) images[7].re, (int) images[7].im);
		g.drawLine((int) images[7].re, (int) images[7].im, (int) images[8].re, (int) images[8].im);
		// on print les points d'intersection
		for(int i=0;i<images.length;i++) {
			g.fillRect((int) images[i].re-2, (int) images[i].im-2, 4, 4);
		}
		// on build l'affichage de la position du point sous le curseur
		this.addMouseMotionListener(this);
	}
	
	// EVENEMENTS MOUSE MOTION (récupérer les coordonnées)
	
	@Override
	public void mouseDragged(MouseEvent e) {
        posSourisX=e.getX();
		posSourisY=e.getY();
    }
	@Override
	public void mouseMoved(MouseEvent e) {
		posSourisX=e.getX();
		posSourisY=e.getY();
	}
	
	
}
