import GeneralStuff.Vector3;
import Things.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;

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

    ArrayList<Thing> visible = new ArrayList<>();

    private BufferedImage image;

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

    public BufferedImage makeImage() {
        for (int x = 0; x < pixelWidth; x++) {
            for (int y = 0; y < pixelWidth; y++) {
                Ray current = new Ray(3, this.position, pixelGrid[x][y], visible,this);
                Vector3 color = current.castRay();
                //System.out.println("r: " + color.x + " g: " + color.y + " b: " + color.z);
                Color temp = new Color(color.x, color.y, color.z);
                image.setRGB(x, y, temp.getRGB());
            }
        }

        return image;

    }

    public Vector3 getSkyboxColor() {
        return skyboxColor;
    }
}
