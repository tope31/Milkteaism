package com.javakun.milkteaism.service;

import com.javakun.milkteaism.model.Sales;
import com.javakun.milkteaism.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;
    @Override
    public List<Sales> getSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sales addSale(Sales sales) {
        return salesRepository.save(sales);
    }
}
