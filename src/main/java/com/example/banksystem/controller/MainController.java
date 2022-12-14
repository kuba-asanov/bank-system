package com.example.banksystem.controller;

import com.example.banksystem.model.Customers;
import com.example.banksystem.model.TransactionHistory;
import com.example.banksystem.model.TransactionModel;
import com.example.banksystem.repo.MongoRepo;
import com.example.banksystem.repo.TransactionRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class MainController {
    public static int key=0;

    @Autowired
    private Customers customer;

    //Autowired Singleton
    @Autowired
    private MongoRepo mongorepo;

    //Autowired Singleton
    @Autowired
    private TransactionRepo tranRepo;

        @GetMapping("/")
        public String index() {
            return "Hello Kuba!";
        }

        @ApiOperation(value = "Getting all customers")
        @GetMapping("/getall")
        public ArrayList<Customers> getAllCustomers(){
            ArrayList <Customers> userlist = new ArrayList<>();
            mongorepo.findAll().forEach(userlist::add);
            return userlist;
        }

        @ApiOperation(value = "Get customer by uuid")
        @GetMapping("/get/{id}")
        public Customers getCustomer(@PathVariable String id) {
            return mongorepo.findById(id).get();
        }

        @ApiOperation(value = "Create customer")
        @PostMapping("/create")
        public String addCustomer(@RequestBody Customers customer) {
            mongorepo.save(customer);
            return "Added";
        }

        @ApiOperation(value = "Update customer")
        @PostMapping("/update")
        public String updateCustomer(@RequestBody Customers customer) {

            Customers newCustomer = new Customers(customer.getId(), customer.getName(), customer.getEmail(), customer.getMobile(), customer.getBalance());
            mongorepo.save(newCustomer);
            return "Update";
        }
        @Autowired
        private TransactionModel transaction;

        @ApiOperation(value = "Delete customer by uuid")
        @DeleteMapping("/delete/{id}")
        public String deleteCustomer(@PathVariable String id) {
            mongorepo.deleteById(id);
            return "Deleted";
        }

        @Autowired
        private TransactionHistory newTrans;

        @ApiOperation(value = "Top up balance")
        @PutMapping("/transaction")
        public String updateBalance(@RequestBody TransactionModel transaction ) {
            String id = transaction.getId();
            int amount = transaction.getBalance();
            Customers update = mongorepo.findById(id).get();
            amount = amount + mongorepo.findById(id).get().getBalance();
            update.setBalance(amount);
            mongorepo.save(update);

            newTrans.setId(++key);
            newTrans.setAccount_holder(mongorepo.findById(id).get().getName());
            newTrans.setAccount_number(mongorepo.findById(id).get().getId());
            newTrans.setAmount(transaction.getBalance());


            tranRepo.save(newTrans);

            return "Sent";
        }


        @ApiOperation(value = "Getting all transactions")
        @GetMapping("/transactions")
        public ArrayList<TransactionHistory> showTransactions(){

            ArrayList <TransactionHistory> history = new ArrayList<>();
            tranRepo.findAll().forEach(history::add);
            return history;

        }
    }

