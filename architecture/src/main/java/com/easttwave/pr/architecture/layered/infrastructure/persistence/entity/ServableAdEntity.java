package com.easttwave.pr.architecture.layered.infrastructure.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class ServableAdEntity {

    @Id
    @GeneratedValue
    private Long dataKey;

    private String adId;

    private String title;

    private String description;

}
