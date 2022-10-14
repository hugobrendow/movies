package br.com.letscode.movies.dto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoExample {
    public static void main(String[] args) {
        System.out.println("Executing...");
        getMovies().subscribe();
    }

    public static Mono<MovieOmdb> getMovie() {
        // R2DBC - Driver SQL
        Mono<MovieOmdb> monoMovie = Mono.just(new MovieOmdb()).log();
        return monoMovie;
    }

    public static Flux<MovieOmdb> getMovies() {
        return Flux.just(
                        new MovieOmdb("imdb", "Homem Aranha", "2021", "Dramatic", "Hugo", "R", "teste", "93 min", "pt", "20"),
                        new MovieOmdb("imdb2", "Homem Aranha 2", "2022", "Dramatic", "Hugo", "R", "teste", "93 min", "pt", "20")
                )
                .doOnNext(it -> System.out.println("Aqui estou carregando " + it.getTitle()))
                .doOnComplete(() -> getMovies2())
                .log();
    }

    private static void getMovies2() {
        System.out.println("Finalizei o fluxo...");
    }

}
