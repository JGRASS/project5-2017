package dinamika;

public class Konj extends Figura {

	public Konj(int boja, int mesto){
		super(boja);
		if(boja == 0) p.setX(0);
		else p.setX(7);
		if(mesto == 1) p.setY(1);
		else p.setY(6);
	}
	
	
	public Polozaj[] mogucnosti(Figura[][] tabla, PoslednjiPotez poslednji) {
		Polozaj[] niz = new Polozaj[8];
		int counter = 0;
		
		if(p.getX() - 2 >= 0){
			if(p.getY() - 1 >= 0){
				if(tabla[p.getX() - 2][p.getY() - 1] == null)
					niz[counter++] = new Polozaj(p.getX() - 2, p.getY() - 1);
				else 
					if(this.boja != tabla[p.getX() - 2][p.getY() - 1].getBoja())
						niz[counter++] = new Polozaj(p.getX() - 2, p.getY() - 1);
			}
			
			if(p.getY() + 1 < 8){
				if(tabla[p.getX() - 2][p.getY() + 1] == null)
					niz[counter++] = new Polozaj(p.getX() - 2, p.getY() + 1);
				else
					if(this.boja != tabla[p.getX() - 2][p.getY() + 1].getBoja())
						niz[counter++] = new Polozaj(p.getX() - 2, p.getY() + 1);
			}
		}
		
		if(p.getX() + 2 < 8){
			if(p.getY() - 1 >= 0){
				if(tabla[p.getX() + 2][p.getY() - 1] == null)
					niz[counter++] = new Polozaj(p.getX() + 2, p.getY() - 1);
				else 
					if(this.boja != tabla[p.getX() + 2][p.getY() - 1].getBoja())
						niz[counter++] = new Polozaj(p.getX() + 2, p.getY() - 1);
			}
			
			if(p.getY() + 1 < 8){
				if(tabla[p.getX() + 2][p.getY() + 1] == null)
					niz[counter++] = new Polozaj(p.getX() + 2, p.getY() + 1);
				else
					if(this.boja != tabla[p.getX() + 2][p.getY() + 1].getBoja())
						niz[counter++] = new Polozaj(p.getX() + 2, p.getY() + 1);
			}
		}
		
		if(p.getY() - 2 >= 0){
			if(p.getX() - 1 >= 0){
				if(tabla[p.getX() - 1][p.getY() - 2] == null)
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY() - 2);
				else
					if(this.boja != tabla[p.getX() - 1][p.getY() - 2].getBoja())
						niz[counter++] = new Polozaj(p.getX() - 1, p.getY() - 2);
			}
			
			if(p.getX() + 1 < 8){
				if(tabla[p.getX() + 1][p.getY() - 2] == null)
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY() - 2);
				else 
					if(this.boja != tabla[p.getX() + 1][p.getY() - 2].getBoja())
						niz[counter++] = new Polozaj(p.getX() + 1, p.getY() - 2);
			}
		}
		
		if(p.getY() + 2 < 8){
			if(p.getX() - 1 >= 0){
				if(tabla[p.getX() - 1][p.getY() + 2] == null)
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY() + 2);
				else
					if(this.boja != tabla[p.getX() - 1][p.getY() + 2].getBoja())
						niz[counter++] = new Polozaj(p.getX() - 1, p.getY() + 2);
			}
			
			if(p.getX() + 1 < 8){
				if(tabla[p.getX() + 1][p.getY() + 2] == null)
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY() + 2);
				else 
					if(this.boja != tabla[p.getX() + 1][p.getY() + 2].getBoja())
						niz[counter++] = new Polozaj(p.getX() + 1, p.getY() + 2);
			}
		}
		
		return niz;
	}
	

	public Polozaj[] zasticena(Figura[][] tabla) {
		Polozaj[] niz = new Polozaj[8];
		for(int i = 0; i < 8; i++) niz[i] = null;
		int counter = 0;
		
		if(p.getX() - 2 >= 0){
			if(p.getY() - 1 >= 0){
				if(tabla[p.getX() - 2][p.getY() - 1] == null)
					niz[counter++] = new Polozaj(p.getX() - 2, p.getY() - 1);
				else 
					if(this.boja == tabla[p.getX() - 2][p.getY() - 1].getBoja())
						niz[counter++] = new Polozaj(p.getX() - 2, p.getY() - 1);
			}
			
			if(p.getY() + 1 < 8){
				if(tabla[p.getX() - 2][p.getY() + 1] == null)
					niz[counter++] = new Polozaj(p.getX() - 2, p.getY() + 1);
				else
					if(this.boja == tabla[p.getX() - 2][p.getY() + 1].getBoja())
						niz[counter++] = new Polozaj(p.getX() - 2, p.getY() + 1);
			}
		}
		
		if(p.getX() + 2 < 8){
			if(p.getY() - 1 >= 0){
				if(tabla[p.getX() + 2][p.getY() - 1] == null)
					niz[counter++] = new Polozaj(p.getX() + 2, p.getY() - 1);
				else 
					if(this.boja == tabla[p.getX() + 2][p.getY() - 1].getBoja())
						niz[counter++] = new Polozaj(p.getX() + 2, p.getY() - 1);
			}
			
			if(p.getY() + 1 < 8){
				if(tabla[p.getX() + 2][p.getY() + 1] == null)
					niz[counter++] = new Polozaj(p.getX() + 2, p.getY() + 1);
				else
					if(this.boja == tabla[p.getX() + 2][p.getY() + 1].getBoja())
						niz[counter++] = new Polozaj(p.getX() + 2, p.getY() + 1);
			}
		}
		
		if(p.getY() - 2 >= 0){
			if(p.getX() - 1 >= 0){
				if(tabla[p.getX() - 1][p.getY() - 2] == null)
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY() - 2);
				else
					if(this.boja == tabla[p.getX() - 1][p.getY() - 2].getBoja())
						niz[counter++] = new Polozaj(p.getX() - 1, p.getY() - 2);
			}
			
			if(p.getX() + 1 < 8){
				if(tabla[p.getX() + 1][p.getY() - 2] == null)
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY() - 2);
				else 
					if(this.boja == tabla[p.getX() + 1][p.getY() - 2].getBoja())
						niz[counter++] = new Polozaj(p.getX() + 1, p.getY() - 2);
			}
		}
		
		if(p.getY() + 2 < 8){
			if(p.getX() - 1 >= 0){
				if(tabla[p.getX() - 1][p.getY() + 2] == null)
					niz[counter++] = new Polozaj(p.getX() - 1, p.getY() + 2);
				else
					if(this.boja == tabla[p.getX() - 1][p.getY() + 2].getBoja())
						niz[counter++] = new Polozaj(p.getX() - 1, p.getY() + 2);
			}
			
			if(p.getX() + 1 < 8){
				if(tabla[p.getX() + 1][p.getY() + 2] == null)
					niz[counter++] = new Polozaj(p.getX() + 1, p.getY() + 2);
				else 
					if(this.boja == tabla[p.getX() + 1][p.getY() + 2].getBoja())
						niz[counter++] = new Polozaj(p.getX() + 1, p.getY() + 2);
			}
		}
		
		return niz;
	}
}
