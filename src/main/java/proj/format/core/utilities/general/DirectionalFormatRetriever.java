package proj.format.core.utilities.general;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.utilities.objects.Loc;
import proj.format.core.utilities.objects.Vec;

public class DirectionalFormatRetriever {
    
    /**
     * Gets all locations of the effect
     * @param location Location center
     * @param points Original points of the shape to be moved/rotated
     * @return Adjusted locations
     */
    public static List<Loc> getLocations(Loc location, List<Vec> points){
        List<Loc> toPlayLocations = new ArrayList<>();
        double distanceOutFromCenter = 0.25;
        double yModifier = 1.0;
        Quaternion rot = Quaternion.rotation(location.getYaw(), new Vec(0.0, 1.0, 0.0));
        Vec origin = location.toVector();
        Vec direction = location.getDirection().setY(0.0).normalize();
        Vec pointt = direction.clone().normalize().multiply(-distanceOutFromCenter).add(origin);
        Loc loc = pointt.toLocation();
        loc.subtract(0, 0.4, 0);
        points.forEach(vector -> {
            Vec point = Quaternion.rotate(vector, rot);
            toPlayLocations.add(point.toLocation().add(loc));
        });
        for(Loc playLoc : toPlayLocations){
            playLoc.add(0.0, yModifier, 0.0);
        }
        return toPlayLocations;
    }

    /**
     * Shapes a boolean double array to a shape
     * @param shape boolean double array
     * @param space Spacing between points in the shape
     * @param slantModifier angle modifier
     * @return Points of the shape
     */
    public static List<Vec> shapeToPoints(boolean[][] shape, double space, double slantModifier) {
        List<Vec> list = new ArrayList<>();
        for (int r = 0; r < shape.length; r++) {
            boolean[] row = shape[r];
            double y = r * -2 / (double) (shape.length - 1) + 1;
            double z = (y * space) * (slantModifier);
            for (int c = 0; c < row.length; c++) {
                if (row[c]) {
                    double x = c * 2 / (double) (row.length - 1) - 1;
                    list.add(new Vec(x * space, y * space, z));
                }
            }
        }
        return list;
    }
    
}