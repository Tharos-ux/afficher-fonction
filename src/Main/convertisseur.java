/*
 * Copyright (c) 2019, Dubois Siegfried, ODOSOS
 * Cédé à titre de licence libre autorisant l'usage de l'œuvre, dans un but pédagogique,
 * permettant l'étude de l'œuvre pour en comprendre le fonctionnement ou l'adapter à ses besoins,
 * la modification (amélioration, extension et transformation) ou incorporation de l'œuvre en une œuvre dérivée,
 * ainsi que la redistribution de l'œuvre, c'est-à-dire sa diffusion à d'autres usagers, à l'exception d'un usage commercial.
 */

package Main;

public class convertisseur {
	
	public static complexe CGS(complexe z) {
		return new complexe(z.re*principale.zoom+principale.dimX/2,-z.im*principale.zoom+principale.dimY/2);
	}  // convertisseur graphique --> souris
	
	public static complexe CSG(complexe z) {
		return new complexe((z.re-principale.dimX/2)/principale.zoom,(-z.im+principale.dimY/2)/principale.zoom);
	}  // convertisseur souris --> graphique	
	

}
