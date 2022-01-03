/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhaCungCap;

import java.io.Serializable;

public class NhaCungCap implements Serializable{
     private String MaNhaCungCap;
    private String TenNhaCungCap;
    private String QuocGia;  
    public NhaCungCap(){
        
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return TenNhaCungCap;
    }

    public void setTenNhaCungCap(String TenNhaCungCap) {
        this.TenNhaCungCap = TenNhaCungCap;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String QuocGia) {
        this.QuocGia = QuocGia;
    }
    public void XuatNhaCungCap(){
       
        System.out.format("\n%5s | ", MaNhaCungCap);
        System.out.format("%17s | ", TenNhaCungCap);
        System.out.format("%19s |", QuocGia);
    }
}
