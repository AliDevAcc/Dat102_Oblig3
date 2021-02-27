package no.hvl.dat102;

import java.lang.*;

public class Aar implements Comparable <Aar>{
	private int aar;
	
	public Aar(int aar) {
		this.aar=aar;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	@Override
	public int compareTo(Aar a) {
		int c=0;
		if (aar < a.getAar()) {
			c=-1;
		} else if (aar > a.getAar()) {
			c=1;
		}
		
		
		return c;
	}


	
	
}
