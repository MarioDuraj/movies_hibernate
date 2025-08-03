package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
@Data
@ToString(callSuper = true)
public class Actor extends AbstractEntity {
    @Column(name = "name")
    private String firstname;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "year_Of_Birth")
    private Integer yearOfBirth;
    @ManyToMany
    @JoinTable(name = "actors_to_movies")
    private List<Movie> movies;

    public void addMovie(Movie movie) {
        if (this.getMovies()== null || this.getMovies().isEmpty()){
            List<Movie> movieList = new ArrayList<>();
            movieList.add(movie);
            this.setMovies(movieList);
        }else {
            this.getMovies().add(movie);
        }
    }
}
