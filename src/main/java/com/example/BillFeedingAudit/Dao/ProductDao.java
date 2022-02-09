package com.example.BillFeedingAudit.Dao;

import com.example.BillFeedingAudit.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,String> {

}
