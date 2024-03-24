package Things;

import GeneralStuff.Vector3;

public class Thing {

    protected Vector3 position;
    protected float reflectivity;
    protected Vector3 color1;

    protected Thing(Vector3 position, float reflectivity, Vector3 color1){
        this.position = position;
        this.reflectivity = reflectivity;
        this.color1 = color1;
    }

    public Vector3 reflect(Vector3 position, Vector3 incoming){
        return new Vector3(0,0,0);
    }

    public float findIntersection(Vector3 origin, Vector3 direction){
        return 0;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public Vector3 getColor(Vector3 position) {
        return color1;
    }
}
