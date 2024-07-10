package com.example.clienteurekacalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private ServiceAdditionClient serviceAdditionClient;

    final CircuitBreakerFactory circuitBreakerFactory;

    public  CalculatorController(CircuitBreakerFactory circuitBreakerFactory) {
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @GetMapping("/addcalculator/{item_a}/{item_b}")
    public String addCalculator(@PathVariable("item_a") int item_a,
                                @PathVariable("item_b") int item_b)
    {
        CircuitBreaker breaker = circuitBreakerFactory.create("addcalculator");

        return breaker.run(() -> {
            return "Calculator : " + serviceAdditionClient.addition(item_a,item_b);
        }, throwable -> {
            return "Calculator : Wait";
        });
    }
}
