package FuzzyLogic;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Intiator intiator = new Intiator();
        FuzzyArray FundingArray = intiator.getFunding();
        FuzzyArray ExpertiseArray = intiator.getExpertise();
        HashMap<Enum<?> ,Double> ret =  FundingArray.calculate(50);
        System.out.println("v low "+ ret.get(Fuzzy.Funding.VERY_LOW));
        System.out.println("low " +ret.get(Fuzzy.Funding.LOW));
        System.out.println( "medium "+ret.get(Fuzzy.Funding.MEDIUM));
        System.out.println("high " +ret.get(Fuzzy.Funding.HIGH));
        HashMap<Enum<?> ,Double> ret2 =  ExpertiseArray.calculate(40);
        System.out.println("Begineer "+ ret2.get(Fuzzy.Expertise.BEGINNER));
        System.out.println( "Intermediate "+ret2.get(Fuzzy.Expertise.INTERMEDIATE));
        System.out.println( "Expert "+ret2.get(Fuzzy.Expertise.EXPERT));
        FuzzyArray Risk = intiator.getRisk();
        double risklow = Math.max((ret.get(Fuzzy.Funding.HIGH)) ,ret2.get(Fuzzy.Expertise.EXPERT));
        double riskNormal =Math.max( Math.min(ret.get(Fuzzy.Funding.MEDIUM),ret2.get(Fuzzy.Expertise.INTERMEDIATE)) ,ret2.get(Fuzzy.Expertise.BEGINNER) );
        double riskHigh = Math.max(ret.get(Fuzzy.Funding.VERY_LOW), Math.min(ret.get(Fuzzy.Funding.LOW),ret2.get(Fuzzy.Expertise.BEGINNER)));
        System.out.println("rish low "+ risklow);
        System.out.println("rish Normal "+ riskNormal);
        System.out.println("risk high " + riskHigh);
        double ans = (risklow *Risk.get(Fuzzy.Risk.LOW).getCentroid() + riskNormal*Risk.get(Fuzzy.Risk.NORMAL).getCentroid() + riskHigh *Risk.get(Fuzzy.Risk.HIGH).getCentroid())/
                (risklow + riskNormal + riskHigh);
        System.out.println("answer "+ ans);

        // write your code here
    }

}
