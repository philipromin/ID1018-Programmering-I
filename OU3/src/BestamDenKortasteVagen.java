import java.util.Random;

public class BestamDenKortasteVagen {

	public static void main (String[] args) {
		Random randomNr = new Random();
		
		int m = randomNr.nextInt(10)+1;
		int n = randomNr.nextInt(10)+1;
		System.out.println("Antal stationer i Zon 2: " + m + "\nAntal stationer i Zon 3: "+n);
		System.out.println();
			
		int xu[] = DenKortasteVagen.generateXU(m);
		int vy[] = DenKortasteVagen.generateVY(n);
		int uv[][] = DenKortasteVagen.generateUV(m, n);		
		
		int[] kortasteVagen = new int[3];
		kortasteVagen = DenKortasteVagen.kortasteVagen(m, n, xu, vy, uv);
		System.out.println("Den kortaste vägen är genom station U"+kortasteVagen[1]+" och V"+kortasteVagen[2]);
		
		int langd =  DenKortasteVagen.langd(m, n, xu, vy, uv);
		System.out.println("Denna längd är "+langd);

	}	
}
