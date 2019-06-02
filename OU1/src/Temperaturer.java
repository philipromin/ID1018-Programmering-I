import java.util.Locale;
import java.util.Scanner;

public class Temperaturer {
	public static void main (String[] args)
	{
		System.out.println ("TEMPERATURER\n");
		
		// inmatningsverktyg
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);
		
		// mata in uppgifter om antalet veckor och antalet m�tningar
		System.out.print ("antalet veckor: ");
		int    antalVeckor = in.nextInt ();
		System.out.print ("antalet m�tningar per vecka: ");
		int    antalMatningarPerVecka = in.nextInt ();
		
		// plats att lagra temperaturer
		double[][]    t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
		
		// mata in temperaturerna
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.println ("temperaturer -vecka " + vecka+ ":");
			for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
				t[vecka][matning] = in.nextDouble ();
		}
		System.out.println ();
		
		// visa temperaturerna
		System.out.println ("temperaturerna:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
				System.out.print (t[vecka][matning] + " ");
			System.out.println ();
		}
		System.out.println ();
		
		// den minsta,den st�rsta och medeltemperaturen�veckovis
		double[]    minT = new double[antalVeckor + 1];
		double[]    maxT = new double[antalVeckor + 1];
		double[]    sumT = new double[antalVeckor + 1];
		double[]    medelT = new double[antalVeckor + 1];
		
		// minsta temperatur
		for (int i = 1; i <= antalVeckor; i++)
		{			
			minT[i] = t[i][1];
			for (int j = 1; j <= antalMatningarPerVecka; j++)
			{
				if (t[i][j] < minT[i])
				{
					minT[i] = t[i][j];
				}
			}
			System.out.println ("Minsta temperatur vecka " +i+ " �r " +minT[i]);
		}
		System.out.println();
		
		// st�rsta temperatur
		for (int i = 1; i <= antalVeckor; i++)
		{			
			maxT[i] = t[i][1];
			for (int j = 1; j <= antalMatningarPerVecka; j++)
			{
				if (t[i][j] > maxT[i])
				{
					maxT[i] = t[i][j];
				}
			}
			System.out.println ("St�rsta temperatur vecka " +i+ " �r " +maxT[i]);
		}
		System.out.println();
			
		// medeltemperatur veckovis
		for (int i = 1; i <= antalVeckor; i++)
		{
			sumT[i] = 0;
			for (int j = 1; j <= antalMatningarPerVecka; j++)
			{
				sumT[i] += t[i][j];
				medelT[i] = sumT[i]/antalMatningarPerVecka;
			}
			System.out.println ("Medeltemperatur vecka " +i+ " �r " +medelT[i]);
		}
		System.out.println();

		// den minsta, den st�rsta och medeltemperaturen -helam�tperioden
		double    minTemp = minT[1];
		double    maxTemp = maxT[1];
		double    sumTemp = 0;
		double    medelTemp = 0;
		
		// minsta temperatur under hela perioden
		for (int i = 1; i <= antalVeckor; i++)
		{
			if (minT[i] < minTemp)
			{
				minTemp = minT[i];
			}
		}
		System.out.println ("Den minsta temperaturen under hela m�tperioden �r " +minTemp);
		System.out.println();
		
		// st�rsta temperatur under hela perioden
		for (int i = 1; i <= antalVeckor; i++)
		{
			if (minT[i] > maxTemp)
			{
				maxTemp = maxT[i];
			}
		}
		System.out.println ("Den st�rsta temperaturen under hela m�tperioden �r " +maxTemp);
		System.out.println();
		
		// medeltemperatur under hela perioden
		for (int i = 1; i <= antalVeckor; i++)
		{
			sumTemp += sumT[i];
			medelTemp = sumTemp/(antalVeckor*antalMatningarPerVecka);
		}
		System.out.println ("Medeltemperaturen under hela perioden �r " +medelTemp);


	}
}
