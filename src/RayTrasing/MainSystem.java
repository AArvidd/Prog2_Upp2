package RayTrasing;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.Things.*;

public class MainSystem {

    private BufferedImage image;
    Camera main;

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

    public BufferedImage getImage(){
        return image;
    }

}