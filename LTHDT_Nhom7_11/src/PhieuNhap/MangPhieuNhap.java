package PhieuNhap;

import DungChung.Check;
import DungChung.Mang;
import NhaCungCap.MangNhaCungCap;
import NhaCungCap.NhaCungCap;
import NhanVien.MangNhanVien;
import NhanVien.NhanVien;
import HoaDon.DSHoaDon;
//import SanPham.;
import SanPham.SanPham;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MangPhieuNhap implements Serializable,Mang {

    private PhieuNhap[] MangPhieuNhap;
    private int soluongPhieuNhap;
    

    public MangPhieuNhap() {

    }
    @Override
    public void NhapMang() {
        Scanner sc = new Scanner(System.in);
//========================================================================Doc file mang sinh vien===================================================///
               Object obj;
        NhanVien DS_NhanVien[] =null ;
        DS_NhanVien=new NhanVien[0];
        String fileName = "DS_NhanVien.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(obj = oIn.readObject())!=null;i++) {
                    
                    DS_NhanVien=Arrays.copyOf(DS_NhanVien, i+1);
                    DS_NhanVien[i]=new NhanVien();
                    DS_NhanVien[i] =(NhanVien) obj;
                    
                   
                }
            } catch (Exception e) {
            }
            fin.close();
            oIn.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Nhan Vien=========================================\n");
      System.out.format("\n%5s%18s%28s%28s%28s\n", "Ma Nhan Vien", "Ten Nhan Vien","Ngay Sinh","Gioi Tinh","Phone");
        for(int i=0;i<DS_NhanVien.length;i++){
            System.out.format("\n%5s | ", DS_NhanVien[i].getMaNhanVien());
            System.out.format("%15s | ", DS_NhanVien[i].getMaNhanVien());
            System.out.format("%25s |", DS_NhanVien[i].getNgaysinh());
            System.out.format("%25s |", DS_NhanVien[i].getGioitinh());
            System.out.format("%25s |", DS_NhanVien[i].getDienthoai());
               
    }
 //====================================================Doc File Mang Nha Cung Cap=====================================================//
   Object oop;
        NhaCungCap DS_NhaCungCap[] =null ;
        DS_NhaCungCap=new NhaCungCap[0];
        String a = "DS_NhaCungCap.txt";
        try {
            FileInputStream Nhacc = new FileInputStream(a);
            ObjectInputStream oNhacc = new ObjectInputStream(Nhacc);
            try {
                for (int i=0;(oop = oNhacc.readObject())!=null;i++) {
                    
                    DS_NhaCungCap=Arrays.copyOf(DS_NhaCungCap, i+1);
                    DS_NhaCungCap[i]=new NhaCungCap();
                    DS_NhaCungCap[i] =(NhaCungCap) oop;
                    
                   
                }
            } catch (Exception e) {
            }
            Nhacc.close();
            oNhacc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Nha Cung Cap=========================================\n");
      System.out.format("\n%5s%18s%20s\n", "Ma Nha Cung Cap", "Ten Nha Cung Cap","Quoc Gia");
        for(int i=0;i<DS_NhaCungCap.length;i++){
            System.out.format("\n%5s | ", DS_NhaCungCap[i].getMaNhaCungCap());
            System.out.format("%15s | ", DS_NhaCungCap[i].getTenNhaCungCap());
            System.out.format("%20s |", DS_NhaCungCap[i].getQuocGia());
               
    } 
 //==================================================================================================================================//
  Object obj1;
        PhieuNhap u[] =null ;
        u=new PhieuNhap[0];
        String b = "DS_PhieuNhap.txt";
        try {
            FileInputStream px = new FileInputStream(b);
            ObjectInputStream oIn = new ObjectInputStream(px);
            try {
                for (int i=0;(obj1 = oIn.readObject())!=null;i++) {
                    
                    u=Arrays.copyOf(u, i+1);
                    u[i]=new PhieuNhap();
                    u[i] =(PhieuNhap) obj1;
                    
                   
                }
            } catch (Exception e) {
            }
            px.close();
            oIn.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        
        System.out.print("\n======================================Danh Sach Phieu Nhap=========================================\n");
        System.out.format("\n%5s%20s%25s%35s\n", "Ma Phieu Nhap", "Ma Nhan Vien","Ma Nha Cung Cap","Thoi Gian");
      for(int i=0;i<u.length;i++){
           u[i].XuatPhieuNhap();
       }
      
 //======================================================================================================================================
 MangPhieuNhap=new PhieuNhap[0];
        while (true) {
            //System.out.print("\nNhap so luong Phieu Nhap: ");
            try {
                //soluongPhieuNhap=sc.nextInt();
                
                int gt=MangPhieuNhap.length;
                MangPhieuNhap=Arrays.copyOf(MangPhieuNhap, MangPhieuNhap.length+1);
                //sc.nextLine();
                for(int i=gt;i<MangPhieuNhap.length;i++){
                    MangPhieuNhap[i]=new PhieuNhap();
                    String f;
                    haha:   
                    while(true){
                       System.out.print("\nNhap ma Phieu Nhap:");
                        f=sc.nextLine();
                        for(int j=0;j<u.length;j++){
                            if(f.equals(u[j].getMaPhieuNhap())){
                                System.out.print("\nMa Phieu Nhap bi trung.....");
                                continue haha;
                            }
                        }
                        break haha;
                    }
                    MangPhieuNhap[i].setMaPhieuNhap(f);
                    String manv;
                    hihi:
                    do{
                        System.out.print("\nNhap ma Nhan vien cua Phieu Nhap:");
                        manv=sc.nextLine();
                        for(int k=0;k<DS_NhanVien.length;k++){
                            if(manv.equals(DS_NhanVien[k].getMaNhanVien())){
                                break hihi;
                            }
                           
                        }
                        System.out.print("\nMa Nhan vien ko ton tai...........");
                    }while(true);
                    MangPhieuNhap[i].setManv(manv);
                    Date date=java.util.Calendar.getInstance().getTime(); 
                    MangPhieuNhap[i].setThoiGianNhap(date);
                   String macc;
                    hihi:
                    do{
                        System.out.print("\nNhap ma Nha Cung Cap cua Phieu Nhap:");
                        macc=sc.nextLine();
                        for(int k=0;k<DS_NhaCungCap.length;k++){
                            if(macc.equals(DS_NhaCungCap[k].getMaNhaCungCap())){
                                break hihi;
                            }
                           
                        }
                        System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                    }while(true);
                    MangPhieuNhap[i].setMancc(macc);
                    
                }
            } catch (Exception e) {
                System.out.print("\nLoi Nhap so luong phieu Nhap...Nhap lai:");
            }
            break;
        }
         File file = new File("DS_PhieuNhap.txt");
        boolean append = file.exists();
        FileOutputStream fOut;
        ObjectOutputStream oOut;
        try {
            if (append) {
                fOut = new FileOutputStream(file, true);
                oOut = new AppendableObjectOutputStream(fOut);
            } else {
                fOut = new FileOutputStream(file, true);
                oOut = new ObjectOutputStream(fOut);
            }
            for(int i=0;i<MangPhieuNhap.length;i++){
            oOut.writeObject(MangPhieuNhap[i]);}
            oOut.flush();
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void XuatMang() {
        System.out.format("%5s%18s%25s%50s%55s\n", "Ma Phieu Nhap", "Ma Nhan Vien","Ma Nha Cung Cap     ", "Thoi Gian Nhap");
        for (int i = 0; i < MangPhieuNhap.length; i++) {
            System.out.format("%5s | ", MangPhieuNhap[i].getMaPhieuNhap());
            System.out.format("%15s | ", MangPhieuNhap[i].getManv());
            System.out.format("%22s | ", MangPhieuNhap[i].getMancc());
            System.out.format("%38s |", MangPhieuNhap[i].getThoiGianNhap());
            //System.out.format("%10s |\n", MangPhieuNhap[i].getDonGia());
        }
    }
    
    class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        // TODO Auto-generated constructor stub
        super(out);
    }
 
    @Override
    protected void writeStreamHeader() throws IOException {
        // TODO Auto-generated method stub
    }
}
    public void writefileMangPhieuNhap() throws IOException {
  
        File file = new File("DS_PhieuNhap.txt");
        boolean append = file.exists();
        FileOutputStream fOut;
        ObjectOutputStream oOut;
        try {
            if (append) {
                fOut = new FileOutputStream(file, true);
                oOut = new AppendableObjectOutputStream(fOut);
            } else {
                fOut = new FileOutputStream(file, true);
                oOut = new ObjectOutputStream(fOut);
            }
            for(int i=0;i<MangPhieuNhap.length;i++){
            oOut.writeObject(MangPhieuNhap[i]);}
            oOut.flush();
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
       
        
    }
    public void readfileMangPhieuNhap()  throws IOException {
        Object obj;
        PhieuNhap u[] =null ;
        u=new PhieuNhap[0];
        String fileName = "DS_PhieuNhap.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(obj = oIn.readObject())!=null;i++) {
                    
                    u=Arrays.copyOf(u, i+1);
                    u[i]=new PhieuNhap();
                    u[i] =(PhieuNhap) obj;
                    
                   
                }
            } catch (Exception e) {
            }
            fin.close();
            oIn.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        
        System.out.print("\n======================================Mang Phieu Xuat=========================================\n");
        System.out.format("\n%5s%20s%25s%40s\n", "Ma Phieu Nhap", "Ma Nhan Vien","Ma Nha Cung Cap","Thoi Gian Nhap");
      for(int i=0;i<u.length;i++){
           u[i].XuatPhieuNhap();
       }      
    }
    public static void main(String[] args) throws IOException {
        MangPhieuNhap a = new MangPhieuNhap();
        a.NhapMang();
       // a.writefileMangPhieuNhap();
        a.readfileMangPhieuNhap();
       
    }
}
