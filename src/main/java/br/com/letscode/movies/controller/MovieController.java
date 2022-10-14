package br.com.letscode.movies.controller;

import br.com.letscode.movies.dto.MovieOmdb;
import br.com.letscode.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/movies")
public class MovieController {

    /*
        << Cinema do Itaú é muito bom >>
        1. Filtrar filmes por ano ou nome
     */

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Mono<MovieOmdb> filterByImdbId(@RequestParam("imdbID") String imdbID) {
        Mono<MovieOmdb> movieDetails = movieService.getMovieDetails(imdbID);
        return movieService.getMovieDetails(imdbID);
    }

    @GetMapping(value = "/2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieOmdb> listAll() {
        return Flux.just(
                        new MovieOmdb("imdb", "Homem Aranha", "2022", "Dramatic", "Hugo", "R", "teste", "93 min", "pt", "20"),
                        new MovieOmdb("imdb2", "Homem Aranha 2", "2023", "Dramatic", "Hugo", "R", "teste", "93 min", "pt", "20"))
                .log()
                .delaySequence(Duration.ofSeconds(2));
    }

    @GetMapping(value = "/3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieOmdb> listAll2() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(val -> new MovieOmdb("imdb" + val, "Homem Aranha" + val, "2022", "Dramatic", "Hugo", "R", "teste", "93 min", "pt", "20"));
    }


}
