package pl.connectis.springjpa;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.connectis.springjpa.domain.Movie;
import pl.connectis.springjpa.repository.MovieRepository;

@SpringBootApplication
@AllArgsConstructor
public class SpringJpaApplication implements CommandLineRunner {

	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Iterable<Movie> all = movieRepository.findAll();
	}
}
