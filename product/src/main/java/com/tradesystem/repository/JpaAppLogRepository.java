package com.tradesystem.repository;

import com.tradesystem.entity.AppLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAppLogRepository extends JpaRepository<AppLogEntity, Long> {
}
