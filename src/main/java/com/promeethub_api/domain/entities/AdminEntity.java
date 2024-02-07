package com.promeethub_api.domain.entities;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "\"admin\"")
public class AdminEntity extends UserEntity {


}