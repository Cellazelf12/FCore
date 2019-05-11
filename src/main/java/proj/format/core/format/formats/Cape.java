package proj.format.core.format.formats;

import java.util.List;

import proj.format.core.format.Formats;
import proj.format.core.format.IFormat;
import proj.format.core.utilities.general.DirectionalFormatRetriever;
import proj.format.core.utilities.objects.Loc;
import proj.format.core.utilities.objects.Vec;

public class Cape implements IFormat {
    
    private static boolean o = false;
    private static boolean x = true;
    private static boolean[][] shape = { 
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o },
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o }, 
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o },
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o }, 
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o },
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o }, 
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o },
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o }, 
            { o, o, o, o, o, o, x, x, x, x, o, o, o, o, o, o },
            { o, o, o, o, o, o, x, x, x, x, o, o, o, o, o, o }, 
            { o, o, o, o, o, o, x, x, x, x, o, o, o, o, o, o },
            { o, o, o, o, o, o, x, x, x, x, o, o, o, o, o, o }, 
            { o, o, o, o, o, o, x, x, x, x, o, o, o, o, o, o },
            { o, o, o, o, o, o, x, x, x, x, o, o, o, o, o, o },
            { o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o }, 
            };
    private static List<Vec> points = DirectionalFormatRetriever.shapeToPoints(shape, 1.5, 0.25);

    @Override
    public String getString() {
        return "CAPE";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 0, frame, 0.0, 0.0);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth) {
        return DirectionalFormatRetriever.getLocations(location, points);
    }

}
