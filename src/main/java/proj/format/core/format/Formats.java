package proj.format.core.format;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.formats.Cape;
import proj.format.core.format.formats.CrossFire;
import proj.format.core.format.formats.Exact;
import proj.format.core.format.formats.Hat;
import proj.format.core.format.formats.Helix;
import proj.format.core.format.formats.Random;
import proj.format.core.format.formats.RandomLayer;
import proj.format.core.format.formats.RandomRoundLayer;
import proj.format.core.format.formats.Square;
import proj.format.core.format.formats.Wing;
import proj.format.core.format.formats.XYCircle;
import proj.format.core.format.formats.XZCircle;
import proj.format.core.format.formats.YZCircle;
import proj.format.core.utilities.objects.Loc;

public enum Formats {
    
    NONE(null),
    RANDOM(new Random()),
    RANDOM_LAYER(new RandomLayer()), 
    RANDOM_ROUND_LAYER(new RandomRoundLayer()), 
    EXACT(new Exact()),
    SQUARE(new Square()),
    CROSS_FIRE(new CrossFire()),
    HELIX(new Helix()),
    WING(new Wing()),
    HAT(new Hat()),
    CAPE(new Cape()),
    XY_CIRCLE(new XYCircle()),
    XZ_CIRCLE(new XZCircle()),
    YZ_CIRCLE(new YZCircle()),
    ;
    
    private IFormat format;
    
    Formats(IFormat format) {
        this.format = format;
    }
    
    /**
     * 
     * @return List of all formats
     */
    public static List<String> getFormats() {
        Formats[] formats = Formats.values();
        List<String> list = new ArrayList<String>();
        for(Formats ifv : formats) {
            list.add(ifv.getString().toUpperCase());
        }
        return list;
    }
    
    /**
     * 
     * @param format Format name
     * @return IFormat value of format
     */
    public static Formats getFormat(String format){
        format = format.toUpperCase();
        for(Formats formats : Formats.values()){
            if(formats.getString().toUpperCase().equals(format)){
                return formats;
            }
        }
        return NONE;
    }
    
    /**
     * 
     * @param format Format name
     * @return If format exists
     */
    public static boolean exists(String format){
        for(Formats formats: Formats.values()){
            if(formats.getString().equalsIgnoreCase(format)){
                return true;
            }
        }
        return false;
    }

    
    /**
     * 
     * @return Name of the format
     */
    public String getString() {
        return format.getString();
    }

    
    /**
     * 
     * @return Name of the format
     */
    public String getName() {
        return format.getString();
    }

    
    /**
     * 
     * @return Name of the format
     */
    @Override
    public String toString() {
        return format.getString();
    }
    
    /**
     * 
     * @param location Location center
     * @param mod Integer modifier used to slightly adjust the positioning of the format
     * @return Locations of a single "frame" of the format
     */
    public List<Loc> getLocs(Loc location, Integer frame){
        return format.getLocs(location, frame);
    }
    
    /**
     * 
     * @param location Location center
     * @param rate Used with 'loopable' formats to define the "definition" of the format
     * @param many Used to specify return amount of duplicated locations, or amount of organized locations
     * @param frame Gets the "Frame" of the format (0-[rate-1])
     * @param width Width or Length of the format (modifies both X and Z coordinates)
     * @param higth Height of the format (will not change Y center location)
     * @return List of locations for specified frame of the format with other specified details
     */
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth) {
        return format.getLocs(location, rate, many, frame, width, higth);
    }

}
