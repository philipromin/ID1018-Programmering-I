import java.util.Arrays;
import java.util.Random;

public class ValjPolylinje {
	public static final Random rand = new Random();
	public static final int ANTAL_POLYLINJER = 10;
	
	public static void main(String[] args) {
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];	
		for(int i = 0; i < ANTAL_POLYLINJER; i++) {
			polylinjer[i] = slumpPolylinje();
		}
		
		System.out.println("Alla polylinjer:");
		for(int i = 0; i < ANTAL_POLYLINJER; i++) {
			System.out.println(polylinjer[i]);
		}
		
		Polylinje kortasteGula = bestamKortasteGula(polylinjer);
		System.out.println();
		System.out.println("Den kortaste gula polylinjen är: " + kortasteGula);
		System.out.println("Dess längd är: " + kortasteGula.langd());
	}
	
	public static Punkt slumpPunkt() {
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		
		return new Punkt (n, x, y);
	}
	
	public static Polylinje slumpPolylinje() {
		Polylinje polylinje = new Polylinje ();		
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		Arrays.fill(valdaNamn, Boolean.TRUE);
		Punkt valdPunkt = null;
		char valtChar = 0;
		
		while (antalValdaHorn < antalHorn) {
			Punkt p = slumpPunkt();
			int c = p.getNamn().charAt(0);
			
			//System.out.println(c);
			
			if(valdaNamn[c-65] == false) {
				
			}
			else {
				valdaNamn[c-65] = false;
				polylinje.laggTill(p);
				antalValdaHorn ++;
			}
					
		}
		String[] farger = {"gul", "röd","blå"};
		int i = rand.nextInt(2);
		polylinje.setFarg(farger[i]);
		
		return polylinje;
	}
	
	public static Polylinje bestamKortasteGula (Polylinje[] polylinjer) {
		Polylinje[] gulaPolylinjer = gulaPolylinjer(polylinjer);
		Polylinje kortasteGula = gulaPolylinjer[0];
		
		for(int i = 0; i < gulaPolylinjer.length; i++) {
			if(gulaPolylinjer[i].langd() < kortasteGula.langd()) {
				kortasteGula = gulaPolylinjer[i];
			}
		}
		return kortasteGula;
	}
	
	public static Polylinje[] gulaPolylinjer(Polylinje[] polylinjer)  {
		int antalGulaPolylinjer = 0;
		
		for(int i = 0; i < polylinjer.length; i++) {
			if(polylinjer[i].getFarg().equals("gul")) {
				antalGulaPolylinjer ++;
			}
		}
		
		Polylinje[] gulaPolylinjer = new Polylinje[antalGulaPolylinjer];
		int i2 = 0;
		
		for(int i = 0; i < polylinjer.length; i++) {
			if(polylinjer[i].getFarg().equals("gul")) {
				gulaPolylinjer[i2] = polylinjer[i];
				i2++;
			}
		}
		
		return gulaPolylinjer;
	}
}
	
	
