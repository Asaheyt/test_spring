package com.epam.asaheyt.test.features.tests.domain.useCases;

import com.epam.asaheyt.test.features.tests.domain.models.Test;
import com.epam.asaheyt.test.features.tests.domain.services.TestService;
import com.epam.asaheyt.test.features.tests.presentation.dto.TestDto;
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
