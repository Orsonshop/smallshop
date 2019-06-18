package com.example.smallshop.api.bean;


import javax.persistence.*;

@Entity
@Table(name = "pmanage")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String pname;



    @Column
    private String ptype;

    @Column
    private String pprice;

    @Column
    private String pnumber;

    @Column
    private String pdate;

    @Column
    private String duration;

    public Product() {
    }

    public Product(String pname, String ptype, String pprice, String pnumber, String pdate, String duration) {
        this.pname = pname;
        this.ptype = ptype;
        this.pprice = pprice;
        this.pnumber = pnumber;
        this.pdate = pdate;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
