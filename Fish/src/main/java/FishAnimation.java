import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Fishes.*;

/**
 * Represents the entire Fish Animation in the JFrame
 */
class FishAnimation extends JPanel {

    private BufferedImage backgroundImage;
    private Image image;
    private ImageReader imageReader;
    private Fish fish;
    private Timer timer;


    FishAnimation(String backgroundPath, Fish fish){
        try{
            ImageInputStream stream = ImageIO.createImageInputStream(new File(backgroundPath).getAbsoluteFile());
            this.imageReader = ImageIO.getImageReaders(stream).next();
            imageReader.setInput(stream);
            this.backgroundImage = imageReader.read(0,imageReader.getDefaultReadParam());
            this.fish = fish;
            this.timer = new Timer(100, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });

        }catch(IOException exception){
            exception.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getScaledInstance(600, 300, Image.SCALE_SMOOTH), 0, 0, this);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fish.update();
        fish.draw(g);
    }
}