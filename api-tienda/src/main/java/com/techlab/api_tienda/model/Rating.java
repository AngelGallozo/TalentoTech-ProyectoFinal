package com.techlab.api_tienda.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Rating {
    private Double rate;
    private Integer count;

    public Rating(){}

    public Rating(Double rate, Integer count){
        this.rate = rate;
        this.count = count;
    }
}
