package RayTrasing;

import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.Things.*;

import java.util.ArrayList;

//this class contains the information and functions to a ray
public class Ray {

    //teh depth left for a ray to reflect
    private int depth;

    //origin of the ray
    private Vector3 origin;

    //direction the ray travels
    private Vector3 direction;

    private ArrayList<Thing> scene;
    private Camera camera;

    //constructor
    public Ray(int depth, Vector3 origin, Vector3 direction, ArrayList<Thing> scene, Camera camera) {
        this.depth = depth;

        this.origin = origin;

        this.direction = direction;
        this.direction.normalise();

        this.scene = scene;

        this.camera = camera;
    }

    //cast the ray and return the color of where it hit
    public Vector3 castRay() {

        //contains information about how fare the ray had to travel and which object was hit
        float[] intersection = findIntersection();

        if (intersection[1] == -1) {//if ray hit nothing
            return camera.getSkyboxColor();
        }

        Vector3 intersectionPos = new Vector3(//position of where the ray hit
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

        if (depth <= 0 || reflectivity == 0)//if the hit object isn't reflective ore the ray cant reflect
            return directColor;


        Ray next = new Ray(depth - 1, intersectionPos, reflectDir, scene, camera); //new ray to get the color of teh reflection
        Vector3 reflectColor = next.castRay();

        //color blending
        int r = (int) (directColor.x * (1 - reflectivity) + reflectColor.x * reflectivity);
        int g = (int) (directColor.y * (1 - reflectivity) + reflectColor.y * reflectivity);
        int b = (int) (directColor.z * (1 - reflectivity) + reflectColor.z * reflectivity);

        Vector3 color = new Vector3(r, g, b);
        color.limitTo(255);// limit teh color so that the system doesn't brake

        return color;

    }

    //this function calculate which object the ray first hit if anny and how fare the ray had to travel
    public float[] findIntersection() {
        ArrayList<Float> intersectionLength = new ArrayList<>();

        if (scene.isEmpty())// if there is nothing to hit
            return new float[] {-1, -1};

        for (int i = 0; i < scene.size(); i++) {//calculates the intersection of all object in the scene
            Thing current = scene.get(i);
            intersectionLength.add(current.findIntersection(this.origin, this.direction));
        }

        float shortest = intersectionLength.get(0);
        int shortestIndex = 0;

        for (int i = 0; i < intersectionLength.size(); i++) {//finds an intersection
            if (intersectionLength.get(i) == -1)
                continue;
            shortest = intersectionLength.get(i);
            shortestIndex = i;
            break;
        }

        for (int i = shortestIndex; i < intersectionLength.size(); i++) {//finds the first intersection
            float test = intersectionLength.get(i);
            if (test == -1) {
                continue;
            }
            if (test < shortest) {
                shortest = test;
                shortestIndex = i;
            }
        }

        if (shortest == -1)//if nothing is hit
            shortestIndex = -1;

        return new float[]{shortest, shortestIndex};

    }

}

