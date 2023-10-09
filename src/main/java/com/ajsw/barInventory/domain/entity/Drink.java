package com.ajsw.barInventory.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "drink")
@Data // Anotación que agrega getters, setters, toString, equals, hashCode, etc.
@NoArgsConstructor // Genera un constructor sin argumentos
public class Drink{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;
}
