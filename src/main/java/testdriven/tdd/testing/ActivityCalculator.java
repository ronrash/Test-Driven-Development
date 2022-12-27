package testdriven.tdd.testing;

public class ActivityCalculator {

    public static String rateActivityLevel(int weeklyCardiomMins,int weeklyCardioSession){

        if(weeklyCardiomMins<=0)
            throw new RuntimeException("Cannod be zero");

        if(weeklyCardioSession<20)
        return "Bad";

         else if ( weeklyCardiomMins<40) {
            return "Average";
        }


         return "good";
    }
}
