package SanPham;

import java.io.Serializable;
import java.util.Scanner;

public class CPU extends SanPham implements Serializable{

    public CPU() {
        super();
    
    }
    
    public String getMaCPU() {
        return super.getMaSanPham();
    }
    public void setMaCPU(String macpu) {
        super.MaSanPham = macpu;
    }
    public String getTen() {
        return super.TenSanPham;
    }
    public void setTen(String Ten) {
       super.TenSanPham=Ten;
    }

    
    public String getMaSanPham() {
        return MaSanPham;
    }
    
    
    public void setMaSanPham(String MaSanPham) {
        super.MaSanPham = MaSanPham;
    }

    
    public String getTenSanPham() {
        return TenSanPham;
    }

    
    public void setTenSanPham(String TenSanPham) {
        super.TenSanPham = TenSanPham;
    }

    @Override
    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong){
        super.Soluong = soluong;
    }
   public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        super.MaNhaCungCap = MaNhaCungCap;
    }

    public String getMaHang() {
        return super.MaHang;
    }

    public void setMaHang(String Mahang) {
        this.MaHang = Mahang;
    }
    @Override
    public String loai(){
        super.setLoaihang("CPU:");
        return super.getLoaihang();
    }
    
}
