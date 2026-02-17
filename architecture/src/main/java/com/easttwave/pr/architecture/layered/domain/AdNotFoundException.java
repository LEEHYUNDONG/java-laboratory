package com.easttwave.pr.architecture.layered.domain;

public class AdNotFoundException extends RuntimeException {

    private final Long id;

    public AdNotFoundException(Long adId) {
        this.id = adId;
    }
}
