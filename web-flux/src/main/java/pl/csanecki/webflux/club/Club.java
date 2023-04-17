package pl.csanecki.webflux.club;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Club {

    @MongoId
    private String id;
    private String name;

    public Club(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
