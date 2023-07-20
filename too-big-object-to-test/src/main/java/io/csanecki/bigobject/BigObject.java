package io.csanecki.bigobject;

public class BigObject implements AgeProvider {

  private final String name;

  private final int age;

  private final String street;

  private final String city;

  private final String country;

  public BigObject(String name, int age, String street, String city, String country) {
    this.name = name;
    this.age = age;
    this.street = street;
    this.city = city;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }
}
