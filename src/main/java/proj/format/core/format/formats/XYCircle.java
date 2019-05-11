package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.general.CircleCalculator;
import proj.format.core.utilities.objects.Loc;

public class XYCircle implements IFormat {

    @Override
    public String getString() {
        return "XY_CIRCLE";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 2, frame, 1.0, 0.0);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth) {
        List<Loc> list = new ArrayList<Loc>();
        
        //
        double [] positions;
        
        positions = CircleCalculator.getPoint(width, rate, frame);
        list.add(new Loc(location.getX() + positions[0], location.getY() + positions[1], location.getZ()));
        
        if(many > 0) {
            frame = frame + (rate/2);
            if(frame >= rate)
                frame = frame - rate;
            
            positions = CircleCalculator.getPoint(width, rate, frame);
            list.add(new Loc(location.getX() + positions[0], location.getY() + positions[1], location.getZ()));
        }
        
        return list;
      }

}
