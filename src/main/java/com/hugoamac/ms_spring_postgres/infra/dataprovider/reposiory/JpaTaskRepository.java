package com.hugoamac.ms_spring_postgres.infra.dataprovider.reposiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugoamac.ms_spring_postgres.infra.dataprovider.entity.TaskEntity;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByCode(String code);
}
