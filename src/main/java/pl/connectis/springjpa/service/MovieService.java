package pl.connectis.springjpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.connectis.springjpa.domain.Movie;
import pl.connectis.springjpa.domain.MovieCategory;

import java.util.Optional;

public interface MovieService {

    Long createMovie(String title, MovieCategory category, Integer length, String description, Integer requiredAge, String posterFilePath);

    Optional<Movie> getMovie(Long movieId);

    Page<Movie> getMoviesInCategory(MovieCategory category, Pageable pageable);

    Page<Movie> getMoviesByPartOfTitle(String partOfTitle, Pageable pageable);

    Page<Movie> getAllMovies(Pageable pageable);

    void updateMovie(Long movieId, String title, MovieCategory category, Integer length, String description, Integer requiredAge);

    void removeMovie(Long movieId);

}
