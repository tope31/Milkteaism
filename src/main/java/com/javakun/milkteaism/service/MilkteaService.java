package com.javakun.milkteaism.service;

import com.javakun.milkteaism.model.Milktea;
import org.springframework.data.domain.Page;
import java.util.List;

public interface MilkteaService {
    List<Milktea> getAllMilktea();

    Milktea addMilktea(Milktea milktea);

    Page<Milktea> findMilkteaByMilkteaId(int page, int size, String sort);


}
