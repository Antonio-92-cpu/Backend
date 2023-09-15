package com.demo.portfolioControllers;

import com.demo.domain.models.Portfolio;
import com.demo.domain.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/citas")
public class PortfolioController {
    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public List<Portfolio> getCitaController() {
        return portfolioService.getCitas();
    }

    @PostMapping
    public void createCitas(@RequestBody Portfolio portfolio) {
        portfolioService.newCita(portfolio);

    }

    @PutMapping("/{id}")
    public void updateCita(@PathVariable Integer id, @RequestBody Portfolio portfolio) {
        portfolioService.update(id, portfolio);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id, Portfolio portfolio) {
        portfolioService.deleteCita(id, portfolio);
    }
}