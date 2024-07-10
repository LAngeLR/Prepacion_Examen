package com.example.clienteurekaaddition;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionServiceController {
    @GetMapping("/addition/{item_a}/{item_b}")
    public String addition(@PathVariable("item_a") int a,
                           @PathVariable("item_b") int b)

    {
        return "(" + Integer.toString(a) +
                " + " + Integer.toString(b) + ") = " + Integer.toString(a+b);
    }
}
