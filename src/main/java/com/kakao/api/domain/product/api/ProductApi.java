package com.kakao.api.domain.product.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductApi {
    @GetMapping()
    public String getProduct(){
        return String.format("product");
    }

    @PostMapping()
    public String createProduct(){
        // TODO: post API 구현
        return String.format("product");
    }
}
