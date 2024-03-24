package Things;

import GeneralStuff.Vector3;

public class Ground extends Thing {

    private Vector3 color2;

    public Ground (Vector3 position, float reflectivity, Vector3 color1, Vector3 color2){
        super(position, reflectivity, color1);
        this.color2 = color2;
    }

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

    public float findIntersect(Vector3 origin, Vector3 direction){

        float length = (position.z - origin.z) / direction.z;

        if(length < 0)
            length = -1;

        return length;
    }

    @Override
    public Vector3 getColor(Vector3 intersection){

        int size = 5;
        if (intersection.x < 0)
            intersection.x = intersection.x * -1 + size - 1;

        if (intersection.y < 0)
            intersection.y = intersection.y * -1 + size - 1;

        boolean X = ((intersection.x % (size * 2)) - size) < 0;
        boolean Y = ((intersection.y % (size * 2)) - size) < 0;

        return X == Y ? color1 : color2;
    }

}
