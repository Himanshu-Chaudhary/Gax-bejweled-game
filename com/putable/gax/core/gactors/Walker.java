package com.putable.gax.core.gactors;

import java.awt.Color;
import java.awt.Graphics2D;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Outcome;

public class Walker extends Mass{
	private Color c = Color.orange;
	private boolean directionRight = false;
	private int toRight = -1, startAngle = 300;
	public Walker (Color c){
		this.c =c;
	}
	public Walker(java.awt.Color c, boolean toRight){
		directionRight = toRight;		
	}
	public Walker(){
		
	}
	public Outcome act(Engine e, int x, int y) {
		if (directionRight) {
			this.toRight = 1;
			startAngle =120;
			
		}
		else {
			this.toRight = -1;
			startAngle = 300;
		}
		if (e.exists(x, y+1)){
			if (e.get(x, y+1) == null) return super.act(e, x, y);
		}
		
		if (!e.exists(x+toRight, y)){	
			directionRight = !directionRight;
			return Outcome.FAIL;
		}
		
		if (e.get(x+toRight, y)!= null){
			if (!e.exists(x+toRight, y-1)){
				directionRight = !directionRight;
				return Outcome.FAIL;
			}
			if (e.get(x+toRight, y-1)== null){
				e.set(x+toRight, y-1, e.clear(x, y));
				
				return Outcome.SUCCESS;
			}
			directionRight = !directionRight;
			return Outcome.FAIL;
			
				
			}
		e.set(x+toRight, y, e.clear(x, y));
		return Outcome.SUCCESS;
		
	
		
	}

	@Override
	public void operate(int code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g, int x, int y, int widthPerSite, int heightPerSite) {
		g.setColor(c);
		
		g.fillArc(x*widthPerSite, y*heightPerSite, widthPerSite, heightPerSite, startAngle, 120);
	
		
	}

}
