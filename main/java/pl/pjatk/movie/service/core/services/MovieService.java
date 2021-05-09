package pl.pjatk.movie.service.core.services;

import org.springframework.stereotype.Service;
import pl.pjatk.movie.service.core.models.MovieModel;
import java.util.List;

@Service
public class MovieService {

    public static List getAllMovies() {
        return List.of(
                new MovieModel(1L, "Dracula", "Horror"),
                new MovieModel(2L, "Titanic", "Tragedy"),
                new MovieModel(3L, "Harry Potter", "Fantasy")
        );
    }

}
