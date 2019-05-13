package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.general.Randoms;
import proj.format.core.utilities.objects.Loc;

public class Random implements IFormat {

    @Override
    public String getString() {
        return "RANDOM";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 0, frame, 1.0, 2.0);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double height) {
        List<Loc> loc = new ArrayList<Loc>();
        Double totalWidth = width*2;
        Double totalLength = width*2;
        Double totalHigth = width*2;
        int n = 0;
        for(;n <= Math.abs(many);n++){
            loc.add(
                    new Loc(
                            location.getX() - width + Randoms.randomDouble(0.0, totalWidth), 
                            location.getY() - height + Randoms.randomDouble(0.0, totalHigth), 
                            location.getZ() - width + Randoms.randomDouble(0.0, totalLength)));
        }
        return loc;
    }

}
