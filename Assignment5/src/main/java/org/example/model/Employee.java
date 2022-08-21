package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {


    @Id
    private Integer empId;

    private String empName;

    private String password;

    //@OneToOne
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AssetId")
    private Asset asset;
}
