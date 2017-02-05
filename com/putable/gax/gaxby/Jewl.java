package com.putable.gax.gaxby;

import java.awt.Color;
import java.awt.Graphics2D;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Outcome;
import com.putable.gax.core.gactors.Block;
import com.putable.gax.core.gactors.Mass;
// jewl Gactor for the Advanced game
public class Jewl extends Block {
	boolean isClicked = false;
	public Jewl(Color temp) {
	 super(temp);
	}
	@Override
	public  Outcome act(Engine e, int x, int y){
		if (e.scorePoints(0) > 5) {
			e.scorePoints(-5);
			return Outcome.WON;
		}
		if (!isClicked) return super.act(e, x, y);
		
		e.clear(x, y);
		return Outcome.SUCCESS;
	}

	@Override
	public void operate(int code) {
		if (code == 0){
			isClicked = true;
		}
		
	}

	@Override
	public void render(Graphics2D g, int x, int y, int widthPerSite, int heightPerSite) {
		g.setColor(super.c);
		int[] xArr = {x*widthPerSite , x*widthPerSite+(widthPerSite/2),(x+1)*widthPerSite, x*widthPerSite+(widthPerSite/2)};
		int[] yArr = {y*heightPerSite+(heightPerSite/2),y*heightPerSite,y*heightPerSite+(heightPerSite/2),(y+1)*heightPerSite};

		g.fillPolygon(xArr, yArr, 4);
			
	}

	Color getColor(){
		return this.c;
	}
}
