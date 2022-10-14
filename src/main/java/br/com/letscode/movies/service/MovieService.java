package br.com.letscode.movies.service;

import br.com.letscode.movies.dto.MovieOmdb;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class MovieService {
    private WebClient webClient;

    public MovieService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://www.omdbapi.com")
                .build();
    }

    public Mono<MovieOmdb> getMovieDetails(String imdbID) {
        Mono<MovieOmdb> movieOmdbMono = this.webClient
                .get()
                .uri("/?apikey=f9d0fd06&i=".concat(imdbID))
                .retrieve()
                .bodyToMono(MovieOmdb.class)
                .delayElement(Duration.ofSeconds(1));
        return movieOmdbMono;
    }

}
