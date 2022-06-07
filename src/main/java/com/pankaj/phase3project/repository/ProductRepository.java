package com.pankaj.phase3project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankaj.phase3project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findAllProductsByCategory_Id(int id);

}
