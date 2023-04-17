package pl.csanecki.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.csanecki.webflux.club.Club;
import pl.csanecki.webflux.club.ClubRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DataInitializer {

    private ClubRepo clubRepo;

    @Autowired
    public DataInitializer(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void insertInitialData() {
        clubRepo.deleteAll()
                .thenMany(
                        Flux.just(
                                "Arsenal", "Aston Villa", "Brighton & Hove Albion", "Burnley", "Chelsea", "Crystal Palace", "Everton",
                                "Fulham", "Leeds United", "Leicester City", "Liverpool", "Manchester City", "Manchester United",
                                "Newcastle United", "Sheffield United", "Southampton", "Tottenham Hotspur", "West Bromwich Albion",
                                "West Ham United", "Wolverhampton Wanderers"
                        )
                )
                .map(Club::new)
                .flatMap(clubRepo::save)
                .thenMany(clubRepo.findAll())
                .subscribe(System.out::println);

        Mono.just("FC Barcelona")
                .map(Club::new)
                .flatMap(clubRepo::save)
                .subscribe();
    }
}
