package com.asaheyt.testProject.features.tests.domain.useCases;

import com.asaheyt.testProject.features.tests.presentation.dto.TestDto;
import com.asaheyt.testProject.features.tests.domain.models.Test;
import com.asaheyt.testProject.features.tests.domain.services.TestService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record CreateTestUseCase(
  TestService testService
) {
  public Mono<Test> invoke(TestDto testDto) {
    return testService.create(testDto);
  }
}
