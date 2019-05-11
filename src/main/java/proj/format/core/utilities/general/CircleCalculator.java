package proj.format.core.utilities.general;

public class CircleCalculator {

    /**
     * 
     * @param radius
     *            Radius of the circle
     * @param points
     *            Points on edge of circle
     * @param point
     *            Starting at 0, going clockwise, the point you want the
     *            location of
     * @return Two points {A, B} to add to your X and Y positions for requested
     *         point
     */
    public static double[] getPoint(double radius, int points, int point) {
        double[] positions = { 0, 0 };

        double pos1 = 0;
        double pos2 = 0;

        double theta = (point * (360 / points)); // Angle

        positions[0] = pos1 + radius * Math.cos(theta * Math.PI / 180F);
        positions[1] = pos2 + radius * Math.sin(theta * Math.PI / 180F);

        return positions;
    }

    /**
     * 
     * @param pos1
     *            Position A (X) of the center of the circle
     * @param pos2
     *            Position B (Y) of the center of the circle
     * @param radius
     *            Radius of the circle
     * @param points
     *            Points on edge of circle
     * @param point
     *            Starting at 0, going clockwise, the point you want the
     *            location of
     * @return Two resulting points {A, B} ({X, Y}) of the requested point
     */
    public static double[] getPoint(double pos1, double pos2, double radius, int points, int point) {
        double[] positions = { 0, 0 };

        double theta = (point * (360 / points)); // Angle

        positions[0] = pos1 + radius * Math.cos(theta * Math.PI / 180F);
        positions[1] = pos2 + radius * Math.sin(theta * Math.PI / 180F);

        return positions;
    }

}
