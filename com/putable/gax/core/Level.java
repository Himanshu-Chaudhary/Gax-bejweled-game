package com.putable.gax.core;

/**
 * A Level completely describes an initial configuration of an Engine,
 * specifying its grid width and height, and a method to reinitialize that grid,
 * along with miscellaneous other properties.
 * 
 * @author ackley
 * @version 1.0
 * 
 */
public interface Level {
    /**
     * The width of the level in sites
     * 
     * @return the width, greater than 0
     */
    public int getGridWidth();

    /**
     * The height of the level in sites
     *   
     */
    public int getGridHeight();

    /**
     * The desired width of each site, in pixels. Renderers are not required to
     * honor this, but the level may fail to render optimally if it is not.
     * 
     * @return the desired width per site in pixels, greater than 0
     */
    public int getPreferredSiteWidth();

    /**
     * The desired height of each site, in pixels. Renderers are not required to
     * honor this, but the level may fail to render optimally if it is not.
     * 
     * @return the desired height per site in pixels, greater than 0
     */
    public int getPreferredSiteHeight();

    /**
     * Initialize the engine grid from scratch, which will be of size
     * {@link #getGridWidth()} by {@link #getGridHeight()}. All sites must be
     * initialized by this method; this method can not assume sites are
     * initially null.
     * 
     * @param e
     *            The engine to configure
     * @throws NullPointerException
     *             if e is null.
     * @throws IllegalStateException
     *             if {@link Engine#getWidth()} is not equal to
     *             {@link #getGridWidth()} or {@link Engine#getHeight()} is not
     *             equal to {@link #getGridHeight()}
     */
    public void gridInitialize(Engine e);

    /**
     * The name of this level. Renderers may choose to display this name in some
     * suitable way to identify the level.
     * 
     * @return The name, a non-null String
     */
    public String getName();

    /**
     * The target number of milliseconds per burst for this level. A burst is
     * defined to be {@link #getGridWidth()}*{@link #getGridHeight()} calls on
     * {@link Engine#step()}. Note that any given Engine and rendering system
     * may or may not be able to deliver any given burst rate, depending on
     * system capabilities and the size and complexity of the Level.
     * 
     * @return the desired number of milliseconds per burst, greater than 0
     */
    public int getBurstMs();

}
