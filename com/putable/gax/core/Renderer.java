package com.putable.gax.core;

/**
 * The interface describing something that can 'render' -- produce some kind of
 * output -- of the state of an {@link Engine}. It may or may not produce any
 * actual graphical output, depending on purpose, and implementations may also
 * be designed to generate inputs to (the {@link Gactor}s of) an {@link Engine},
 * via calls to {@link Gactor#operate(int)}.
 * 
 */
public interface Renderer {
    /**
     * This method is called (e.g., from
     * {@link EDTGame#actionPerformed(java.awt.event.ActionEvent)} after the
     * {@link Engine} has completed a burst.
     * 
     * @param e
     *            The engine whose state is to be rendered.
     */
    public void render(Engine e);
}
