package Things;

import GeneralStuff.Vector3;

public class Thing {

    private Vector3 position;
    private float reflectivity;
    private Vector3 color1;

    protected Thing(Vector3 position, float reflectivity, Vector3 color1){
        this.position = position;
        this.reflectivity = reflectivity;
        this.color1 = color1;
    }

    //protected Vector3 reflect (){} todo

}
