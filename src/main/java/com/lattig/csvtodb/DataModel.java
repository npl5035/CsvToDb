package com.lattig.csvtodb;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "data_model")
public class DataModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String H;
    private String I;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;

    public DataModel() {
    }

    public DataModel(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
        this.E = e;
        this.F = f;
        this.G = g;
        this.H = h;
        this.I = i;
        this.J = j;
    }
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
    public String getH() {
        return H;
    }

    public void setH(String h) {
        H = h;
    }

    @Column(name = "I")
    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    @Column(name = "J")
    public String getJ() {
        return J;
    }

    public void setJ(String j) {
        J = j;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
