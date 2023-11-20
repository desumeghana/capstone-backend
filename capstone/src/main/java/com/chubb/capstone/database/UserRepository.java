package com.chubb.capstone.database;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chubb.capstone.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {



	Optional<User> findByEmail(String email);

}
