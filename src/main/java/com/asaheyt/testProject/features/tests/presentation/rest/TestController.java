package com.asaheyt.testProject.features.tests.presentation.rest;

import com.asaheyt.testProject.features.tests.presentation.dto.TestDto;
import com.asaheyt.testProject.features.tests.domain.useCases.CreateTestUseCase;
import com.asaheyt.testProject.features.tests.domain.useCases.TestUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/tests")
public class TestController {

  private final TestUseCase testUseCase;
  private final CreateTestUseCase createTestUseCase;

  public TestController(TestUseCase testUseCase, CreateTestUseCase createTestUseCase) {
    this.testUseCase = testUseCase;
    this.createTestUseCase = createTestUseCase;
  }

  @GetMapping
  @SecurityRequirement(name = "basicAuth")
  public Mono<ResponseEntity<?>> getTests(
    @RequestParam String name
  ) {
    return Mono.just(ResponseEntity.ok(testUseCase.invoke(name)));
  }

  @PostMapping
  public Mono<ResponseEntity<?>> createTest(
    @RequestBody TestDto testDto
    ) {
    return Mono.just(ResponseEntity.ok(createTestUseCase.invoke(testDto)));
  }
}
