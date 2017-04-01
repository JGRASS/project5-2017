package dinamika;

public abstract class Figura {
	public int boja;
	public Polozaj p = new Polozaj();
	
	public Figura(int boja) {
		super();
		this.boja = boja;
	}
	
	public Figura() {
		super();
	}

	public abstract Polozaj[] mogucnosti(Figura[][] tabla);
	public abstract Polozaj[] zasticena(Figura[][] tabla);
	
	public int getBoja() {
		return boja;
	}
	public void setBoja(int boja) {
		this.boja = boja;
	}

	public Polozaj getP() {
		return p;
	}

	public void setP(Polozaj p) {
		this.p = p;
	} 
	
	public void pomeri(int x, int y, Figura[][] tabla){
		p.setX(x);
		p.setY(y);
	}
}
