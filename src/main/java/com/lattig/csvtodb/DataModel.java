package com.lattig.csvtodb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "data_model")
public class DataModel implements Serializable {

    @Id
    private Integer id;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private boolean H;
    private boolean I;
    private String J;

    @Column(name = "A")
    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    @Column(name = "B")
    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    @Column(name = "C")
    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    @Column(name = "D")
    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    @Column(name = "E")
    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    @Column(name = "F")
    public String getF() {
        return F;
    }

    public void setF(String f) {
        F = f;
    }

    @Column(name = "G")
    public String getG() {
        return G;
    }

    public void setG(String g) {
        G = g;
    }

    @Column(name = "H")
    public boolean isH() {
        return H;
    }

    public void setH(boolean h) {
        H = h;
    }

    @Column(name = "I")
    public boolean isI() {
        return I;
    }

    public void setI(boolean i) {
        I = i;
    }

    @Column(name = "J")
    public String getJ() {
        return J;
    }

    public void setJ(String j) {
        J = j;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
