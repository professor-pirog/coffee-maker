package ru.kvt.coffeemaker.mappers;


import ru.kvt.coffeemaker.dto.CoffeeMakerStateDto;
import ru.kvt.coffeemaker.model.CoffeeMakerState;



public class CoffeeMakerStateMapper {

    public static CoffeeMakerStateDto toCoffeeMakerStateDto(CoffeeMakerState coffeeMakerState) {
        CoffeeMakerStateDto coffeeMakerStateDto = new CoffeeMakerStateDto();
        coffeeMakerStateDto.setBoilingMode(coffeeMakerState.getBoilingMode().toString());
        coffeeMakerStateDto.setCoffeeStrength(coffeeMakerState.getCoffeeStrength());
        coffeeMakerStateDto.setIsCoffeeMakerEnabled(coffeeMakerState.getIsCoffeeMakerEnabled());

        return coffeeMakerStateDto;

    }


}
