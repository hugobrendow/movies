package br.com.letscode.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieOmdb {
    private String imdbID;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Director")
    private String director;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Poster")
    private String poster;
    @JsonProperty("Runtime")
    private String runtime;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("Rated")
    private String rated;
}
