package com.vietlong.sandbox.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "permissions", schema = "oxford3000")
@Data
@EqualsAndHashCode(exclude = {"users"})
@AllArgsConstructor
@NoArgsConstructor
public class Permissions {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "permission_code", nullable = false)
  private String permissionCode;

  @Column(name = "description")
  private String description;

  @JsonIgnore
  @ManyToMany(mappedBy = "permissions")
  private Set<User> users;
}
