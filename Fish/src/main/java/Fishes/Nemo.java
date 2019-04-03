package Fishes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Fishes.*;

/**
 * Represents a type of fish
 */
public class Nemo extends Fish {

    private int x, y, xVelocity;
    private BufferedImage image;

    public Nemo(Dimension dimension, String path) {
        this(50, 50, dimension, path);
    }

    Nemo(int x, int y, Dimension dimension, String path) {
        super(dimension);
        this.x = x;
        this.y = y;
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    @Override
    public void update() {
        if(x > SCREEN_WIDTH)x -= xVelocity;
        if(x < 0)x += xVelocity;
    }

}