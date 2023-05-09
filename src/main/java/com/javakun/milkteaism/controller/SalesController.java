package com.javakun.milkteaism.controller;

import com.javakun.milkteaism.model.Sales;
import com.javakun.milkteaism.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/getSales")
    public ResponseEntity<List<Sales>> getSales() {
        return new ResponseEntity<>(salesService.getSales(), HttpStatus.OK);
    }

    @PostMapping("/addSale")
    public ResponseEntity<Sales> addSale(@RequestBody Sales sales) {
        return new ResponseEntity<>(salesService.addSale(sales), HttpStatus.CREATED);
    }
}
