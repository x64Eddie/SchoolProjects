import java.awt.Graphics;

import javax.swing.JFrame;

import Fishes.Fish;
import Fishes.*;

class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(600, 300);
        frame.add(new FishAnimation(".//src//main//resources//ocean.png",
         new Nemo(50,200,frame.getSize(),".//src//main//resources//fish_left.png")));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}