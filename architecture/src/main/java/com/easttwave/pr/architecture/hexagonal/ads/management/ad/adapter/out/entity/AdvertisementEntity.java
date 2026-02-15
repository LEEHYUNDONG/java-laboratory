package com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.out.entity;


import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.Ad;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;

@Entity
@Table(name = "advertisement")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(AccessLevel.PRIVATE)
@Getter
public class AdvertisementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dataKey;

    @NaturalId
    @Column(name = "adId")
    private String adId;

    private String title;

    private String description;

    private String imageUri;

    // 나중에 광고 set으로도 표현이 가능해야함
    private LocalDate startDate;

    private LocalDate endDate;

    public static AdvertisementEntity toEntity(Ad ad) {
        AdvertisementEntity advertisementEntity = new AdvertisementEntity();
        advertisementEntity.setAdId(ad.getAdId().value());
        advertisementEntity.setTitle(ad.getTitle());
        advertisementEntity.setDescription(ad.getDescription());
        advertisementEntity.setImageUri(ad.getImageUri().getUrl());
        advertisementEntity.setStartDate(ad.getDateRange().getStartDate());
        advertisementEntity.setEndDate(ad.getDateRange().getEndDate());

        return advertisementEntity;
    }

    public void applyChanges(Ad ad) {
        this.setTitle(ad.getTitle());
        this.setDescription(ad.getDescription());
        this.setImageUri(ad.getImageUri().getUrl());
        this.setStartDate(ad.getDateRange().getStartDate());
        this.setEndDate(ad.getDateRange().getEndDate());
    }

}
