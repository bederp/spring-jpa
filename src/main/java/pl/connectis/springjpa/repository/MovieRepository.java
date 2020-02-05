package pl.connectis.springjpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.connectis.springjpa.domain.Movie;
import pl.connectis.springjpa.domain.MovieCategory;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

    Page<Movie> findByCategory(MovieCategory category, Pageable pageable);
    Page<Movie> findByTitleContaining(String partOfTile, Pageable pageable);

}
