/*
 * Copyright (c) 2019, Dubois Siegfried, ODOSOS
 * Cédé à titre de licence libre autorisant l'usage de l'œuvre, dans un but pédagogique,
 * permettant l'étude de l'œuvre pour en comprendre le fonctionnement ou l'adapter à ses besoins,
 * la modification (amélioration, extension et transformation) ou incorporation de l'œuvre en une œuvre dérivée,
 * ainsi que la redistribution de l'œuvre, c'est-à-dire sa diffusion à d'autres usagers, à l'exception d'un usage commercial.
 */

package Main;

public class complexe {
	float re;
	float im;
	
	// constructeur de complexe
	complexe(float a, float b) {
		re = a;
		im = b;
	}
	
	public float module() {
		return (float)Math.sqrt(im*im+re*re);
	}
	
	public float argument() {
		//return (float)Math.toRadians((Math.sin(im)+Math.cos(re))/module());
		return (float) Math.atan((this.im)/this.re+this.module());
	}
	
	public complexe invert() { // intervertit réel et imaginaire
		return new complexe(this.im,this.re);
	}
	
	public complexe negate() {
		return new complexe(-this.re,-this.im);
	}
	
	public complexe conjuge() {
		return new complexe(this.re,-this.im);
	}
}
