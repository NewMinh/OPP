package KhachHang;

import DungChung.Kiemtraloi;
import DungChung.docfileghifile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class DSKhachHang implements Serializable,docfileghifile {
    Khachhang []DSKH;
    private int SLKH;
    private transient Kiemtraloi KTra = new Kiemtraloi();
    private transient Scanner sc = new Scanner(System.in);

    public DSKhachHang(Khachhang[] DSKH, int SLKH) {
        this.DSKH = DSKH;
        this.SLKH = SLKH;
    }
    
    public DSKhachHang() {
        this.DSKH = null;
        this.SLKH = 0;
    }

    public int getSLKH() {
        return SLKH;
    }

    public void setSLKH(int SLKH) {
        this.SLKH = SLKH;
    }
    
    public void docfile(){
        DSKH=new Khachhang[SLKH];
        try {
            FileInputStream fi=new FileInputStream("DSKHout.txt");
            ObjectInputStream ois=new ObjectInputStream(fi);
            while (fi.available()>0){
                DSKH=Arrays.copyOf(DSKH, DSKH.length+1);
                Khachhang obj=(Khachhang) ois.readObject();
                DSKH[SLKH]=obj;
                SLKH++;
            }                
            ois.close();
            fi.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }    
           
    }
    
    public void ghifile(){
        try {
            FileOutputStream f=new FileOutputStream("DSKHout.txt");
            ObjectOutputStream oos=new ObjectOutputStream(f);             
            for (int i=0;i<SLKH;i++)
                oos.writeObject(DSKH[i]);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ThemNhieuKhachHang(){
        int sl;
        String tmp;
        Khachhang[] sv;
        while(true){
        do{
        	System.out.print("\nNhap so luong khach hang muon them: ");
            tmp=sc.nextLine();
        }while(tmp.isEmpty());
        if(KTra.isNumber(tmp)==true){
            sl = Integer.parseInt(tmp);
            break;
        }
        else{
            System.out.println("Du lieu nhap vao khong hop le.Vui long nhap lai !!!");
        }
        }
    
        sv=new Khachhang[sl];
        for (int i=0;i<sl;i++){
            System.out.printf("Nhập khách hàng thứ %d : ", (i+1));
            sv[i]=new Khachhang();
            sv[i].setMaKH();
            if(TimkiemMa(sv[i].getMaKH())==true) {
                do {
                    System.out.println("Ma KH da ton tai trong he thong!!!");
                    System.out.println("Vui long nhap lai !!!!!");
                    System.out.println("Danh sach Ma KH co san la: " + ListMaKH());
                    sv[i].setMaKH();
                } while(TimkiemMa(sv[i].getMaKH())==true);
            }
            sv[i].nhapkh();
            DSKH= Arrays.copyOf(DSKH, DSKH.length+1);
            DSKH[SLKH]=sv[i];
            SLKH++;
        }
    }
    
    public String ListMaKH(){
        String s = "";
        for (int i = 0;i < SLKH;i++){
            s+= DSKH[i].getMaKH();
            if(i != SLKH-1){
                s+=',';
            }
        }
        return s;
    }
    
    public void XoaKhachHang(){
        if(SLKH == 0){
            System.out.println("He thong khong co khach hang nao het !!!");
            return;
        }
        System.out.println("Danh sach ma khach hang co trong he thong la : " + ListMaKH());
        
        String msv;
        System.out.println("Co "+SLKH+" khach hang trong he thong");
        do{
            System.out.print("Nhap Ma KH can xoa: ");
            msv=sc.nextLine();
        } while(msv.isEmpty()||msv.matches("KH-"+"[0-9]{3}")==false);
        int kt = 0;
        for (int i=0;i<SLKH;i++)
            if (DSKH[i].getMaKH().equalsIgnoreCase(msv)){
                for (int j=i;j<SLKH-1;j++)
                    DSKH[j]=DSKH[j+1];
                SLKH--;
                kt = 1;
                break;
            }
        if (kt==0)
            System.out.println("Khong tim thay MaKH can xoa");
    }
    
    public void TimkiemtheoMa(){
        if(SLKH == 0){
            System.out.println("He thong khong co khach hang nao het !!!");
            return;
        }
        System.out.println("Danh sach ma khach hang co trong he thong la : " + ListMaKH());
        
        int kt=0;
        String msv;
        do{
            System.out.print("Nhap Ma KH can tim: ");
            msv=sc.nextLine();
        } while(msv.isEmpty());
        for (int i=0;i<SLKH;i++)
            if (DSKH[i].getMaKH().equalsIgnoreCase(msv)){
                kt=1;
                System.out.printf("\"%-12s%-30s%-12s%-12s%-15s%-35s\n","Ma KH","Ho ten KH", "Gioi Tinh", "Ngay Sinh", "Phone", "Dia Chi");
                DSKH[i].XuatKH();
                break;
            }
        if (kt==0)
            System.out.println("Khong tim thay Ma KH do");
    }
    
    public void SuaKH(){
        if(SLKH == 0){
            System.out.println("He thong khong co khach hang nao het !!!");
            return;
        }
        System.out.println("Danh sach ma khach hang co trong he thong la : " + ListMaKH());
        
        String msv;
        do{
            System.out.print("Nhap Ma KH can sua: ");
            msv=sc.nextLine();
        } while(msv.isEmpty());
        int i;
        for (i=0;i<SLKH;i++)
            if (DSKH[i].getMaKH().equalsIgnoreCase(msv)){
                System.out.println("Thong tin KH truoc khi sua: ");
                System.out.printf("%15s%15s%20s%20s\n","\nMa KH","Ho ten","Ngày mua","So dien thoai");
                DSKH[i].XuatKH();
                System.out.println("Sua Thong Tin KH");
                DSKH[i]=new Khachhang(DSKH[i].getMaKH(),"","","");
                DSKH[i].nhapkh();
                break;
            }
        if(i >= SLKH){
            System.out.println("Khong tim thay Ma KH de sua !!!");
            return;
        }
    }
    
    public boolean TimkiemMa(String s){
        for (int i = 0;i < DSKH.length;i++){
            if(DSKH[i].getMaKH().equals(s)){
                return true;
            }
        }
        return false;
    }
    
    public void XuatDSKhachHang(){
        if(DSKH == null){
            System.out.println("Danh sách rỗng!");
            return ;
        }
        System.out.format("%15s%15s%20s%20s\n","\nMa KH","Ho ten","Ngày mua","So dien thoai");
        for (int i = 0;i < SLKH;i++){
        	System.out.format("\n%5s",DSKH[i].getMaKH());
            System.out.format("%20s",DSKH[i].getHoTen());
            System.out.format("%15s",DSKH[i].getngaymua());
            System.out.format("%15s",DSKH[i].getPhone());
        }
        System.out.println();
    }
    public void timkiemkh(){
        String k;
        String UName;
        do{
            
                System.out.println("\nNhap vao Ho ten hay Ma Khach hang hay Sdt:");
                UName=sc.nextLine();
            while(UName.isEmpty())
            {
            	System.out.println("Nhap vao Ho ten hay Ma Khach hang hay Sdt:");
                UName=sc.nextLine();
            }
            System.out.format("%15s%15s%20s%20s\n","\nMa KH","Ho ten","Ngày mua","So dien thoai");
            for(int i=0;i<SLKH;i++) {
                if(DSKH[i].getHoTen().toLowerCase().contains(UName.toLowerCase()) || DSKH[i].getMaKH().toLowerCase().contains(UName.toLowerCase()) || DSKH[i].getPhone().contains(UName)){
                	System.out.format("\n%5s",DSKH[i].getMaKH());
                    System.out.format("%20s",DSKH[i].getHoTen());
                    System.out.format("%15s",DSKH[i].getngaymua());
                    System.out.format("%15s",DSKH[i].getPhone());
                }
            }
            System.out.print("\nNhap 1 de tim tiep. Nhap phim bat ky de thoat" );
            k=sc.nextLine();
        }while(k.matches("1")==true);
    }
    public static void Ghi() {
        DSKhachHang ds = new DSKhachHang();
        ds.DSKH=new Khachhang[4];
        ds.SLKH=4;
        
        ds.DSKH[0]=new Khachhang("KH-001", "Kieu Minh Tu", "0123442324", "23/01/2001");
        ds.DSKH[1]=new Khachhang("KH-002", "Le Hong Viet", "0123465893","25/01/2012");
        ds.DSKH[2]=new Khachhang("KH-003", "Tan Dung", "0123442431", "22/04/2020");
        ds.DSKH[3]=new Khachhang("KH-004", "Phan Thanh Toan", "0345436789", "24/01/2021");
        
        ds.ghifile();
        //ds.XuatDSKhachHang();
        //ds.ThemNhieuKhachHang();
        //ds.timkiemkh();
    }
    public static void main(String[] args) {
    	Ghi();
    	//DSKhachHang ds = new DSKhachHang();
        //ds.docfile();
        //ds.XuatDSKhachHang();
        //ds.timkiemkh();
        //ds.ThemNhieuKhachHang();
        //ds.timkiemkh();
        //ds.SuaKH();
        //ds.XoaKhachHang();
        //ds.XuatDSKhachHang();
        //ds.ghifile();
        //ds.docfile();
        //ds.XuatDSKhachHang();
    }
}
