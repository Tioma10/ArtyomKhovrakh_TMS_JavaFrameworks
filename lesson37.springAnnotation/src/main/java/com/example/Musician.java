package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Musician {
    @Autowired
    private Instrument instrument;

    public void perform() {
        System.out.print("Musician is playing: ");
        instrument.play();
    }
}