package com.easttwave.pr.architecture.hexagonal.ads.shared.infrastructure.persistence;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "**.entity")
public class JpaAuditConfig {
}
