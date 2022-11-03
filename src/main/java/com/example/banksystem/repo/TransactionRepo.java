package com.example.banksystem.repo;

import com.example.banksystem.model.TransactionHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface TransactionRepo extends MongoRepository<TransactionHistory, Integer> {

}
