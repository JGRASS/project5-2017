package gameplay;

import dinamika.*;

public class Sah {
	public static boolean proveri(Figura[][] tabla, int boja){
		Polozaj kraljvaPozicija = null;
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(tabla[i][j] != null && tabla[i][j] instanceof Kralj && tabla[i][j].getBoja() == boja){
					kraljvaPozicija = new Polozaj(i, j);
					break;
				}
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(tabla[i][j] != null && tabla[i][j].getBoja() != boja){
					Polozaj[] napadnuta = tabla[i][j].mogucnosti(tabla, null);
					if(daLiSadrzi(napadnuta, kraljvaPozicija)) return true;
				}
		return false;
	}
	
	public static boolean daLiSadrzi(Polozaj[] napadnuta, Polozaj kraljevaPozicija){
		int i = 0;
		while(i < napadnuta.length && napadnuta[i] != null){
			if(napadnuta[i].equals(kraljevaPozicija)) return true;
			i++;
		}
		return false;
	}
}
