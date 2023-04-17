package pl.devcezz.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    GradeCalculator gradeCalculator = new GradeCalculator();

    @Test
    void shouldGetTwoIfSlacker() {
        Student slacker = aStudent(Student.Status.SLACKER);

        GradeCalculator.Grade grade = gradeCalculator.calculate(100, slacker);

        assertEquals(GradeCalculator.Grade.TWO, grade);
    }

    @Test
    void shouldGetThreeIfPercentageIsFifty() {
        Student regular = aStudent(Student.Status.REGULAR);

        GradeCalculator.Grade grade = gradeCalculator.calculate(50, regular);

        assertEquals(GradeCalculator.Grade.THREE, grade);
    }

    @Test
    void shouldGetFiveIfPercentageIsEightyAndIsOutstanding() {
        Student outstanding = aStudent(Student.Status.OUTSTANDING);

        GradeCalculator.Grade grade = gradeCalculator.calculate(80, outstanding);

        assertEquals(GradeCalculator.Grade.FIVE, grade);
    }

    @Test
    void shouldFailWhenPercentageIsBelowZero() {
        Student regular = aStudent(Student.Status.REGULAR);

        assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculate(-23, regular));
    }

    @Test
    void shouldFailWhenPercentageIsAboveOneHundred() {
        Student regular = aStudent(Student.Status.REGULAR);

        assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculate(123, regular));
    }

    Student aStudent(Student.Status status) {
        return new Student(status);
    }
}