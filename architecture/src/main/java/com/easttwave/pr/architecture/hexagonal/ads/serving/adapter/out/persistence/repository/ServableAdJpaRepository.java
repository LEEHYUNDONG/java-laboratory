package com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.out.persistence.repository;

import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ServableAd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServableAdJpaRepository extends JpaRepository<ServableAd, Long> {
}
