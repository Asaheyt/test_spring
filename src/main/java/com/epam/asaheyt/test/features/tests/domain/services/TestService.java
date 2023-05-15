package com.epam.asaheyt.test.features.tests.domain.services;

import com.epam.asaheyt.test.features.tests.domain.models.Test;
import com.epam.asaheyt.test.features.tests.presentation.dto.TestDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TestService {
  Flux<Test> test(String name);

  Mono<Test> create(TestDto testDto);
}
