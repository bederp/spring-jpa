package pl.connectis.springjpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.connectis.springjpa.domain.Room;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

}
