package pl.pjatk.movie.service.core.services;

import org.springframework.stereotype.Service;
import pl.pjatk.movie.service.core.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public static List getAllMovies() {
        return List.of(
                new MovieModel(1, "Dracula", "Horror"),
                new MovieModel(2, "Titanic", "Tragedy"),
                new MovieModel(3, "Harry Potter", "Fantasy")
        );
    }

}
