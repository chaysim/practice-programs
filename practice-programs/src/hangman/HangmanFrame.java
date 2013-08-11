package hangman;

import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HangmanFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public HangmanFrame(int length) {
		if (length < 11) {
			setSize(1000, 800);
		} else {
			setSize(this.getMaximumSize());
		}
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Hangman");
		KeyboardPanel panel;
		try {
			panel = new KeyboardPanel(length);

			this.add(panel);
		} catch (FileNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Not Working");
		}
		setVisible(true);

	}
}