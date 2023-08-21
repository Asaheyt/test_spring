package com.asaheyt.testProject.features.tests.data.repositories;

import com.asaheyt.testProject.features.tests.data.entities.TestEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface TestRepository extends R2dbcRepository<TestEntity, UUID> {
  Flux<TestEntity> findAllByName(String name);
}
