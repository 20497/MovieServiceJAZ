package pl.pjatk.movie.service.core.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pjatk.movie.service.core.exceptions.MovieNotFoundException;
import pl.pjatk.movie.service.core.models.Movie;
import pl.pjatk.movie.service.core.repository.MovieRepository;
import java.util.List;


@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        var movieToUpdate = findById(id);
        if (movie.getName() != null) {
            movieToUpdate.setName((movie.getName()));
        }
        if (movie.getCategory() != null) {
            movieToUpdate.setCategory(movie.getCategory());
        }

        return addMovie(movieToUpdate);
    }

    public void deleteMovieById(Long id) {
        if (!movieRepository.findAll().removeIf(movie -> movie.getId().equals(id))) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
        movieRepository.deleteById(id);
    }

    public void isAvailable(Long id) {
        var movie = findById(id);
        movie.setAvailable(true);
        addMovie(movie);
    }
}
