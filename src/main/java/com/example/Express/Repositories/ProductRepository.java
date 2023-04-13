package com.example.Express.Repositories;

import com.example.Express.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByIdAndVariant(Integer id, String variant);

}
