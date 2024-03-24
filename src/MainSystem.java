import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import GeneralStuff.Vector3;
import Things.*;

public class MainSystem {
    public  MainSystem() throws Exception {


        ArrayList<Thing> sean = new ArrayList<>();
        sean.add(new Sphere(new Vector3(30, 0, 0), 10, 0.5f, new Vector3(255, 0, 255)));
        sean.add(new Sphere(new Vector3( 20, -20, 0), 5, 0.25f, new Vector3(0, 0, 255)));
        sean.add(new Sphere(new Vector3(50, 0, 20), 10, 0.5f,new Vector3(255, 0, 0)));

        sean.add(new Ground(new Vector3(0, 0, -20), 0.25f, new Vector3(0, 0, 0), new Vector3(255, 255, 255)));

        Camera main = new Camera(new Vector3(0, 0, 0), 2000, 2000, 2, sean,new Vector3(255, 255, 0));

        BufferedImage image = main.makeImage();
        File output = new File("outputJava.png");
        ImageIO.write(image, "png", output);

    }
}