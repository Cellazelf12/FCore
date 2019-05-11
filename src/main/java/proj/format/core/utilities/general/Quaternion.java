package proj.format.core.utilities.general;

import proj.format.core.utilities.objects.Vec;

public class Quaternion {

    private final double w, x, y, z;

    /**
     * Creates a new Quaternion object
     * 
     * @param w
     *            W value
     * @param x
     *            X value
     * @param y
     *            Y value
     * @param z
     *            Z value
     */
    public Quaternion(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Rotate a vector using a rotation quaternion.
     * 
     * @param vector
     *            Vector
     * @param r
     *            Quaternion
     * @return Rotated vector
     */
    public static Vec rotate(Vec vector, Quaternion r) {
        return r.mul(Quaternion.from(vector)).mul(r.inverse()).toVector();
    }

    /**
     * Rotate a vector theta degrees around an axis.
     * 
     * @param vector
     *            Vector
     * @param axis
     *            Axis Vector
     * @param deg
     *            Degrees
     * @return Rotated Vector
     */
    public static Vec rotate(Vec vector, Vec axis, double deg) {
        return Quaternion.rotate(vector, Quaternion.rotation(deg, axis));
    }

    /**
     * Create quaternion from a vector.
     * 
     * @param vector
     *            Vector from
     * @return Quaternion value
     */
    public static Quaternion from(Vec vector) {
        return new Quaternion(0, vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Create a rotation quaternion from theta and an axis.
     * 
     * @param deg
     *            Degrees
     * @param axis
     *            Axis Vector
     * @return Rotated Quaternion
     */
    public static Quaternion rotation(double deg, Vec axis) {
        axis = axis.normalize();
        deg = Math.toRadians(deg / 2);
        double sd = Math.sin(deg);
        return new Quaternion(Math.cos(deg), axis.getX() * sd, axis.getY() * sd, axis.getZ() * sd);
    }

    /**
     * Returns a Vector value of the Quaternion
     * 
     * @return Vector value
     */
    public Vec toVector() {
        return new Vec(x, y, z);
    }

    /**
     * Inverses the Quaternion
     * 
     * @return Inversed Quaternion
     */
    public Quaternion inverse() {
        double l = w * w + x * x + y * y + z * z;
        return new Quaternion(w / l, -x / l, -y / l, -z / l);
    }

    /**
     * 
     * @return Conjugate of the Quaternion
     */
    public Quaternion conjugate() {
        return new Quaternion(w, -x, -y, -z);
    }

    /**
     * Multiply this quaternion and another.
     * 
     * @param r
     *            Quaternion to multiply with
     * @return the Hamilton product of this quaternion and r.
     */
    public Quaternion mul(Quaternion r) {
        double n0 = r.w * w - r.x * x - r.y * y - r.z * z;
        double n1 = r.w * x + r.x * w + r.y * z - r.z * y;
        double n2 = r.w * y - r.x * z + r.y * w + r.z * x;
        double n3 = r.w * z + r.x * y - r.y * x + r.z * w;
        return new Quaternion(n0, n1, n2, n3);
    }

    /**
     * 
     * @return W value
     */
    public double getW() {
        return w;
    }

    /**
     * 
     * @return X value
     */
    public double getX() {
        return x;
    }

    /**
     * 
     * @return Y value
     */
    public double getY() {
        return y;
    }

    /**
     * 
     * @return Z value
     */
    public double getZ() {
        return z;
    }
}