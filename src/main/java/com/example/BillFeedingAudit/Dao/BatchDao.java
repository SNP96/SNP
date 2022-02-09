package com.example.BillFeedingAudit.Dao;

import com.example.BillFeedingAudit.Entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchDao extends JpaRepository<Batch,Integer> {

    List<Batch> findBypurfeednoIgnoreCase(String invoice);
    List<Batch> findByprodid(long prodid);

    @Query("select b from Batch b where b.prodid =:pid  ORDER BY b.Purdate desc")
    List<Batch> productListSortByDate(@Param("pid") String prodid);

//    @Query("select b from Product p JOIN p.ProductNames b where b.RndId =:pid ORDER BY b.Purdate DESC")
//    List<Batch> productListSortByDateJPQL(@Param("pid") String prodid);

//        @Query("select p.Name, b.batchno,b.mrp,b.purfeedno, b.Purdate from Batch b JOIN b.Product p where b.prodid =:pid ORDER BY b.Purdate DESC")
//        List<Batch> Join2(@Param("pid") String prodid);

//        @Query("select p.Name, b.batchno,b.mrp,b.purfeedno, b.Purdate from Batch b JOIN b.pname p where b.prodid =:pid ORDER BY b.Purdate DESC")
//        List<Batch> Join(@Param("pid") String prodid);

    @Query(value = "select Product.Name,Batch.RndId,Batch.ProdId,Batch.Purdate,Batch.PurFeedNo from Batch LEFT JOIN Product on Product.RndId = Batch.ProdId WHERE Batch.ProdId=:pid ORDER BY Batch.PurDate DESC;",nativeQuery = true)
    List<Batch> productListSortByDateNativeQuery(@Param("pid") String prodid);

    @Query("select r from Batch r where r.RndId =:rid ORDER BY r.Purdate desc ")
    Batch getRecordById(@Param("rid")long rndid);

}
