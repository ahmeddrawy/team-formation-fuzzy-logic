package FuzzyLogic;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fund = scanner.nextInt(); // 50
        int expertise = scanner.nextInt(); /// 40
        Intiator intiator = new Intiator();
        FuzzyArray FundingArray = intiator.getFunding();
        FuzzyArray ExpertiseArray = intiator.getExpertise();
        HashMap<Enum<?> ,Double> ret =  FundingArray.calculate(fund);
        System.out.println("v low "+ ret.get(Fuzzy.Funding.VERY_LOW));
        System.out.println("low " +ret.get(Fuzzy.Funding.LOW));
        System.out.println( "medium "+ret.get(Fuzzy.Funding.MEDIUM));
        System.out.println("high " +ret.get(Fuzzy.Funding.HIGH));
        HashMap<Enum<?> ,Double> ret2 =  ExpertiseArray.calculate(expertise);
        System.out.println("Begineer "+ ret2.get(Fuzzy.Expertise.BEGINNER));
        System.out.println( "Intermediate "+ret2.get(Fuzzy.Expertise.INTERMEDIATE));
        System.out.println( "Expert "+ret2.get(Fuzzy.Expertise.EXPERT));
        FuzzyArray Risk = intiator.getRisk();
        double risklow = Math.max((ret.get(Fuzzy.Funding.HIGH)) ,ret2.get(Fuzzy.Expertise.EXPERT));
        double riskNormal =Math.min(ret.get(Fuzzy.Funding.MEDIUM), Math.max(ret2.get(Fuzzy.Expertise.INTERMEDIATE),ret2.get(Fuzzy.Expertise.BEGINNER)) );
        double riskHigh = Math.max(ret.get(Fuzzy.Funding.VERY_LOW), Math.min(ret.get(Fuzzy.Funding.LOW),ret2.get(Fuzzy.Expertise.BEGINNER)));
        System.out.println("rish low "+ risklow);
        System.out.println("rish Normal "+ riskNormal);
        System.out.println("risk high " + riskHigh);
        double ans = (risklow *Risk.get(Fuzzy.Risk.LOW).getCentroid() + riskNormal*Risk.get(Fuzzy.Risk.NORMAL).getCentroid() + riskHigh *Risk.get(Fuzzy.Risk.HIGH).getCentroid())/
                (risklow + riskNormal + riskHigh);
        System.out.println("answer "+ ans);
        HashMap<Enum<?> , Double> riskCal = Risk.calculate(ans);
        System.out.println("membership in low "+riskCal.get(Fuzzy.Risk.LOW));
        System.out.println("membership in normal "+riskCal.get(Fuzzy.Risk.NORMAL));
        System.out.println("membership in high "+riskCal.get(Fuzzy.Risk.HIGH));
        if(riskCal.get(Fuzzy.Risk.LOW) >= riskCal.get(Fuzzy.Risk.NORMAL) && riskCal.get(Fuzzy.Risk.LOW) >= riskCal.get(Fuzzy.Risk.HIGH)){
            System.out.println("Risk is low");
        }
        else if(riskCal.get(Fuzzy.Risk.NORMAL) >= riskCal.get(Fuzzy.Risk.LOW) && riskCal.get(Fuzzy.Risk.NORMAL) >=riskCal.get(Fuzzy.Risk.HIGH)){
            System.out.println("Risk is Normal");
        }
        else {
            System.out.println("Risk is High");
        }

        // write your code here
    }

}
