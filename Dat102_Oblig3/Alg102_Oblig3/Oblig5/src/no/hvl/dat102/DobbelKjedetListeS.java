package no.hvl.dat102;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeMADT;

public class DobbelKjedetListeS<T extends Comparable<T>> implements DobbelKjedetOrdnetListeMADT<T>{ // Ny,spesiell ordnetliste med// dobbelkjeding
	private DobbelNode<T> foerste;
	private DobbelNode<T>midten;
	private DobbelNode<T> siste;
	private int antall;
	public DobbelKjedetListeS(T minVerdi, T maksVerdi){	// F�rste node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;
		midten = foerste;

		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>();
		nyNode2.setElement(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;

		antall = 0;}
	@Override
	public void leggTil(T ny){
		// Setter inn ordnet f�r den noden p peker p�
				DobbelNode<T> p,f;

				if (((ny).compareTo(foerste.getElement()) <= 0) || (ny.compareTo(siste.getElement()) >= 0)) {
					// Ugyldig. Alternativt kan vi ha det som et forkrav!
					System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

				} else { // Kun lovlige verdier

					antall++;

					if (ny.compareTo(midten.getElement()) >= 0) {// Finn plass i siste
																	// halvdel
						p = midten.getNeste();
					} else { // Finn plass i f�rste halvdel
						p = foerste.getNeste();
					}

					while (ny.compareTo(p.getElement()) >= 0) {
						p = p.getNeste();
					} // while

					// Setter inn:
					// Innsett foran noden som p peker p�

					DobbelNode<T> nyNode = new DobbelNode<T>(ny);
					f=p.getForrige();
					nyNode.setNeste(p);
					nyNode.setForrige(f);
					f.setNeste(nyNode);
					p.setForrige(nyNode);
					// Fyll ut med noen f� setninger

					// Oppdaterer ny midten
					nyMidten();
					

	}
	}
	
	private void nyMidten() {
		int midtNR = antall / 2;
		DobbelNode<T> p = foerste.getNeste();
		/*if()
		if(midtNR%2==0) {
			p=midten.getNeste();
		} else {
			
		}
		
		*/for (int i = 1; i <= midtNR; i++) {
			p = p.getNeste();
		} 
		midten = p;
	}//
	
	@Override
	public T fjern(T x){
		T resultat = null;
		DobbelNode<T> p = null,f = null,d;
		boolean funnet=false;
		while(!funnet) {
		if ((x.compareTo(foerste.getElement()) <= 0) || (x.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
			if (x.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
				p = midten; // Midten defineres � tilh�re siste del
			} else { // Let i f�rste halvdel
				p = foerste.getNeste();
			}

			while (x.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} // while

			// Test p� funnet
			if (x.compareTo(p.getElement()) == 0) {
				funnet = true;
			}	
		}
				// Fyll ut med noen f� setninger.
					if (foerste.getForrige() == null) {     // F�rste element
						foerste = foerste.getNeste();
						if (foerste == null) { // Tom liste
							midten=null;
							siste = null;
						}
					} else { // Inni listen eller bak
						f=p.getForrige();
						resultat=f.getElement();
						d=f.getForrige();
						d.setNeste(p);
						p.setForrige(d);
						if (midten == siste) { // bak
							siste = foerste.getForrige();
						}
					}
					antall = antall - 1;
				// Oppadtere midten
				nyMidten();


			 // funnet

		} // lovlige
			return resultat;
			}
		
	
	@Override
	public boolean fins(T x){
	boolean funnet = false;
	DobbelNode<T> p = null;
	if ((x.compareTo(foerste.getElement()) <= 0) || (x.compareTo(siste.getElement()) >= 0)) {
		// Ugyldig. Alternativt kan vi ha det som et forkrav!
		System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

	} else { // Kun lovlige verdier
		if (x.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
			p = midten; // Midten defineres � tilh�re siste del
		} else { // Let i f�rste halvdel
			p = foerste.getNeste();
		}

		while (x.compareTo(p.getElement()) > 0) {
			p = p.getNeste();
		} // while

		// Test p� funnet
		if (x.compareTo(p.getElement()) == 0) {
			funnet = true;
		}	
	} // else
	return funnet;
	}
	public void visListe(){	
	DobbelNode<T> p = foerste;

	while (p != null) {
		System.out.print(p.getElement() + " ");
		p = p.getNeste();
	}

	System.out.println(
			"Foerste:" + foerste.getElement() + " Midten:" + midten.getElement() + " Siste:" + siste.getElement());
	System.out.println();
}
}
//class

