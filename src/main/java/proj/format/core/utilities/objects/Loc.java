package proj.format.core.utilities.objects;

import lombok.Getter;
import lombok.Setter;

public class Loc {

    @Getter
    @Setter
    private Double x;

    @Getter
    @Setter
    private Double y;

    @Getter
    @Setter
    private Double z;

    @Getter
    @Setter
    private Float yaw;

    @Getter
    @Setter
    private Float pitch;

    @Getter
    @Setter
    private Vec vector;

    /**
     * 
     * @param x
     *            X
     * @param y
     *            Y
     * @param z
     *            Z
     * @param yaw
     *            Yaw of looking direction
     * @param pitch
     *            Pitch of looking direction
     */
    public Loc(double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    /**
     * 
     * @param x
     *            X
     * @param y
     *            Y
     * @param z
     *            Z
     */
    public Loc(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = 0.0f;
        this.pitch = 0.0f;
    }

    /**
     * @return A duplicated Loc object
     */
    public Loc clone() {
        return new Loc(x, y, z, yaw, pitch);
    }

    /**
     * Subtracts the specified amounts
     * 
     * @param x
     *            to X
     * @param y
     *            to Y
     * @param z
     *            to Z
     */
    public void subtract(double x, double y, double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
    }

    /**
     * Adds the specified amounts
     * 
     * @param x
     *            to X
     * @param y
     *            to Y
     * @param z
     *            to Z
     */
    public void add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    /**
     * 
     * @return A vector based off of Yaw and Pitch
     */
    public Vec getDirection() {
        Vec vector = new Vec();

        double rotX = this.getYaw();
        double rotY = this.getPitch();

        vector.setY(-Math.sin(Math.toRadians(rotY)));

        double xz = Math.cos(Math.toRadians(rotY));

        vector.setX(-xz * Math.sin(Math.toRadians(rotX)));
        vector.setZ(xz * Math.cos(Math.toRadians(rotX)));

        return vector;
    }

    /**
     * 
     * @return A vector based off of the location
     */
    public Vec toVector() {
        return new Vec(x, y, z);
    }

    public Loc add(Loc loc) {
        this.x += loc.x;
        this.y += loc.y;
        this.z += loc.z;
        return this;
    }

    /**
     * 
     * @param loc
     *            Loc to compare against
     * @return true if Locations are similar (not including direction)
     */
    public boolean matchesLoc(Loc loc) {
        if (this.x.equals(loc.getX())) {
            if (this.y.equals(loc.getY())) {
                if (this.z.equals(loc.getZ())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param loc
     *            Loc to compare against
     * @return true if Locations are similar including direction
     */
    public boolean matchesLocAndDirection(Loc loc) {
        if (this.x.equals(loc.getX())) {
            if (this.y.equals(loc.getY())) {
                if (this.z.equals(loc.getZ())) {
                    if (this.yaw.equals(loc.getYaw())) {
                        if (this.pitch.equals(loc.getPitch())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
