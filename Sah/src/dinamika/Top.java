package dinamika;

public class Top extends Figura {
	public boolean pomeran;
	
	public Top(int boja, int mesto) {
		super(boja);
		pomeran = false;
		if (boja == 0)
			p.setX(0);
		else
			p.setX(7);
		if (mesto == 1)
			p.setY(0);
		else
			p.setY(7);
	}

	public Polozaj[] mogucnosti(Figura[][] tabla, PoslednjiPotez poslednji) {
		Polozaj[] niz = new Polozaj[14];
		boolean[] kraj = new boolean[4];
		int counter = 0;

		for (int i = 1; i < 8; i++) {
			boolean izlaz = true;

			for (int j = 0; j < 4; j++)
				if (kraj[j] == false)
					izlaz = false;

			if (izlaz == true)
				break;

			if (!kraj[0]) {
				if (p.getX() - i >= 0) {
					if (tabla[p.getX() - i][p.getY()] == null)
						niz[counter++] = new Polozaj(p.getX() - i, p.getY());
					else {
						if (tabla[p.getX() - i][p.getY()].getBoja() != this.boja)
							niz[counter++] = new Polozaj(p.getX() - i, p.getY());
						kraj[0] = true;
					}
				}
			}

			if (!kraj[1]) {
				if (p.getX() + i < 8) {
					if (tabla[p.getX() + i][p.getY()] == null)
						niz[counter++] = new Polozaj(p.getX() + i, p.getY());
					else {
						if (tabla[p.getX() + i][p.getY()].getBoja() != this.boja)
							niz[counter++] = new Polozaj(p.getX() + i, p.getY());
						kraj[1] = true;
					}
				}
			}

			if (!kraj[2]) {
				if (p.getY() - i >= 0) {
					if (tabla[p.getX()][p.getY() - i] == null)
						niz[counter++] = new Polozaj(p.getX(), p.getY() - i);
					else {
						if (tabla[p.getX()][p.getY() - i].getBoja() != this.boja)
							niz[counter++] = new Polozaj(p.getX(), p.getY() - i);
						kraj[2] = true;
					}
				}
			}

			if (!kraj[3]) {
				if (p.getY() + i < 8) {
					if (tabla[p.getX()][p.getY() + i] == null)
						niz[counter++] = new Polozaj(p.getX(), p.getY() + i);
					else {
						if (tabla[p.getX()][p.getY() + i].getBoja() != this.boja)
							niz[counter++] = new Polozaj(p.getX(), p.getY() + i);
						kraj[3] = true;
					}
				}
			}
		}
		return niz;
	}

	public Polozaj[] zasticena(Figura[][] tabla) {
		Polozaj[] niz = new Polozaj[14];
		boolean[] kraj = new boolean[4];
		int counter = 0;

		for (int i = 0; i < 14; i++)
			niz[i] = null;

		for (int i = 1; i < 8; i++) {
			boolean izlaz = true;

			for (int j = 0; j < 4; j++)
				if (kraj[j] == false)
					izlaz = false;

			if (izlaz == true)
				break;

			if (!kraj[0]) {
				if (p.getX() - i >= 0) {
					if (tabla[p.getX() - i][p.getY()] == null)
						niz[counter++] = new Polozaj(p.getX() - i, p.getY());
					else {
						if (tabla[p.getX() - i][p.getY()].getBoja() == this.boja)
							niz[counter++] = new Polozaj(p.getX() - i, p.getY());
						kraj[0] = true;
					}
				}
			}

			if (!kraj[1]) {
				if (p.getX() + i < 8) {
					if (tabla[p.getX() + i][p.getY()] == null)
						niz[counter++] = new Polozaj(p.getX() + i, p.getY());
					else {
						if (tabla[p.getX() + i][p.getY()].getBoja() == this.boja)
							niz[counter++] = new Polozaj(p.getX() + i, p.getY());
						kraj[1] = true;
					}
				}
			}

			if (!kraj[2]) {
				if (p.getY() - i >= 0) {
					if (tabla[p.getX()][p.getY() - i] == null)
						niz[counter++] = new Polozaj(p.getX(), p.getY() - i);
					else {
						if (tabla[p.getX()][p.getY() - i].getBoja() == this.boja)
							niz[counter++] = new Polozaj(p.getX(), p.getY() - i);
						kraj[2] = true;
					}
				}
			}

			if (!kraj[3]) {
				if (p.getY() + i < 8) {
					if (tabla[p.getX()][p.getY() + i] == null)
						niz[counter++] = new Polozaj(p.getX(), p.getY() + i);
					else {
						if (tabla[p.getX()][p.getY() + i].getBoja() == this.boja)
							niz[counter++] = new Polozaj(p.getX(), p.getY() + i);
						kraj[3] = true;
					}
				}
			}
		}
		
		return niz;
	}

	@Override
	public void pomeri(int x, int y, Figura[][] tabla) {
		super.pomeri(x, y, tabla);
		pomeran = true;
	}

	public boolean isPomeran() {
		return pomeran;
	}

	public void setPomeran(boolean pomeran) {
		this.pomeran = pomeran;
	}
	
	

}
