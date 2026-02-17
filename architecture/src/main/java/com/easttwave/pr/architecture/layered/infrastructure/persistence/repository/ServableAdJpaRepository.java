package com.easttwave.pr.architecture.layered.infrastructure.persistence.repository;


import com.easttwave.pr.architecture.layered.infrastructure.persistence.entity.ServableAdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServableAdJpaRepository extends JpaRepository<ServableAdEntity, Long> {
}
