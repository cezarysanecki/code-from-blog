package pl.csanecki.webflux.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ClubApi {

    private ClubRepo clubRepo;

    @Autowired
    public ClubApi(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Club> getAllClubs() {
        return clubRepo.findAll()
                .delayElements(Duration.ofMillis(500));
    }
}
