package com.example.banksystem.repo;

import com.example.banksystem.model.TransactionHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

//Abstract Factory Pattern
public interface TransactionRepo extends MongoRepository<TransactionHistory, Integer> {

}
