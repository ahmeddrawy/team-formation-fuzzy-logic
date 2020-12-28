package FuzzyLogic;

import java.util.HashMap;

public class Intiator {
    FuzzyArray Funding = null;
    FuzzyArray Expertise = null;
    Intiator(){
        HashMap<Enum<?> , FuzzyCategory> funding = initFunding();
        HashMap<Enum<?> , FuzzyCategory> expertise = initExpertise();
        Funding = new FuzzyArray(4,funding);
        Expertise = new FuzzyArray(3,expertise);
    }
    public static HashMap<Enum<?>, FuzzyCategory> initFunding(){
        HashMap<Enum<?> , FuzzyCategory> arr =new HashMap<>();
        arr.put(Fuzzy.Funding.VERY_LOW,new FuzzyCategory(4,new double[]{0,0,10,30}));
        arr.put(Fuzzy.Funding.LOW,new FuzzyCategory(4,new double[]{10,30,40,60}));
        arr.put(Fuzzy.Funding.MEDIUM,new FuzzyCategory(4,new double[]{40,60,70,90}));
        arr.put(Fuzzy.Funding.HIGH,new FuzzyCategory(4,new double[]{70,90,100,100}));
        return arr;
    }
    public static HashMap<Enum<?>, FuzzyCategory> initExpertise(){
        HashMap<Enum<?> , FuzzyCategory> arr =new HashMap<>();
        arr.put(Fuzzy.Expertise.BEGINNER,new FuzzyCategory(3,new double[]{0,15,30}));
        arr.put(Fuzzy.Expertise.INTERMEDIATE,new FuzzyCategory(3,new double[]{15,30,45}));
        arr.put(Fuzzy.Expertise.EXPERT,new FuzzyCategory(3,new double[]{30,60,60}));
        return arr;
    }

    public FuzzyArray getExpertise() {
        return Expertise;
    }

    public FuzzyArray getFunding() {
        return Funding;
    }
}
