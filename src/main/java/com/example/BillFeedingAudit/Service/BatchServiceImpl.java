package com.example.BillFeedingAudit.Service;

import com.example.BillFeedingAudit.Dao.BatchDao;
import com.example.BillFeedingAudit.Entities.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchDao batchDao;

    @Override
    public List<Batch> batchDetails(String invoice) {

        Batch newBatch=null;
        Batch oldBatch=null;

        List<Batch> comparedBatches = new ArrayList<>();


        //contains productlist of invoice no. which is entered in frontend
        List<Batch> blist = batchDao.findBypurfeednoIgnoreCase(invoice);
        System.out.println("Batch by Invoice: " + blist);

        for(Batch b : blist){
              newBatch=getNewBatch(b.getRndId());


            System.out.println("new Batch from function\n"+newBatch);

            oldBatch=getOldBatch(invoice, b.getProdid(),newBatch);
            System.out.println("old Batch from function\n"+oldBatch);

            if (oldBatch!=null && newBatch!=null){
                if (oldBatch.getMrp() != newBatch.getMrp() && oldBatch.getPurdate().before(newBatch.getPurdate())) {
                    System.out.println(newBatch.getProdid());
                    System.out.println("-------------------------------difference in batch Mrp's------------------------------");
                    System.out.println("newbatch" + newBatch);
                    System.out.println("oldbatch" + oldBatch);
                     comparedBatches.add(newBatch);
                     comparedBatches.add(oldBatch);
                }
            }

        }

        return comparedBatches;
    }

    public Batch getNewBatch(long rndid){
        return batchDao.getRecordById(rndid);
    }

    public Batch getOldBatch(String invoice,String prodid,Batch newBatch){
        Queue<Batch> qlist = new LinkedList<>();
        Batch oldBatch=null;
        qlist.addAll(batchDao.productListSortByDate(prodid));


        for (int i=0 ; i<= qlist.size();i++) {
            oldBatch=null;
            Batch batchQueue = qlist.poll();

            if (batchQueue.getPurfeedno().equals(invoice)==false && batchQueue.getPurdate().before(newBatch.getPurdate()) && batchQueue.getBatchno().equals(newBatch.getBatchno())==false)
            {
                oldBatch=batchQueue;
                qlist.clear();
                break;
            }

        }
        return oldBatch;
    }
}