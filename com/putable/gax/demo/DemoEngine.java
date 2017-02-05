package com.putable.gax.demo;

import java.util.Random;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Level;
import com.putable.gax.core.Outcome;

/**
 * Some more-minimal-than-minimal demonstration code for an Engine.  Missing many pieces!
 *
 */
public class DemoEngine implements Engine {

    private Gactor grid;  // XXX An '1x1 grid'!  A real engine needs more; an actual data structure here!
    private Level level;
    private Random random = new Random(1);  // XXX always the same seed!
    
    @Override
    public Random getRandom() {
        return random;
    }
    
    @Override
    public long scorePoints(long increment) {
        throw new UnsupportedOperationException("WRITE ME"); // XXX 
    }

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public void restartLevel() {
        // Call back into the level to init us
        level.gridInitialize(this);
    }

    private int steps;
    
    @Override
    public Outcome step() {
        ++steps;
        if (grid==null)
            return null;
        return grid.act(this, 0, 0); // XXX need real step processing
    }

    @Override
    public boolean exists(int x, int y) {
        return x==0 && y==0;
    }
    
    private void validCoord(int x, int y)
    {
        if (x != 0 || y != 0)  // XXX need proper coord checking!
            throw new IllegalArgumentException();
    }

    @Override
    public Gactor get(int x, int y) {
        validCoord(x,y);
        return grid; // XXX need real grid access
    }

    @Override
    public Gactor clear(int x, int y) {
        validCoord(x,y);
        Gactor ret = grid; // XXX need real grid access and update
        grid = null;
        return ret;
    }

    @Override
    public void set(int x, int y, Gactor a) {
        validCoord(x,y);
        // XXX INCOMPLETE!
        grid = a;

    }

    @Override
    public int getWidth() {
        return 1;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public int getBurstNumber() {
        return steps/1;
    }

}
