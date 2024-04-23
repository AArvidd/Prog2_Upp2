package RayTrasing;

import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.Things.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;

//this class controls the generation of all initial rays and the final image
public class Camera {

    private Vector3 position;

    //width and height of the canvas
    private float width;
    private float height;

    //how many pixels there are in the width and height of the image
    private int pixelWidth;
    private int pixelHeight;

    //coordinates of the center of each pixel
    private Vector3[][] pixelGrid;

    private Vector3 skyboxColor;

    //the objects in teh scene that can bee rendered
    ArrayList<Thing> visible = new ArrayList<>();

    //output image
    private BufferedImage image;

    //constructor
    public Camera(Vector3 position, int pixelWidth, int pixelHeight, float width, ArrayList<Thing> sean, Vector3 skyboxColor) {
        this.position = position;

        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;

        this.width = width;
        this.height = pixelHeight * width / pixelWidth;

        this.image = new BufferedImage(this.pixelWidth, this.pixelHeight, BufferedImage.TYPE_INT_RGB);

        visible.addAll(sean);

        this.skyboxColor = skyboxColor;

        pixelPoint();
    }

    //this function calculates the directions all initial rays have
    private void pixelPoint() {

        Vector3[][] pixelGrid = new Vector3[pixelWidth][pixelHeight];

        float deltaPixelX = width / pixelWidth;
        float deltaPixelY = height / pixelHeight;

        for (int pX = 0; pX < pixelWidth; pX++) {
            float xCord = (deltaPixelX / 2) - (width / 2) + (pX * deltaPixelX);

            for (int pY = 0; pY < pixelHeight; pY++) {

                pixelGrid[pX][pY] = new Vector3(1, xCord, (height / 2) - (deltaPixelY / 2) - (pY * deltaPixelY));

            }
        }

        this.pixelGrid = pixelGrid;

    }

    //this function manages the generation of the image
    public BufferedImage makeImage() {
        for (int x = 0; x < pixelWidth; x++) {
            for (int y = 0; y < pixelHeight; y++) {
                Ray current = new Ray(3, this.position, pixelGrid[x][y], visible, this);
                Vector3 color = current.castRay();
                Color temp = new Color((int)color.x, (int)color.y, (int)color.z);
                image.setRGB(x, y, temp.getRGB());
            }
        }

        return image;

    }

    //returns the skybox color of the camera
    public Vector3 getSkyboxColor() {
        return skyboxColor;
    }

    //adds a scene fore if scene is generated later
    public void addScene(ArrayList<Thing> scene){
        this.visible = scene;
    }

}
