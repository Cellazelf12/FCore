package proj.format.core.utilities.objects;

import lombok.Getter;

public class Vec {

    @Getter
    Double x;

    @Getter
    Double y;

    @Getter
    Double z;

    /**
     * 
     * For locations
     * 
     * @param x
     *            X
     * @param y
     *            Y
     * @param z
     *            Z
     */
    public Vec(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates and empty vector
     */
    public Vec() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    /**
     * 
     * @return Normalized vector
     */
    public Vec normalize() {
        double length = length();

        x /= length;
        y /= length;
        z /= length;

        return this;
    }

    /**
     * 
     * @return Length of vector
     */
    public double length() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    /**
     * 
     * @return Location value
     */
    public Loc toLocation() {
        return new Loc(x, y, z);
    }

    /**
     * @return Duplicate Vector
     */
    public Vec clone() {
        return new Vec(x, y, z);
    }

    /**
     * 
     * @param x
     *            X value
     * @return Current Vector
     */
    public Vec setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * 
     * @param y
     *            Y value
     * @return Current Vector
     */
    public Vec setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * 
     * @param z
     *            Z value
     * @return Current Vector
     */
    public Vec setZ(double z) {
        this.z = z;
        return this;
    }

    /**
     * 
     * @param d
     *            Value to multiply by
     * @return multiplied vector
     */
    public Vec multiply(double d) {
        x *= d;
        y *= d;
        z *= d;
        return this;
    }

    /**
     * 
     * @param vec
     *            Vector to add
     * @return Added vectors
     */
    public Vec add(Vec vec) {
        x += vec.x;
        y += vec.y;
        z += vec.z;
        return this;
    }

}