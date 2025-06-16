package com.example.lesson41actuator.controller;

import java.util.*;

import com.example.lesson41actuator.model.Car;
import com.example.lesson41actuator.exception.CarNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cars")
public class CarController {
    private final Map<Integer, Car> carDB = new LinkedHashMap<>();
    private int currentId = 1;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("cars", new ArrayList<>(carDB.values()));
        return "list";
    }

    @GetMapping("/new")
    public String newCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("car") Car car,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err ->
                    errors.put(err.getField(), err.getDefaultMessage())
            );
            model.addAttribute("errors", errors);
            return "form";
        }
        if (car.getId() == 0) {
            car.setId(currentId++);
        }
        carDB.put(car.getId(), car);
        return "redirect:/cars";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        Car car = carDB.get(id);
        if (car == null) {
            throw new CarNotFoundException(id);
        }
        model.addAttribute("car", car);
        return "form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        carDB.remove(id);
        return "redirect:/cars";
    }
}