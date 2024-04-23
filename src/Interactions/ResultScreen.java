package Interactions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ResultScreen extends JFrame {


    public ResultScreen(BufferedImage image){

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int maxHeight = (int)size.getHeight()-100;
        int maxWidth = (int)size.getWidth()-100;

        int height = image.getHeight();
        int width = image.getWidth();

        if(height > maxHeight || width > maxWidth) {
            if(height > maxHeight){
                float relation = (float) height / maxHeight;
                height /= relation;
                width /= relation;
            }else{
                float relation = (float) width / maxWidth;
                height /= relation;
                width /= relation;
            }

            BufferedImage resizedImage = new BufferedImage(width,  height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = resizedImage.createGraphics();
            graphics.drawImage(image, 0, 0, width, height, null);
            graphics.dispose();
            image = resizedImage;
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.add(new ResultPanel(image));
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

    }
}
