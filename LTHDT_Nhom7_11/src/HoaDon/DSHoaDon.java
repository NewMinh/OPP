package HoaDon;

import KhachHang.DSKhachHang;
import SanPham.DanhSachSanPham;
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

public class DSHoaDon implements Serializable,docfileghifile{
	Hoadon []DSHD;
    private int SLHD;
    private transient Kiemtraloi KTra = new Kiemtraloi();
    private transient Scanner sc;

    public DSHoaDon() {
        this.DSHD = null;
        this.SLHD = 0;
    }

    public DSHoaDon(Hoadon[] DSHD, int SLHD) {
        this.DSHD = DSHD;
        this.SLHD = SLHD;
    }

    public int getSLHD() {
        return SLHD;
    }

    public void setSLHD(int SLHD) {
        this.SLHD = SLHD;
    }
    
    public void docfile(){
        DSHD=new Hoadon[SLHD];
        try {
            FileInputStream fi=new FileInputStream("DSHDout.txt");
            ObjectInputStream ois=new ObjectInputStream(fi);
            while (fi.available()>0){
                DSHD=Arrays.copyOf(DSHD, DSHD.length+1);
                Hoadon obj=(Hoadon) ois.readObject();
                DSHD[SLHD]=obj;
                SLHD++;
            }                
            ois.close();
            fi.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void ghifile(){
        try {
            FileOutputStream f=new FileOutputStream("DSHDout.txt");
            ObjectOutputStream oos=new ObjectOutputStream(f);             
            for (int i=0;i<SLHD;i++)
                oos.writeObject(DSHD[i]);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void XoaHoaDon(DSChiTietHoaDon cthd){
    	sc = new Scanner(System.in);
    	String k;
    	do {
        System.out.println("\nDanh sach ma hoa don co trong he thong la : " + ListHD());
        if(SLHD == 0){
            System.out.println("He thong khong co hoa don nao het !!!");
            return;
        }   
        String msv;
        do{
            System.out.print("Nhap Ma HD can xoa: ");
            msv=sc.nextLine();
        } while(msv.matches("HD-"+"[0-9]{3}")==false);
        int kt = 0;
        for (int i=0;i<SLHD;i++)
            if (DSHD[i].getMaHD().equalsIgnoreCase(msv)){
                for (int j=i;j<SLHD-1;j++)
                    DSHD[j]=DSHD[j+1];
                SLHD=SLHD-1;
                cthd.XoaCTHD(msv);
                cthd.ghifile();
                kt = 1;
                break;
            }
        if (kt==0)
            System.out.println("Khong tim thay MaHD can xoa");
        System.out.print("\nNhap 1 de tim tiep. Nhap phim bat ky de thoat" );
        k=sc.nextLine();
    }while(k.matches("1")==true);
    }
    public int TimkiemMa(String s){
        for (int i = 0;i < SLHD;i++){
            if(DSHD[i].getMaHD().equals(s)){
                return 1;
            }
        }
        return 0;
    }
    public void ThemNhieuHoaDon(DSChiTietHoaDon cthd,DSKhachHang DSKH,DanhSachSanPham DSSP){
    	sc = new Scanner(System.in);
        /*MangNhanVien DSNV = new MangNhanVien();
        DSNV.docfileMangNhanVien();*/
        int sl;
        String c;
        Hoadon[] sv;
        while(true){
            String tmp;
            do{
                System.out.print("\nNhap so luong can nhap : ");
                tmp = sc.nextLine();
            }while(tmp.isEmpty());
            if(KTra.isNumber(tmp)==true){
                sl = Integer.parseInt(tmp);
                break;
            }
            else{
                System.out.println("Du lieu nhap vao khong hop le.Vui long nhap lai !!!");
            }
        }
        String msv;
       /* msv = sc.nextLine();
        if(DSNV.TimkiemMa(msv)==false) {
            do{
                System.out.print("Nhap vao ma NV(Admin) cua ban: ");
                msv = sc.nextLine();
                if(DSNV.TimkiemMa(msv) == false){
                    System.out.println("Ma nhan vien(Admin) khong ton tai !!!");
                }
            }while(DSNV.TimkiemMa(msv) == false);
        }*/
        
        sv=new Hoadon[sl];             
        for (int i=0;i<sl;i++){
            sv[i]=new Hoadon();
            DSKH.ListMaKH();
            String mkh="t";
            int k = 0;
            while( mkh.matches("[1-2]{1}")==false){
                System.out.println("Khách hàng đã có trong hệ thống chưa? 1.có / 2.không");
                mkh = sc.nextLine();
                if(mkh.matches("[1-2]{1}")==false) System.out.println("Vui long nhap dung yeu cau !!!");
                else k = Integer.parseInt(mkh);
            }
            
            switch(k){
                case 1:{
                    String Makh;
                    do{
                        System.out.println("Danh sach Ma KH co san la : "+DSKH.ListMaKH());
                        System.out.print("Nhap vao ma KH : ");
                        Makh = sc.nextLine();
                        if(DSKH.TimkiemMa(Makh)==false){
                            System.out.println("Khong tim thay ma KH!!!");
                        }
                    } while(DSKH.TimkiemMa(Makh)==false);
                    //DSKH.DiemKH(Makh, HD.getNgayxuatHD());
                    //HD.setMaKH(Makh);
                    sv[i].setMaKH(Makh);
                    break;
                }
                case 2:{
                    System.out.println("Nhap vao he thong khach hang");
                    DSKH.ThemNhieuKhachHang();
                    DSKH.ghifile();
                    return;
                }
            }
            sv[i].getMaNV();
            sv[i].setMaHD();
            if(TimkiemMa(sv[i].getMaHD())==1) {
                do {
                    System.out.println("Ma HD da ton tai trong he thong!!!");
                    System.out.println("Vui long nhap lai !!!!!");
                    System.out.println("Danh sach Ma HD co san la: " + ListHD());
                    sv[i].setMaHD();
                } while(TimkiemMa(sv[i].getMaHD())==1);
            }
            /*sv[i].setMaNV();*/
            sv[i].setNgayxuatHD(KTra.KiemTraNgay());
            sv[i].setThanhtien(cthd.ThemCTHD(sv[i].getMaHD(),DSSP));
            cthd.ghifile();        
        }
        for (int i=0;i<sl;i++){
            DSHD= Arrays.copyOf(DSHD, DSHD.length+1);
            DSHD[SLHD]=sv[i];
            SLHD++;
        }    
    }
    
    public void SuaHoaDon(DSChiTietHoaDon cthd) {
    	sc = new Scanner(System.in);
        System.out.println("Danh sach ma hoa don co trong he thong la : " + ListHD());
        if(SLHD == 0){
            System.out.println("He thong khong co hoa don nao het !!!");
            return;
        }
        String msv,c,d;
        do{
            System.out.print("Nhap Ma HD can sua: ");
            msv=sc.nextLine();
        } while(msv.isEmpty()||msv.matches("HD-"+"[0-9]{3}")==false);
        int i;
        for (i=0;i<SLHD;i++)
            if (DSHD[i].getMaHD().equalsIgnoreCase(msv)){
            	System.out.print("Nhap 1 de sua hoa don. Nhap phim bat ky de thoat");
            	d=sc.nextLine();
            	if(d.matches("1")) {
                DSHD[i]=new Hoadon();
                DSHD[i].NhapHD();
                DSHD[i].setMaHD(msv);}
                System.out.print("Nhap 1 de sua chi tiet hoa don. Nhap phim bat ky de thoat");
                c=sc.nextLine();
                if (c.matches("1")){                    
                    cthd.Xuat1dsCTHD(DSHD[i].getMaHD());
                    SuaCTHD1(cthd);
                    cthd.ghifile();
                    break;
                }                
                else break;
            }
        if(i >= SLHD){
            System.out.println("Khong tim thay Ma HD de sua !!!");
            return;
        }
    }
    public String ListHD(){
        String s = "";
        if(SLHD == 0){
            return null;
        }
        for (int i = 0;i < SLHD;i++){
            s+= DSHD[i].getMaHD();
            if(i != SLHD-1){
                s+=',';
            }
        }
        return s;
    }
    public void SuaCTHD1(DSChiTietHoaDon cthd)
    {
    	sc=new Scanner(System.in);
    	String k;
        do {
        
        double sum=0;
        if(cthd.DSCTHD.length == 0){
            System.out.println("\nHe thong khong co hoa don nao het !!!");
            return;
        }
        System.out.println("\nDanh sach ma hoa don co trong he thong la : " + ListHD());
        
        String msv;
        do{
            System.out.print("Nhap Ma HD can sua: ");
            msv=sc.nextLine();
        } while(msv.isEmpty() ||msv.matches("HD-"+"[0-9]{3}")==false);
        int kt = 0;
        for (int i=0;i<cthd.DSCTHD.length;i++) {
            if (cthd.DSCTHD[i].getMaHD().equalsIgnoreCase(msv)){
                System.out.println("Thong tin CTHD truoc khi sua: ");
                System.out.printf("%-12s%-12s%-12s%-20s\n","Ma HD","Ma SP", "Gia","So luong");
                cthd.DSCTHD[i].XuatCThoadon();
                System.out.println("Sua Thong Tin CTHD");
                cthd.DSCTHD[i]=new CTHoaDon(cthd.DSCTHD[i].getMaHD(),cthd.DSCTHD[i].getMaSP(),0,0);
                cthd.DSCTHD[i].setSoLuong();
                cthd.DSCTHD[i].setGia();
                sum+=cthd.DSCTHD[i].getSoLuong()*cthd.DSCTHD[i].getGia();
                kt = 1;
            }
        }
        double tong=cthd.SuaCTHD(msv, kt, DSHD, sum);
        cthd.ghifile();
        if(tong!=-1)
        {
        	for(int i=0;i<SLHD;i++)
        	{
        		if(msv.matches(DSHD[i].getMaHD())==true)
        		{
        			DSHD[i].setThanhtien(tong);
        		}
        	}
        	}
        else System.out.println("Khong co ma hoa don trong he thong");
        System.out.print("\nNhap 1 de tim tiep. Nhap phim bat ky de thoat" );
        k=sc.nextLine();
    }while(k.matches("1")==true);
    }
    public void XuatDSHoaDon(){
        if(DSHD == null){
            System.out.println("Danh sach rong !!!!");
            return ;
        }
        System.out.format("%15s%15s%15s%15s%15s\n","\nMa HD","Ma NV","Ma KH","ngay ban","thanhtien");
        for (int i = 0;i < SLHD;i++){
        	System.out.format("\n%5s",DSHD[i].getMaHD());
        	System.out.format("%15s",DSHD[i].getMaNV());
        	System.out.format("%15s",DSHD[i].getMaKH());
        	System.out.format("%15s",DSHD[i].getNgayxuatHD());
        	System.out.format("%10s",DSHD[i].getThanhtien());
        }
    }
    public void timkiemHD() {
    	sc = new Scanner(System.in);
        String k;
        String UName;
        do{
            do{
                System.out.println("\nNhap vao Ma Hoa Don or Ma Nhan Vien or Ma Khach Hang:");
                UName=sc.nextLine();
            }while(UName.isEmpty());
            System.out.format("%15s%15s%15s%15s%15s\n","\nMa HD","Ma NV","Ma KH","ngay ban","thanhtien");
            for (int i = 0;i < SLHD;i++){
                if(DSHD[i].getMaHD().toLowerCase().contains(UName.toLowerCase()) || DSHD[i].getMaKH().toLowerCase().contains(UName.toLowerCase()) ){
                	System.out.format("\n%5s",DSHD[i].getMaHD());
                	System.out.format("%15s",DSHD[i].getMaNV());
                	System.out.format("%15s",DSHD[i].getMaKH());
                	System.out.format("%15s",DSHD[i].getNgayxuatHD());
                	System.out.format("%10s",DSHD[i].getThanhtien());
                    }
            }
            
                System.out.print("\nNhap 1 de tim tiep. Nhap phim bat ky de thoat" );
                k=sc.nextLine();
            }while(k.matches("1")==true);
    }
    public static void Ghi() {
        DSHoaDon ds = new DSHoaDon();
        ds.DSHD=new Hoadon[4];
        ds.SLHD=4;
        
        ds.DSHD[0]=new Hoadon("HD-001", "NV-001", "KH-001", "18/10/2020",1250000);
        ds.DSHD[1]=new Hoadon("HD-002", "NV-002", "KH-002", "31/12/2021",1000000);
        ds.DSHD[2]=new Hoadon("HD-003", "NV-003", "KH-003", "13/09/2016",360000);
        ds.DSHD[3]=new Hoadon("HD-004", "NV-004", "KH-004", "18/03/2021",980000);
        
        ds.ghifile();
        //ds.XuatDSHoaDon();
        //ds.ghifile();
        //ds.SuaCTHD1();
        ds.XuatDSHoaDon();
        //ds.ghifile();
    }
    public static void main(String[] args) {
    	//DSHoaDon ds = new DSHoaDon();
    	//ds.docfile();
    	//ds.XuatDSHoaDon();
    	//ds.SuaHoaDon();
    	//ds.ghifile();
    	Ghi();
    }
    
}
