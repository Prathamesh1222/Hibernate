package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    @Id
    private Integer assetId;

    private Integer serialNo;

    private Integer prNo;

    private String assetType;

    private Integer assrtPrice;

    private String assetLocation;
}
