package br.com.letscode.movies.model;

import lombok.Data;

@Data
public class Movie {
    private String imdbID;
    private String title;
    private String year;
    private String genre;
    private String director;
    private String plot;
    private String poster;
    private String runtime;
    private String language;
    private String rated;
}
