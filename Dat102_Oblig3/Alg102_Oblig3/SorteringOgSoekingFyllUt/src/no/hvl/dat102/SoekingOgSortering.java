package no.hvl.dat102;

public class SoekingOgSortering <T extends Comparable<T>> {

	/*************************************************************************************************/
	// Søkealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gjør et lineært søk i en tabell av usorterte data
	 * 
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er verdien vi søker etter
	 * @return sann om elementet ble funnet ellers usann
	 */

	public static <T extends Comparable<T>> boolean linearSoekU(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks <= maks && !funnet) {
			if (data[indeks].compareTo(el) == 0)
				funnet = true;
			indeks++;
		} // while
		return funnet;
	}// metode

	/**
	 * Metoden gjør et lineært søk i en sortert tabell av data
	 * 
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   verdien vi søker etter
	 * @return sann hvis funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekS(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks < maks && data[indeks].compareTo(el) < 0) {
			indeks++;
		} // while

		if (data[indeks].compareTo(el) == 0) {
			funnet = true;
		}

		return funnet;

	}// metode

	/**
	 * Metoden gjør et binært søk i en *sortert* tabell av data
	 * 
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er elementet vi søker etter
	 * @return sann om elementet ble funnet ellers usann.
	 */

	// Alt 1
	public static <T extends Comparable<T>> boolean binaerSoek(T[] data, int min, int maks, T element) {

		boolean funnet = false;
		int midtpunkt = (min + maks) / 2;
		if (data[midtpunkt].compareTo(element) == 0) {
			funnet = true;
		} else if (data[midtpunkt].compareTo(element) > 0) {
			if (min <= midtpunkt - 1) {
				funnet = binaerSoek(data, min, midtpunkt - 1, element);
			}
		} else if (midtpunkt + 1 <= maks) {
			funnet = binaerSoek(data, midtpunkt + 1, maks, element);
		}
		return funnet;
	}// metode

	// Alt 2
	public static <T extends Comparable<T>> boolean binaerSoek2(T[] data, int min, int maks, T el) {
		boolean funnet;
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (min > maks) { // basistilfelle, ingen element
			funnet = false;
		} else if (resultat == 0) {
			funnet = true;
		} else if (resultat < 0) {
			funnet = binaerSoek2(data, min, midtpunkt - 1, el);
		} else {
			funnet = binaerSoek2(data, midtpunkt + 1, maks, el);
		}

		return funnet;

	}

	/* Rekursiv binærsøk som returnerer indeks */
	// Alt 3
	public static <T extends Comparable<T>> int binaerSoek3(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		if (min > maks) { // basistilfelle, ingen element
			return -1;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) { // basistilfelle, finner elementet
			return midtpunkt;
		}
		if (resultat < 0) {// ( vil her også fungere med else if)
			return binaerSoek3(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek3(data, midtpunkt + 1, maks, el);
		}
	}// metode

	/* Ikke rekursiv binærsøk som returnerer indeks */
	// Alt 4
	public static <T extends Comparable<T>> int binaerSoek4(T[] data, int min, int maks, T el) {
		return maks;
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		// Fyll ut og kjør metoden
	}//

	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/

	/**
	 * Utvalgsortering
	 * 
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgSortering(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}
			} // indre for-løkke

			/** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre for-løkke
	}// metode

	/**
	 * Sortering ved innsetting
	 * 
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void sorteringVedInsetting(T[] data) {

		for (int indeks = 1; indeks < data.length; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;// Forskyv større verdier mot hoyre
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			} // 3 9 6 1 2
			data[p] = nokkel;
		} // ytre
	}// metode

	public static <T extends Comparable<T>> void bobleSort(T[] data) {
		int p, sok;
		T temp;
		for (p = data.length - 1; p >= 0; p--) {
			for (sok = 0; sok <= p - 1; sok++) {
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					/** Bytt verdiene */
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
				}
			} // indre løkke
		} // ytre løkke
	}// metode

	private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
		int venstre, hoyre;
		T temp, pivot;// pivot som første element. Boka bruker midterste
		pivot = data[min];
		venstre = min;
		hoyre = maks;
		while (venstre < hoyre) {// ytre løkke
			/** Søker et element som er > enn pivot */
			/**
			 * Sikrer at partisjoneringsprosessen vil fortsette så lenge venstre < hoyre
			 */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}
			/** Søker et element som er <= enn pivot */
			while (data[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			}

			/** bytter elementene */
			if (venstre < hoyre) {
				temp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = temp;
			}
		} // while–ytre løkke
		/** flytter pivot til riktig og sin endelige plass */
		temp =data[min];
		data[min] = data[hoyre];
		data[hoyre] = temp;
		return hoyre;
	}

	

	public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {
		int posPartisjon;
		if (min < maks) { // minst to elementer
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikkSort(data, posPartisjon + 1, maks);
		}
	}// metode

	private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {
		/*
		 * Fletter to sorterte deltabeller, tabell[forste,midten] og
		 * tabell[midten+1,siste]til en sortert tabell Forkrav: forste <= midten <=
		 * siste Deltabellene tabell[forste,midten] og tabell[midten+1,siste] er hver
		 * sorterte i ikke- avtagende rekkefølge. ResultatIabell[forste,siste] er
		 * sortert. Implementasjon : Denne metoden fletter to deltabeller til en
		 * hjelpetabell og kopierer resultatet til den originale tabellen.
		 */

		int stor = siste - forste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);// Initierer lokale indekser
		// start og slutt på venstre deltabell
		int forste1 = forste;
		int siste1 = midten; // start og slutt på høyre deltabell
		int forste2 = midten + 1;
		int siste2 = siste;

		/*
		 * Så lenge begge deltabellene ikke er tomme, kopier det minste elementet til
		 * hjelpetabellen.
		 */
		int indeks = 0;
		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (tabell[forste1].compareTo(tabell[forste2]) <= 0) {
				hjelpeTabell[indeks] = tabell[forste1];
				forste1++;
			} else {
				hjelpeTabell[indeks] = tabell[forste2];
				forste2++;
			}
			indeks++;
		} // while
		// kopiere resten av venstre del (kan være tom)
		while (forste1 <= siste1) {
			hjelpeTabell[indeks] = tabell[forste1];
			forste1++;
			indeks++;
		} // while// kopiere resten av høyre del (kan være tom)
		while (forste2 <= siste2) {
			hjelpeTabell[indeks] = tabell[forste2];
			forste2++;
			indeks++;
		} // while
		// Kopier resultatet tilbake til den originale tabellen
		int h = 0;
		for (indeks = forste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h];
			h++;
		}
	}// flette */

	public static <T extends Comparable<T>> void fletteSort(T[] tabell, int forste, int siste) {
		if (forste < siste) {// minst to elementer
			int midten = (forste + siste) / 2; // Sorter venstre halvdel tabell[forste,midten];
			fletteSort(tabell, forste, midten); // Sorter høyre halvdel tabell[midten+1,siste];
			fletteSort(tabell, midten + 1, siste); // Fletter de to halvdelene
			flette(tabell, forste, midten, siste);
		}
	}// fletteSort
}

// ...
