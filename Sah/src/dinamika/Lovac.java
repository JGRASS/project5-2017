package dinamika;

public class Lovac extends Figura {

	public Lovac(int boja, int mesto) {
		super(boja);
		if (boja == 0)
			p.setX(0);
		else
			p.setX(7);
		if (mesto == 1)
			p.setY(2);
		else
			p.setY(5);
	}

	public Lovac() {
		super();
	}

	public Polozaj[] mogucnosti(Figura[][] tabla) {
		Polozaj[] niz = new Polozaj[13];
		boolean[] kraj = new boolean[4];
		int counter = 0;

		for (int i = 1; i < 8; i++) {
			boolean izlaz = true;
			for (int j = 0; j < 4; j++)
				if (kraj[j] == false)
					izlaz = false;
			if (izlaz == true)
				break;
			if (p.getY() - i >= 0 && p.getX() - i >= 0) {
				if (!kraj[0]) {
					if (tabla[p.getX() - i][p.getY() - i] == null)
						niz[counter++] = new Polozaj(p.getX() - i, p.getY() - i);
					else {
						if (this.boja != tabla[p.getX() - i][p.getY() - i].getBoja()) 
							niz[counter++] = new Polozaj(p.getX() - i, p.getY() - i);
						kraj[0] = true;
					}
				}
			}
			if (p.getY() + i < 8 && p.getX() - i >= 0) {
				if (!kraj[1]) {
					if (tabla[p.getX() - i][p.getY() + i] == null)
						niz[counter++] = new Polozaj(p.getX() - i, p.getY() + i);
					else {
						if (this.boja != tabla[p.getX() - i][p.getY() + i].getBoja()) 
							niz[counter++] = new Polozaj(p.getX() - i, p.getY() + i);
						kraj[1] = true;
					}
				}
			}
			if (p.getY() - i >= 0 && p.getX() + i < 8) {
				if (!kraj[2]) {
					if (tabla[p.getX() + i][p.getY() - i] == null)
						niz[counter++] = new Polozaj(p.getX() + i, p.getY() - i);
					else {
						if (this.boja != tabla[p.getX() + i][p.getY() - i].getBoja()) 
							niz[counter++] = new Polozaj(p.getX() + i, p.getY() - i);
						kraj[2] = true;
					}
				}
			}
			if (p.getY() + i < 8 && p.getX() + i < 8) {
				if (!kraj[3]) {
					if (tabla[p.getX() + i][p.getY() + i] == null) {
						niz[counter++] = new Polozaj(p.getX() + i, p.getY() + i);
					} else {
						if (this.boja != tabla[p.getX() + i][p.getY() + i].getBoja()) 
							niz[counter++] = new Polozaj(p.getX() + i, p.getY() + i);
						kraj[3] = true;
					}
				}
			}

		}
			return niz;
	}
	public Polozaj[] zasticena(Figura[][] tabla) {
		Polozaj[] niz = new Polozaj[13];
		boolean[] kraj = new boolean[4];
		int counter = 0;

		for (int i = 0; i < 13; i++)
			niz[i] = null;
		for (int i = 1; i < 8; i++) {
			boolean izlaz = true;
			for (int j = 0; j < 4; j++)
				if (kraj[j] == false)
					izlaz = false;
			if (izlaz == true)
				break;
			if (p.getY() - i >= 0 && p.getX() - i >= 0) {
				if (!kraj[0]) {
					if (tabla[p.getX() - i][p.getY() - i] == null)
						niz[counter++] = new Polozaj(p.getX() - i, p.getY() - i);
					else {
						if (this.boja == tabla[p.getX() - i][p.getY() - i].getBoja()) 
							niz[counter++] = new Polozaj(p.getX() - i, p.getY() - i);
						kraj[0] = true;
					}
				}
			}
			if (p.getY() + i < 8 && p.getX() - i >= 0) {
				if (!kraj[1]) {
					if (tabla[p.getX() - i][p.getY() + i] == null)
						niz[counter++] = new Polozaj(p.getX() - i, p.getY() + i);
					else {
						if (this.boja == tabla[p.getX() - i][p.getY() + i].getBoja()) 
							niz[counter++] = new Polozaj(p.getX() - i, p.getY() + i);
						kraj[1] = true;
					}
				}
			}
			if (p.getY() - i >= 0 && p.getX() + i < 8) {
				if (!kraj[2]) {
					if (tabla[p.getX() + i][p.getY() - i] == null)
						niz[counter++] = new Polozaj(p.getX() + i, p.getY() - i);
					else {
						if (this.boja == tabla[p.getX() + i][p.getY() - i].getBoja()) 
							niz[counter++] = new Polozaj(p.getX() + i, p.getY() - i);
						kraj[2] = true;
					}
				}
			}
			if (p.getY() + i < 8 && p.getX() + i < 8) {
				if (!kraj[3]) {
					if (tabla[p.getX() + i][p.getY() + i] == null) {
						niz[counter++] = new Polozaj(p.getX() + i, p.getY() + i);
					} else {
						if (this.boja == tabla[p.getX() + i][p.getY() + i].getBoja()) 
							niz[counter++] = new Polozaj(p.getX() + i, p.getY() + i);
						kraj[3] = true;
					}
				}
			}

		}
			return niz;
	}
}