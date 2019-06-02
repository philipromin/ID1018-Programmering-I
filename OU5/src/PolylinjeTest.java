import java.util.Arrays;

public class PolylinjeTest {
	public static void main(String[] args) {
		Punkt p1 = new Punkt ("A", 1, 1);
		Punkt p2 = new Punkt ("B", 1, 2);
		Punkt p3 = new Punkt ("C", 1, 3);
		Punkt p4 = new Punkt ("D", 1, 4);
		Punkt p5 = new Punkt ("E", 1, 5);
		
		Punkt[] horn = {p1, p2, p3};
		
		Polylinje p = new Polylinje(horn);
		System.out.println("Polylinje: " + p + "\n");
		
		Punkt[] allaHorn = p.getHorn();
		System.out.println("Alla h�rn: "+ Arrays.toString(allaHorn));
		
		Punkt hornEtt = p.getHorn(1);
		System.out.println("H�rn ett: " + hornEtt);
		
		String farg = p.getFarg();
		System.out.println("F�rg: " + farg);
		int bredd = p.getBredd();
		System.out.println("Bredd: " + bredd);
		double langd = p.langd();
		System.out.println("L�ngden av polylinjen �r: " + langd + "\n");
		
		p.setFarg("Rosa");
		p.setBredd(5);
		System.out.println("Polylinjen efter �ndringar av f�rg och bredd: " + p + "\n");
		
		p.laggTill(p4);
		System.out.println("Polylinjen efter till�gg av punkt 4: " + p);
		
		p.laggTillFramfor(p5, "B");
		System.out.println("Polylinjen efter till�gg av punkt E framf�r punkt B: " + p);
		
		p.taBort("C");
		System.out.println("Polylinje efter borttagning av punkt E: " + p + "\n");
				
		Polylinje.PolylinjeIterator iterator = p.new PolylinjeIterator();
		for(int i = 0; i < p.getHorn().length; i++) {
			Punkt hornIterator = iterator.horn();
			System.out.println(hornIterator);
			iterator.gaFram();
		}
	}
}
