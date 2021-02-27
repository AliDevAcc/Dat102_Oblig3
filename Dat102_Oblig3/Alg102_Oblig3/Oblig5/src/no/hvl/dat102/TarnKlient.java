package no.hvl.dat102;
import java.time.Duration;

public class TarnKlient {
// 4 ringer 
	public static void main(String[] args){
		TarnIHanoi tarn1 = new TarnIHanoi(24);
		tarn1.spill();
		
		TarnIHanoi tarn2 = new TarnIHanoi(12);
		tarn2.spill();
		
		TarnIHanoi tarn3 = new TarnIHanoi(6);
		tarn3.spill();
		
		TarnIHanoi tarn4 = new TarnIHanoi(5);
		tarn4.spill();
		Duration d=Duration.ofSeconds(tarn1.getAntall());
		System.out.println(d.toSeconds() + " sekunder");
		Duration e=Duration.ofSeconds(tarn2.getAntall());
		System.out.println(e.toSeconds()  + " sekunder");
		Duration f=Duration.ofSeconds(tarn3.getAntall());
		System.out.println(f.toSeconds() + " sekunder");
		Duration g=Duration.ofSeconds(tarn4.getAntall());
		System.out.println(g.toSeconds() + " sekunder");
		
		
		System.out.println((tarn1.getAntall()-1)/(tarn2.getAntall()-1));
		System.out.println((tarn2.getAntall()-1)/(tarn3.getAntall()-1));
		System.out.println("Brøkene får ikke samme verdi");
		//System.out.println(tarn.getAntall());
		}//main}//class 
}
