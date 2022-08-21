package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HollywoodMovies {

    @Id
    private String movieId;

    private String movieName;

    private String language;

    private Integer releasedIn;

    private Integer revenueInDollers;
}
