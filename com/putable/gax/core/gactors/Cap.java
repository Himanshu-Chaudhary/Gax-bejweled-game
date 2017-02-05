package com.putable.gax.core.gactors;

import java.awt.Color;
import java.awt.Graphics2D;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Outcome;

public class Cap extends Mass {
	private Color c = new Color(0xa52a2a);
	Cap (Color c){
		this.c =c;
	}
	public Cap() {
		
	}
	@Override
	public Outcome act(Engine e, int x, int y) {
		boolean  supportedLeft = (e.exists(x+1,y) && (e.get(x+1, y) != null));
		boolean  supportedRight = (e.exists(x-1,y) && (e.get(x-1, y) != null));
		if (supportedLeft || supportedRight) return Outcome.SUCCESS;
		return super.act(e, x, y);		
	}

	@Override
	public void operate(int code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g, int x, int y, int widthPerSite, int heightPerSite) {
		g.setColor(c);
		g.fillRoundRect(x*widthPerSite, y*heightPerSite, widthPerSite, heightPerSite, 20*widthPerSite/100, 20*heightPerSite/100);
		
	}

}
