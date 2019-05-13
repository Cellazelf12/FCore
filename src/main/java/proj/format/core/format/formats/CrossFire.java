package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.general.CircleCalculator;
import proj.format.core.utilities.objects.Loc;

public class CrossFire implements IFormat {

    @Override
    public String getString() {
        return "CROSS_FIRE";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 1, frame, 1.0, 1.0);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double height) {
        List<Loc> list = new ArrayList<Loc>();
        double[] positions;
        
        //Height modifier for both rings... (Seperation from eachother)
        Double mod = 2.0 / rate; //if rate == 32 || mod = 0.0625
        Double mod2 = (double) (rate / 2); // if rate == 32 || mod2 = 16
        double n = frame;
        double h = frame * mod;
        if (frame > (mod2 - 1)) {
            n = mod2 - (frame - (mod2 - 1));
            h = n * mod;
        }
        
        //Gets the "frame" of the circle, and adjusts the location
        positions = CircleCalculator.getPoint(width, rate, frame);
        list.add(new Loc(location.getX() + positions[0], location.getY() + h, location.getZ() + positions[1]));

        // Reverser Method
        Double o = 0.0;
        if (frame > (mod2 - 1))
            for (o = 0.0; frame < rate; o++)
                frame++;
        else
            for (o = (mod2 - 1); frame < mod2; o++)
                frame++;

        // Get Opposite Side
        positions = CircleCalculator.getPoint(width, rate, (o.intValue() + mod2.intValue()));
        list.add(new Loc(location.getX() + positions[0], location.getY() + h, location.getZ() + positions[1]));
        
        return list;
    }

}