package com.example.controller;

import com.example.model.Car;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final Map<Integer, Car> carDB = new LinkedHashMap<>();
    private int currentId = 1;

    @GetMapping
    public String list(HttpServletRequest request) {
        request.setAttribute("cars", new ArrayList<>(carDB.values()));
        return "list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("car", new Car());
        return "form";
    }

    @PostMapping
    public String saveCar(HttpServletRequest request) {
        String idParam = request.getParameter("id");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");

        if (idParam == null || idParam.isEmpty() || idParam.equals("0")) {
            Car car = new Car(currentId++, model, brand);
            carDB.put(car.getId(), car);
        } else {
            int id = Integer.parseInt(idParam);
            Car car = carDB.get(id);
            if (car != null) {
                car.setModel(model);
                car.setBrand(brand);
            }
        }

        return "redirect:/cars";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, HttpServletRequest request) {
        Car car = carDB.get(id);
        request.setAttribute("car", car);
        return "form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        carDB.remove(id);
        return "redirect:/cars";
    }
}