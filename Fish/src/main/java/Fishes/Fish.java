package Fishes;

import java.awt.Dimension;
import java.awt.Graphics;


/**
 * Represents all the fish that are going to be swimming in the water.
 */
public abstract class Fish{
    
    protected final double SCREEN_WIDTH, SCREEN_HEIGHT;

    public Fish(Dimension dimension){
        SCREEN_HEIGHT = dimension.getHeight();
        SCREEN_WIDTH = dimension.getWidth();
    }
    public abstract void draw(Graphics graphics);
    public abstract void update();
}
