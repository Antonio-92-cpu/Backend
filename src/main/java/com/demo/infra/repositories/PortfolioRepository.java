package com.demo.infra.repositories;

import com.demo.domain.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository <Portfolio, Integer> {
}
