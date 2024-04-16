package Interactions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class myPanel extends JPanel {
    private final BufferedImage image;

    public myPanel(BufferedImage image) {
        this.image = image;

        int height = image.getHeight();
        int width = image.getWidth();
        this.setSize(width, height);
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("painting");
        super.paintComponent(g);
        System.out.println("painting more");
        try{
            System.out.println("found image");
            g.drawImage(image, 0, 0, this);
        }catch (Exception e){
            System.out.println("cant draw");
        }
        /*

        if (image. null) {
            System.out.println("image null");
            return;
        }
        System.out.println("found image");
        g.drawImage(image, 0, 0, this);
        //repaint();

         */


    }
}
