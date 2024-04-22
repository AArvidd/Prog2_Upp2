package Interactions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ResultPanel extends JPanel {
    private final BufferedImage image;

    public ResultPanel(BufferedImage image) {
        this.image = image;

        int height = image.getHeight();
        int width = image.getWidth();
        this.setSize(width, height);
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            g.drawImage(image, 0, 0, this);
        }catch (Exception e){
        }

    }
}
