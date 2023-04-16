package com.example.Express.Controller;


import com.example.Express.Model.Product;
import com.example.Express.POJOS.ProductRequest;
import com.example.Express.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/express")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) throws Exception{
        log.info("In Product Controller");
        log.info("In addProduct function");
        return productService.addProduct(productRequest);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) throws Exception{
        log.info("In Product Controller");
        log.info("In getProductById function");
        return productService.getProductById(id);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) throws Exception{
        log.info("In Product Controller");
        log.info("In deleteById function");
        return productService.deleteProductById(id);
    }
}
