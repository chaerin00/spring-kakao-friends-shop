package com.kakao.api.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    private String id=UUID.randomUUID().toString();
    @Column(length = 50)
    private String name;

    @Column(nullable = false)
    private Double price;
}

