package testdriven.tdd.testing;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ActivityCalculatorTest {


    @Test
    void should_ReturnBad_When_AvgBelow20() {

        // given
        int weeklyCardiomMins = 100;
        int weeklyCardioSession = 19;
        //when
        final String performance = ActivityCalculator.rateActivityLevel(weeklyCardiomMins, weeklyCardioSession);
        //then

        Assertions.assertEquals("Bad", performance);
    }

    @Test
    void should_ReturnAvg_When_AvgBetween20To40() {
    }

    @Test
    void should_ReturnBad_When_AvgGreaterThan40() {
    }

    @Test
    void should_ThrowException_When_InputisZero() {

        // given
        int weeklyCardiomMins = 0;
        int weeklyCardioSession = 0;
        //when
        Executable executable = () -> ActivityCalculator.rateActivityLevel(weeklyCardiomMins, weeklyCardioSession);
        //then

        Assertions.assertThrows(RuntimeException.class, executable);
    }

}