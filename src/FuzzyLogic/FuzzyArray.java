package FuzzyLogic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/// fuzzy categories
enum Fuzzy {
    ;
    enum Funding{
        VERY_LOW,
        LOW,
        MEDIUM,
        HIGH
    }
    enum Expertise{
        BEGINNER,
        INTERMEDIATE,
        EXPERT
    }
    enum Risk{
        LOW,MEDIUM,HIGH
    }
};
public class FuzzyArray {
    int sz = 0 ;
    HashMap <Enum<?> , FuzzyCategory> arr = new HashMap<>();
    Enum<?> state = null;
    FuzzyArray(int sz,HashMap<Enum<?> , FuzzyCategory> arr){
        this.sz = sz;
        this.arr = arr;


    }
    FuzzyCategory get(Enum<?>state){
        return arr.get(state);
    }
    ///calculate membership in each category and return array
    HashMap<Enum<?> , Double> calculate(double x){
        HashMap<Enum<?> , Double> ret = new HashMap<>();
        Iterator it = arr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            FuzzyCategory fs = (FuzzyCategory) pair.getValue();
            ret.put((Enum<?>) pair.getKey(), fs.inRange(x));
        }
        return ret;
    }

}
