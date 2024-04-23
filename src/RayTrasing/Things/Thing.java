package RayTrasing.Things;

import RayTrasing.GeneralStuff.Vector3;

//this class is the base of everything that gets rendered
public class Thing {

    protected Vector3 position;
    protected float reflectivity;
    protected Vector3 color1;

    //constructor
    protected Thing(Vector3 position, float reflectivity, Vector3 color1){
        this.position = position;
        this.reflectivity = reflectivity;
        this.color1 = color1;
    }

    //declaration for later functions
    public Vector3 reflect(Vector3 position, Vector3 incoming){
        return new Vector3(0,0,0);
    }

    //declaration for later functions
    public float findIntersection(Vector3 origin, Vector3 direction){
        return 0;
    }

    //returns the reflectivity of the object
    public float getReflectivity() {
        return reflectivity;
    }

    //returns teh color of the object
    public Vector3 getColor(Vector3 position) {
        return color1;
    }
}
