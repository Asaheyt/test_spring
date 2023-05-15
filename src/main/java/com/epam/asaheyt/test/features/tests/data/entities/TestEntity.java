package com.epam.asaheyt.test.features.tests.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;


@Data
@Table("test")
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
  @Id
  @Column("id")
  private UUID id;
  @Column("name")
  private String name;

  public TestEntity(String name) {
    this.name = name;
  }
}
