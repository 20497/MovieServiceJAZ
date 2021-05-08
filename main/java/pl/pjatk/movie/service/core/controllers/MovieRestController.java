package pl.pjatk.movie.service.core.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.movie.service.core.models.MovieModel;
import pl.pjatk.movie.service.core.services.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    @GetMapping("/all")
    public ResponseEntity<List<MovieModel>> getAllMovies()
    {
        return ResponseEntity.status(HttpStatus.OK).body(MovieService.getAllMovies());
    }
}
