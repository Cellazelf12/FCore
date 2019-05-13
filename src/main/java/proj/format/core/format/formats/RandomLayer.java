package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.general.Randoms;
import proj.format.core.utilities.objects.Loc;

public class RandomLayer implements IFormat {

    @Override
    public String getString() {
        return "RANDOM_LAYER";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 1, frame, 1.0, 0.0);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double height) {
        List<Loc> loc = new ArrayList<Loc>();
        Double totalWidth = width*2;
        int n = 0;
        for(;n <= many;){
            double x = location.getX() - width + Randoms.randomDouble(0.0, totalWidth);
            double y = location.getY();
            double z = location.getZ() - width + Randoms.randomDouble(0.0, totalWidth);
            loc.add(new Loc(x, y, z));
            n++;
        }
        return loc;
    }

}
