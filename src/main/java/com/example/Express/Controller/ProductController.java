package com.example.Express.Controller;


import com.example.Express.Model.Product;
import com.example.Express.POJOS.ProductRequest;
import com.example.Express.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) throws Exception{
        return productService.addProduct(productRequest);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) throws Exception{
        return productService.getProductById(id);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) throws Exception{
        return productService.deleteProductById(id);
    }
}
