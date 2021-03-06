package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordBag {
	private int length;
	private ArrayList<String> words;

	public WordBag(int length) throws FileNotFoundException {
		this.setLength(length);

		File file = new File("dic.txt");
		Scanner readFromFile = new Scanner(file);
		this.words = new ArrayList<String>();
		while (readFromFile.hasNextLine()) {
			String word = readFromFile.nextLine();
			if (word.length() == length) {
				words.add(word);
			}
		}
		readFromFile.close();
	}

	public int getSize() {
		return words.size();
	}

	public String getWord() {
		Random random = new Random();
		int num = random.nextInt(this.words.size());
		return words.get(num);
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
