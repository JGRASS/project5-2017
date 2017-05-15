package dinamika;

public class PoslednjiPotez {
	Figura figura;
	Polozaj prethodniPolozaj;
	
	public PoslednjiPotez(){
		figura = null;
		prethodniPolozaj = new Polozaj();
	}

	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Polozaj getPrethodniPolozaj() {
		return prethodniPolozaj;
	}

	public void setPrethodniPolozaj(Polozaj prethodniPolozaj) {
		this.prethodniPolozaj = prethodniPolozaj;
	}
}
