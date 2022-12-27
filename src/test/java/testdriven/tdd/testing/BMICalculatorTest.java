package testdriven.tdd.testing;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testdriven.tdd.testing.BMICalculator.isDietRecommended;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

    @Test
    void should_ReturnTrue_When_DietRecommended() {
        // given
        double weight = 74.4;
        double height = 1.69;
        // when
        final boolean dietRecommended = isDietRecommended(weight, height);

        //then
        assertTrue(dietRecommended);
    }

    @ParameterizedTest(name="weight={0},height={1}")
    @CsvSource(value = {"74.4,1.69","95.0,1.75","110.0,1.79"})
    void should_ReturnTrue_When_DietRecommendedWithParameterizedTests(double weight,double height) {
        // given
        // when
        final boolean dietRecommended = isDietRecommended(weight, height);

        //then
        assertTrue(dietRecommended);
    }
    @ParameterizedTest(name="weight={0},height={1}")
    @CsvFileSource(resources = "/diet-data.csv",numLinesToSkip = 1)
    void should_ReturnTrue_When_DietRecommendedWithCsvFile(double weight,double height) {
        // given
        // when
        final boolean dietRecommended = isDietRecommended(weight, height);

        //then
        assertTrue(dietRecommended);
    }

    @Test
    void should_ReturnFalse_When_DietRecommended() {
        // given
        double weight = 70.4;
        double height = 1.69;
        // when
        final boolean dietRecommended = isDietRecommended(weight, height);

        //then
        assertFalse(dietRecommended);
    }

    // check for exceptions
    @Test
    void should_ReturnArithmeticException_When_HeightIsZero() {
        // given
        double weight = 70.4;
        double height = 0;
        // when

        //then
        // checks a method throws an exception in junit 5

        assertThrows(ArithmeticException.class, () -> isDietRecommended(weight, height));
    }

    // another way to check if the method throws an exception
    @Test
    void should_ReturnArithmeticException_When_HeightIsZero_new() {
        // given
        double weight = 70.4;
        double height = 0;
        // when
        Executable executable = () -> isDietRecommended(weight, height);

        //then
        // checks a method throws an exception in junit 5

        assertThrows(ArithmeticException.class, executable);
    }


    //Assert All
    @Test
    void should_ReturnWorstBmi_when_CoderListNotEmpty() {

        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(1.82, 64.7));
        // when
        final Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        // then

        // this will check for all the  assertions
        assertAll(
                () -> assertEquals(1.82, coderWithWorstBMI.getHeight()),
                () -> assertEquals(98.0, coderWithWorstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnNull_When_CoderListIsEmpty() {

        // given
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(0, 64.7));
        // when
        Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coderList);
        // then
        assertThrows(ArithmeticException.class, executable);
    }

    // Assert Null Values
    @Test
    void should_ThrowArithmeticException_When_HeightIsZeroForAnyCoderInTheList() {

        // given
        List<Coder> coderList = new ArrayList<>();
        // when
        final Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        // then

        assertNull(coderWithWorstBMI);
    }

    // array equals
    @Test
    void name() {
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.80, 60.0));
        coderList.add(new Coder(1.82, 98.0));
        coderList.add(new Coder(1.82, 64.7));
        double[] expected = new double[]{18.52, 29.59, 19.53};

        final double[] actual = BMICalculator.getBMIScores(coderList);

        assertArrayEquals(expected, actual);

    }
}