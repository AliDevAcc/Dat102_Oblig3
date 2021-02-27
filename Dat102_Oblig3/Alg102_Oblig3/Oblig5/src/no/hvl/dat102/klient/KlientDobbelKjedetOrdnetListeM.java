package no.hvl.dat102.klient;

import no.hvl.dat102.DobbelKjedetListeS;

public class KlientDobbelKjedetOrdnetListeM {

	public static void main(String[] args) {

		String ord[] = { "o", "a", "s", "m", "e", "k", "c" };

		DobbelKjedetListeS<String> liste = new DobbelKjedetListeS(new String("AAA"), new String("zzz"));

		// Legger data inn i listen
		for (int i = 0; i < ord.length; i++)
			liste.leggTil(ord[i]);

		// viser ut liste
		System.out.println("\n\n Opprinnelig liste");
		liste.visListe();

		// Tester om et bestem element fins
		String element = new String("Kalle");

		boolean funnet = liste.fins(element);
		if (funnet)
			System.out.println("\nElementet " + element + " fins");
		else
			System.out.println("\nElementet " + element + " fins ikke");

		// Fjerner noen fra listen og viser ut igjen

		String element1 = new String("a");
		String element2 = new String("m");
		String element3 = new String("e");
		String element4 = new String("o");
		String element5 = new String("k");
		String element6 = new String("c");
		String element7 = new String("s");

		System.out.println("\n Fjerner " + element1);
		liste.fjern(element1);
		liste.visListe();
		System.out.println("\n\n");

		System.out.println("\n Fjerner " + element2);
		liste.fjern(element2);
		liste.visListe();
		System.out.println("\n\n");

		System.out.println("\n Fjerner " + element3);
		liste.fjern(element3);
		liste.visListe();
		System.out.println("\n\n");

		System.out.println("\n Fjerner " + element4);
		liste.fjern(element4);
		liste.visListe();
		System.out.println("\n\n");

		System.out.println("\n Fjerner " + element5);
		liste.fjern(element5);
		liste.visListe();
		System.out.println("\n\n");

		System.out.println("\n Fjerner " + element6);
		liste.fjern(element6);
		liste.visListe();
		System.out.println("\n\n");

		System.out.println("\n Fjerner " + element7);
		liste.fjern(element7);
		liste.visListe();
		System.out.println("\n\n");

	}
}// class
