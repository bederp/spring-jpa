package pl.connectis.springjpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.connectis.springjpa.domain.Movie;
import pl.connectis.springjpa.domain.Poster;

import java.util.Optional;

public interface PosterRepository extends PagingAndSortingRepository<Poster, Long> {

    Optional<Poster> findByMovie(Movie movie);

}
