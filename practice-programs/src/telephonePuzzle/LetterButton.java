package telephonePuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class LetterButton extends JButton {

	private static final long serialVersionUID = 1L;

	private ArrayList<Character> letters;
	private Character correctLetter;
	private int upTo;

	public LetterButton(Character correctLetter) {
		setFont(new Font("Arial", 1, 22));
		setMargin(new Insets(0, 0, 0, 0));
		addMouseListener(new ButtonListener());
		setBorder(new LineBorder(Color.ORANGE, 5, false));
		this.letters = new ArrayList<Character>();
		this.correctLetter = correctLetter;
		this.upTo = 0;
		this.setText("???");
		setList();
	}

	public void setList() {
		switch (correctLetter) {
		case 'a':
		case 'b':
		case 'c':
			letters.add('a');
			letters.add('b');
			letters.add('c');
			break;
		case 'd':
		case 'e':
		case 'f':
			letters.add('d');
			letters.add('e');
			letters.add('f');
			break;
		case 'g':
		case 'h':
		case 'i':
			letters.add('g');
			letters.add('h');
			letters.add('i');
			break;
		case 'j':
		case 'k':
		case 'l':
			letters.add('j');
			letters.add('k');
			letters.add('l');
			break;
		case 'm':
		case 'n':
		case 'o':
			letters.add('m');
			letters.add('n');
			letters.add('o');
			break;
		case 'p':
		case 'q':
		case 'r':
		case 's':
			letters.add('p');
			letters.add('q');
			letters.add('r');
			letters.add('s');
			break;
		case 't':
		case 'u':
		case 'v':
			letters.add('t');
			letters.add('u');
			letters.add('v');
			break;
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			letters.add('w');
			letters.add('x');
			letters.add('y');
			letters.add('z');
			break;
		}
	}

	public void getNextLetter() {
		if (upTo == letters.size()) {
			upTo = 0;
		}
		this.setText(letters.get(upTo) + "");
		upTo++;
	}

	private class ButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			getNextLetter();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}

	}

}
