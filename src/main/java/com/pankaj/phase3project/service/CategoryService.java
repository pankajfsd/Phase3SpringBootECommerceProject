package com.pankaj.phase3project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.phase3project.model.Category;
import com.pankaj.phase3project.repository.CategoryRepository;
import com.pankaj.phase3project.repository.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}
	
	public Optional<Category> getCategoryById(int id){
		return categoryRepository.findById(id);
	}

	public void removeProdById(long id) {
		productRepository.deleteById(id);
		
	}

}
