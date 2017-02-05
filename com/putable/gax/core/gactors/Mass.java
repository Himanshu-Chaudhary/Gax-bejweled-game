package com.putable.gax.core.gactors;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Outcome;

public abstract class Mass extends Gactor {
	
	public  Outcome act(Engine e, int x, int y){
		if (e.exists(x, y+1)){
			
			if (e.get(x, y+1)== null){
				
					e.set(x, y+1, e.clear(x, y));
					return Outcome.SUCCESS;	
				
				
			}
		}
		return Outcome.FAIL;
	}
	
}
