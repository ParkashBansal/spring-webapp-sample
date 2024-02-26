package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CoffeeShopController {

    private int coffeeStock = 100;

    @GetMapping("/order-coffee")
    public String orderCoffee(@RequestParam int quantity) {
        if (quantity > 0 && quantity <= coffeeStock) {
            coffeeStock -= quantity;
            return "Enjoy your coffee!";
        }
        else {
            return "Sorry, we're out of coffee or your order is invalid.";
        }
    }

    @GetMapping("/restock-coffee")
    public String restockCoffee(@RequestParam int quantity) {
        if (quantity > 0) {
            coffeeStock += quantity;
            return "Coffee restocked by " + quantity + " cups.";
        }
        else {
            return "Invalid quantity for restocking.";
        }
    }

    @GetMapping("/serve-coffee")
    public String serveCoffee() {
        coffeeStock--;
        return "Here's your coffee!";
    }
}
