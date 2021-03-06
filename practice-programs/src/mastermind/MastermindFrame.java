package mastermind;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MastermindFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private ColorButton[][] colorButtons;
	private ArrayList<Color> colors;
	private JButton goButton;
	private ColorButton[] lastRow;
	private AnswerPanel[] answerPanels;
	private int currentCol;

	public MastermindFrame() {
		setSize(990, 450);
		setTitle("Mastermind");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(5, 11));
		setColors();
		addButtons();
		setVisible(true);
	}

	public void reset() {
		this.dispose();
		new MastermindFrame();
	}

	public void addGoButton() {
		goButton = new JButton();
		goButton.setText("Go!");
		goButton.setBackground(Color.GREEN);
		goButton.addMouseListener(new GoListener());
		goButton.setMargin(new Insets(0, 0, 0, 0));
		this.add(goButton);
	}

	public void addButtons() {
		colorButtons = new ColorButton[4][11];
		answerPanels = new AnswerPanel[10];
		currentCol = 0;
		for (int i = 0; i < 11; i++) {
			if (i == 10) {
				addGoButton();
			} else {
				AnswerPanel answerPanel = new AnswerPanel();
				answerPanels[i] = answerPanel;
				this.add(answerPanel);
			}
		}
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 11; i++) {
				ColorButton colorButton = new ColorButton();
				this.add(colorButton);
				colorButtons[j][i] = colorButton;
				if (i == 10) {
					colorButton.setEnabled(false);
					setButtonInLastRow(colorButton, j);
				} else if (i == currentCol) {
					colorButton.addMouseListener(new ButtonListener());
				} else {
					colorButton.setEnabled(false);
				}
			}
		}
	}

	public void setButtonInLastRow(ColorButton button, int j) {
		lastRow = new ColorButton[4];
		lastRow[j] = button;
		button.setColor(colors.remove(0));
		button.hide();
	}

	public void changeGoButton() {
		currentCol = 0;
		if (goButton.getText().compareTo("Go!") == 0) {
			goButton.setText("New game?");
		} else {
			goButton.setText("Go!");
		}
	}

	public void revealLastRow() {
		for (int i = 0; i < 4; i++) {
			colorButtons[i][10].unhide();
		}
	}

	private void setColors() {
		colors = new ArrayList<Color>();
		colors.add(Color.RED);
		colors.add(Color.YELLOW);
		colors.add(Color.CYAN);
		colors.add(Color.BLUE);
		colors.add(Color.MAGENTA);
		colors.add(Color.PINK);
		Collections.shuffle(colors);
	}

	private class GoListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (goButton.getText().compareTo("Go!") != 0) {
				reset();
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			if (colorButtons[0][currentCol].getColor() != Color.WHITE
					&& colorButtons[1][currentCol].getColor() != Color.WHITE
					&& colorButtons[2][currentCol].getColor() != Color.WHITE
					&& colorButtons[3][currentCol].getColor() != Color.WHITE) {
				try {
					if (!getAnswer()) {
						setNextRow();
					} else {
						revealLastRow();
						changeGoButton();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/*
		 * This method loops through the current row, removes the mouselistener
		 * from each button,and checks if any of the colors match exactly. If
		 * they do, the int black is incremented, and the color is added to a
		 * list of colors already found to match. Then the row is looped through
		 * again to check for colors that match but are in the wrong places. If
		 * any exits, the int white is incremented, and the color is added to a
		 * list of colors already found to match.
		 */
		public boolean getAnswer() throws InterruptedException {
			int black = 0;
			int white = 0;
			ArrayList<Color> usedColors = new ArrayList<Color>();
			for (int i = 0; i < 4; i++) {
				for (MouseListener ml : colorButtons[i][currentCol]
						.getMouseListeners()) {
					colorButtons[i][currentCol].removeMouseListener(ml);
				}
				if (colorButtons[i][currentCol].getColor() == colorButtons[i][10]
						.getColor()
						&& !usedColors.contains(colorButtons[i][currentCol]
								.getColor())) {
					black++;
					usedColors.add(colorButtons[i][currentCol].getColor());
				}
			}
			for (int i = 0; i < 4; i++) {
				if ((colorButtons[i][currentCol].getColor() == colorButtons[0][10]
						.getColor()
						|| colorButtons[i][currentCol].getColor() == colorButtons[1][10]
								.getColor()
						|| colorButtons[i][currentCol].getColor() == colorButtons[2][10]
								.getColor() || colorButtons[i][currentCol]
						.getColor() == colorButtons[3][10].getColor())
						&& !usedColors.contains(colorButtons[i][currentCol]
								.getColor())) {
					white++;
					usedColors.add(colorButtons[i][currentCol].getColor());
				}
			}
			answerPanels[currentCol++].setColorList(black, white);
			if (black == 4) {
				JOptionPane.showMessageDialog(null, "You won!");
				return true;
			} else if (currentCol == 10) {
				JOptionPane.showMessageDialog(null, "You lost!");
				return true;
			} else {
				return false;
			}
		}

		public void setNextRow() {
			for (int i = 0; i < 4; i++) {
				colorButtons[i][currentCol].setEnabled(true);
				colorButtons[i][currentCol]
						.addMouseListener(new ButtonListener());
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}

	}
}
