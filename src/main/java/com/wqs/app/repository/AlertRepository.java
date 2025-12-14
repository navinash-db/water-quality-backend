package com.wqs.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wqs.app.entity.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {

    List<Alert> findByReadStatusFalse();
}
