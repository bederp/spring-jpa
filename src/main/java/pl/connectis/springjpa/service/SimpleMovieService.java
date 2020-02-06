package pl.connectis.springjpa.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.connectis.springjpa.domain.Movie;
import pl.connectis.springjpa.domain.MovieCategory;
import pl.connectis.springjpa.domain.Poster;
import pl.connectis.springjpa.repository.MovieRepository;
import pl.connectis.springjpa.repository.PosterRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SimpleMovieService implements MovieService {

    private MovieRepository movieRepository;
    private PosterRepository posterRepository;

    @Override
    @Transactional
    public Long createMovie(String title, MovieCategory category, Integer length, String description,
                            Integer requiredAge, String posterFilePath) {
        Movie movie = new Movie(title, category, length, description, requiredAge, null);

        Movie save = movieRepository.save(movie);
        Optional.ofNullable(posterFilePath).ifPresent(path -> createPoster(movie, path));
        System.out.println("Mój obiekt movie id=" + movie.getId());
        System.out.println("Obiekt zarządzany przez Jpa movie id=" + save.getId());
        return save.getId();
    }

    private void createPoster(Movie movie, String path) {
        Poster poster = new Poster(path, movie);
        poster.setMovie(movie);
        posterRepository.save(poster);
    }

    @Override
    public Optional<Movie> getMovie(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public Page<Movie> getMoviesInCategory(MovieCategory category, Pageable pageable) {
        return movieRepository.findByCategory(category, pageable);
    }

    @Override
    public Page<Movie> getMoviesByPartOfTitle(String partOfTitle, Pageable pageable) {
        return movieRepository.findByTitleContaining(partOfTitle, pageable);
    }

    @Override
    public Page<Movie> getAllMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void updateMovie(Long movieId, String title, MovieCategory category, Integer length, String description, Integer requiredAge) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        movieOptional.orElseThrow(() -> new EntityNotFoundException("Movie id:" + movieOptional + " doesn't exist"))
                .updateMovie(title, category, length, description, requiredAge);
    }


    @Override
    @Transactional
    public void removeMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
