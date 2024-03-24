package GeneralStuff;

public class Vector3 {

    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void normalise(){

        double magnitude = Math.sqrt(x * x + y * y + z * z);

        this.x /= magnitude;
        this.y /= magnitude;
        this.z /= magnitude;

    }

    public float calculateDot(Vector3 other){
        return (this.x * other.x) + (this.y * other.y) +(this.z * other.z);
    }

    public void limitTo(float limit){
        if (this.x > limit)
            this.x = limit;
        if (this.y > limit)
            this.y = limit;
        if (this.z > limit)
            this.z = limit;
    }

}
