package com.kakao.api.domain.product.api;

import com.kakao.api.domain.model.Product;
import com.kakao.api.domain.model.ProductCreationRequest;
import com.kakao.api.domain.product.application.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/product")
public class ProductApi {
    private ProductRepository productRep;

    @Autowired
    public ProductApi(ProductRepository boardRep) {
        this.productRep = boardRep;
    }

    @GetMapping()
    public String getProduct(){
        return String.format("product");
    }

    @PostMapping()
    public Product createProduct(@RequestBody ProductCreationRequest request){
        Product member = new Product();
        BeanUtils.copyProperties(request, member);
        return productRep.save(member);
    }
}
