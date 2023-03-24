package com.kakao.api.domain.model;

import lombok.Data;

@Data
public class ProductCreationRequest {
    private String name;
    private Double price;
}
