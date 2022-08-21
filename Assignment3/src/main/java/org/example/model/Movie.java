package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {


    @Id
    private String movieId;

    private String movieName;

    private String language;

    private Integer releasedIn;

    private Integer revenueInDollers;

    @ManyToOne(cascade = CascadeType.ALL)
    private Director director;
}
