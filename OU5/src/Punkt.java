
public class Punkt {
	
	private String name;
	private int x;
	private int y;
	
	public Punkt(String name, int x, int y) {
		this.name = name; 
		this.x = x;
		this.y = y;
	}
	
	public Punkt(Punkt p) {
		this.name = p.name;
		this.x = p.x;
		this.y = p.y;	
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	
	public String getNamn() {
		return name;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		String s = "";
		
		s = "(" + this.name + ", " + this.x + ", " + this.y + ")";
		
		return s;
	}
	
	public double avstand(Punkt p) {
		int newx = p.getX() - this.x;
		int newy = p.getY() - this.y;
		double avstand = Math.sqrt((Math.pow(newx, 2)) + (Math.pow(newy, 2)));
		return avstand;
	}
	
	public boolean equals(Punkt p) {
		if(this.x == p.getX() && this.y == p.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
