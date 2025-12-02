package com.vietlong.sandbox.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vietlong.sandbox.repository.Oxford3000Repository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class Oxford3000Service {

  private final Oxford3000Repository oxford3000Repository;

  public List<String> getAllOxford3000ClassOfWord() {
    List<String> classOfWord = oxford3000Repository.findAllClassOfWord();
    return classOfWord;
  };

  public List<String> getAllOxford3000Level() {
    List<String> level = oxford3000Repository.findAllLevel();
    return level;
  };

}
