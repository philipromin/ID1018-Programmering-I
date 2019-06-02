import java.util.Locale;
import java.util.Scanner;

public class Triangel {
	
	public static void main(String[] args) {
		Scanner    in = new Scanner (System.in);   //Scanner
		in.useLocale(Locale.US);				   //Anger decimalformat , .
		
												   //Loop som körs sålänge användaren vill beräkna omkrets eller area
		while(true){
			System.out.println("Vad vill du beräkna? a) Omkrets b) Area");
			String svar = in.next();
		
			if(svar.equals("a")) {
				System.out.println("Ange triangelns alla sidor:");
				double a = in.nextDouble();
				double b = in.nextDouble();
				double c = in.nextDouble();
				System.out.println();	
				
				double omkrets = omkrets(a, b, c);
				System.out.println("Triangelns omkrets är " +omkrets+ " längdenheter");
				System.out.println();
			}
			else if(svar.equals("b")) {
				System.out.println("Ange triangelns längd");
				double l = in.nextDouble();
				System.out.println("Ange triangelns höjd");
				double h = in.nextDouble();
			
				double area = area (l, h);
				System.out.println("Triangelns area är " +area+ " areaenheter");
				System.out.println();
			}
		
			System.out.println("Vill du fortsätta med dessa beräkningar på triangeln?");
			svar = in.next();
		
			if(svar.equals("nej") || svar.equals("Nej") || svar.equals("NEJ")) {
				System.out.println();
				break;
			}
		}
				System.out.println("Nu ska vi beräkna längden på triangelns bisektriser. Var vänlig ange triangelns sidor a, b, c samt vinklarna AB, AC och BC där AB är vinklen mellan sidorna a och b. Ange vinklarna i grader.");	
				System.out.println();
			while(true) {

				System.out.println("Ange sidorna a, b, c:");
				double a = in.nextDouble();
				double b = in.nextDouble();
				double c = in.nextDouble();
				System.out.println();
		
				System.out.println("Ange vinklarna AB, AC och BC:");
				double ab = (Math.PI/180)* in.nextDouble(); //gör om vinklarna till radianer
				double ac = (Math.PI/180)* in.nextDouble(); //gör om vinklarna till radianer
				double bc = (Math.PI/180)* in.nextDouble(); //gör om vinklarna till radianer
				System.out.println();
		
				double bisektris_ab = bisektris (a, b, ab);
				double bisektris_ac = bisektris (a, c, ac);
				double bisektris_bc = bisektris (b, c, bc);
		
				System.out.println("Bisektrisen som skär vinkeln AB är: " + bisektris_ab + " längdenheter");
				System.out.println();
				System.out.println("Bisektrisen som skär vinkeln AC är: " + bisektris_ac + " längdenheter");
				System.out.println();
				System.out.println("Bisektrisen som skär vinkeln BC är: " + bisektris_bc + " längdenheter");
				System.out.println();
				
				System.out.println("Vill du beräkna nya bisektriser?");
				String svar = in.next();
				if(svar.equals("nej") || svar.equals("Nej") || svar.equals("NEJ")) {
					System.out.println();
					break;
				}
			}
				//Här ska vi beräkna radien av den inskrivna cirkeln
				System.out.println("Vi kan även beräkna radien av den cirkel som är omskriven kring en triangel, samt radien av den cirkel som är inskriven i en triangel med hjälp av dess sidor. ");
				System.out.println();
				while(true) {
				System.out.println("Ange triangelns alla sidor:");
				System.out.println();	

				double a = in.nextDouble();
				double b = in.nextDouble();
				double c = in.nextDouble();
				
				//double s = semiperimeter (a, b, c); 
				double radie_inskriven = radie_inskriven (a, b, c);
				double radie_omskriven = radie_omskriven (a, b, c);
				
				System.out.println("Radien av den inskrivna cirkeln är: " + radie_inskriven +" längdenheter");
				System.out.println();
				System.out.println("Radien av den omskrivna cirkeln är: " + radie_omskriven +" längdenheter");
				System.out.println();
				
				System.out.println("Vill du beräkna radien på nya cirklar?");
				String svar = in.next();
				if(svar.equals("nej") || svar.equals("Nej") || svar.equals("NEJ")) {
					System.out.println();
					break;
				}
			}	
	}
	public static double radie_inskriven (double a, double b, double c){
		double s = (a+b+c)/2;
		double r = Math.sqrt(((s-a)*(s-b)*(s-c))/s);
		return r;
	}
	
	public static double bisektris (double b, double c, double alfa) {	
		double    p = 2 * b * c * Math.cos (alfa / 2);     
		double    bis = p / (b + c); 
	    return bis; 	
	}
	
	public static double omkrets (double a, double b, double c) {
		double omkrets = a+b+c;
		return omkrets;
	}	
	
	public static double area (double l, double h) {
		double area = (l*h)/2;	
		return area;	
	}
	
	/*public static double semiperimeter (double a, double b, double c) {
		double semiperimeter = (a + b + c) / 2;
		return semiperimeter;
	}*/
	
	public static double radie_omskriven (double a, double b, double c) {
		double s = (a+b+c)/2;
		double r = (a*b*c)/(4*(Math.sqrt(s*(s-a)*(s-b)*(s-c))));
		return r;
	}
}
