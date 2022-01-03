package HoaDon;

import DungChung.Kiemtraloi;
import java.io.Serializable;
import java.util.Scanner;

public class Hoadon implements Serializable{
    private static final long serialVersionUID = 7011625783441273367L;
    private String MaHD;
    protected String MaNV;
    protected String MaKH;
    private String NgayxuatHD;
    private double Thanhtien;
    private transient Kiemtraloi KT= new Kiemtraloi();;
    private transient Scanner sc = new Scanner(System.in);

    public Hoadon(String MaHD, String MaNV, String MaKH, String NgayxuatHD,double Thanhtien) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.NgayxuatHD = NgayxuatHD;
        this.Thanhtien=Thanhtien;
    }
    
    public Hoadon() {
        this.MaHD = null;
        this.MaNV = null;
        this.MaKH = null;
        this.NgayxuatHD = null;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }
    public void setMaHD() {
        while(true)
        {
        	System.out.println("Nhập mã HD HD-SSS: (VD: HD-011)");
        	this.MaHD = sc.nextLine();
        	if(MaHD.matches("HD-"+"[0-9]{3}"))
        	{
        		break;
        	}
        }
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    public void setMaNV() {
        while(true)
        {
        	System.out.println("Nhập mã NV : (VD: 01)");
        	this.MaNV = sc.nextLine();
        	if(MaNV.matches("[0-9]{2}"))
        	{
        		break;
        	}
        }
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }
    public void setMaKH() {
    	
            while(true)
            {
            	System.out.println("Nhập mã khách hàng KH-SSS: (VD: KH-011)");
            	this.MaKH = sc.nextLine();
            	if(MaKH.matches("KH-"+"[0-9]{3}"))
            	{
            		break;
            	}
            }
    }

    public String getNgayxuatHD() {
        
       
        return this.NgayxuatHD;
    }

    public void setNgayxuatHD(String NgayxuatHD) {
        this.NgayxuatHD = NgayxuatHD;
    }
    public void setNgayxuatHD() {
        this.NgayxuatHD = KT.KiemTraNgay();
    }
    
    public double getThanhtien() {
        return Thanhtien;
    }
    
    public void setThanhtien(double xx) {
        this.Thanhtien = xx;
    }
    
    public void NhapHD(){
        setMaKH();
        setMaNV();
        setNgayxuatHD();
    }
    
    
    
    public void Copy(Hoadon a){
        this.MaHD=a.getMaHD();
        this.MaKH=a.getMaKH();
        this.MaKH=a.getMaKH();
        this.Thanhtien=a.getThanhtien();
    }
    public String toString() {
        return "{" + "MaHoaDon=" + MaHD + ", MaNhanVien=" + MaNV + ", MaKhachHang=" + MaKH + ", NgayBan=" + NgayxuatHD + ", Thanhtien=" + Thanhtien + '}';
    }
    public static void main(String[] args) {
        Hoadon a = new Hoadon();
        System.out.println(a.getNgayxuatHD());
                
    }
}
