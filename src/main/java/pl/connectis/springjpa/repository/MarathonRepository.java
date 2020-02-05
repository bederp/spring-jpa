package pl.connectis.springjpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.connectis.springjpa.domain.Marathon;

public interface MarathonRepository extends PagingAndSortingRepository<Marathon, Long> {

}
