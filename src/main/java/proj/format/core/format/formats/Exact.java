package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.objects.Loc;

public class Exact implements IFormat {

    @Override
    public String getString() {
        return "EXACT";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 0, frame, 0.0, 0.0);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth) {
        List<Loc> locs = new ArrayList<Loc>();
        Double y = location.getY() + higth;
        for(int i = 0; i <= Math.abs(many); i++)
            locs.add(new Loc(location.getX(), y, location.getZ(), location.getYaw(), location.getPitch()));
        return locs;
    }

}
