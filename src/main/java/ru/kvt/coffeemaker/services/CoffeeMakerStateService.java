package ru.kvt.coffeemaker.services;

import ru.kvt.coffeemaker.model.CoffeeMakerState;

import java.util.Optional;

public interface CoffeeMakerStateService {
    public Optional<CoffeeMakerState> findById(Long id);
    public CoffeeMakerState save(CoffeeMakerState coffeeMakerState);
}
