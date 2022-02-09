package com.example.BillFeedingAudit.Dto;

import com.example.BillFeedingAudit.Entities.Product;

import javax.persistence.Column;
import java.util.Date;

public class BatchDto{
    private Long rndid;

    private String batchno;

    private Long prodid;

    private String pname;

    private double Margin;


    private double Mrp;


    private String purfeedno;

    private Date Purdate;


    public Date getPurdate() {
        return Purdate;
    }

    public void setPurdate(Date purdate) {
        Purdate = purdate;
    }

    public Long getRndid() {
        return rndid;
    }

    public void setRndid(Long rndid) {
        this.rndid = rndid;
    }

    public String getBatchno() {
        return batchno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public void setMargin(double margin) {
        Margin = margin;
    }

    public Long getProdid() {
        return prodid;
    }

    public void setProdid(Long prodid) {
        this.prodid = prodid;
    }

    public double getMargin() {
        return Margin;
    }

    public void setMargin(int margin) {
        Margin = margin;
    }

    public double getMrp() {
        return Mrp;
    }

    public void setMrp(double mrp) {
        Mrp = mrp;
    }

    public String getPurfeedno() {
        return purfeedno;
    }

    public void setPurfeedno(String purfeedno) {
        this.purfeedno = purfeedno;
    }
}


