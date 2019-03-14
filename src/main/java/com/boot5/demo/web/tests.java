package com.boot5.demo.web;

import org.jsoup.Jsoup;

import java.io.*;
import java.net.*;
import java.util.*;

public class tests {


    public static void main(String[] args) {

        String text;
        //final String textURL="https://en.wikipedia.org/wiki/Apophony";
        final String textURL="https://www.thetimes.co.uk/";
        //final String textURL="https://ru.wikipedia.org/wiki/%D0%92%D1%83%D0%BB%D0%BA%D0%B0%D0%BD";


        try {
            URL website = new URL(textURL);

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(website.openStream()));

            StringBuilder stringBuilder = new StringBuilder(256);

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
                stringBuilder.append(System.lineSeparator()); // ставим разделитель новой строки чистый
            }

            bufferedReader.close();
            website = null;
            text = stringBuilder.toString().trim();

            Map<String, Integer> map = new HashMap<>();


                // убираем с помощью джейсупа  теги
            String stripped = Jsoup.parse(text).text();
            //  для англиского
            String[] arr = stripped.split("[^a-zA-Z]+");

            // для руского
            //String [] arr =text.split("[^а-яА-Я]+");

            for (String x : arr) {
                map.merge(x.toLowerCase(), 1, (a, b) -> a + b);
            }
            //  сортируем по количеству  слов
            TreeMap<String, Integer> sortMap = new TreeMap<>(map);
            sortMap.entrySet().stream()
                   .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())

                    .forEach(System.out::println);
            System.out.println("*** Количество  слов всего ="+sortMap.size());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
