package com.dipen.ods.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipen.ods.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
