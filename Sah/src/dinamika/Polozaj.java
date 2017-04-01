package dinamika;

public class Polozaj {
	private int x, y;

	public Polozaj(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Polozaj() {
		super();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object o){
		if(o instanceof Polozaj)
			if(((Polozaj)o).getX() == this.x && ((Polozaj)o).getY() == this.y)
				return true;
		return false;
	}
	
	
}
