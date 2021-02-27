package no.hvl.dat102;

import no.hvl.dat102.tabell.SirkulaerKoe;
import no.hvl.dat102.tabell.TabellKoe;

public class Sorteringsklient {
	public static void main(String[] args) {
		int[] liste = { 7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241, 6589, 6622, 1211 };
		
//		String temp;
//		Integer tallObj;
//		int siffer, tall;
//		
//		TabellKoe<Integer>[] sifferKoer = (TabellKoe<Integer>[])(new TabellKoe[10]);
//		// Sirkulærkoe er mer effektiv ved
//		// uttak ...
//		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
//			sifferKoer[sifferVerdi] = new TabellKoe<Integer>(); /** sorterer liste */
//			for (int posisjon = 0; posisjon < 4; posisjon++) {// ytre løkke
//				for (int i = 0; i < liste.length; i++) {// indre løkke
//					temp = String.valueOf(liste[i]);
//					siffer = Character.digit(temp.charAt(3 - posisjon), 10);
//					sifferKoer[siffer].innKoe(new Integer(liste[i]));
//				} // indre løkke
//			
//		}
//		/* legger sorterte tall ut i liste */ 
//			tall = 0;
//		for (int sifferVerdi1 = 0; sifferVerdi1 <= 9; sifferVerdi1++) {
//			while (!(sifferKoer[sifferVerdi1].erTom())) {
//				tallObj = sifferKoer[sifferVerdi1].utKoe();
//				liste[tall] = tallObj.intValue();
//				tall++;
//			} //while 
//			}//for 
//		}//ytre løkke/** skriver ut sortert listet */ 
//	for (int i=0; i <liste.length; i++){ System.out.println (liste[i]);
//	}
		
		SirkulaerKoe<Integer> s1= new SirkulaerKoe<Integer>();
		Person[] p= new Person[3];
		p[0]= new Person("David", "Toska");
		p[1]=new Person("Carl", "Carlson");
		p[2]=new Person("Mohamed", "Ali");
		
		Aar[] e= new Aar[3];
		
		e[0]= new Aar(7);
		e[1]= new Aar(9);
		e[2]= new Aar(5);
		
		
		SoekingOgSortering s = new SoekingOgSortering();
//		System.out.println("Sortering ved innsetting");
//		s.sorteringVedInsetting(e);
//		for(int i=0; i < e.length;i++) {
//			System.out.println(e[i].getAar());
//		}
		
//		System.out.println("Utvalgssortering");
//		s.utvalgSortering(p);
		
//		System.out.println("boblesortering");
//		s.bobleSort(p);
		
//		System.out.println("kvikksortering");
//		s.kvikkSort(e, 0, e.length-1);
		
		System.out.println("flettesortering");
		s.fletteSort(e, e[0].getAar(),e[e.length-1].getAar());
		
		
		for(int i=0; i < e.length;i++) {
			System.out.println(e[i].getAar());
		}
	}
}
