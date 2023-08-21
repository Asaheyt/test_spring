package com.asaheyt.testProject.features.tests.data.services;

import com.asaheyt.testProject.features.tests.data.entities.TestEntity;
import com.asaheyt.testProject.features.tests.data.repositories.TestRepository;
import com.asaheyt.testProject.features.tests.domain.models.Test;
import com.asaheyt.testProject.features.tests.domain.services.TestService;
import com.asaheyt.testProject.features.tests.presentation.dto.TestDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TestServiceImpl implements TestService {

  private final TestRepository testRepository;

  public TestServiceImpl(TestRepository testRepository) {
    this.testRepository = testRepository;
  }

  @Override
  public Flux<Test> test(String name) {
    return
      testRepository.findAllByName(name).map(testEntity -> new Test(testEntity.getId(), testEntity.getName()));
  }

  @Override
  public Mono<Test> create(TestDto testDto) {
    return testRepository.save(new TestEntity(testDto.name())).map(testEntity -> new Test(testEntity.getId(), testEntity.getName()));
  }
}
