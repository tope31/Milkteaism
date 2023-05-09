package com.javakun.milkteaism.service;

import com.javakun.milkteaism.model.Sales;

import java.util.List;

public interface SalesService {
    List<Sales> getSales();

    Sales addSale(Sales sales);
}
