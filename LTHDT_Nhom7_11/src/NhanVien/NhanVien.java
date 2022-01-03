/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;
import DungChung.ConNguoi;
import java.io.Serializable;
import java.util.Scanner;

public class NhanVien extends ConNguoi implements Serializable{
    protected String MaNhanVien;
    static Scanner sc = new Scanner(System.in); 
  
    public void XuatNhanVien(){
        System.out.format("%5s%18s%20s%25s%20s\n", "\nMa Nhan Vien", "Ten Nhan Vien","Ngay sinh", "Gioi tinh", "Phone");
            System.out.format("%5s | ", MaNhanVien);
            System.out.format("%15s | ",super.getHoten());
            System.out.format("%20s |", super.getNgaysinh());
            System.out.format("%22s | ", super.getGioitinh());
            System.out.format("%20s | ", super.getDienthoai());
    }
        
    
    public String getMaNhanVien() {
        return MaNhanVien;
    }
    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }
    public Scanner getSc() {
        return sc;
    }
    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    public String getHoten() {
        return super.getHoten();
    }
    public void setHoten(String hoten) {
        super.setHoten(hoten);
    }
    public String getNgaysinh() {
        return super.getNgaysinh();
    }
    public void setNgaysinh(String ngaysinh) {
       super.setNgaysinh(ngaysinh); 
    }
    public String getGioitinh() {
        return super.getGioitinh();
    }
    public void setGioitinh(String gioitinh) {
       super.setGioitinh(gioitinh);
    }
    public String getDienthoai() {
        return super.getDienthoai();
    }
    public void setDienthoai(String dienthoai) {
        super.setDienthoai(dienthoai);
    }
  
}

