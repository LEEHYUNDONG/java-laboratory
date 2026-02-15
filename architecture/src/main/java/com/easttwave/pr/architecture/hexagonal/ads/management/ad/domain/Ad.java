package com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto.CreateAdRequest;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.out.entity.AdvertisementEntity;
import com.easttwave.pr.architecture.hexagonal.ads.management.shared.domain.DateRange;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public final class Ad {

    private AdId adId;

    private String title;

    private String description;

    private ImageUri imageUri;

    private DateRange dateRange;

    public static Ad createAds(CreateAdRequest command) {
        Ad ad = new Ad();
        ad.setTitle(command.title());
        ad.setDescription(command.description());
        ad.setImageUri(new ImageUri(command.imageUri()));
        ad.setDateRange(new DateRange(command.startDate(), command.endDate()));

        return ad;
    }

    public void updateDescription(String description) {
        this.setDescription(description);
    }

    public static Ad toDomain(AdvertisementEntity advertisementEntity) {
        Ad ad = new Ad();
        ad.setTitle(advertisementEntity.getTitle());
        ad.setDescription(advertisementEntity.getDescription());
        ad.setImageUri(new ImageUri(advertisementEntity.getImageUri()));
        ad.setDateRange(new DateRange(advertisementEntity.getStartDate(), advertisementEntity.getEndDate()));

        return ad;
    }
}
