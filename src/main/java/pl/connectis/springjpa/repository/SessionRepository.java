package pl.connectis.springjpa.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.connectis.springjpa.domain.Session;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SessionRepository extends PagingAndSortingRepository<Session, Long> {

    @Query("SELECT s FROM Session s WHERE function('DATE_TRUNC', 'day', s.startTime)=?1")
    List<Session> findAllByStartDate(Date date);

    @EntityGraph(value = "Session.tickets", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Session> readById(Long id);

}
