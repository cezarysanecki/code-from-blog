package pl.devcezz;

class Human {

    private final int age;

    Human(final int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String greet() {
        if (age < 1) {
            return "Gugu";
        } else if (age < 5) {
            return "Hi";
        } else if (age < 18) {
            return "Yo!";
        } else if (age < 26) {
            return "G’day";
        } else {
            return "Good morning";
        }
    }
}
