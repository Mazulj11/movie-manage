package com.puj_project.movie_manage.controllers;

import com.puj_project.movie_manage.models.Movie;
import com.puj_project.movie_manage.repository.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController implements UserDetailsService {

    private final MovieRepository movieRepo;

    @Autowired
    public MovieController(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            throw new UsernameNotFoundException("Korisnik nije prijavljen.");
        }
        return (UserDetails) authentication.getPrincipal();
    }

    @GetMapping("/add")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            model.addAttribute("currentUsername", true);
        } else {
            model.addAttribute("currentUsername", false);
        }

        return "movie-add";
    }

    @PostMapping("/add-movie")
    public String newMovie(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movie", movie);
            return "movie-add";
        } else {
            try {
                movieRepo.save(movie);
            } catch (Exception e) {
                model.addAttribute("saveError", "Error saving movie: " + e.getMessage());
                return "movie-add";
            }
            return "redirect:/movies";
        }
    }

    @GetMapping("")
    public String index(Model model) {
        List<Movie> movies = movieRepo.findAll();
        model.addAttribute("movies", movies);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            model.addAttribute("currentUsername", true);
        } else {
            model.addAttribute("currentUsername", false);
        }

        return "movies-list";
    }

    @GetMapping("/details/{id}")
    public String showMovieDetails(@PathVariable Long id, Model model) {
        movieRepo.findById(id).ifPresent(movie -> model.addAttribute("movie", movie));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            model.addAttribute("currentUsername", true);
        } else {
            model.addAttribute("currentUsername", false);
        }

        return "movie-details";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") Long id, @Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movie", movie);
            return "movie-details";
        } else {
            try {
                Optional<Movie> existingMovieOptional = movieRepo.findById(id);
                if (existingMovieOptional.isPresent()) {
                    Movie existingMovie = getExistingMovie(movie, existingMovieOptional);


                    movieRepo.save(existingMovie);
                } else {
                    model.addAttribute("saveError", "Movie not found with ID: " + id);
                    return "movie-details";
                }
            } catch (Exception e) {
                model.addAttribute("saveError", "Error updating movie: " + e.getMessage());
                return "movie-details";
            }
            return "redirect:/movies";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id, Model model) {
        try {
            Optional<Movie> movieOptional = movieRepo.findById(id);

            if (movieOptional.isPresent()) {
                movieRepo.delete(movieOptional.get());
            } else {
                model.addAttribute("deleteError", "Movie not found with ID: " + id);
            }
            return "redirect:/movies";
        } catch (Exception e) {
            model.addAttribute("deleteError", "Error deleting movie: " + e.getMessage());
            return "redirect:/movies";
        }
    }



    private static Movie getExistingMovie(Movie movie, Optional<Movie> existingMovieOptional) {
        Movie existingMovie = existingMovieOptional.get();
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setVoteAverage(movie.getVoteAverage());
        existingMovie.setStatus(movie.getStatus());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        existingMovie.setRevenue(movie.getRevenue());
        existingMovie.setRuntime(movie.getRuntime());
        existingMovie.setBudget(movie.getBudget());
        existingMovie.setHomepage(movie.getHomepage());
        existingMovie.setOverview(movie.getOverview());
        existingMovie.setPosterPath(movie.getPosterPath());
        existingMovie.setGenres(movie.getGenres());
        existingMovie.setProductionCompanies(movie.getProductionCompanies());
        existingMovie.setProductionCountries(movie.getProductionCountries());
        return existingMovie;
    }


}
