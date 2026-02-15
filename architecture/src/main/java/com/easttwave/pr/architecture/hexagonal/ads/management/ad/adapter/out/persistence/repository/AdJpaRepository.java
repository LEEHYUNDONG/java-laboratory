package com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.out.persistence.repository;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.out.entity.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdJpaRepository extends JpaRepository<AdvertisementEntity, Long> {

    Optional<AdvertisementEntity> findByAdId(String adId);
}
