package com.putable.gax.gaxby;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import com.putable.gax.core.EDTGame;
import com.putable.gax.core.Engine;
import com.putable.gax.core.Level;
import com.putable.gax.core.Outcome;
import com.putable.gax.core.Renderer;
// Advanced version of game
public class Advanced extends EDTGame {
	// declaring engine,Level and Renderer;
	Engine advanced = new GactorEngine();
	AdvancedRenderer advancedRenderer = new AdvancedRenderer();
	Level level = new AdvancedLevels(5);

	void CreateGUI() {
		//Creates the Graphical elements and gets it from renderer
		JFrame main = new JFrame();
		main.setSize(500, 500);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		advanced = new GactorEngine();
		advanced.setLevel(level);
		advanced.restartLevel();
		advancedRenderer = new AdvancedRenderer();
		main.add(advancedRenderer, BorderLayout.CENTER);
		main.setVisible(true);
		this.startGame();
	}

	@Override
	public Level nextLevel(Level prev, Outcome out) {
		// implementing methods from the interface
		// provides 3 new levels with added colors

		if (prev == null)
			return new AdvancedLevels(5);
		AdvancedLevels temp = (AdvancedLevels) prev;
		if (temp.getNumColors() > 7)
			return null;
		return new AdvancedLevels(temp.getNumColors() + 1);

	}

	@Override
	public Engine getEngine() {

		return this.advanced;
	}

	@Override
	public Renderer getRenderer() {

		return this.advancedRenderer;
	}

}
