package com.putable.gax.gaxby;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Renderer;
// renderer for Gaxby
public class GactorRenderer extends JPanel implements Renderer {
	public GactorRenderer() {
		this.addListen();
	}
	// declaring a Buffered image which will ad elements to it
	private BufferedImage image;
	int width, height;
	GactorEngine temp;
	String score = "";

	@Override
	public void render(Engine e) {
		// declaring variables for the method
		temp = (GactorEngine) e;
		width = e.getLevel().getPreferredSiteWidth();
		height = e.getLevel().getPreferredSiteHeight();
		// image will hold all the graphical elements
		image = new BufferedImage(e.getWidth() * width, e.getHeight() * height, BufferedImage.TYPE_INT_RGB);

		Graphics2D g2D = (Graphics2D) image.getGraphics();
		super.paintComponent(g2D);
		for (int i = 0; i < e.getWidth(); i++) {
			for (int j = 0; j < e.getHeight(); j++) {
				Gactor temp = e.get(i, j);
				if (temp != null)
					// add elemets to image buffer
					temp.render(g2D, i, j, width, height);
			}
		}
		// updates score
		score = "Score : " + e.scorePoints(0);
		// paints the graphics in the screen
		repaint();
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g); // Do the regular painting 'above' us
		// adds the image buffer in the screen
		g2d.drawImage(image, 0, 0, this);
		if (temp != null) {
			// adds the score
			g2d.drawString(score, temp.getWidth() * width / 2, temp.getHeight() * height+10);
		}

	}

	private void addListen() {
		// listens for the click in release gactor
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//get height and width of the click
				int x = e.getX() / width;
				int y = e.getY() / height;

				if (temp.exists(x, y) && (temp.get(x, y) != null)) {
					temp.get(x, y).operate(0);
				}
			}
		});

	}
}
