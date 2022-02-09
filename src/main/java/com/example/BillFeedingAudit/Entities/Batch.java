package com.example.BillFeedingAudit.Entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "rndid",nullable = false)
    private long RndId;

    @Column(nullable = false,updatable = false)
    private String batchno;

    @Column(nullable = false,updatable = false)
    private String prodid;

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prodid", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Product product;


    @Column(nullable = false,updatable = false)
    private double margin;

    @Column(nullable = false,updatable = false)
    private double mrp;

    @Column(nullable = false,updatable = false)
    private String purfeedno;

    @Column(nullable = false,updatable = false)
    private Date Purdate;

//    @ManyToOne(fetch=FetchType.EAGER,targetEntity = Product.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "prodid",insertable = false,updatable = false,referencedColumnName = "RndId" )
//    @ManyToOne
//    @JoinColumn(name = "prodid",nullable = false)
//    private Product product;
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public Date getPurdate() {
        return Purdate;
    }

    public void setPurdate(Date purdate) {
        Purdate = purdate;
    }

    public Long getRndId() {
        return RndId;
    }

    public void setRndId(Long rndId) {
        RndId = rndId;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public void setRndId(long rndId) {
        RndId = rndId;
    }


    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public String getPurfeedno() {
        return purfeedno;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPurfeedno(String purfeedno) {
        this.purfeedno = purfeedno;
    }


    @Override
    public String toString() {
        return "Batch{" +
                "RndId=" + RndId +
                ", batchno='" + batchno + '\'' +
                ", prodid='" + prodid + '\'' +
                ", pname='" + product.getName() + '\'' +
                ", margin=" + margin +
                ", mrp=" + mrp +
                ", purfeedno='" + purfeedno + '\'' +
                ", Purdate=" + Purdate +
                '}';
    }
}
