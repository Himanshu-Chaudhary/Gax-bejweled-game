package com.putable.gax.gaxby.gactors;

import java.awt.Color;
import java.awt.Graphics2D;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Outcome;

public class Release extends Gactor{
boolean wasClicked = false;
private Color c = Color.gray;
Release (Color c){
	this.c =c;
}
	public Release() {
	// TODO Auto-generated constructor stub
}
	@Override
	public Outcome act(Engine e, int x, int y) {
		if (wasClicked) e.clear(x, y);
		return Outcome.SUCCESS;
	}

	@Override
	public void operate(int code) {
		if (code == 0) wasClicked = true;
		
		
	}

	@Override
	public void render(Graphics2D g, int x, int y, int widthPerSite, int heightPerSite) {
		g.setColor(c);
		g.fillRoundRect(x*widthPerSite, y*heightPerSite, widthPerSite, heightPerSite, 25*widthPerSite/100, 25*heightPerSite/100);
	
		
	}

}
