package Interactions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ResultScreen extends JFrame {

    public ResultScreen(BufferedImage image){

        BufferedImage resizedImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = resizedImage.createGraphics();
        graphics.drawImage(image, 0, 0, 800, 800, null);
        graphics.dispose();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int height = image.getHeight();
        int width = image.getWidth();
        this.setSize(800, 800);
        this.add(new ResultPanel(resizedImage));
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

    }
}
