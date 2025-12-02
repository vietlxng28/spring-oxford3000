package com.vietlong.sandbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "oxford3000", schema = "oxford3000")
public class Oxford3000 {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "word", nullable = false)
  private String word;

  @Column(name = "class_of_word", nullable = false)
  private String classOfWord;

  @Column(name = "level", nullable = false)
  private String level;
}
