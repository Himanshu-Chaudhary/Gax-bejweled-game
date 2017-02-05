package com.putable.gax.core;

/**
 * The basic elements of a GAX framework Game: An {@link Engine}, a
 * {@link Renderer}, and a {@link #nextLevel(Level, Outcome)} method to advance
 * the game from {@link Level} to Level.
 * 
 * @author ackley
 * 
 */
public interface Game {

    /**
     * Find the next {@link Level} to play. When called with prev==null (and out
     * unspecified), returns the first Level to be played.
     * 
     * @param prev
     *            the Level that was just played, or null for the first Level
     * @param out
     *            the Outcome of the Level that was just played. This value is
     *            unspecified when prev equals null.
     * 
     * @return The next Level to play, or null if the game is over and should
     *         exit.
     * 
     */
    public abstract Level nextLevel(Level prev, Outcome out);

    /**
     * @return the {@link Engine} associated with this game
     */
    public abstract Engine getEngine();

    /**
     * @return the {@link Renderer} associated with this game
     */
    public abstract Renderer getRenderer();

}
