
package SanPham;

import java.io.Serializable;
import java.util.Scanner;

public abstract class SanPham implements Serializable{
    String MaSanPham;
    String TenSanPham;
    String MaNhaCungCap;
    String MaHang;
    String loaihang;
    int Soluong;    
    private int gianhap,giaban;  

   

    public SanPham(){
        this.MaSanPham=null;
        this.TenSanPham=null;
        this.MaNhaCungCap=null;
        this.loaihang=null;
        this.MaHang=null;
        this.Soluong=0;
        this.gianhap=0;
        this.giaban=0;
    }
    public String loai(){
        return loaihang;      
    }
    public void ten(){
        
    }
    public void NhapSanPham(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Ma San Pham:");
        MaSanPham=sc.nextLine();
        System.out.println("Nhap Ten San Pham:");
        TenSanPham=sc.nextLine();
        System.out.println("Nhap Ma Nha Cung Cap:");
        MaNhaCungCap=sc.nextLine();
        System.out.println("Nhap Ma Hang:");
        MaHang=sc.nextLine();
        System.out.println("Nhap gia nhap:");
        gianhap=sc.nextInt();
        System.out.println("Nhap gia ban:");
        giaban=sc.nextInt();
        System.out.println("Nhap So Luong:");
        Soluong=sc.nextInt();
                
       
    }
    
    public void XuatSanPham(){
        
        System.out.format("%5s  |", MaSanPham);
        System.out.format("%17s  |", TenSanPham);
        System.out.format("%20s |", loaihang);
        System.out.format("%22s  |", MaHang);
        System.out.format("%22s  |", MaNhaCungCap);
        System.out.format("%20d  |", Soluong);
        System.out.format("%20d  |",gianhap);
        System.out.format("%20d |\n", giaban);
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        this.Soluong = soluong;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }
    
    public String getMaSanPham() {
        return MaSanPham;
    }
   
    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
       
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String mahang) {
        this.MaHang = mahang;
    }

    public String getLoaihang() {
        return loaihang;
    }
    public void setLoaihang(String loaihang) {
        this.loaihang = loaihang;
    }
    
}


    

