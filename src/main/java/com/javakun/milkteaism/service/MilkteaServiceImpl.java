package com.javakun.milkteaism.service;

import com.javakun.milkteaism.model.Milktea;
import com.javakun.milkteaism.repository.MilkteaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilkteaServiceImpl implements MilkteaService {
    @Autowired
    private MilkteaRepository milkteaRepository;

    @Override
    public List<Milktea> getAllMilktea() {
        return milkteaRepository.findAll();
    }

    @Override
    public Milktea addMilktea(Milktea milktea) {
        return milkteaRepository.save(milktea);
    }

    @Override
    public Page<Milktea> findMilkteaByMilkteaId(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sort).ascending());
        return milkteaRepository.findAll(pageable);
    }

}
