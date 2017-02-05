package com.putable.gax.gaxby.gactors;

import java.awt.Color;
import java.awt.Graphics2D;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Outcome;
import com.putable.gax.core.gactors.Walker;

public class Goal extends Gactor{
	Color c = Color.green;
	Goal(Color c){
		this.c = c;
	}

	public Goal() {
	
	}


	@Override
	public Outcome act(Engine e, int x, int y) {
		Walker walker = new Walker();
		
		if (check(x+1,y,walker,e)) {
			remove(x+1,y,100,e);
			return Outcome.WON;
			
		}
		if (check(x-1,y,walker,e)) {
			remove(x-1,y,100,e);
			return Outcome.WON;
			
		}
		if (check(x,y+1,walker,e)) {
			remove(x,y+1,100,e);
			return Outcome.WON;
			
		}
		if (check(x,y-1,walker,e)) {
			remove(x,y-1,100,e);
			return Outcome.WON;
			
		}
		
		return Outcome.SUCCESS;
	}

	@Override
	public void operate(int code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g, int x, int y, int widthPerSite, int heightPerSite) {
		g.setColor(c);
		g.fillOval(x*widthPerSite, y*heightPerSite, widthPerSite, heightPerSite);
		
	}

}
