package no.hvl.dat102;

public class TarnIHanoi {
	// T�rn i Hanoi
	private int antallRinger;// Setter opp
	private long antall;
	// spillet med spesifisert antall ringer.

	public TarnIHanoi(int startRinger){
		antallRinger=startRinger;
		}// metode //Utf�rer det f�rste kallet til flyttRinger.
	// Flytter ringene fra t�rn 1 til t�rn 3ved � bruke t�rn 2.

	public long getAntall() {
		return antall;
	}
	
	public void setAntall(long antall) {
		this.antall=antall;
	}
	public void spill(){
		flyttRinger(antallRinger, 1, 3, 2);
		}// metode

	private void flyttRinger(int antRinger,int start, int slutt, int temp){
		if(antRinger== 1){// Basistilfellet
			flyttEnRing(start, slutt);
			}
		else{//Rolleskifte fra, til, mellom, 
				flyttRinger(antRinger-1, start,temp, slutt);
				flyttEnRing(start, slutt);
				flyttRinger(antRinger-1, temp,slutt, start);
				}
		
		}
	
	private void flyttEnRing(int start, int slutt){
		antall++;
		
		//System.out.println("Programmet har blitt kj�rt:" + antall + " gang");
		
		}
	}

