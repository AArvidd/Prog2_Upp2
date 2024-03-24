import GeneralStuff.Vector3;
import Things.*;

import java.util.ArrayList;

public class Ray {

    private int depth;

    //origin
    private Vector3 origin;

    //destination
    private Vector3 direction;

    private ArrayList<Thing> scene;
    private Camera camera;

    public Ray(int depth, Vector3 origin, Vector3 direction, ArrayList<Thing> scene, Camera camera) {
        this.depth = depth;

        this.origin = origin;

        this.direction = direction;
        this.direction.normalise();

        this.scene = scene;

        this.camera = camera;
    }


    public Vector3 castRay() {

        float[] intersection = findIntersection();


        if (intersection[1] == -1) {
            return camera.getSkyboxColor();
        }

        Vector3 intersectionPos = new Vector3(
                origin.x + direction.x * intersection[0],
                origin.y + direction.y * intersection[0],
                origin.z + direction.z * intersection[0]
        );


        Vector3 directColor;
        Vector3 reflectDir;
        float reflectivity;


        Thing hit = scene.get((int) intersection[1]);
        directColor = hit.getColor(intersectionPos);
        reflectDir = hit.reflect(intersectionPos, this.direction);
        reflectivity = hit.getReflectivity();


        if (depth == 0 || reflectivity == 0)
            return directColor;


        Ray next = new Ray(depth - 1, intersectionPos, reflectDir, scene, camera);
        Vector3 reflectColor = next.castRay();

        int r = (int) (directColor.x * (1 - reflectivity) + reflectColor.x * reflectivity);
        int g = (int) (directColor.y * (1 - reflectivity) + reflectColor.y * reflectivity);
        int b = (int) (directColor.z * (1 - reflectivity) + reflectColor.z * reflectivity);

        Vector3 color = new Vector3(r, g, b);
        //System.out.println("r: " + color.x + " g: " + color.y + " b: " + color.z);
        color.limitTo(255);

        return color;

    }

    public float[] findIntersection() {
        ArrayList<Float> intersectionLength = new ArrayList<>();

        for (int i = 0; i < scene.size(); i++) {
            Thing current = scene.get(i);
            intersectionLength.add(current.findIntersection(this.origin, this.direction));
        }

        float shortest = intersectionLength.get(0);
        int shortestIndex = 0;

        for (int i = 0; i < intersectionLength.size(); i++) {
            if (intersectionLength.get(i) == -1)
                continue;
            shortest = intersectionLength.get(i);
            shortestIndex = i;
            break;
        }

        for (int i = shortestIndex; i < intersectionLength.size(); i++) {
            float test = intersectionLength.get(i);
            if (test == -1) {
                continue;
            }
            if (test < shortest) {
                shortest = test;
                shortestIndex = i;
            }
        }

        return new float[]{shortest, shortestIndex};

    }

}

