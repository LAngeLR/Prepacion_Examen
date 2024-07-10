package com.example.clienteurekacalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private ServiceAdditionClient serviceAdditionClient;

    @GetMapping("/addcalculator/{item_a}/{item_b}")
    public String addCalculator(@PathVariable("item_a") int item_a,
                                @PathVariable("item_b") int item_b)
    {
        return "Calculator : " + serviceAdditionClient.addition(item_a,item_b);
    }
}
