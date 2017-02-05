package com.putable.gax.demo;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Level;

/** A Level that describes a 1x1 grid containing one DemoGactor */
public class DemoLevel1 implements Level {

    @Override
    public int getGridWidth() {
        return 1;
    }

    @Override
    public int getGridHeight() {
        return 1;
    }

    @Override
    public int getPreferredSiteWidth() {
        return 10; // not used in demo
    }

    @Override
    public int getPreferredSiteHeight() {
        return 10; // not used in demo
    }

    @Override
    public void gridInitialize(Engine e) {
        e.clear(0, 0); // only legal place
        e.set(0, 0, new DemoGactor());
    }

    @Override
    public String getName() {
        return "DemoLevel1";
    }

    @Override
    public int getBurstMs() {
        return 500;  // Half a second per burst 
    }

}
