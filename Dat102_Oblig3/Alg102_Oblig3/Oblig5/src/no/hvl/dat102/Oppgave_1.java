package no.hvl.dat102;

public class Oppgave_1 {
public static void main(String[] args) {
	System.out.println(sum(100));
	System.out.println(sum2(10));
	
}

public static int sum(int i) {
	int y;
	if(i==1) {
		y=1; 
	} else {
		y = i + sum(i-1);
	}
	
	return y;
}

public static int sum2(int i) {
	int y;
	if(i==0) {
		y=2; 
	} else if (i==1) {
		y=5 + sum2(i-1);
	}
		else {
		y = 5*i - 6*i-1 + 2 + sum2(i-1);
	}
	
	
	return y;
}

}
