package com.bezkoder.spring.thymeleaf.repository;

import com.bezkoder.spring.thymeleaf.entity.PlayerIndex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerIndexRepository extends JpaRepository<PlayerIndex, Integer> {}
