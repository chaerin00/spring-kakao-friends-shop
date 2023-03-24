package com.kakao.api.domain.product.api;

import com.kakao.api.domain.model.Product;
import com.kakao.api.domain.model.ProductCreationRequest;
import com.kakao.api.domain.product.application.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/product")
public class ProductApi {
    private ProductRepository productRep;

    @Autowired
    public ProductApi(ProductRepository boardRep) {
        this.productRep = boardRep;
    }

    @GetMapping()
    public List<Product> getProductList(){
        return productRep.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductDetail(@PathVariable String id) throws Exception {
        Optional<Product> product=productRep.findById(id);
        if(product.isPresent()){
            return product.get();
        }

        throw new RuntimeException("Cannot find any product under given ID");
    }

    @PostMapping()
    public Product createProduct(@RequestBody ProductCreationRequest request){
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        return productRep.save(product);
    }
}
