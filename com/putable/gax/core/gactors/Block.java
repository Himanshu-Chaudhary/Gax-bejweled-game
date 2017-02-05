package com.putable.gax.core.gactors;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends Mass {
	protected Color c;
	protected Block(Color c){
		this.c = c;
	}
	Block (){
		this(Color.BLUE);
	}

	@Override
	public void operate(int code) {
	
		
	}

	@Override
	public void render(Graphics2D g, int x, int y, int widthPerSite, int heightPerSite) {
		g.setColor(c);
		g.fillRoundRect(x*widthPerSite, y*heightPerSite, widthPerSite, heightPerSite, 10*widthPerSite/100, 10*heightPerSite/100);
			
	}

}
