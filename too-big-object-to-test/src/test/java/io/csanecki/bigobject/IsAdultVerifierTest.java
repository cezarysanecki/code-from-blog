package io.csanecki.bigobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IsAdultVerifierTest {

  @Test
  void person_of_age_24_is_adult() {
    BigObject bigObject = new BigObject(
        "Jan Kowalski",
        24,
        "Krótka",
        "Kędzierzyn",
        "Polska");

    boolean isAdult = IsAdultVerifier.isAdult(bigObject);

    assertTrue(isAdult);
  }

  @Test
  void age_of_24_means_that_someone_is_adult() {
    boolean isAdult = IsAdultVerifier.isAdult(24);

    assertTrue(isAdult);
  }

  @Test
  void age_provider_with_24_means_that_someone_is_adult() {
    boolean isAdult = IsAdultVerifier.isAdult(() -> 24);

    assertTrue(isAdult);
  }

}