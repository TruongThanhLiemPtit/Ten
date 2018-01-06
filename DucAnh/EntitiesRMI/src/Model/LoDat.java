/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class LoDat implements Serializable{
    private String Ma,ChuLo,DiaDiem;
    private double DTD,DTC;

    public LoDat(String Ma, String ChuLo, String DiaDiem, double DTD, double DTC) {
        this.Ma = Ma;
        this.ChuLo = ChuLo;
        this.DiaDiem = DiaDiem;
        this.DTD = DTD;
        this.DTC = DTC;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getChuLo() {
        return ChuLo;
    }

    public void setChuLo(String ChuLo) {
        this.ChuLo = ChuLo;
    }

    public String getDiaDiem() {
        return DiaDiem;
    }

    public void setDiaDiem(String DiaDiem) {
        this.DiaDiem = DiaDiem;
    }

    public double getDTD() {
        return DTD;
    }

    public void setDTD(double DTD) {
        this.DTD = DTD;
    }

    public double getDTC() {
        return DTC;
    }

    public void setDTC(double DTC) {
        this.DTC = DTC;
    }

    @Override
    public String toString() {
        return Ma+"\t"+ChuLo+"\t"+DiaDiem+"\t"+DTD+"\t"+DTC;
    }

    

    
    
}
