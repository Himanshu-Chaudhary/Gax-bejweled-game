package com.putable.gax.gaxby;
//advanced level implements level interface
// extra methods have been declared
import java.awt.Color;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Level;
import com.putable.gax.core.gactors.Cap;
import com.putable.gax.core.gactors.Supported;
import com.putable.gax.core.gactors.Walker;
import com.putable.gax.gaxby.gactors.Goal;
import com.putable.gax.gaxby.gactors.Release;
import com.putable.gax.gaxby.gactors.Trap;

public class AdvancedLevels implements Level{
	
	int numColors;
	Color[] color = {Color.red, Color.BLACK, Color.BLUE, Color.GREEN ,Color.CYAN,Color.orange,Color.DARK_GRAY,Color.MAGENTA,Color.YELLOW};
	
	AdvancedLevels(int numColors){
		this.numColors = numColors;
	}
		 int width = 10,height=10,prefferedWidth = 40,prefferedHeight=40,burstMs = 1;
		 String name;
		 
		 public int getNumColors(){
			 return this.numColors;
		 }
	@Override
	public int getGridWidth() {
		
		return this.width;
	}

	@Override
	public int getGridHeight() {
		
		return this.height;
	}

	@Override
	public int getPreferredSiteWidth() {
		return this.prefferedWidth;
	}

	@Override
	public int getPreferredSiteHeight() {
		return this.prefferedHeight;
	}

	@Override
	public void gridInitialize(Engine e) {
		if (e == null) throw new NullPointerException ();
		if ((e.getWidth() != getGridWidth()) || (e.getHeight() != getGridHeight())) throw new IllegalStateException();
		e = (GactorEngine) e;
		if ((e.getWidth()  != this.getGridWidth()) || (e.getHeight() != this.getGridHeight())) throw new IllegalStateException();
		for (int i = 0; i < e.getWidth() ; i++){
			for (int j = 0; j < e.getHeight(); j++){
				e.clear(i, j);
				Color temp = color[e.getRandom().nextInt(numColors)];
				e.set(i, j, new Jewl(temp));
			}
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getBurstMs() {
		return this.burstMs;
	}

}
