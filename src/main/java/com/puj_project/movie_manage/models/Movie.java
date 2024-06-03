package com.puj_project.movie_manage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.util.Date;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Polje naslov je obavezno")
    @Size(min = 1, max = 200, message = "Polje naslov mora biti između 1 i 200 znakova.")
    private String title;

    @DecimalMin(value = "1.00", message = "Prosječna ocjena mora biti najmanje 1.00")
    @DecimalMax(value = "10.00", message = "Prosječna ocjena mora biti najviše 10.00")
    @Digits(integer = 2, fraction = 2, message = "Prosječna ocjena mora biti na dvije decimale")
    private Long voteAverage;

    @NotBlank(message = "Polje status je obavezno")
    private String status;

    private Date releaseDate;

    @Positive(message = "Prihod mora biti pozitivan broj")
    private Long revenue;

    @Positive(message = "Trajanje mora biti pozitivan broj")
    private Integer runtime;

    @Positive(message = "Budžet mora biti pozitivan broj")
    private Long budget;

    private String homepage;

    private String overview;

    private String posterPath;

    private String genres;

    private String productionCompanies;

    private String productionCountries;

    public Movie() {}

    public String getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(String productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(String productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public @Positive(message = "Budžet mora biti pozitivan broj") Long getBudget() {
        return budget;
    }

    public void setBudget(@Positive(message = "Budžet mora biti pozitivan broj") Long budget) {
        this.budget = budget;
    }

    public @Positive(message = "Trajanje mora biti pozitivan broj") Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(@Positive(message = "Trajanje mora biti pozitivan broj") Integer runtime) {
        this.runtime = runtime;
    }

    public @Positive(message = "Prihod mora biti pozitivan broj") Long getRevenue() {
        return revenue;
    }

    public void setRevenue(@Positive(message = "Prihod mora biti pozitivan broj") Long revenue) {
        this.revenue = revenue;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public @NotBlank(message = "Polje status je obavezno") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Polje status je obavezno") String status) {
        this.status = status;
    }

    public @DecimalMin(value = "1.00", message = "voteAverage mora biti najmanje 1.00") @DecimalMax(value = "10.00", message = "voteAverage mora biti najviše 10.00") @Digits(integer = 2, fraction = 2, message = "voteAverage mora biti na dvije decimale") Long getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(@DecimalMin(value = "1.00", message = "voteAverage mora biti najmanje 1.00") @DecimalMax(value = "10.00", message = "voteAverage mora biti najviše 10.00") @Digits(integer = 2, fraction = 2, message = "voteAverage mora biti na dvije decimale") Long voteAverage) {
        this.voteAverage = voteAverage;
    }

    public @NotBlank(message = "Polje naslov je obavezno") @Size(min = 1, max = 200, message = "Polje naslov mora biti između 1 i 200 znakova.") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Polje naslov je obavezno") @Size(min = 1, max = 200, message = "Polje naslov mora biti između 1 i 200 znakova.") String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}