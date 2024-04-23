package RayTrasing.GeneralStuff;

//this class if for saving three related values as a vector
public class Vector3 {

    //public fore easy access to the values
    public float x;
    public float y;
    public float z;

    //constructor
    public Vector3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //normalises the vector
    public void normalise(){

        double magnitude = Math.sqrt(x * x + y * y + z * z);

        this.x /= magnitude;
        this.y /= magnitude;
        this.z /= magnitude;

    }

    //calculates the dot product between this and another vector
    public float calculateDot(Vector3 other){
        return (this.x * other.x) + (this.y * other.y) +(this.z * other.z);
    }

    //limits the values of this vector to a specified value
    public void limitTo(float limit){
        if (this.x > limit)
            this.x = limit;
        if (this.y > limit)
            this.y = limit;
        if (this.z > limit)
            this.z = limit;
    }

}
