package ru.kvt.coffeemaker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
public class CoffeeMakerStateDto {

    private Boolean isCoffeeMakerEnabled;


    private Integer coffeeStrength;

    private String boilingMode;

}
