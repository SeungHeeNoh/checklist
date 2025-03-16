package com.sweethome.checklist.repository;

import com.sweethome.checklist.domain.CheckItemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckItemLogRepository extends JpaRepository<CheckItemLog, Long> {
}
