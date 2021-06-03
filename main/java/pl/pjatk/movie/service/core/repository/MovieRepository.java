package pl.pjatk.movie.service.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.movie.service.core.models.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();

    Movie save(Movie movie);

    Optional<Movie> findById(Long id);

    void deleteById(Long id);
}
