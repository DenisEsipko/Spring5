package com.boot5.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class Home {

    @GetMapping("zz")
    public String home(@RequestParam(name = "par", required = false,defaultValue = "Zoro")
                       String name, Model model){
      List<String> stringList =  List.of("a", "b", "c");


        model.addAttribute("name" , name);
        model.addAttribute("name2",stringList);
        return "zzz";
    }

//            //http://localhost:8080/zz/Deni
//    @GetMapping("zz/{namezz}")
//    public String home(@PathVariable(value = "namezz")
//                                   String name, Model model){
//        //List<String> stringList = List.of("a", "b", "c");
//
//        model.addAttribute("name" , name);
//        return "zz";
//    }
}
