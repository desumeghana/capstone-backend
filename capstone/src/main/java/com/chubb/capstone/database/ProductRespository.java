package com.chubb.capstone.database;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.chubb.capstone.model.Product;

@Repository
public interface ProductRespository extends MongoRepository<Product,String> {

	List<Product> findByCategory(String category);
	
	 @Query("{ title : { $regex : ?0 ,$options: 'i' }}")
     List<Product> getProductByTitleRegEx(String title);
	
	
}
