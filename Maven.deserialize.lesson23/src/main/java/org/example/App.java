package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

class Animal {
    public String name;
    public String species;
    public int age;

    @Override
    public String toString() {
        return "Animal:"+"\t" +
                "name=" + name + "\t" +
                "species=" + species + "\t" +
                "age=" + age;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        String jsonString = "{\"name\":\"Boris\",\"species\":\"Lion\",\"age\":9}";
        Animal animal = new ObjectMapper().readValue(jsonString, Animal.class);
        System.out.println(animal);
    }
}
