package com.puj_project.movie_manage.repository;

import com.puj_project.movie_manage.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findFirst5ByOrderByReleaseDateDesc();

    Movie findFirstByOrderByVoteAverageDesc();

    List<Movie> findFirst2ByOrderByBudgetDesc();


    @Query("SELECT m FROM Movie m WHERE m.id = (SELECT MAX(m2.id) FROM Movie m2)")
    Movie findTopRatedMovie();

}

