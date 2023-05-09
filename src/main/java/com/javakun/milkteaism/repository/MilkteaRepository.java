package com.javakun.milkteaism.repository;

import com.javakun.milkteaism.model.Milktea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilkteaRepository extends JpaRepository<Milktea,Long> {
}
