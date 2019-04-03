import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Fishes.*;

/**
 * Represents the entire Fish Animation in the JFrame
 */
class FishAnimation extends JPanel {


    private BufferedImage backgroundImage;
    private Fish fish;
    private Timer timer;


    FishAnimation(@Nonnull String backgroundPath, @Nonnull Fish fish){
        try{
            this.backgroundImage = ImageIO.read(new File(backgroundPath));
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
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, this);
        fish.update();
        fish.draw(g);
    }
}