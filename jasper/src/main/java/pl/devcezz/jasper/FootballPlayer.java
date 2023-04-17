package pl.devcezz.jasper;

public class FootballPlayer {

    private static Long NEXT_ID_PLAYER = 1L;

    private final Long id;
    private final String firstname;
    private final String lastname;
    private final Position position;

    private FootballPlayer(
            Long id,
            String firstname,
            String lastname,
            Position position) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
    }

    public static FootballPlayer of(
            String firstname,
            String lastname,
            Position position) {
        return new FootballPlayer(
                NEXT_ID_PLAYER++,
                firstname,
                lastname,
                position);
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Position getPosition() {
        return position;
    }
}
