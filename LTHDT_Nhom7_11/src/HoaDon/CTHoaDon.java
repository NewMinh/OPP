package HoaDon;
import DungChung.Kiemtraloi;
import java.io.Serializable;
import java.util.Scanner;

public class CTHoaDon implements Serializable{
    private String MaHD;
    private String MaSP;
    private int SoLuong;
    private double Gia;
    private transient Kiemtraloi KTra = new Kiemtraloi();
    private transient Scanner sc=new Scanner(System.in);

    public CTHoaDon(String MaHD, String MaSP, int SoLuong, double Gia) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
    }
    
    public CTHoaDon() {
        this.MaHD = null;
        this.MaSP = null;
        this.SoLuong = 0;
        this.Gia = 0;
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

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }
    public void setMaSP() {
        while(true)
        {
        	System.out.println("Nhập mã SP: (VD: 01)");
        	this.MaSP = sc.nextLine();
        	if(MaSP.matches("[0-9]{2}"))
        	{
        		break;
        	}
        }
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    public void setSoLuong() {
        while(true){
            String tmp;
            do{
                System.out.print("Nhap so luong can nhap : ");
                tmp = sc.nextLine();
            }while(tmp.isEmpty());
            if(KTra.isNumber(tmp)==true){
                this.SoLuong = Integer.parseInt(tmp);
                break;
            }
            else{
                System.out.println("Du lieu nhap vao khong hop le.Vui long nhap lai !!!");
            }
        }
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
    public void setGia() {
        while(true){
            String tmp;
            do{
                System.out.print("Nhap vao gia nhap cua SP : ");
                tmp = sc.nextLine();
            } while(tmp.isEmpty());
            if(KTra.isNumber(tmp)== true){
                this.Gia = Double.parseDouble(tmp);
                break;
            }
            else{
                System.out.println("Nhap lai gia SP !!!");
            }
        }
    }
    
    public void NhapCTHD(){
       setMaSP();
       setSoLuong();
       setGia();
    }
    
    public void Copy(CTHoaDon a){
        this.MaHD = a.getMaHD();
        this.MaSP = a.getMaSP();
        this.SoLuong = a.getSoLuong();
        this.Gia = a.getGia();
    }
    
    public double TongHD(){
        return this.Gia*this.SoLuong;
    }
    
    @Override
    public String toString(){
        return "{ MaHoaDon = " + this.getMaHD() + ", Gia = " + this.getGia() + ",Soluong = " + this.getSoLuong()+"}";
    }
    
    public void XuatCThoadon(){
        System.out.printf("%-12s%-12s%-12s%-20s\n",this.getMaHD(),this.getMaSP(),this.getGia(),this.getSoLuong());
    }
}
