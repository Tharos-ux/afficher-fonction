/*
 * Copyright (c) 2019, Dubois Siegfried, ODOSOS
 * Cédé à titre de licence libre autorisant l'usage de l'œuvre, dans un but pédagogique,
 * permettant l'étude de l'œuvre pour en comprendre le fonctionnement ou l'adapter à ses besoins,
 * la modification (amélioration, extension et transformation) ou incorporation de l'œuvre en une œuvre dérivée,
 * ainsi que la redistribution de l'œuvre, c'est-à-dire sa diffusion à d'autres usagers, à l'exception d'un usage commercial.
 */

package Main;
public class maths {
	
	// ajouter ici des String ajoute des champs à la liste déroulante
	public static final String[] listeStringFonctions = {"Carré","Cube","Complexe conjugé","Exponentielle","Inverse","Cosinus","Sinus","Tangente"};
	// sert à donner des adresses aux fonctions
	// ce sont les noms que l'on retrouve dans la liste déroulante
	public static complexe choixFonction(String fonction, complexe z) {
		if(fonction=="Carré") return carre(z);
		if(fonction=="Complexe conjugé") return conjuge(z);
		if(fonction=="Cube") return cube(z);
		if(fonction=="Exponentielle") return exp(z) ;
		if(fonction=="Inverse") return inverse(z);
		if(fonction=="Cosinus") return cosinus(z);
		if(fonction=="Sinus") return sinus(z);
		if(fonction=="Tangente") return tangente(z);
		// if(fonction=="<nom de la chaîne>") return <nom de la fonction>(z);
		// les compositions sont possibles : exemple carre(cube(z))
		return z; // rien à calculer (fonction non déclarée)
	}

	// fonctions mathématiques
	
	public static complexe carre(complexe z) {
		return new complexe(z.re*z.re - (z.im*z.im), 2*z.re*z.im);
	}

	public static complexe cube(complexe z) {
		return new complexe(z.re*z.re*z.re - 3*z.re*z.im*z.im,-z.im*z.im*z.im+3*z.im*z.re*z.re);
	}
	
	public static complexe conjuge(complexe z) {
		return new complexe(z.re, -z.im);
	}
	
	public static complexe exp(complexe z) {
		return new complexe((float)(Math.exp(z.re)*(Math.cos(z.im))),(float)(Math.exp(z.re)*(Math.sin(z.im))));
	}
	
	public static complexe inverse(complexe z) {
		return new complexe((z.re)/((z.re*z.re)+(z.im*z.im)),(-z.im)/((z.re*z.re)+(z.im*z.im)));
	}	
	
	public static complexe cosinus(complexe z) {
		return new complexe((float)(Math.cos(z.re)*(Math.exp(z.im)+Math.exp(-z.im))/2),(float)(-Math.sin(z.re)*(Math.exp(z.im)-Math.exp(-z.im))/2));
	}
	
	public static complexe sinus(complexe z) {
		return new complexe((float)(Math.sin(z.re)*(Math.exp(z.im)+Math.exp(-z.im))/2),(float)(Math.cos(z.re)*(Math.exp(z.im)-Math.exp(-z.im))/2));
	}
	
	public static complexe tangente(complexe z) {
		return new complexe((float)(Math.sin(2*z.re)/(Math.cos(2*z.re)+(Math.exp(2*z.im)+Math.exp(-2*z.im))/2)),(float)((Math.exp(2*z.im)-Math.exp(-2*z.im))/(2*Math.cos(2*z.re)-Math.exp(2*z.im)-Math.exp(-2*z.im))));
	}	
	
	/*
	public static complexe NOM(complexe z) {
		return new complexe(CALCUL PARTIE REELLE,CALCUL PARTIE IMAGNAIRE);
	}
	*/

}