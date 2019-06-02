import java.util.Scanner;

public class RaknaMedStrangar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Ange vad du vill beräkna:");
		String s = in.nextLine();	
		
		Scanner tokenizer = new Scanner(s);
		String tal1 = tokenizer.next();
		String operator = tokenizer.next();
		String tal2 = tokenizer.next();
		
		if(operator.equals("+")) {
			String summa = addera(tal1, tal2);	
			System.out.println(summa);
		}
		else if(operator.equals("-")) {
			String differens = subtrahera(tal1, tal2);
			System.out.println(differens);
		}
		else {
			System.out.println("Fel operator");
		}
	}
	
	public static String addera (String tal1, String tal2) {
		StringBuilder talEtt = new StringBuilder(tal1);
		StringBuilder talTva = new StringBuilder(tal2);
		
		while(talEtt.length() < talTva.length()) { //matchar längd på Strings talEtt och talTva genom att lägga till 0:or i början
			talEtt.insert (0, "0"); 
		}
		while(talTva.length() < talEtt.length()) {
			talTva.insert (0, "0");
		}
		
		StringBuilder sum = new StringBuilder(talEtt.length()+1); //sträng med capacity längd av talen som ska adderas + 1
		int carry=0;

		for(int i = talEtt.length()-1; i >= 0; i--) {
			 int temp = (talEtt.charAt(i)-48)+(talTva.charAt(i)-48)+carry;
			 
			 if((talEtt.charAt(i)-48)+(talTva.charAt(i)-48)+carry > 9 && i != 0) {
				 carry = 1;
				 sum.insert(0, temp-10);
			 }
			 else if((talEtt.charAt(i)-48)+(talTva.charAt(i)-48)+carry > 9 && i == 0){
				 sum.insert(0, temp);
			 }
			 else {
				 sum.insert(0, temp);
				 carry = 0;
			 }
		}
		
		
		String summa = sum.toString();		
		return summa;		
	}
	public static String subtrahera (String tal1, String tal2) {
		StringBuilder talEtt = new StringBuilder(tal1);
		StringBuilder talTva = new StringBuilder(tal2);
		
		while(talEtt.length() < talTva.length()) { //matchar längd på Strings talEtt och talTva genom att lägga till 0:or i början
			talEtt.insert (0, "0"); 
		}
		while(talTva.length() < talEtt.length()) {
			talTva.insert (0, "0");
		}
		
		StringBuilder diff = new StringBuilder(talEtt.length()+1); //sträng med capacity längd av talen som ska adderas + 1
		int carry=0;
		
		if(Integer.parseInt(tal1) > Integer.parseInt(tal2)) {
			
			for(int i = talEtt.length()-1; i >= 0; i--) {
				int temp = (talEtt.charAt(i)-48)-(talTva.charAt(i)-48)-carry;
			
				if(temp < 0 && i != 0) {
					carry = 1;
					diff.insert(0, temp+10);
				}
				else {
					diff.insert(0, temp);
					carry = 0;
				}
			}
		}
		else {
			for(int i = talEtt.length()-1; i >= 0; i--) {
				int temp = (talTva.charAt(i)-48)-(talEtt.charAt(i)-48)-carry;
		
				if(temp < 0 && i != 0) {
					carry = 1;
					diff.insert(0, temp+10);
				}
				else {
					diff.insert(0, temp);
					carry = 0;
				}
			}
			diff.insert(0, "-");
		}
		String differens = diff.toString();
		return differens;
	}
}
