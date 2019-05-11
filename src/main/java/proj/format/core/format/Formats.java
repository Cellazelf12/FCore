package proj.format.core.format;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public enum Formats {
    
    NONE(null),
//    RANDOM(new Random()),
//    RANDOM_LAYER(new RandomLayer()), 
//    RANDOM_ROUND_LAYER(new RandomRoundLayer()), 
//    EXACT(new Exact()),
//    SQUARE(new Square()),
////    PENNY(new Penny()),
//    CROSS_FIRE(new CrossFire()),
//    HELIX(new Helix()),
////    FIREFLY(new Firefly()),
//    WING(new Wing()),
//    HAT(new Hat()),
//    CAPE(new Cape()),
//    XY_CIRCLE(new XYCircle()),
//    XZ_CIRCLE(new XZCircle()),
//    YZ_CIRCLE(new YZCircle()),
    ;
    
    @Getter
    private IFormat format;
    
    Formats(IFormat format) {
        this.format = format;
    }
    
    public static List<String> getFormats() {
        Formats[] formats = Formats.values();
        List<String> list = new ArrayList<String>();
        for(Formats ifv : formats) {
            list.add(ifv.getFormat().getString().toUpperCase());
        }
        return list;
    }
    
    public static IFormat getFormat(String format){
        format = format.toUpperCase();
        for(Formats iformat : Formats.values()){
            if(iformat.getFormat().getString().toUpperCase().equals(format)){
                return iformat.getFormat();
            }
        }
        return NONE.getFormat();
    }
    
    public static boolean exists(String format){
        for(Formats iformats: Formats.values()){
            if(iformats.getFormat().getString().equalsIgnoreCase(format)){
                return true;
            }
        }
        return false;
    }
    
    public String getName() {
        return format.getString();
    }
    
    @Override
    public String toString() {
        return format.getString();
    }

}
