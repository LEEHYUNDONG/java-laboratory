package com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.out.persistence;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.out.entity.AdvertisementEntity;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.out.persistence.repository.AdJpaRepository;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.application.port.out.AdPersistencePort;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.Ad;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdsAdapter implements AdPersistencePort {

    private final AdJpaRepository adJpaRepository;

    public AdsAdapter(AdJpaRepository adJpaRepository) {
        this.adJpaRepository = adJpaRepository;
    }

    @Override
    public void saveAd(Ad ad) {
        Optional<AdvertisementEntity> advertisementEntity = adJpaRepository.findByAdId(ad.getAdId().value());
        if (advertisementEntity.isPresent()) {
            throw new DuplicateKeyException("Ad already exists");
        }

        AdvertisementEntity entity = AdvertisementEntity.toEntity(ad);

        adJpaRepository.save(entity);
    }


    @Override
    public void removeAd(String adId) {
        AdvertisementEntity entity = adJpaRepository.findByAdId(adId).orElseThrow(() -> new IllegalArgumentException("찾으려는 광고가 없습니다."));

        adJpaRepository.delete(entity);
    }

    @Override
    public List<Ad> findAllAds() {
        return adJpaRepository
                .findAll()
                .stream()
                .map(Ad::toDomain)
                .toList();
    }

    @Override
    public void updateAd(String adId, Ad ad) {
        AdvertisementEntity entity = adJpaRepository.findByAdId(adId)
                .orElseThrow(() -> new IllegalArgumentException("수정하려는 광고가 없습니다."));
        entity.applyChanges(ad);
    }

    @Override
    public Optional<Ad> findByAdId(String adId) {
        return adJpaRepository.findByAdId(adId).map(Ad::toDomain);
    }
}
