package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

import dinamika.Figura;
import dinamika.Konj;
import dinamika.Kralj;
import dinamika.Kraljica;
import dinamika.Lovac;
import dinamika.Pijun;
import dinamika.Polozaj;
import dinamika.PoslednjiPotez;
import dinamika.Top;
import gameplay.Pat;
import gameplay.Sah;

import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class SahGUI {
	static boolean bo = false;
	static int xx = 0;
	static int yy = 0;
	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	private JButton[][] chessBoardSquares = new JButton[8][8];
	private Image[][] chessPieceImages = new Image[2][6];
	private JPanel chessBoard;
	private final JLabel message = new JLabel("Klikni na nova partija");
	private static final String COLS = "87654321";
	public static final int QUEEN = 0, KING = 1, ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
	public static final int[] STARTING_ROW = { ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK };
	public static final int BLACK = 0, WHITE = 1;

	/**
	 * @wbp.parser.entryPoint
	 */
	SahGUI() {
		initializeGui();
	}

	public final void initializeGui() {
		createImages();
		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		JToolBar tools = new JToolBar();
		tools.setBackground(new Color(178, 34, 34));
		tools.setFloatable(false);
		gui.add(tools, BorderLayout.PAGE_START);
		Action newGameAction = new AbstractAction("Novi") {

			@Override
			public void actionPerformed(ActionEvent e) {
				setupNewGame();
			}
		};
		JButton button = tools.add(newGameAction);
		button.setText("Nova partija");
		tools.addSeparator();
		JButton button_1 = new JButton("Izadji");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Hvala sto ste igrali!", "Kraj igre",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		tools.add(button_1); // TODO - add functionality!
		tools.addSeparator();
		tools.add(message);

		gui.add(new JLabel("?"), BorderLayout.LINE_START);

		chessBoard = new JPanel(new GridLayout(0, 9)) {

			/**
			 * Override the preferred size to return the largest it can, in a
			 * square shape. Must (must, must) be added to a GridBagLayout as
			 * the only component (it uses the parent as a guide to size) with
			 * no GridBagConstaint (so it is centered).
			 */
			@Override
			public final Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				Dimension prefSize = null;
				Component c = getParent();
				if (c == null) {
					prefSize = new Dimension((int) d.getWidth(), (int) d.getHeight());
				} else if (c != null && c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight()) {
					prefSize = c.getSize();
				} else {
					prefSize = d;
				}
				int w = (int) prefSize.getWidth();
				int h = (int) prefSize.getHeight();
				int s = (w > h ? h : w);
				return new Dimension(s, s);
			}
		};
		chessBoard.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(Color.BLACK)));
		Color boja = new Color(11, 32, 34);
		chessBoard.setBackground(boja);
		JPanel boardConstrain = new JPanel(new GridBagLayout());
		boardConstrain.setBackground(boja);
		boardConstrain.add(chessBoard);
		gui.add(boardConstrain);

		Insets buttonMargin = new Insets(0, 0, 0, 0);
		for (int ii = 0; ii < chessBoardSquares.length; ii++) {
			for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
				JButton b = new JButton();
				b.setMargin(buttonMargin);
				ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
				b.setIcon(icon);
				if ((jj % 2 == 1 && ii % 2 == 1)
						// ) {
						|| (jj % 2 == 0 && ii % 2 == 0)) {
					b.setBackground(Color.WHITE);
				} else {
					b.setBackground(Color.BLACK);
				}
				chessBoardSquares[jj][ii] = b;
			}
		}

		chessBoard.add(new JLabel(""));
		for (int ii = 0; ii < 8; ii++) {
			chessBoard.add(new JLabel(COLS.substring(ii, ii + 1), SwingConstants.CENTER));
		}
		for (int ii = 0; ii < 8; ii++) {
			for (int jj = 0; jj < 8; jj++) {
				switch (jj) {
				case 0:
					chessBoard.add(new JLabel("" + (9 - (ii + 1)), SwingConstants.CENTER));
				default:
					chessBoard.add(chessBoardSquares[jj][ii]);
				}
			}
		}
	}

	public final JComponent getGui() {
		return gui;
	}

	private final void createImages() {
		try {
			URL url = new URL("http://i.stack.imgur.com/memI0.png");
			BufferedImage bi = ImageIO.read(url);
			for (int ii = 0; ii < 2; ii++) {
				for (int jj = 0; jj < 6; jj++) {
					chessPieceImages[ii][jj] = bi.getSubimage(jj * 64, ii * 64, 64, 64);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Initializes the icons of the initial chess board piece places
	 */
	private final void setupNewGame() {
		message.setText("Igraj!");
		ButtonHandler bh = new ButtonHandler();
		for (int ii = 0; ii < STARTING_ROW.length; ii++) {
			chessBoardSquares[ii][0].setIcon(new ImageIcon(chessPieceImages[BLACK][STARTING_ROW[ii]]));
		}
		for (int ii = 0; ii < STARTING_ROW.length; ii++) {
			chessBoardSquares[ii][1].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
		}
		for (int ii = 0; ii < STARTING_ROW.length; ii++) {
			chessBoardSquares[ii][6].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
		}
		for (int ii = 0; ii < STARTING_ROW.length; ii++) {
			chessBoardSquares[ii][7].setIcon(new ImageIcon(chessPieceImages[WHITE][STARTING_ROW[ii]]));
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessBoardSquares[i][j].addActionListener(bh);
			}
		}
	}

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				SahGUI cg = new SahGUI();
				JFrame f = new JFrame("ChessChamp");
				f.getContentPane().add(cg.getGui());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setLocationByPlatform(true);
				f.pack();
				f.setMinimumSize(f.getSize());
				f.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
		Figura[][] tabla;
		PoslednjiPotez[] poslednjiPotezi;
		int potez;

		tabla = new Figura[8][8];
		poslednjiPotezi = new PoslednjiPotez[2];
		for (int boja = 0; boja < 2; boja++) {
			int poz = boja * 7;
			poslednjiPotezi[boja] = new PoslednjiPotez();
			for (int j = 0; j < 8; j++)
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
		int x, y;
		Scanner s = new Scanner(System.in);
		while (true) {
			if (Sah.proveri(tabla, potez)) {
				if (Pat.proveri(tabla, potez, poslednjiPotezi[(potez + 1) % 2])) {
					System.out.println("Sah mat");
					break;
				} else
					System.out.println("Sah");
			} else {
				if (Pat.proveri(tabla, potez, poslednjiPotezi[(potez + 1) % 2])) {
					System.out.println("Pat");
					break;
				}
			}
			if (potez == 0)
				System.out.println("Beli na potezu");
			else
				System.out.println("Crni na potezu");
			System.out.println("Unesite koordinate");
			while (bo == false ) {
			}
			bo = false;
			x = xx;
			y = yy;
			for (int i = 0; i < 8; i++) {
				System.out.println();
				for (int j = 0; j < 8; j++) {
					System.out.println(tabla[i][j]);
				}
			}
			if (x < 0 || x > 8 || y < 0 || y > 8 || tabla[x][y] == null || tabla[x][y].getBoja() != potez % 2) {
				System.out.println("Greska, pokusajte ponovo");
				continue;
			}
			Polozaj[] mogucnosti = tabla[x][y].mogucnosti(tabla, poslednjiPotezi[(potez + 1) % 2]);
			if (mogucnosti[0] == null) {
				System.out.println("Nema mogucnosti za pomeranje figure, pokusajte ponovo");
				continue;
			}
			ispisi(mogucnosti);
			boolean uspesan = false;
			while (!uspesan) {
				System.out.println("Unesite zeljeni potez");
				int x1 = xx;
				int y1 = yy;
				if (!odgovarajuce(mogucnosti, new Polozaj(x1, y1))) {
					System.out.println("Greska, pokusajte ponovo");
					continue;
				}
				uspesan = true;
				if (tabla[x][y] instanceof Pijun && tabla[x1][y1] == null && y != y1) {
					tabla[x][y1] = null;
				}
				tabla[x1][y1] = tabla[x][y];
				tabla[x][y] = null;
				tabla[x1][y1].pomeri(x1, y1, tabla);
				poslednjiPotezi[potez].setPrethodniPolozaj(new Polozaj(x, y));
				poslednjiPotezi[potez].setFigura(tabla[x1][y1]);
			}
			potez = ++potez % 2;

		}
		System.out.println("Kraj igre");
	}

	public static void ispisi(Polozaj[] mogucnosti) {
		System.out.println("Moguca polja su");
		for (int i = 0; mogucnosti[i] != null; i++)
			System.out.print("(" + mogucnosti[i].getX() + "," + mogucnosti[i].getY() + ") ; ");
	}

	public static boolean odgovarajuce(Polozaj[] mogucnosti, Polozaj zeljeno) {
		for (int i = 0; mogucnosti[i] != null; i++)
			if (mogucnosti[i].equals(zeljeno))
				return true;
		return false;
	}

	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (source == chessBoardSquares[i][j]) {
						bo = true;
						xx = i;
						yy = j;
						JOptionPane.showMessageDialog(null, " " + i + " " + j, "Kraj igre",
								JOptionPane.INFORMATION_MESSAGE);
						return;

					}

				}
			}

		}

	}
}