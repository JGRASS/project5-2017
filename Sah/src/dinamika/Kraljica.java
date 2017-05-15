package dinamika;

public class Kraljica extends Figura {

	public Kraljica(int boja){
		super(boja);
		p.setY(4);
		if(boja == 0) p.setX(0);
		else p.setX(7);
	}
	
	public Polozaj[] mogucnosti(Figura[][] tabla, PoslednjiPotez poslednji) {
		Polozaj[] niz = new Polozaj[28];
		int counter = 0;

		boolean[] kraj = new boolean[8];
		
		for(int i = 1; i < 8 ; i++){
			boolean izlaz = true;
			
			for(int j = 0; j < 8; j++)
				if(kraj[j] == false) izlaz = false;
			
			if(izlaz == true) break;
			
			if(p.getX() - i >= 0){
				if(!kraj[0]){
					if(tabla[p.getX() - i][p.getY()] == null) 
						niz[counter++] = new Polozaj(p.getX() - i, p.getY());
					else{
						if(tabla[p.getX() - i][p.getY()].getBoja() != this.boja)
							niz[counter++] = new Polozaj(p.getX() - i, p.getY());
						kraj[0] = true;
					}
				}
				
				if(p.getY() - i >= 0){
					if(!kraj[1]){
						if(tabla[p.getX() - i][p.getY() - i] == null)
							niz[counter++] = new Polozaj(p.getX() - i, p.getY() - i);
						else{
							if(this.boja != tabla[p.getX() - i][p.getY() - i].getBoja())
								niz[counter++] = new Polozaj(p.getX() - i, p.getY() - i);
							kraj[1] = true;
						}
					}
				}
				
				if(p.getY() + i < 8){
					if(!kraj[2]){
						if(tabla[p.getX() - i][p.getY() + i] == null)
							niz[counter++] = new Polozaj(p.getX() - i, p.getY() + i);
						else{
							if(this.boja != tabla[p.getX() - i][p.getY() + i].getBoja())
								niz[counter++] = new Polozaj(p.getX() - i, p.getY() + i);
							kraj[2] = true;
						}
					}
				}
			}
			
			if(p.getX() + i < 8){
				if(!kraj[3]){
					if(tabla[p.getX() + i][p.getY()] == null) 
						niz[counter++] = new Polozaj(p.getX() + i, p.getY());
					else{
						if(tabla[p.getX() + i][p.getY()].getBoja() != this.boja)
							niz[counter++] = new Polozaj(p.getX() + i, p.getY());
						kraj[3] = true;
					}
				}
				
				if(p.getY() - i >= 0){
					if(!kraj[4]){
						if(tabla[p.getX() + i][p.getY() - i] ==null)
							niz[counter++] = new Polozaj(p.getX() + i, p.getY() -i);
						else{
							if(this.boja != tabla[p.getX() + i][p.getY() - i].getBoja())
								niz[counter++] = new Polozaj(p.getX() + i, p.getY() -i);
							kraj[4] = true;
						}
					}
				}
				
				if(p.getY() + i < 8){
					if(!kraj[5]){
						if(tabla[p.getX() + i][p.getY() + i] == null){
							niz[counter++] = new Polozaj(p.getX() + i, p.getY() + i);
						}
						else{
							if(this.boja != tabla[p.getX() + i][p.getY() + i].getBoja())
								niz[counter++] = new Polozaj(p.getX() + i, p.getY() + i);
							kraj[5] = true;
						}
					}	
				}
			}
			if(p.getY() - i >= 0){
				if(!kraj[6]){
					if(tabla[p.getX()][p.getY() - i] == null)
						niz[counter++] = new Polozaj(p.getX(), p.getY() - i);
					else{
						if(tabla[p.getX()][p.getY() - i].getBoja() != this.boja)
							niz[counter++] = new Polozaj(p.getX(), p.getY() - i);
						kraj[6] = true;
					}	
				}
			}
			if(p.getY() + i < 8){
				if(!kraj[7]){
					if(tabla[p.getX()][p.getY() + i] == null)
						niz[counter++] = new Polozaj(p.getX(), p.getY() + i);
					else{
						if(tabla[p.getX()][p.getY() + i].getBoja() != this.boja)
							niz[counter++] = new Polozaj(p.getX(), p.getY() + i);
						kraj[7] = true;
					}
				}
			}
		}
		
		return niz;
	}
	public Polozaj[] zasticena(Figura[][] tabla) {
		Polozaj[] niz = new Polozaj[28];
		int counter = 0;
		
		for(int i = 0; i < 28; i++) niz[i] = null;
		boolean[] kraj = new boolean[8];
		
		for(int i = 1; i < 8 ; i++){
			boolean izlaz = true;
			
			for(int j = 0; j < 8; j++)
				if(kraj[j] == false) izlaz = false;
			
			if(izlaz == true) break;
			
			if(p.getX() - i >= 0){
				if(!kraj[0]){
					if(tabla[p.getX() - i][p.getY()] == null) 
						niz[counter++] = new Polozaj(p.getX() - i, p.getY());
					else{
						if(tabla[p.getX() - i][p.getY()].getBoja() == this.boja)
							niz[counter++] = new Polozaj(p.getX() - i, p.getY());
						kraj[0] = true;
					}
				}
				
				if(p.getY() - i >= 0){
					if(!kraj[1]){
						if(tabla[p.getX() - i][p.getY() - i] == null)
							niz[counter++] = new Polozaj(p.getX() - i, p.getY() - i);
						else{
							if(this.boja == tabla[p.getX() - i][p.getY() - i].getBoja())
								niz[counter++] = new Polozaj(p.getX() - i, p.getY() - i);
							kraj[1] = true;
						}
					}
				}
				
				if(p.getY() + i < 8){
					if(!kraj[2]){
						if(tabla[p.getX() - i][p.getY() + i] == null)
							niz[counter++] = new Polozaj(p.getX() - i, p.getY() + i);
						else{
							if(this.boja == tabla[p.getX() - i][p.getY() + i].getBoja())
								niz[counter++] = new Polozaj(p.getX() - i, p.getY() + i);
							kraj[2] = true;
						}
					}
				}
			}
			
			if(p.getX() + i < 8){
				if(!kraj[3]){
					if(tabla[p.getX() + i][p.getY()] == null) 
						niz[counter++] = new Polozaj(p.getX() + i, p.getY());
					else{
						if(tabla[p.getX() + i][p.getY()].getBoja() == this.boja)
							niz[counter++] = new Polozaj(p.getX() + i, p.getY());
						kraj[3] = true;
					}
				}
				
				if(p.getY() - i >= 0){
					if(!kraj[4]){
						if(tabla[p.getX() + i][p.getY() - i] ==null)
							niz[counter++] = new Polozaj(p.getX() + i, p.getY() -i);
						else{
							if(this.boja == tabla[p.getX() + i][p.getY() - i].getBoja())
								niz[counter++] = new Polozaj(p.getX() + i, p.getY() -i);
							kraj[4] = true;
						}
					}
				}
				
				if(p.getY() + i < 8){
					if(!kraj[5]){
						if(tabla[p.getX() + i][p.getY() + i] == null){
							niz[counter++] = new Polozaj(p.getX() + i, p.getY() + i);
						}
						else{
							if(this.boja == tabla[p.getX() + i][p.getY() + i].getBoja())
								niz[counter++] = new Polozaj(p.getX() + i, p.getY() + i);
							kraj[5] = true;
						}
					}	
				}
			}
			
			if(p.getY() - i >= 0){
				if(!kraj[6]){
					if(tabla[p.getX()][p.getY() - i] == null)
						niz[counter++] = new Polozaj(p.getX(), p.getY() - i);
					else{
						if(tabla[p.getX()][p.getY() - i].getBoja() == this.boja)
							niz[counter++] = new Polozaj(p.getX(), p.getY() - i);
						kraj[6] = true;
					}
				}
			}
			
			if(p.getY() + i < 8){
				if(!kraj[7]){
					if(tabla[p.getX()][p.getY() + i] == null)
						niz[counter++] = new Polozaj(p.getX(), p.getY() + i);
					else{
						if(tabla[p.getX()][p.getY() + i].getBoja() == this.boja)
							niz[counter++] = new Polozaj(p.getX(), p.getY() + i);
						kraj[7] = true;
					}
				}
			}
		}
		
		return niz;
	}

}
