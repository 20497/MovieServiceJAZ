package pl.pjatk.movie.service.core.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movie.service.core.models.Movie;
import pl.pjatk.movie.service.core.services.MovieService;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private MovieService movieService;


    public void MovieController(MovieService movieService) {
        this.movieService = movieService;

    }

    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping("/post/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @GetMapping("/get/addMovie/{id}")
    public ResponseEntity<Movie> addMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PutMapping("/put/addMovie/{id}")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie, @PathVariable Long id) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
            movieService.deleteMovieById(id);
            return ResponseEntity.noContent().build();
    }
    @PutMapping("/isAvailable/{id}")
    public ResponseEntity<Void> isAvailable(@PathVariable Long id){
        movieService.isAvailable(id);
        return ResponseEntity.ok().build();
    }
}
