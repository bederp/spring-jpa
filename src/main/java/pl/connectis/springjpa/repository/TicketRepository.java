package pl.connectis.springjpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.connectis.springjpa.domain.Session;
import pl.connectis.springjpa.domain.Ticket;

import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {

    List<Ticket> findAllBySessions(Session session);

    Long countBySessions(Session session);

}
