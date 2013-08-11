package connect4;

import java.awt.Color;

public class Piece {

	private int x;
	private int y;
	private int length;
	private int width;
	private Color color;

	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
		this.length = 100;
		this.width = 100;
		this.color = Color.BLACK;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
