package com.boot5.demo;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data

@RequiredArgsConstructor   // конструктор без параметров

public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;


    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
