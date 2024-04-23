package RayTrasing;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import RayTrasing.Things.*;

//this class manages the saving of teh image the camera generates
public class MainSystem {

    private BufferedImage image;
    Camera main;

    //constructor, image generator and image saving
    public MainSystem(ArrayList<Thing> sean, Camera camera){

        this.main = camera;

        main.addScene(sean);

        image = main.makeImage();
        try {
            File output = new File("outputJava.png");
            ImageIO.write(image, "png", output);
        }catch (Exception e){
            System.out.println("Something went wrong");
        }

    }

    //return the image generated if needed elsewhere
    public BufferedImage getImage(){
        return image;
    }

}