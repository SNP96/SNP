package com.example.BillFeedingAudit.Controller;

import com.example.BillFeedingAudit.Dto.BatchDto;
import com.example.BillFeedingAudit.Dto.ProductDto;
import com.example.BillFeedingAudit.Entities.Batch;
import com.example.BillFeedingAudit.Entities.Product;
import com.example.BillFeedingAudit.Service.BatchService;
import com.example.BillFeedingAudit.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BillAuditingController {

    @Autowired
    ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BatchService batchService;



    @GetMapping(value = "/productdetails")
    public ResponseEntity productDetails(){


        ResponseEntity responseEntity = null;
        List<Product> pList = new ArrayList<>();
        pList = productService.Pdetails();

        List<ProductDto> pListDto = new ArrayList<>();
        for (Product p: pList) {
            pListDto.add(modelMapper.map( p, ProductDto.class));
        }

        return new ResponseEntity(pListDto, HttpStatus.OK);
    }

    @GetMapping(value="/billauditing")
    public ResponseEntity billaudit(@RequestParam String invoice)throws Exception{
        List<Batch> blist = new ArrayList<>();
        System.out.println("Value of parameter"+invoice);

        blist=batchService.batchDetails(invoice);

        List<BatchDto> bListDto = new ArrayList<>();
        for (Batch b : blist){
            BatchDto b1 = modelMapper.map(b,BatchDto.class);
            b1.setPname(b.getProduct().getName());
            bListDto.add(b1);;
        }

        return new ResponseEntity(bListDto,HttpStatus.OK);
    }
}
