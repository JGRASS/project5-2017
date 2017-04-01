package gameplay;

import java.util.Scanner;

import dinamika.*;

public class Partija {
	Figura[][] tabla;
	int potez;
	Scanner citaj = new Scanner(System.in);
	
	public Partija(){
		tabla = new Figura[8][8];
		for(int boja = 0; boja < 2; boja++){
			int poz = boja * 7;
			
			for(int j = 0; j < 8; j++)
				tabla[Math.abs(poz - 1)][j] = new Pijun(boja, j);
			
			tabla[poz][0] = new Top(boja, 1);
			tabla[poz][7] = new Top(boja, 2);
			tabla[poz][1] = new Konj(boja, 1);
			tabla[poz][6] = new Konj(boja, 2);
			tabla[poz][2] = new Lovac(boja, 1);
			tabla[poz][5] = new Lovac(boja, 2);
			tabla[poz][3] = new Kralj(boja);
			tabla[poz][4] = new Kraljica(boja);
			
		}
		potez = 0;
	}
	
	public void ispis(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(tabla[i][j] != null){
					if(tabla[i][j] instanceof Kralj)
						System.out.print("K");
					if(tabla[i][j] instanceof Kraljica)
						System.out.print("Q");
					if(tabla[i][j] instanceof Lovac)
						System.out.print("L");
					if(tabla[i][j] instanceof Konj)
						System.out.print("H");
					if(tabla[i][j] instanceof Top)
						System.out.print("T");
					if(tabla[i][j] instanceof Pijun)
						System.out.print("P");
					if(tabla[i][j].getBoja() == 0)
						System.out.print(" \t");
					else
						System.out.print("+\t");
				}
				else System.out.print("  \t");
			}
			System.out.println("\n");
		}
	}
	
	public void start(){
		ispis();
		int x, y;
		Scanner s = new Scanner(System.in);
		while(true){
			if(potez == 0) System.out.println("Beli na potezu");
			else System.out.println("Crni na potezu");
			System.out.println("Unesite koordinate");
			x = s.nextInt();
			y = s.nextInt();
			if(x < 0 || x > 8 || y < 0 || y > 8 || tabla[x][y] == null || tabla[x][y].getBoja() != potez % 2){
				System.out.println("Greska, pokusajte ponovo");
				continue;
			}
			Polozaj[] mogucnosti = tabla[x][y].mogucnosti(tabla);
			if(mogucnosti[0] == null){
				System.out.println("Nema mogucnosti za pomeranje figure, pokusajte ponovo");
				continue;
			}
			ispisi(mogucnosti);
			boolean uspesan = false;
			while(!uspesan){
				System.out.println("Unesite zeljeni potez");
				int x1 = s.nextInt();
				int y1 = s.nextInt();
				if(!odgovarajuce(mogucnosti, new Polozaj(x1, y1))){
					System.out.println("Greska, pokusajte ponovo");
					continue;
				}
				uspesan = true;
				tabla[x1][y1] = tabla[x][y];
				tabla[x][y] = null;
				tabla[x1][y1].pomeri(x1, y1, tabla);
			}
			potez = ++potez % 2;
			ispis();
		}
		
	}
	
	public static void ispisi(Polozaj[] mogucnosti){
		System.out.println("Moguca polja su");
		for(int i = 0; mogucnosti[i] != null; i++)
			System.out.print("("+mogucnosti[i].getX()+","+mogucnosti[i].getY()+") ; ");
	}
	
	public static boolean odgovarajuce(Polozaj[] mogucnosti, Polozaj zeljeno){
		for(int i = 0; mogucnosti[i] != null; i++)
			if(mogucnosti[i].equals(zeljeno))
				return true;
		return false;
	}
}