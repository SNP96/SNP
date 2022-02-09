package com.example.BillFeedingAudit.Service;

import com.example.BillFeedingAudit.Entities.Batch;
import com.example.BillFeedingAudit.Entities.Product;

import java.util.List;

public interface BatchService {
    List<Batch> batchDetails(String invoice);
}
