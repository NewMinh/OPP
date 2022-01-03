    
package PhieuNhap;

import java.io.Serializable;
import java.util.Date;

public class PhieuNhap implements Serializable{
    private String MaPhieuNhap;
    private String mancc;
    private String Manv;
    private Date ThoiGianNhap;
    private double TongDonGia;
    public PhieuNhap(){
        
    }
    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }
    
    public Date getThoiGianNhap() {
        return ThoiGianNhap;
    }

    public void setThoiGianNhap(Date ThoiGianNhap) {
        this.ThoiGianNhap = ThoiGianNhap;
    }
    

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }
    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }
    public double getDonGia() {
        return TongDonGia;
    }
    public void setDonGia(double DonGia) {
        this.TongDonGia = DonGia;
    }     
    public void XuatPhieuNhap(){
            
            System.out.format("\n%5s | ", MaPhieuNhap);
            System.out.format("%18s | ",Manv);
            System.out.format("%22s |", mancc);
            System.out.format("%40s |", ThoiGianNhap);
            //System.out.format("%17s |\n", TongDonGia);
        }
    }

