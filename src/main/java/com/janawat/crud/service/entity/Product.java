package com.janawat.crud.service.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product  extends BaseEntity {
    private String name;
    private Double price;
}
