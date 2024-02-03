package com.hotwaxx.Assesment.repository;

import com.hotwaxx.Assesment.entity.Person;
import com.hotwaxx.Assesment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
