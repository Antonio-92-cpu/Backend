package com.demo.domain.service;

import com.demo.domain.models.Portfolio;
import com.demo.infra.repositories.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Autowired

    public List<Portfolio> getCitas(){
    return portfolioRepository.findAll();
}

    public void newCita(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    public void update(Integer id, Portfolio portfolio) {
        Optional<Portfolio> citabyID = (portfolioRepository.findById(id));
        if (citabyID.isPresent()){
            Portfolio portfolioExisting = citabyID.get();

            portfolioExisting.setNombre(portfolio.getNombre());
            portfolioExisting.setHora(portfolio.getHora());
            portfolioExisting.setCiudad(portfolio.getCiudad());
            portfolioExisting.setDia(portfolio.getDia());
            portfolioRepository.save(portfolioExisting);

        }
    }

    public void deleteCita(Integer id, Portfolio portfolio) {
        boolean existe = portfolioRepository.existsById(id);
        if (existe){
            portfolioRepository.delete(portfolio);
        }
    }
}
