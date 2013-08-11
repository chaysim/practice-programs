package hangman;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ManPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int chancesLeft;
	private ManDisplayPanel man;

	public ManPanel() {
		this.chancesLeft = 10;
		setSize(500, 400);
		setLayout(new GridLayout(1, 1));
		man = new ManDisplayPanel(chancesLeft);
		this.add(man);
		man.addBorder();
	}

	public void registerMistake() {
		chancesLeft--;
		this.remove(man);
		this.man = new ManDisplayPanel(chancesLeft);
		this.add(man);
		man.addBorder();
	}

	public int getChancesLeft() {
		return chancesLeft;
	}

	public void setChancesLeft(int chancesLeft) {
		this.chancesLeft = chancesLeft;
	}
}
