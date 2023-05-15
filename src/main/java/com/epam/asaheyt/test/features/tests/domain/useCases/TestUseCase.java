package com.epam.asaheyt.test.features.tests.domain.useCases;

import com.epam.asaheyt.test.features.tests.domain.models.Test;
import com.epam.asaheyt.test.features.tests.domain.services.TestService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public record TestUseCase(
  TestService testService
) {
  public Flux<Test> invoke(String name) {
    return testService.test(name);
  }
}
