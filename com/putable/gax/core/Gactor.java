package com.putable.gax.core;

import java.awt.Graphics2D;

/**
 * The base class of the Gactor hierarchy. A Gactor is an object that can occupy
 * a grid site in an {@link Engine}, via its twin roles first as an argument to
 * {@link Engine#set(int, int, Gactor)} and second as the return type from
 * {@link Engine#get(int, int)}.
 * <p>
 * A Gactor possesses three abstract operations that must be defined by concrete
 * subclasses:
 * <ol>
 * <li>A Gactor can play the <i>active</i> role, performing an
 * {@link #act(Engine, int, int)} that is in some way appropriate to its type.
 * This typically advances the Gactor's internal state machine, and also updates
 * site(s) in the supplied {@link Engine} in some way.
 * <li>A Gactor can play the <i>passive</i> role, accepting input from the
 * player (or other sources) via its {@link #operate(int)} method. Note that
 * calls to this method occur between {@link #act(Engine, int, int)} calls, at
 * poorly-defined times; Gactor implementations may prefer not to react
 * immediately to a {@link #operate(int)} call, but instead somehow note that
 * the call occurred and otherwise defer reacting to that event until the next
 * {@link #act(Engine, int, int)} call.
 * <li>A Gactor can {@link #render(Graphics2D, int, int, int, int)} itself in
 * some fashion to the {@link Graphics2D} it is passed.there
 * </ol>
 * 
 * @author ackley
 * 
 */
public abstract class Gactor {

    /**
     * Perform whatever action this Gactor is designed to do, in this current
     * circumstance in the given {@link Engine}. Returns an {@link Outcome}
     * providing categorical information about the results of the act; for
     * maximum utility all subclasses that override this method are expected to
     * document their override to explain specifically what return values of
     * {@link Outcome#SUCCESS} and {@link Outcome#FAIL} mean for that particular
     * subclass.  (For an example, see {@link com.putable.gax.core.gactors.Mass#act(Engine, int, int)}.
     * 
     * @param e
     *            The Engine this actor exists and operates within.
     * @param x
     *            The current grid x position of this Gactor.
     * @param y
     *            The current grid y position of this Gactor.
     * 
     * @return {@link Outcome#SUCCESS} if the act, whatever it is, was performed
     *         successfully; {@link Outcome#FAIL} if the act could not be
     *         performed for whatever reason; {@link Outcome#WON} if this act
     *         caused the current {@link Level} to be won; or
     *         {@link Outcome#LOST} if this act caused the current {@link Level}
     *         to be lost.
     * 
     * @throws NullPointerException
     *             if e is null
     * @throws IllegalStateException
     *             if e.get(x,y) does not contain a reference to this Gactor
     *             (upon entry to the method, which may later move this Gactor).
     */
    public abstract Outcome act(Engine e, int x, int y);

    /**
     * React to an operation happening to this Gactor.
     * 
     * @param code
     */
    public abstract void operate(int code);

    /**
     * Render a depiction of this Gactor to a graphics context. Note the x and y
     * arguments are in units of grid sites, not pixels. Rendering is expected
     * to take place in the rectangle bounded by the corners
     * (x*widthPerSite,y*heightPerSite) and
     * ((x+1)*widthPerSite,(y+1)*heightPerSite), but note that it <i>may or may
     * not</i> be possible to draw outside that region, depending on the details
     * of the {@link Renderer} implementation in use.
     * 
     * @param g
     *            The graphics context to render to
     * @param x
     *            The current grid x position of this Gactor
     * @param y
     *            The current grid y position of this Gactor
     * @param widthPerSite
     *            The number of pixels per site horizontally in this display
     * @param heightPerSite
     *            The number of pixels per site vertically in this display
     */
    public abstract void render(Graphics2D g, int x, int y, int widthPerSite,
            int heightPerSite);
    
    public boolean check (int x,int y, Gactor g,Engine e){
    	
    	if (e.exists(x, y)){
    		Gactor temp = e.get(x, y);
    		if (temp != null){
    		if (e.get(x, y).getClass().equals(g.getClass())){
        		return true;
        	}	}
    	}
    	
    	return false;
    }
   public void remove (int x,int y, int increment,Engine e){
	   e.scorePoints(increment);
	   e.clear(x, y);
		
    }

}

