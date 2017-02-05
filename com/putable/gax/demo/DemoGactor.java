package com.putable.gax.demo;

import java.awt.Graphics2D;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Outcome;

/**
 * Some more-minimal-than-minimal demonstration code for a Gactor.  Does almost nothing!
 *
 */
public class DemoGactor extends Gactor {

    @Override
    public Outcome act(Engine e, int x, int y) {
        // Updating me has 10% chance to win the game!  What fun!
        return e.getRandom().nextInt(10)==0?Outcome.WON:Outcome.SUCCESS;  
    }

    @Override
    public void operate(int code) {
        /* I cannot be operated upon! */
    }

    @Override
    public void render(Graphics2D g, int x, int y, int widthPerSite,
            int heightPerSite) {
        /* I don't know how to render myself! */
    }

}
