package com.putable.gax.core;

import java.util.Random;

/**
 * The main GAX framework behavioral interface.
 * 
 * @version 1.0
 * 
 * @author ackley
 * 
 */
public interface Engine {

    /**
     * Access the master PRNG of the simulation. This would be used, for
     * example, by {@link Gactor}s that have probabilistic behavior.
     * 
     * @return the random number generator for the engine, guaranteed to be
     *         non-null
     */
    public Random getRandom();

    /**
     * Increment the point score by 'increment' and return the resulting score.
     * 
     * @code scorePoints(0) returns the current score;
     *       scorePoints(-scorePoints(0)) resets the score to 0L.
     * 
     * @param increment
     *            amount to change the score by
     * @return the resulting score.
     */
    public long scorePoints(long increment);

    /**
     * Set the level to use for this engine.
     * 
     * @param level
     *            The level to use to configure this engine
     * @throws NullPointerException
     *             if level is null
     */
    public void setLevel(Level level);

    /**
     * Return the level currently being implemented by this Engine
     * 
     * @return the current level, or null if {@link #setLevel(Level)} has never
     *         been called on this Engine
     */
    public Level getLevel();

    /**
     * Reinitialize the engine: Configure or reconfigure this engine from
     * scratch, using all details as needed from the provided Level. Does
     * <i>not</i> affect the score as seen by {@link #scorePoints(long)} or the
     * burst number as seen by {@link #getBurstNumber()};
     * 
     * @throws IllegalStateException
     *             if {@link #setLevel(Level)} has never been called on this
     *             Engine
     */
    public void restartLevel();

    /**
     * Perform one update
     * 
     * @return the result of the step. Either null for no information (i.e., if
     *         a selected site was empty), or the {@link Outcome} value produced
     *         by the {@link Gactor#act(Engine, int, int)} methods that was
     *         invoked
     * 
     */
    public Outcome step();

    /**
     * Check if an (x,y) coordinate is legal for the current grid.
     * 
     * @param x
     *            The column
     * @param y
     *            The row
     * @return true if the grid includes a location (x,y), and false if it does
     *         not
     */
    public boolean exists(int x, int y);

    /**
     * Access the contents of location (x,y).
     * 
     * @param x
     *            The column of interest
     * @param y
     *            The row of interest
     * @return null if the site is unoccupied, else a reference to the Gactor
     *         currently stored at (x,y)
     * @throws IllegalArgumentException
     *             if {@link #exists(int x, int y)} would return false at the
     *             time of the call to this method
     */
    public Gactor get(int x, int y);

    /**
     * Empty the location (x,y).
     * 
     * @param x
     *            The column of interest
     * @param y
     *            The row of interest
     * @return null if the site had previously been unoccupied, else a reference
     *         to the Gactor that had been stored at (x,y)
     * @throws IllegalArgumentException
     *             if {@link #exists(int x, int y)} would return false at the
     *             time of the call to this method
     */
    public Gactor clear(int x, int y);

    /**
     * Store Gactor a at location (x,y).
     * 
     * @param x
     *            The column of interest
     * @param y
     *            The row of interest
     * @param a
     *            The Gactor to be stored
     * @throws IllegalArgumentException
     *             if {@link #exists(int x, int y)} would return false at the
     *             time of the call to this method
     * @throws IllegalArgumentException
     *             If a is null
     * @throws IllegalStateException
     *             If site (x,y) is non-null
     */
    public void set(int x, int y, Gactor a);

    /**
     * 
     * @return the width of the grid, in sites
     */
    public int getWidth();

    /**
     * 
     * @return the height of the grid, in sites
     */
    public int getHeight();

    /**
     * @return what burst we are on. This value increments whenever a burst
     *         completes, as defined by the Engine in question.
     */
    public int getBurstNumber();

}