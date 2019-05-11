package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.general.CircleCalculator;
import proj.format.core.utilities.objects.Loc;

public class Helix implements IFormat {

    @Override
    public String getString() {
        return "HELIX";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 2, frame, 1.0, 2.5);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth) {
        List<Loc> list = new ArrayList<Loc>();
        double[] positions;

        frame = getReversedInt(frame, rate);

        Double w = frame * (width / rate);
        Double h = (higth - (frame)) - 1;
        
        positions = CircleCalculator.getPoint(w, rate, frame);
        list.add(new Loc(location.getX() + positions[0], location.getY() + h, location.getZ() + positions[1]));
        
        //Gets opposite side
        if(many > 0) {
            frame = frame + (rate/2);
            if(frame >= rate)
                frame = frame - rate;
            positions = CircleCalculator.getPoint(w, rate, frame);
            list.add(new Loc(location.getX() + positions[0], location.getY() + h, location.getZ() + positions[1]));
        }
        
        return list;
    }

    public int getReversedInt(Integer current, Integer max) {
        Double mod2 = (double) (max / 2);
        Double n = mod2 - (current - (mod2 - 1));
        return n.intValue();
    }

}
