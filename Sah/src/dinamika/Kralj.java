package dinamika;

import java.util.LinkedList;

public class Kralj extends Figura {
	public boolean pomeran;
	
	public Kralj(int boja){
		super(boja);
		pomeran = false;
		p.setY(3);
		if(boja == 0) p.setX(0);
		else p.setX(7);
	}
	
	public Polozaj[] mogucnosti(Figura[][] tabla) {
		Polozaj[] pocetniNiz = sveKraljveMogucnosti(p.getX(), p.getY(), tabla);
		Polozaj[] konacniNiz = new Polozaj[8];
		LinkedList<Polozaj> nemoguca = nemoguca(tabla);
		
		int i = 0, j = 0;
		
		while(pocetniNiz[i] != null){
			if(!nemoguca.contains(pocetniNiz[i]))
				konacniNiz[j++] = pocetniNiz[i];
			i++;
		}

		if (!pomeran) {
			int poz;
			if (boja == 0)
				poz = 0;
			else
				poz = 7;
			
			if (tabla[poz][1] == null && tabla[poz][2] == null && tabla[poz][0] != null && tabla[poz][0] instanceof Top && !((Top)tabla[poz][0]).isPomeran() && !nemoguca.contains(new Polozaj(poz, 1)) && !nemoguca.contains(new Polozaj(poz,  2)))
				konacniNiz[j++] = new Polozaj(poz, 1);
			if (tabla[poz][4] == null && tabla[poz][5] == null && tabla[poz][6] == null && tabla[poz][7] != null  && tabla[poz][7] instanceof Top && !((Top)tabla[poz][7]).isPomeran() && !nemoguca.contains(new Polozaj(poz, 4)) && !nemoguca.contains(new Polozaj(poz, 5)) && !nemoguca.contains(new Polozaj(poz, 6)))
				konacniNiz[j++] = new Polozaj(poz, 5);

		}
		
		return konacniNiz;
	}
	
	public LinkedList<Polozaj> nemoguca(Figura[][] tabla){
		LinkedList<Polozaj> nemoguca = new LinkedList<Polozaj>();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(tabla[i][j] != null && tabla[i][j].getBoja() != this.boja){
					dopuniListu(nemoguca, tabla[i][j].zasticena(tabla));
				}
			}
		}
		return nemoguca;
	}
	
	public static void dopuniListu(LinkedList<Polozaj> lista, Polozaj[] niz){
		for(int i = 0; i < niz.length; i++)
			if(niz[i] != null && !lista.contains(niz[i]))
				lista.add(niz[i]);
	}
	
	public Polozaj[] sveKraljveMogucnosti(int x, int y, Figura[][] tabla) {
		Polozaj[] niz = new Polozaj[8];
		int counter = 0;
		if (x != 0 && (tabla[x - 1][y] == null || tabla[x - 1][y].getBoja() != this.boja))
			niz[counter++] = new Polozaj(x - 1, y);
		if (x != 7 && (tabla[x + 1][y] == null || tabla[x + 1][y].getBoja() != this.boja))
			niz[counter++] = new Polozaj(x + 1, y);
		if (y != 0 && (tabla[x][y - 1] == null || tabla[x][y - 1].getBoja() != this.boja))
			niz[counter++] = new Polozaj(x, y - 1);
		if (y != 7 && (tabla[x][y + 1] == null || tabla[x][y + 1].getBoja() != this.boja))
			niz[counter++] = new Polozaj(x, y + 1);
		if (x != 0 && y != 0 && (tabla[x - 1][y - 1] == null || tabla[x - 1][y - 1].getBoja() != this.boja))
			niz[counter++] = new Polozaj(x - 1, y - 1);
		if (x != 7 && y != 0 && (tabla[x + 1][y - 1] == null || tabla[x + 1][y - 1].getBoja() != this.boja))
			niz[counter++] = new Polozaj(x + 1, y - 1);
		if (x != 0 && y != 7 && (tabla[x - 1][y + 1] == null || tabla[x - 1][y + 1].getBoja() != this.boja))
			niz[counter++] = new Polozaj(x - 1, y + 1);
		if (x != 7 && y != 7 && (tabla[x + 1][y + 1] == null || tabla[x + 1][y + 1].getBoja() != this.boja))
			niz[counter++] = new Polozaj(x + 1, y + 1);

		return niz;
	}
	
	public Polozaj[] zasticena(Figura[][] tabla){
		Polozaj[] niz = new Polozaj[8];
		int counter = 0;
		
		if(p.getX() != 0)
			niz[counter++] = new Polozaj(p.getX() - 1, p.getY());
		if(p.getX() != 7)
			niz[counter++] = new Polozaj(p.getX() + 1, p.getY());
		if(p.getY() != 0)
			niz[counter++] = new Polozaj(p.getX(), p.getY() - 1);
		if(p.getY() != 7)
			niz[counter++] = new Polozaj(p.getX(), p.getY() + 1);
		if(p.getX() != 0 && p.getY() != 0)
			niz[counter++] = new Polozaj(p.getX() - 1, p.getY() - 1);
		if(p.getX() != 7 && p.getY() != 0)
			niz[counter++] = new Polozaj(p.getX() + 1, p.getY() - 1);
		if(p.getX() != 0 && p.getY() != 7)
			niz[counter++] = new Polozaj(p.getX() - 1, p.getY() + 1);
		if(p.getX() != 7 && p.getY() != 7)
			niz[counter++] = new Polozaj(p.getX() + 1, p.getY() + 1);
		return niz;
	}

	@Override
	public void pomeri(int x, int y, Figura[][] tabla) {
		super.pomeri(x, y, tabla);
		if(!pomeran){
			pomeran = true;
			if(y == 1){
				tabla[x][2] = tabla[x][0];
				tabla[x][0] = null;
				tabla[x][2].pomeri(x, 2, tabla);
			}
			if(y == 5){
				tabla[x][4] = tabla[x][7];
				tabla[x][7] = null;
				tabla[x][4].pomeri(x, 4, tabla);
			}
		}
	}
}
