package com.easttwave.pr.architecture.layered.infrastructure.persistence.repository;

import com.easttwave.pr.architecture.layered.infrastructure.persistence.entity.ServableAdEntity;
import com.easttwave.pr.architecture.layered.service.ServableAdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ServableAdRepositoryImpl implements ServableAdRepository {

    private final ServableAdJpaRepository repository;

    @Override
    public List<ServableAdEntity> findAll() {
        return repository.findAll();
    }
}
