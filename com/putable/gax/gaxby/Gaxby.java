package com.putable.gax.gaxby;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.putable.gax.core.EDTGame;
import com.putable.gax.core.Engine;
import com.putable.gax.core.Level;
import com.putable.gax.core.Outcome;
import com.putable.gax.core.Renderer;
import com.putable.gax.core.gactors.Walker;

public class Gaxby extends EDTGame  {
	// declares required elements for the game
	GactorEngine gameEngine;
	GactorLevel level1;
	GactorRenderer renderer ;
	Gaxby(){
		super();
	}


	  void CreateGUI() {
		 // creates the GUI
		JFrame main = new JFrame();	
		main.setSize(500, 500);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE	);
		gameEngine = new GactorEngine();
		level1 = new GactorLevel();
		gameEngine.setLevel(level1);
		gameEngine.restartLevel();
		renderer = new GactorRenderer();
		main.add(renderer,BorderLayout.CENTER);		
		main.setVisible(true);
		this.startGame();
	}

	

	
	@Override
	public Level nextLevel(Level prev, Outcome out) {
		if (prev == null ) return new GactorLevel();
		if (prev instanceof GactorLevel) return new GactorLevel2();
		return null;
		
	}

	@Override
	public Engine getEngine() {
		return this.gameEngine;
	}

	@Override
	public Renderer getRenderer() {
		
		return renderer;
	}
}
