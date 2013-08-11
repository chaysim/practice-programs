package hangman;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Man extends JPanel {
	private static final long serialVersionUID = 1L;
	private int choice;

	public Man(int choice) {
		this.choice = choice;
		this.setSize(500, 400);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMan(g);
	}

	public void addBorder() {
		TitledBorder border = new TitledBorder("Chances Left: " + choice);
		border.setTitleColor(Color.BLUE);
		this.setBorder(border);
	}

	public void drawMan(Graphics g) {
		switch (choice) {
		case 10:
			drawStand(g);
			break;
		case 9:
			drawStand(g);
			drawFace(g);
			break;
		case 8:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			break;
		case 7:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			drawEye2(g);
			break;
		case 6:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			drawEye2(g);
			drawNose(g);
			break;
		case 5:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			drawEye2(g);
			drawNose(g);
			drawMouth(g);
			break;
		case 4:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			drawEye2(g);
			drawNose(g);
			drawMouth(g);
			drawLeftArm(g);
			break;
		case 3:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			drawEye2(g);
			drawNose(g);
			drawMouth(g);
			drawLeftArm(g);
			drawRightArm(g);
			break;
		case 2:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			drawEye2(g);
			drawNose(g);
			drawMouth(g);
			drawLeftArm(g);
			drawRightArm(g);
			drawLeftLeg(g);
			break;
		case 1:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			drawEye2(g);
			drawNose(g);
			drawMouth(g);
			drawLeftArm(g);
			drawRightArm(g);
			drawLeftLeg(g);
			drawRightLeg(g);
			break;
		case 0:
			drawStand(g);
			drawFace(g);
			drawEye1(g);
			drawEye2(g);
			drawNose(g);
			drawMouth(g);
			drawLeftArm(g);
			drawRightArm(g);
			drawLeftLeg(g);
			drawRightLeg(g);
			drawNoose(g);
			break;
		}
	}

	public void drawStand(Graphics g) {
		g.fillRect(200, 300, 190, 20);
		g.fillRect(320, 60, 20, 240);
		g.fillRect(200, 50, 140, 20);
		g.fillOval(200, 50, 10, 30);
	}

	public void drawFace(Graphics g) {
		Color color = new Color(240, 216, 204);
		g.setColor(color);
		g.fillOval(180, 80, 50, 50);
		g.setColor(Color.BLACK);
		g.drawArc(180, 82, 50, 50, 0, 180);
		g.drawArc(180, 81, 50, 50, 0, 180);
		g.drawArc(180, 80, 50, 50, 0, 180);
	}

	public void drawEye1(Graphics g) {
		g.drawArc(190, 95, 5, 5, 0, 180);
		g.drawOval(190, 100, 5, 5);
		g.setColor(Color.BLUE);
		g.fillOval(190, 100, 5, 5);
	}

	public void drawEye2(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawArc(215, 95, 5, 5, 0, 180);
		g.drawOval(215, 100, 5, 5);
		g.setColor(Color.BLUE);
		g.fillOval(215, 100, 5, 5);
	}

	public void drawNose(Graphics g) {
		Color color = new Color(218, 160, 149);
		g.setColor(color);
		g.drawLine(204, 105, 200, 115);
		g.drawLine(200, 115, 205, 115);
	}

	public void drawMouth(Graphics g) {
		Color color = new Color(191, 69, 68);
		g.setColor(color);
		g.drawArc(195, 120, 20, 5, 0, 180);
	}

	public void drawLeftArm(Graphics g) {
		// draw half neck and one arm
		Color color = new Color(240, 216, 204);
		g.setColor(color);
		g.fillOval(195, 125, 10, 10);
		g.setColor(Color.BLACK);
		g.fillRect(175, 133, 30, 60);
		g.fillRect(142, 133, 35, 18);
	}

	public void drawRightArm(Graphics g) {
		Color color = new Color(240, 216, 204);
		g.setColor(color);
		g.fillOval(205, 125, 10, 10);
		g.setColor(Color.BLACK);
		g.fillRect(200, 133, 30, 60);
		g.fillRect(230, 133, 35, 18);
	}

	public void drawLeftLeg(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(171, 190, 33, 20);
		g.fillRect(172, 210, 25, 40);
	}

	public void drawRightLeg(Graphics g) {
		g.fillRect(202, 190, 30, 20);
		g.fillRect(206, 210, 25, 40);
	}

	public void drawNoose(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(193, 128, 25, 3);
	}

}
