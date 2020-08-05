package com.example.SpringTomcat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.SpringTomcat.model.Expense;
 
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
     
    public List<Expense> findByItem(String item);
}