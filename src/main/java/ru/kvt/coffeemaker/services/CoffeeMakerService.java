package ru.kvt.coffeemaker.services;


import ru.kvt.coffeemaker.model.BoilingMode;
import ru.kvt.coffeemaker.model.CoffeeMakerState;

public interface CoffeeMakerService {


    public void enable();

    public void disable();


    public void pourCoffee();

    public Integer setStrength(Integer coffeeStrength);

    public void boiling();

    public BoilingMode setBoilingMode(BoilingMode boilingMode);

    public CoffeeMakerState getState();

}
