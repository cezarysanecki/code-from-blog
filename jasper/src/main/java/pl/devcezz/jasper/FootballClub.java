package pl.devcezz.jasper;

public class FootballClub {

    private static Long NEXT_ID_CLUB = 1L;

    private final Long id;
    private final String name;
    private final String country;

    private FootballClub(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public static FootballClub of(String name, String country) {
        return new FootballClub(NEXT_ID_CLUB++, name, country);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
