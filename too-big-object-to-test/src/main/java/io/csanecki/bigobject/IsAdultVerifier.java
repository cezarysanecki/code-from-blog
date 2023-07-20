package io.csanecki.bigobject;

public final class IsAdultVerifier {

  public static final int ADULT_AGE = 18;

  private IsAdultVerifier() {
  }

  public static boolean isAdult(BigObject bigObject) {
    return bigObject.getAge() >= ADULT_AGE;
  }

  public static boolean isAdult(int age) {
    return age >= ADULT_AGE;
  }

  public static boolean isAdult(AgeProvider ageProvider) {
    return ageProvider.getAge() >= ADULT_AGE;
  }

}
