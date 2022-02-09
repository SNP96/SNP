package com.example.BillFeedingAudit.Service;

import com.example.BillFeedingAudit.Dao.ProductDao;
import com.example.BillFeedingAudit.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> Pdetails() {
        List<Product> productList =productDao.findAll();
        return  productList;
    }
}
