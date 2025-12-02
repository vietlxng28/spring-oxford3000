package com.vietlong.sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.vietlong.sandbox.entity.Oxford3000;

public interface Oxford3000Repository extends JpaRepository<Oxford3000, Long> {

  @Query(value = "SELECT DISTINCT class_of_word FROM oxford3000.oxford3000", nativeQuery = true)
  List<String> findAllClassOfWord();

  @Query(value = "SELECT DISTINCT level FROM oxford3000.oxford3000", nativeQuery = true)
  List<String> findAllLevel();

}
