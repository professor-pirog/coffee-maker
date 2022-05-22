package ru.kvt.coffeemaker.controllers;


import lombok.RequiredArgsConstructor;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kvt.coffeemaker.dto.CoffeeMakerStateDto;
import ru.kvt.coffeemaker.mappers.CoffeeMakerStateMapper;
import ru.kvt.coffeemaker.model.BoilingMode;
import ru.kvt.coffeemaker.model.CoffeeMakerState;
import ru.kvt.coffeemaker.services.CoffeeMakerService;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Validated
@RestController
@RequestMapping("/api/v1/coffee-maker")
@RequiredArgsConstructor
public class CoffeeMakerController {

    private final CoffeeMakerService coffeeMakerService;

    @PostMapping("/enable")
    public void enable() {
        coffeeMakerService.enable();

    }

    @PostMapping("/disable")
    public void disable() {
        coffeeMakerService.disable();

    }

    @PostMapping("/pour-coffee")
    public void pourCoffee() {
        coffeeMakerService.pourCoffee();

    }

    @PostMapping("/set-strength")
    public Integer setStrength(@RequestBody @Min(0) @Max(100) Integer coffeeStrength) {

        return coffeeMakerService.setStrength(coffeeStrength);

    }


    @PostMapping("/boiling")
    public void boiling() {
        coffeeMakerService.boiling();

    }

    @PostMapping("/boiling/set-mode")
    public BoilingMode setBoilingMode(@RequestBody BoilingMode boilingMode) {

        return coffeeMakerService.setBoilingMode(boilingMode);

    }

    @GetMapping("/get-state")
    public CoffeeMakerStateDto getState() {
        CoffeeMakerState coffeeMakerState = coffeeMakerService.getState();
        return CoffeeMakerStateMapper.toCoffeeMakerStateDto(coffeeMakerState);

    }


//    @PostMapping("/set-strength")
//    public CoffeeStrengthDto setStrength(@RequestBody CoffeeStrengthDto coffeeStrengthDto) {
//        CoffeeStrength coffeeStrength = coffeeMakerService.setStrength(CoffeeStrengthMapper.toCoffeeStrength(coffeeStrengthDto));
//        return CoffeeStrengthMapper.toCoffeeStrengthDto(coffeeStrength);
//
//    }
//
//
//
//    @PostMapping("/boiling/set-mode")
//    public BoilingModeDto setBoilingMode(@RequestBody BoilingModeDto boilingModeDto) {
//        BoilingMode boilingMode = coffeeMakerService.setBoilingMode(BoilingModeMapper.toBoilingMode(boilingModeDto));
//        return BoilingModeMapper.toBoilingModeDto(boilingMode);



}
