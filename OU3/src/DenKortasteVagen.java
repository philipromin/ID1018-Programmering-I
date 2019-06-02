import java.util.Random;

public class DenKortasteVagen {
	
	public static int[] generateXU (int m){
		int[] xu = new int[m]; 
		Random randomNr = new Random();
		
		for(int i = 0; i < m; i++) {				
			xu[i] = randomNr.nextInt(10)+1;		
		}
		return xu;
	}
	public static int[] generateVY (int n){
		int[] vy = new int[n]; 
		Random randomNr = new Random();
		
		for(int j = 0; j < n; j++) {
			vy[j] = randomNr.nextInt(10)+1;
		}
		return vy;
	}
	public static int[][] generateUV (int m, int n){
		int[][] uv = new int[m][n]; 
		Random randomNr = new Random();
		
		for(int i = 0; i < m; i++) {						
			for(int j = 0; j < n; j++) {
				uv[i][j] = randomNr.nextInt(10)+1;
				
			}
		}
		return uv;
	}
	public static int[] kortasteVagen (int m, int n, int[]xu, int[]vy, int[][]uv) {
		int min = xu[0]+vy[0]+uv[0][0];
		int[] denKortasteVagen = new int[3]; 
		denKortasteVagen[1] = 1;
		denKortasteVagen[2] = 1;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int shortest = xu[i]+vy[j]+uv[i][j];
				
				if(shortest < min) {
					min = shortest;
					denKortasteVagen[1] =  i+1;
					denKortasteVagen[2] = j+1;
				}
			}							
		}		
		return denKortasteVagen;		
	}
	public static int langd (int m, int n, int[]xu, int[]vy, int[][]uv) {
		int min = xu[0]+vy[0]+uv[0][0];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int shortest = xu[i]+vy[j]+uv[i][j];
				
				if(shortest < min) {
					min = shortest;
				}
			}							
		}	
		return min;
	}
}
