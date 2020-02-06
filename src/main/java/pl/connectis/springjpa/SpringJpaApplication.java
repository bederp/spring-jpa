package pl.connectis.springjpa;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.connectis.springjpa.domain.MovieCategory;
import pl.connectis.springjpa.service.MovieService;

@SpringBootApplication
@AllArgsConstructor
public class SpringJpaApplication implements CommandLineRunner {

	private MovieService movieService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		movieService.updateMovie(5L, "toString()", MovieCategory.HORROR, 123, "opis", 5);
	}
}
