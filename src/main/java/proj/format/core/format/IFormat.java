package proj.format.core.format;

import java.util.List;

import proj.format.core.utilities.objects.Loc;

public interface IFormat {
    
    /**
     * 
     * @return Name of the format
     */
    public String getString();
    
    /**
     * 
     * @param location Location center
     * @param mod Integer modifier used to slightly adjust the positioning of the format
     * @return Locations of a single "frame" of the format
     */
    public List<Loc> getLocs(Loc location, Integer frame);
    
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
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double higth);
    
}