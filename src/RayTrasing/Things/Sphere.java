package RayTrasing.Things;

import RayTrasing.GeneralStuff.Vector3;

public class Sphere extends Thing{

    float radius;

    public Sphere(Vector3 position, float radius, float reflectivity, Vector3 color){
        super(position, reflectivity, color);
        this.radius = radius;
    }

    @Override
    public Vector3 reflect(Vector3 position, Vector3 incoming){
        Vector3 normal = new Vector3(
                position.x - this.position.x,
                position.y - this.position.y,
                position.z - this.position.z
        );

        normal.normalise();

        float dotProduct = incoming.calculateDot(normal);

        return new Vector3(
                incoming.x - (2 * dotProduct * normal.x),
                incoming.y - (2 * dotProduct * normal.y),
                incoming.z - (2 * dotProduct * normal.z)
        );
    }

    @Override
    public float findIntersection(Vector3 origin, Vector3 direction){
        float t1;
        float t2;

        float a = (
                direction.x * direction.x +
                direction.y * direction.y +
                direction.z * direction.z
        );

        float b = 2 * (
                direction.x * (origin.x - position.x) +
                direction.y * (origin.y - position.y) +
                direction.z * (origin.z - position.z)
        );

        float c =
            -(radius * radius - (
                    origin.x * origin.x +
                    origin.y * origin.y +
                    origin.z * origin.z -
                2 * (
                    origin.x * position.x +
                    origin.y * position.y +
                    origin.z * position.z
                ) +
                    position.x * position.x +
                    position.y * position.y +
                    position.z * position.z
            )
        );

        float center = -(b / (2 * a));
        double pm = Math.sqrt((b * b) - (4 * a * c)) / (2 * a);

        t1 = (float) (center + pm);
        t2 = (float) (center - pm);

        if (Double.isNaN(t1) && Double.isNaN(t2))
            return -1;

        if (t1 <= 0 || t2 <= 0)
            return -1;


        return Math.min(t1, t2);

    }

}
