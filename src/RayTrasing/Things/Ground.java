package RayTrasing.Things;

import RayTrasing.GeneralStuff.Vector3;

//this class contains all the information and code for plains
public class Ground extends Thing {

    private Vector3 color2;

    //constructor
    public Ground (Vector3 position, float reflectivity, Vector3 color1, Vector3 color2){
        super(position, reflectivity, color1);
        this.color2 = color2;
    }

    //calculates the reflection of an incoming ray
    @Override
    public Vector3 reflect(Vector3 position, Vector3 incoming){

        Vector3 normal = new Vector3(0, 0, 1);

        float dotProduct = incoming.calculateDot(normal);

        return new Vector3(
                incoming.x - (2 * dotProduct * normal.x),
                incoming.y - (2 * dotProduct * normal.y),
                incoming.z - (2 * dotProduct * normal.z)
        );
    }

    //this function calculates how fare a ray has to ravel to hit this object or if it evan hits
    @Override
    public float findIntersection(Vector3 origin, Vector3 direction){

        float length = (position.z - origin.z) / direction.z;

        if(length <= 0)
            length = -1;

        return length;
    }

    //returns the color of the point that is hit
    @Override
    public Vector3 getColor(Vector3 intersection){

        int size = 5;
        if (intersection.x < 0)
            intersection.x = intersection.x * -1 + size - 1;

        if (intersection.y < 0)
            intersection.y = intersection.y * -1 + size - 1;

        boolean X = ((intersection.x % (size * 2)) - size) < 0;
        boolean Y = ((intersection.y % (size * 2)) - size) < 0;

        return X == Y ? color1 : color2;//if ells
    }

}
