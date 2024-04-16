package Interactions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ResultScreen extends JFrame {

    //private final BufferedImage image;
    public ResultScreen(BufferedImage image){
        //this.image = image;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int height = image.getHeight();
        int width = image.getWidth();
        this.setSize(width, height);
        this.add(new myPanel(image));
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

    }
/*
    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        if(image == null) {
            return;
        }
        g.drawImage(image, 0, 0, this);
        repaint();


    }

 */
}
