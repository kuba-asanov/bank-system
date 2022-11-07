package com.example.banksystem.repo;

import com.example.banksystem.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//Abstract Factory Pattern
@CrossOrigin(origins = "http://localhost:3000")
public interface MongoRepo extends MongoRepository<Customers, String> {

}
