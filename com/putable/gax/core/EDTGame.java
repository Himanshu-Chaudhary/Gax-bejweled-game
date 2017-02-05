package com.putable.gax.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * A skeleton {@link Game} implementation using a Swing timer to call the
 * {@link Engine#step()}, {@link Game#nextLevel(Level, Outcome)}, and
 * {@link Renderer#render(Engine)} methods appropriately in sequence, from the
 * Swing event dispatching thread at (hopefully) regular intervals.
 * 
 * @author ackley
 * 
 */
public abstract class EDTGame implements Game, ActionListener {

    public EDTGame() {
        setRunning(false);

        // The following call is a disgusting hack to ensure the EDT is alive
        // early even in non-GUI (or late-starting-GUI) programs.
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // Empty! Just needed to exist!
            }
        });

        // Fire up the timer, at some default rate. The Level will tell us what
        // we want, later.
        // Note this won't work without the EDT..
        timer = new Timer(100, this);
        timer.setInitialDelay(100);
        timer.start();
    }

    private boolean isRunning = false;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean run) {
        this.isRunning = run;
    }

    /**
     * This timer field is protected (rather than private) so that subclasses
     * can, if desired, customize its timing properties directly (e.g.,
     * {@link Timer#setCoalesce(boolean)}).
     */
    protected Timer timer;

    /**
     * Start the entire game (over).
     */
    public void startGame() {
        firstTime = true;
    }

    private boolean firstTime = false;

    private void configureLevel(Level newLevel) {
        timer.setDelay(newLevel.getBurstMs());
        getEngine().setLevel(newLevel);
        getEngine().restartLevel();
        setRunning(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (firstTime) {
            firstTime = false;
            configureLevel(this.nextLevel(null, null));
        }
        Engine engine = getEngine();
        if (engine == null)
            return;
        int burstNumber = engine.getBurstNumber();
        if (isRunning) {
        	
            while (burstNumber == engine.getBurstNumber()) {
                Outcome res = engine.step();
                if (res != null && res.ordinal() >= Outcome.WON.ordinal()) {
                    Level next = EDTGame.this.nextLevel(engine.getLevel(), res);
                    if (next == null)
                        System.exit(0);
                    configureLevel(next);
                }
            }
            getRenderer().render(engine);
        }
    }
}
