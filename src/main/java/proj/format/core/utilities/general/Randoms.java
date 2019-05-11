package proj.format.core.utilities.general;

import java.util.Random;

public class Randoms {

    /**
     * Random generator
     */
    public static Random r = new Random();

    /**
     * 
     * @param min
     *            Minimum amount
     * @param max
     *            Maximum amount
     * @return Value in specified range
     */
    public static int randomInt(int min, int max) {
        return r.nextInt(max - min) + min;
    }

    /**
     * 
     * @param min
     *            Minimum amount
     * @param max
     *            Maximum amount
     * @return Value in specified range
     */
    public static double randomDouble(double min, double max) {
        return min + (max - min) * r.nextDouble();
    }

}
