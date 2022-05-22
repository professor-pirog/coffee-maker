package ru.kvt.coffeemaker.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kvt.coffeemaker.exceptions.CoffeeMakerDisabledException;
import ru.kvt.coffeemaker.exceptions.ResourceNotFoundException;
import ru.kvt.coffeemaker.model.BoilingMode;
import ru.kvt.coffeemaker.model.CoffeeMakerState;
import ru.kvt.coffeemaker.model.Event;


@Service
@RequiredArgsConstructor
public class CoffeeMakerServiceImpl implements CoffeeMakerService{

    private final CoffeeMakerStateService coffeeMakerStateService;
    private final EventService eventService;

    @Transactional
    @Override
    public void enable() {

        CoffeeMakerState coffeeMakerState = coffeeMakerStateService.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Установите начальное состояние кофеварки"));
        coffeeMakerState.setIsCoffeeMakerEnabled(true);
        coffeeMakerStateService.save(coffeeMakerState);

        Event event = new Event();
        event.setMessage("Кофеварка включилась");
        eventService.save(event);


        System.out.println("Кофеварка включилась");






    }

    @Transactional
    @Override
    public void disable() {

        CoffeeMakerState coffeeMakerState = coffeeMakerStateService.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Установите начальное состояние кофеварки"));
        coffeeMakerState.setIsCoffeeMakerEnabled(false);
        coffeeMakerStateService.save(coffeeMakerState);

        Event event = new Event();
        event.setMessage("Кофеварка выключилась");
        eventService.save(event);

        System.out.println("Кофеварка выключилась");


    }

    @Transactional
    @Override
    public void pourCoffee() {

        CoffeeMakerState coffeeMakerState = coffeeMakerStateService.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Установите начальное состояние кофеварки"));
        if (!coffeeMakerState.getIsCoffeeMakerEnabled()) {
            throw new CoffeeMakerDisabledException("Кофеварка выключена");
        }


        Event event = new Event();
        event.setMessage("Кофеварка налила кофе");
        eventService.save(event);

        System.out.println("Кофеварка налила кофе");


    }

    @Transactional
    @Override
    public Integer setStrength(Integer coffeeStrength) {

        CoffeeMakerState coffeeMakerState = coffeeMakerStateService.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Установите начальное состояние кофеварки"));
        if (!coffeeMakerState.getIsCoffeeMakerEnabled()) {
            throw new CoffeeMakerDisabledException("Кофеварка выключена");
        }
        coffeeMakerState.setCoffeeStrength(coffeeStrength);
        Integer newCoffeeStrength = coffeeMakerStateService.save(coffeeMakerState).getCoffeeStrength();

        Event event = new Event();
        event.setMessage("Установлена крепость кофе = " + newCoffeeStrength + " %");
        eventService.save(event);

        System.out.println("Установлена крепость кофе = " + newCoffeeStrength + " %");

        return newCoffeeStrength;
    }

    @Transactional
    @Override
    public void boiling() {

        CoffeeMakerState coffeeMakerState = coffeeMakerStateService.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Установите начальное состояние кофеварки"));
        if (!coffeeMakerState.getIsCoffeeMakerEnabled()) {
            throw new CoffeeMakerDisabledException("Кофеварка выключена");
        }
        BoilingMode boilingMode = coffeeMakerStateService.save(coffeeMakerState).getBoilingMode();

        Event event = new Event();
        event.setMessage("Кофеварка налила кипяток с режимом "  + boilingMode);
        eventService.save(event);

        System.out.println("Кофеварка налила кипяток с режимом "  + boilingMode);


    }

    @Transactional
    @Override
    public BoilingMode setBoilingMode(BoilingMode boilingMode) {


        CoffeeMakerState coffeeMakerState = coffeeMakerStateService.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Установите начальное состояние кофеварки"));
        if (!coffeeMakerState.getIsCoffeeMakerEnabled()) {
            throw new CoffeeMakerDisabledException("Кофеварка выключена");
        }
        coffeeMakerState.setBoilingMode(boilingMode);
        BoilingMode newBoilingMode = coffeeMakerStateService.save(coffeeMakerState).getBoilingMode();

        Event event = new Event();
        event.setMessage("Включен режим " + newBoilingMode);
        eventService.save(event);

        System.out.println("Включен режим " + newBoilingMode);

        return newBoilingMode;
    }


    @Override
    public CoffeeMakerState getState() {

        return coffeeMakerStateService.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Установите начальное состояние кофеварки"));
    }
}
