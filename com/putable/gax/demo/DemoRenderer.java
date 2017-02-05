package com.putable.gax.demo;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Renderer;

public class DemoRenderer implements Renderer {

    @Override
    public void render(Engine e) {
        // This renderer does not actually call back into the Gactors for
        // display. Instead it just prints a grid using the class names of the
        // Gactors, to standard out. Could be useful for debugging perhaps, or
        // (if rewritten for a general stream) as a component of a unit testing
        // framework.
        int width = e.getWidth();
        int height = e.getHeight();
        int time = e.getBurstNumber();
        System.out.printf("--%dx%d@%d--\n", width, height, time);
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                Gactor a = e.get(x, y);
                String s;
                if (a == null)
                    s = "---";
                else
                    s = a.getClass().getSimpleName().substring(0, 3);
                System.out.printf("%s ", s);
            }
            System.out.println();
        }
    }
}
