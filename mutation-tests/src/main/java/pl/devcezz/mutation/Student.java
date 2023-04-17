package pl.devcezz.mutation;

public class Student {

    enum Status {
        SLACKER, REGULAR, OUTSTANDING
    }

    private final Status status;

    Student(Status status) {
        this.status = status;
    }

    boolean isSlacker() {
        return status == Status.SLACKER;
    }

    boolean isOutstanding() {
        return status == Status.OUTSTANDING;
    }
}
