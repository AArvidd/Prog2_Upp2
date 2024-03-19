package Things;

import GeneralStuff.Vector3;

public class Sphere extends Thing{

    float radius;

    public Sphere(Vector3 position, float radius, float reflectivity, Vector3 color){
        super(position, reflectivity, color);
        this.radius = radius;
    }

    public Vector3 reflect(Vector3 position, Vector3 incoming){
        Vector3 normal = new Vector3(
                position.x - this.position.x,
                position.y - this.position.y,
                position.z - this.position.z
        );

        normal.normalise();

        float dotProduct =
                (incoming.x * normal.x) +
                (incoming.y * normal.y) +
                (incoming.z * normal.z);

        return new Vector3(
                incoming.x - (2 * dotProduct * normal.x),
                incoming.y - (2 * dotProduct * normal.y),
                incoming.z - (2 * dotProduct * normal.z)
        );

    }

}
