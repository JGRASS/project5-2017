package dinamika;

public class Pijun extends Figura {

	public Pijun(int boja, int mesto){
		super(boja);
		if(boja == 0) p.setX(1);
		else p.setX(6);
		p.setY(mesto);
	}
	public Polozaj[] mogucnosti(Figura[][] tabla, PoslednjiPotez poslednji) {
		Polozaj[] niz = new Polozaj[4]; //5
		int counter = 0;
		
		if(boja == 0){
			if(p.getX() + 1 < 8){
				if(tabla[p.getX() + 1][p.getY()] == null) 
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY());
				if(p.getY() + 1 < 8 && tabla[p.getX() + 1][p.getY() + 1] != null && this.boja != tabla[p.getX() + 1][p.getY() + 1].getBoja())
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY() + 1);
				if(p.getY() - 1 >= 0 && tabla[p.getX() + 1][p.getY() - 1] != null && this.boja != tabla[p.getX() + 1][p.getY() - 1].getBoja())
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY() - 1);
			}
			if(p.getX() == 1 && tabla[p.getX() + 2][p.getY()] == null && tabla[p.getX() + 1][p.getY()] == null)
				niz[counter++] = new Polozaj(p.getX() + 2, p.getY());
		}
		else{
			if(p.getX() - 1 >= 0){
				if(tabla[p.getX() - 1][p.getY()] == null) 
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY());
				if(p.getY() + 1 < 8 && tabla[p.getX() - 1][p.getY() + 1] != null && this.boja != tabla[p.getX() - 1][p.getY() + 1].getBoja())
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY() + 1);
				if(p.getY() - 1 >= 0 && tabla[p.getX() - 1][p.getY() - 1] != null && this.boja != tabla[p.getX() - 1][p.getY() - 1].getBoja())
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY() - 1);
			}
			if(p.getX() == 6 && tabla[p.getX() - 2][p.getY()] == null && tabla[p.getX() - 1][p.getY()] == null)
				niz[counter++] = new Polozaj(p.getX() - 2, p.getY());
		}
		
		if(poslednji != null && this.boja == 0 && p.getX() == 4 && poslednji.getFigura() instanceof Pijun && poslednji.prethodniPolozaj.getX() == 6 && poslednji.getFigura().getP().getX() == 4){
			if(poslednji.getFigura().getP().getY() + 1 == p.getY()) niz[counter++] = new Polozaj(5, poslednji.getFigura().getP().getY());
			else if(poslednji.getFigura().getP().getY() - 1 == p.getY()) niz[counter++] = new Polozaj(5, poslednji.getFigura().getP().getY());
		}
		
		if(poslednji != null && this.boja == 1 && p.getX() == 3 && poslednji.getFigura() instanceof Pijun && poslednji.prethodniPolozaj.getX() == 1 && poslednji.getFigura().getP().getX() == 3){
			if(poslednji.getFigura().getP().getY() + 1 == p.getY()) niz[counter++] = new Polozaj(2, poslednji.getFigura().getP().getY());
			else if(poslednji.getFigura().getP().getY() - 1 == p.getY()) niz[counter++] = new Polozaj(2, poslednji.getFigura().getP().getY());
		}
		
		return niz;
	}
	public Polozaj[] zasticena(Figura[][] tabla) {
		Polozaj[] niz = new Polozaj[4];
		for(int i = 0; i < 3; i++) niz[i] = null; 
		int counter = 0;
		
		if(boja == 0){
			if(p.getX() + 1 < 8){
				if(tabla[p.getX() + 1][p.getY()] == null) 
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY());
				if(p.getY() + 1 < 8 && tabla[p.getX() + 1][p.getY() + 1] != null && this.boja == tabla[p.getX() + 1][p.getY() + 1].getBoja())
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY() + 1);
				if(p.getY() - 1 >= 0 && tabla[p.getX() + 1][p.getY() - 1] != null && this.boja == tabla[p.getX() + 1][p.getY() - 1].getBoja())
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY() - 1);
			}
			if(p.getX() == 1 && tabla[p.getX() + 2][p.getY()] == null && tabla[p.getX() + 1][p.getY()] == null)
				niz[counter++] = new Polozaj(p.getX() + 2, p.getY());
		}
		else{
			if(p.getX() - 1 >= 0){
				if(tabla[p.getX() - 1][p.getY()] == null) 
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY());
				if(p.getY() + 1 < 8 && tabla[p.getX() - 1][p.getY() + 1] != null && this.boja == tabla[p.getX() - 1][p.getY() + 1].getBoja())
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY() + 1);
				if(p.getY() - 1 >= 0 && tabla[p.getX() - 1][p.getY() - 1] != null && this.boja == tabla[p.getX() - 1][p.getY() - 1].getBoja())
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY() - 1);
			}
			if(p.getX() == 6 && tabla[p.getX() - 2][p.getY()] == null && tabla[p.getX() - 1][p.getY()] == null)
				niz[counter++] = new Polozaj(p.getX() - 2, p.getY());
		}
		
		return niz;
	}
	
	public void pomeri(int x, int y, Figura[][] tabla) {
		p.setX(x);
		p.setY(y);
	}

}
