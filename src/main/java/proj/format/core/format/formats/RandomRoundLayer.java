package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.general.CircleCalculator;
import proj.format.core.utilities.general.Randoms;
import proj.format.core.utilities.objects.Loc;

public class RandomRoundLayer implements IFormat {

    @Override
    public String getString() {
        return "RANDOM_ROUND_LAYER";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 1, frame, 1.0, 0.0);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth) {
        List<Loc> loc = new ArrayList<Loc>();
        int n = 0;
        for(;n <= many;){
            double radius = Math.sqrt(Randoms.randomDouble(0.0, width));
            int point =  Randoms.randomInt(0, rate);
            
            double[] positions = CircleCalculator.getPoint(radius, rate, point);
            loc.add(new Loc(location.getX() + positions[0], location.getY(), location.getZ() + positions[1]));
            
            n++;
        }
        return loc;
    }

}
