package pl.csanecki.webflux.club;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClubRepo extends ReactiveMongoRepository<Club, String> {
}
