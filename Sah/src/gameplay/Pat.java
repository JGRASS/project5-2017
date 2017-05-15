package gameplay;

import dinamika.*;

public class Pat {
	public static boolean proveri(Figura[][] tabla, int boja, PoslednjiPotez poslednji){
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(tabla[i][j] != null && tabla[i][j].getBoja() == boja){
					Polozaj[] moguca = tabla[i][j].mogucnosti(tabla, poslednji);
					if(moguca[0] != null) return false;
				}
		return true;
	}
}
