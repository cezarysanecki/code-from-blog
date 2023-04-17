package pl.devcezz.mutation;

public class GradeCalculator {

    enum Grade {
        TWO(2.0),
        THREE(3.0),
        THREE_AND_HALF(3.5),
        FOUR(4.0),
        FOUR_AND_HALF(4.5),
        FIVE(5.0);

        private final double value;

        Grade(double value) {
            this.value = value;
        }

        double getValue() {
            return value;
        }

        Grade increaseByHalf() {
            return switch (this) {
                case TWO -> THREE;
                case THREE -> THREE_AND_HALF;
                case THREE_AND_HALF -> FOUR;
                case FOUR -> FOUR_AND_HALF;
                case FOUR_AND_HALF -> FIVE;
                default -> FIVE;
            };
        }
    }

    public Grade calculate(double percentage, Student student) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException(
                    "percentage must be value between 0 and 100");
        }

        if (student.isSlacker()) {
            return Grade.TWO;
        }

        Grade grade = resolveGrade(percentage);

        if (student.isOutstanding()) {
            return grade.increaseByHalf();
        }
        return grade;
    }

    private Grade resolveGrade(double percentage) {
        if (percentage < 50) {
            return Grade.TWO;
        } else if (percentage < 60) {
            return Grade.THREE;
        } else if (percentage < 70) {
            return Grade.THREE_AND_HALF;
        } else if (percentage < 80) {
            return Grade.FOUR;
        } else if (percentage < 95) {
            return Grade.FOUR_AND_HALF;
        } else {
            return Grade.FIVE;
        }
    }
}
