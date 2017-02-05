package com.putable.gax.core;

/**
 * Possible return values from the {@link Gactor#act(Engine, int, int)} and
 * {@link Engine#step()} methods.
 */
public enum Outcome {
    /**
     * The act was completed successfully, for some Gactor-specific meaning of
     * 'success'
     */
    SUCCESS,
    /**
     * The act failed to complete successfully, for some Gactor-specific meaning
     * of 'fail'
     */
    FAIL,
    /**
     * The act caused the level to be won;
     * {@link Game#nextLevel(Level, Outcome)} should now be called.
     */
    WON, 
    /**
     * The act caused the level to be lost;
     * {@link Game#nextLevel(Level, Outcome)} should now be called.
     */
    LOST, 
    /**
     * The act has requested the game to be ended.
     */
    QUIT
};
