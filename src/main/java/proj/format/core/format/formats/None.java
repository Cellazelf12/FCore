package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.objects.Loc;

public class None implements IFormat {

    @Override
    public String getString() {
        return "NONE";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 0, 0, frame, 0.0, 0.0);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth) {
        return new ArrayList<>();
    }

}
