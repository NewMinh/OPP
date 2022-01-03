package KhachHang;

import DungChung.Kiemtraloi;
import java.io.Serializable;
import java.util.Scanner;

public class Khachhang implements Serializable{
    private String MaKH;
    private String Hoten;
    private String Phone;
    private String ngaymua;
    private transient Kiemtraloi KT = new Kiemtraloi();
    transient Scanner sc = new Scanner(System.in);

    public Khachhang(String MaKH, String Hoten, String Phone,String ngaymua) {
        this.Hoten=Hoten;
        this.Phone=Phone;
        this.MaKH = MaKH;
        this.ngaymua=ngaymua;
    }
    public Khachhang() {
    	this.Hoten=null;
        this.Phone=null;
        this.ngaymua=null;
        this.MaKH = null;
    }
    public String getHoTen() {
        return Hoten;
    }

    public void setHoTen() {
    	do{
            System.out.print("Nhập họ tên: ");
            this.Hoten = sc.nextLine();
        }while(Hoten.matches("[a-zA-Z]*")==false);
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
    public String getPhone() {
        return Phone;
    }
    public String getngaymua() {
        return ngaymua;
    }

    public void setngaymua() {
        ngaymua=KT.KiemTraNgay();
    }
    public void setPhone() {       
       
            do {
                System.out.print("Nhap so dien thoai: ");
                this.Phone=sc.nextLine();
            } while(Phone.isEmpty() || Phone.matches("[0-9]{10}")==false);
    }
    public void nhapkh()
    {
    	setHoTen();
    	setngaymua();
    	setPhone();
    }
    @Override
    public String toString() {
        return "{" + "Makhachhhang=" + MaKH + "hoTen=" + Hoten + ", ngaymua=" + ngaymua + ", phone=" + Phone + " }";
    }
    
    public void XuatKH() {
        System.out.printf("%5s%20s%15s%15s\n",MaKH,Hoten,ngaymua,Phone);
    }
}
