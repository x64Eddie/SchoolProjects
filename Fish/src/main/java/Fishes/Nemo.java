package Fishes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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

    private int x, y, xVelocity, yVelocity;
    private ImageReader imageReader;
    private BufferedImage image;
    private boolean goingRight = true, goingUp = true;

    public Nemo(Dimension dimension, String path) {
        this(50, 50, dimension, path);
    }

    public Nemo(int x, int y, Dimension dimension, String path) {
        super(dimension);
        this.x = x;
        this.y = y;
        this.xVelocity = 15;
        this.yVelocity = 10;
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
        graphics.drawImage(
            image.getScaledInstance(50, 50, Image.SCALE_SMOOTH), x, y, null);
    }

    @Override
    public void update() {
         updateX();
         updateY();
    }

    /**
     * Updating the x-position of the fish
     */
    private void updateX(){
        if(x < 0)this.goingRight = true;
        if(x > SCREEN_WIDTH)this.goingRight = false;
        if(goingRight){
            x += xVelocity;
        }
        else{
            x-=xVelocity;
        }
    }

    /**
     * updating the y-position of the fish.
     */
    private void updateY(){
        if(goingUp){
            y -= yVelocity;
            goingUp = false;
        }
        else{
            y += yVelocity;
            goingUp = true;
        }
    }

}