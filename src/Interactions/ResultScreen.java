package Interactions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//this class is the screen that shows the result of teh raytracing and scales teh image to fit on teh screen if necessary
public class ResultScreen extends JFrame {

    //constructor
    public ResultScreen(BufferedImage image){

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();//gets the size of teh primary screen
        int maxHeight = (int)size.getHeight()-100;
        int maxWidth = (int)size.getWidth()-100;

        int height = image.getHeight();//gets the size of the image
        int width = image.getWidth();

        if(height > maxHeight || width > maxWidth) {//scales the image if the image is too large
            float hRelation = (float) height / maxHeight;
            float wRelation = (float) width / maxWidth;
            if(hRelation > wRelation){
                height /= hRelation;
                width /= hRelation;
            }else{
                height /= wRelation;
                width /= wRelation;
            }

            BufferedImage resizedImage = new BufferedImage(width,  height, BufferedImage.TYPE_INT_RGB);//scales the image
            Graphics graphics = resizedImage.createGraphics();
            graphics.drawImage(image, 0, 0, width, height, null);
            graphics.dispose();
            image = resizedImage;
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("result");
        this.setSize(width, height);
        this.add(new ResultPanel(image));
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

    }
}
