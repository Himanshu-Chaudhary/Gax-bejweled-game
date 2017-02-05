package com.putable.gax.gaxby;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Level;
import com.putable.gax.core.gactors.Cap;
import com.putable.gax.core.gactors.Supported;
import com.putable.gax.core.gactors.Walker;
import com.putable.gax.gaxby.gactors.Goal;
import com.putable.gax.gaxby.gactors.Release;
import com.putable.gax.gaxby.gactors.Trap;
// first level of gactor as specified by the spec
public class GactorLevel implements Level{
		 int width = 5,height=5,prefferedWidth = 80,prefferedHeight=80,burstMs = 15;
		 String name;
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
			}
		}
		e.set(0, 1, new Walker());
		e.set(0,2,new Supported());
		e.set(1, 2, new Cap());
		e.set(2,2, new Release());
		e.set(3, 2, new Cap());
		e.set(4,2,new Supported());
		e.set(0, 4, new Goal());
		e.set(4, 4, new Trap());
		
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
