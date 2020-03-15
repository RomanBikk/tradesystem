package com.tradesystem.domain;

import com.tradesystem.entity.AppLogEntity;
import com.tradesystem.repository.JpaAppLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultAppLogService {
    private final JpaAppLogRepository jpaAppLogRepository;

    public DefaultAppLogService(JpaAppLogRepository jpaAppLogRepository) {
        this.jpaAppLogRepository = jpaAppLogRepository;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AppLogEntity save(AppLogEntity appLogEntity) {
        return jpaAppLogRepository.save(appLogEntity);
    }
}
