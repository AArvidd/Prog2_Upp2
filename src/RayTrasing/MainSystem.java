package RayTrasing;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.Things.*;

public class MainSystem {
    public  MainSystem(ArrayList<Thing> sean){

        /*
        ArrayList<Thing> sean = new ArrayList<>();
        sean.add(new Ground(new Vector3(0, 0, -20), 0.2f, new Vector3(0, 0, 0), new Vector3(255, 255, 255)));
        sean.add(new Sphere(new Vector3(30, 0, 0), 10, 0.5f, new Vector3(255, 0, 255)));
        sean.add(new Sphere(new Vector3( 20, -20, 0), 5, 0.3f, new Vector3(0, 255, 0)));
        sean.add(new Sphere(new Vector3(40, 0, 20), 10, 0.5f,new Vector3(255, 0, 0)));

         */

        Camera main = new Camera(new Vector3(0, 0, 0), 2000, 2000, 2, sean, new Vector3(0, 0, 0));

        BufferedImage image = main.makeImage();
        try {
            File output = new File("outputJava.png");
            ImageIO.write(image, "png", output);
        }catch (Exception e){
            System.out.println("Something went wrong");
        }

    }
}