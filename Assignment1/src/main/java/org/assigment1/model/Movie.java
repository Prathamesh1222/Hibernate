package org.assigment1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    private String movieId;

    private String movieName;

    private String language;

    private Integer releasedIn;

    private Integer revenueInDollars;


}
