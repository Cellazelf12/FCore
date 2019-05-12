package proj.format.core.format;

import java.util.List;

import proj.format.core.utilities.objects.Loc;

public interface IFormat {
    
    public String getString();
    
    public List<Loc> getLocs(Loc location, Integer frame);
    
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth);
    
}