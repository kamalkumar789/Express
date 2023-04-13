package com.example.Express.Service;

import com.example.Express.Model.Product;
import com.example.Express.POJOS.ProductRequest;
import com.example.Express.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Product> addProduct(ProductRequest productRequest) throws Exception{

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setVariant(productRequest.getVariant());
        product.setPrice(productRequest.getPrice());
        product = productRepository.save(product);

        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    public ResponseEntity<Product> getProductById(Integer id) throws Exception{
        Product product = productRepository.findById(id).orElse(null);
        if(product == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    public ResponseEntity deleteProductById(Integer id) throws Exception{

        if(productRepository.findById(id).orElse(null) != null){
            productRepository.deleteById(id);
        }else {
            return new ResponseEntity("Product doesn't exists on this id: "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successfully deleted successfully on this id: "+id,HttpStatus.OK);
    }
}