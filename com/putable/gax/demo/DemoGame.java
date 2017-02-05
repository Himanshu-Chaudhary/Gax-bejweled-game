package com.putable.gax.demo;

import com.putable.gax.core.EDTGame;
import com.putable.gax.core.Engine;
import com.putable.gax.core.Level;
import com.putable.gax.core.Outcome;
import com.putable.gax.core.Renderer;

/**
 * A more-minimal-than-minimal demonstration game. As written (including the
 * specific Random number seeding in DemoEngine), DemoGame prints stuff that
 * starts like this:
 * <pre>
 * --1x1@1--
 * Dem
 * --1x1@2--
 * </pre>
 * and ends like this:
 * <pre>
 * Dem 
 * --1x1@22--
 * Dem
 * </pre>
 * and then exits.
 */

public class DemoGame extends EDTGame {

    public DemoGame() {
        demoEngine = new DemoEngine();
        demoRenderer = new DemoRenderer();
        this.startGame();
    }

    @Override
    public Level nextLevel(Level prev, Outcome out) {
        if (prev == null)
            return new DemoLevel1();
        else
            return null;
    }

    private Engine demoEngine;

    @Override
    public Engine getEngine() {
        return demoEngine;
    }

    private Renderer demoRenderer;

    @Override
    public Renderer getRenderer() {
        return demoRenderer;
    }

    public static void main(String[] args) {
        new DemoGame();
    }

}
