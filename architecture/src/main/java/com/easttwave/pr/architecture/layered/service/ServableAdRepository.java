package com.easttwave.pr.architecture.layered.service;

import com.easttwave.pr.architecture.layered.infrastructure.persistence.entity.ServableAdEntity;

import java.util.List;

public interface ServableAdRepository {

    List<ServableAdEntity> findAll();
}
