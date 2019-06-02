import java.util.*;

public class Algoritm {
			public static void main (String[] args) {
				Random randomNr = new Random();

				int m = randomNr.nextInt(10)+1;
				int n = randomNr.nextInt(10)+1;
				System.out.println("Antal stationer i Zon 2: " + m + "\nAntal stationer i Zon 3: "+n);
				System.out.println();
				
				int[] xu = new int[m]; 
				int[][] uv = new int[m][n];
				int[] vy = new int[n];
								
				for(int i = 0; i < m; i++) {				
					xu[i] = randomNr.nextInt(10)+1;
					System.out.println("Väg: a" + (i+1) + " till Zon 2: " + xu[i]);
					System.out.println();	
					
					for(int j = 0; j < n; j++) {
						uv[i][j] = randomNr.nextInt(10)+1;
						System.out.println("Väg: b"+ (i+1) + ","+(j+1) +  " till Zon 3: " + uv[i][j]);
						System.out.println();
					}
				}
				for(int j = 0; j < n; j++) {
					vy[j] = randomNr.nextInt(10)+1;
					System.out.println("Väg: c"+(j+1)+ " till Y:" +vy[j]);	
					System.out.println();
				}
				
				int min = xu[0]+vy[0]+uv[0][0];
				String minZoner = ""; 
				
				for(int i = 0; i < m; i++) {
					for(int j = 0; j < n; j++) {
						int shortest = xu[i]+vy[j]+uv[i][j];
						
						if(shortest < min) {
							min = shortest;
							minZoner = "Den kortaste vägen är genom station U"+(i+1)+" och genom station V"+(j+1)+"\nDenna väg är "+min; 
						}
					}
										
				}
				
				System.out.println(minZoner);
				System.out.println();
													
			}
}
