package Fishes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import Fishes.*;

/**
 * Represents a type of fish
 */
public class Nemo extends Fish {

    private int x, y, xVelocity;
    private ImageReader imageReader;
    private BufferedImage image;

    public Nemo(Dimension dimension, String path) {
        this(50, 50, dimension, path);
    }

    Nemo(int x, int y, Dimension dimension, String path) {
        super(dimension);
        this.x = x;
        this.y = y;
        try {
            ImageInputStream stream = ImageIO.createImageInputStream(new File(path).getAbsoluteFile());
            this.imageReader = ImageIO.getImageReaders(stream).next();
            imageReader.setInput(stream);
            this.image = imageReader.read(0,imageReader.getDefaultReadParam());

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