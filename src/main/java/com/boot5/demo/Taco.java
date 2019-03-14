package com.boot5.demo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Taco {


    @NotNull
    @Size(min=5, message="Имя должно быть не менее 5 символов")
    private String name;

    @Size(min=1, message="${welcome.message}")

    private List<String> ingredients;

}
