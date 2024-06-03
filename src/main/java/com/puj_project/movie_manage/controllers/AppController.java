package com.puj_project.movie_manage.controllers;

import com.puj_project.movie_manage.models.Movie;
import com.puj_project.movie_manage.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Controller
public class AppController implements UserDetailsService {

    private final MovieRepository movieRepo;

    @Autowired
    public AppController(MovieRepository movieRepo) {
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

    @GetMapping("/")
    public String index(Model model) {
        List<Movie> movies = movieRepo.findFirst5ByOrderByReleaseDateDesc();
        List<Movie> recommendedMovies = movieRepo.findFirst2ByOrderByBudgetDesc();
        model.addAttribute("topVotedMovie", movieRepo.findFirstByOrderByVoteAverageDesc());
        model.addAttribute("movies", movies);
        model.addAttribute("topRatedMovie", movieRepo.findTopRatedMovie());
        model.addAttribute("recommendedMovies", recommendedMovies);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("currentUsername", true);
        } else {
            model.addAttribute("currentUsername", false);
        }

        return "index";
    }

}
