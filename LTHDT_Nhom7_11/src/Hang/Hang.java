/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hang;

import java.io.Serializable;

/**
 *
 * @author Windows10
 */
public class Hang implements Serializable {

  
    
     private String MaHang;
    private String TenHang; 
    public Hang(){
        
    }
        

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    
    public void XuatHang(){
       
        System.out.format("\n%5s | ", MaHang);
        System.out.format("%17s | ", TenHang);
        
    }
}


