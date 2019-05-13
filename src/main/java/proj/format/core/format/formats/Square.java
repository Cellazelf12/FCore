package proj.format.core.format.formats;

import java.util.ArrayList;
import java.util.List;

import proj.format.core.format.IFormat;
import proj.format.core.utilities.objects.Loc;

public class Square implements IFormat {

    @Override
    public String getString() {
        return "SQUARE";
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer frame) {
        return getLocs(location, 32, 2, frame,  0.5, 0.5);
    }

    @Override
    public List<Loc> getLocs(Loc location, Integer rate, Integer many, Integer frame, Double width, Double height) {
        List<Loc> list = new ArrayList<Loc>();
        
        Loc backUp = location.clone();
        
        for(;frame >= rate;){
            frame = frame - rate;
        }
        
        Loc loc;
        
        if(frame < rate*.25){
            loc = setX(location, width, rate, frame, true);
        }else if(frame < rate*.5){
            Double im = frame-(rate*.25);
            loc =  setZ(location, width, rate, im.intValue(), true);
        }else if(frame < rate*.75){
            Double im = frame-(rate*.5);
            loc =  setX(location, width, rate, im.intValue(), false);
        }else{
            Double im = frame-(rate*.75);
            loc =  setZ(location, width, rate, im.intValue(), false);
        }
            

        loc.setY(loc.getY() + height);
        
        
        list.add(loc);
        
        if (many > 1) {
            
            Double d = frame + (rate*0.5);
            frame = d.intValue();
            
            for(;frame > rate;){
                frame = frame - rate;
            }
            
            Loc locc;
            
            if(frame < rate*.25){
                locc = setX(backUp, width, rate, frame, true);
            }else if(frame < rate*.5){
                Double im = frame-((rate*.25)-1);
                locc =  setZ(backUp, width, rate, im.intValue(), true);
            }else if(frame < rate*.75){
                Double im = frame-((rate*.5)-1);
                locc =  setX(backUp, width, rate, im.intValue(), false);
            }else{
                Double im = frame-((rate*.75)-1);
                locc =  setZ(backUp, width, rate, im.intValue(), false);
            }
            
            locc.setY(locc.getY() + height);
            
            list.add(locc);
            
        }

        return list;
      }
    
    
    public Loc setX(Loc location, Double width, Integer rate, Integer im, boolean goingNegative){
        
        Double length = width*2;
        Double bitsPerLength = (rate * 0.25);
        Double bitSize = length / bitsPerLength;
        Double incTotal = bitSize*im;
        
        Double x = location.getX();
        Double z = location.getZ();
        
        
        if(goingNegative){
            z = z + width;
            x = x + width;
            x = x-incTotal;
        }else{
            z = z - width;
            x = x - width;
            x = x+incTotal;
        }
        location.setX(x);
        location.setZ(z);
        
        return location;
    }
    
    
    public Loc setZ(Loc location, Double width, Integer rate, Integer im, boolean goingNegative){
        
        Double length = width*2;
        Double bitsPerLength = (rate * 0.25);
        Double bitSize = length / bitsPerLength;
        Double incTotal = bitSize*im;
        
        Double x = location.getX();
        Double z = location.getZ();
        
        
        if(goingNegative){
            x = x - width;
            z = z + width;
            z = z-incTotal;
        }else{
            x = x + width;
            z = z - width;
            z = z+incTotal;
        }
        
        location.setX(x);
        location.setZ(z);
        
        return location;
    }

}
