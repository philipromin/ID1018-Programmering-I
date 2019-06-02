
public class Polylinje {
		private Punkt[] horn;
		private String farg = "Svart";
		private int bredd = 1;
		
		public Polylinje () {
			this.horn = new Punkt[0];
		}
		
		public Polylinje (Punkt[] horn) {
			this.horn = new Punkt[horn.length];
			for(int i = 0; i < horn.length; i++) {
				this.horn[i] = new Punkt (horn[i]);
				System.out.println("Hörn " + i + " " + this.horn[i]);
			}
			System.out.println();
		}
		
		public String toString () {
			String s = "";
			for(int i = 0; i < this.horn.length; i++)
			{
				s += horn[i];
			}
			s = "{[" + s + "]" + ", " + farg + ", " + bredd + "}";
			return s;
		}
		
		public Punkt[] getHorn(){
			return horn;
		}
		
		public Punkt getHorn(int i){
			return horn[i];
		}
		
		public String getFarg() {
			return farg;
		}
		
		public int getBredd() {
			return bredd;
		}
		
		public void setFarg(String farg) {
			this.farg =  farg;
		}
		
		public void setBredd(int bredd) {
			this.bredd = bredd;
		}
		
		public double langd() {
			double langd = 0;
			
			for(int i = 0; i < this.horn.length-1; i++) {
				int x0 = this.horn[i].getX();
				int y0 = this.horn[i].getY();
				int x1 = this.horn[i+1].getX();
				int y1 = this.horn[i+1].getY();
				
				langd += Math.sqrt((Math.pow(x1-x0, 2)) + (Math.pow(y1-y0, 2)));
			}
			
			return langd;
		}
		
		public void laggTill(Punkt horn) {
			Punkt[] h = new Punkt[this.horn.length + 1];
			
			int i = 0;
			 for (i = 0; i < this.horn.length; i++)
			 h[i] = this.horn[i];
			 h[i] = new Punkt (horn);
			 this.horn = h;
		}
		
		public void laggTillFramfor (Punkt horn, String hornNamn) {
			Punkt[] h = new Punkt[this.horn.length+1];
			int pos = 0;
			
			for(int i = 0; i < this.horn.length; i++) {
				h[i] = this.horn[i];
				
				if(hornNamn == this.horn[i].getNamn()) {
					pos = i;
					h[pos] = horn;
				}
			}
			for(int i = pos + 1; i < this.horn.length + 1; i++) {
				h[i] = this.horn[i-1];
			}
			
			this.horn = h;	
		}
		
		public void taBort (String hornNamn) {
			Punkt[] h = new Punkt[this.horn.length - 1];
			boolean run = true;
			int pos = 0;
			
			while(run) {
				
				for(int i = 0; i < this.horn.length - 1; i++) {
		
					if(hornNamn == this.horn[i].getNamn()) {
						run = false;
						pos = i;
					}
					else {
						h[i] = this.horn[i];
					}
				}
			}
			
			for(int i = pos; i < this.horn.length - 1; i++) {
				h[i] = this.horn[i + 1];
			}
			
			this.horn = h;
		}

		public class PolylinjeIterator {
			private int aktuell = -1;
			
			public PolylinjeIterator ()
			 {
			 if (Polylinje.this.horn.length > 0)
			 aktuell = 0;
			 }
			 public boolean finnsHorn ()
			 {
			 return aktuell != -1;
			 }
			 public Punkt horn () throws java.util.NoSuchElementException{
				 if (!this.finnsHorn ())
					 throw new java.util.NoSuchElementException ("slut av iterationen");
			 
				 Punkt horn = Polylinje.this.horn[aktuell];
				 return horn;
			 }
			 public void gaFram (){
				 
				 if (aktuell >= 0 &&
						 aktuell < Polylinje.this.horn.length - 1)
					 aktuell++;
				 else
					 aktuell = -1;
			 }
		}
}
