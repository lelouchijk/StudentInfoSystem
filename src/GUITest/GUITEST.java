package GUITest;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GUITEST extends JFrame {
	final int originalTileSize = 16;
	final int scale = 3;
	
	final int tilSize = originalTileSize * scale;
	final int maxScreenRow = 16;
	final int maxScreenCol = 12;
	
	final int SCREENWIDTH = tilSize * maxScreenRow;
	final int SCREENHEIGHT = tilSize * maxScreenCol;
	public GUITEST() {
		this.setPreferredSize(new Dimension(SCREENWIDTH,SCREENHEIGHT));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
		this.setTitle("GUI TEST");
	}
	public static void main(String[]arg) {
		new GUITEST();
	}
}
