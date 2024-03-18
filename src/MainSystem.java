import Things.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class MainSystem {
    public  MainSystem() throws Exception {

        ArrayList<Sphere> sean = new ArrayList<Sphere>();
        sean.add(new Sphere(30, 0, 0, 10, 0.5f, 255, 0, 255));
        sean.add(new Sphere(20, -20, 0, 5, 0.25f, 0, 0, 255));
        sean.add(new Sphere(50, 0, 20, 10, 0.5f, 255, 0, 0));



        Ground ground = new Ground(-20, 0.25f, new int[]{0, 0, 0}, new int[]{255, 255, 255});

        Camera main = new Camera(0, 0, 0, 2000, 2000, 2, sean, ground, 0, 0, 0);

        BufferedImage image = main.makeImage();
        File output = new File("outputJava.png");
        ImageIO.write(image, "png", output);

    }
}