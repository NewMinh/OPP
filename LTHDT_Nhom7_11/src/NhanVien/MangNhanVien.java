/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;

import DungChung.Check;
import DungChung.ConNguoi;
import DungChung.Mang;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MangNhanVien implements Mang{
    private ConNguoi[]a;
    private NhanVien[] MangNhanVien;
    private int soluongNhanVien;
    static Scanner sc=new Scanner(System.in);
    public MangNhanVien(){
    
    }
    @Override
    public void NhapMang(){
               Object objNhaVien;
        NhanVien DS_NhanVien[] =null ;
        DS_NhanVien=new NhanVien[0];
        String fileName = "DS_NhanVien.txt";
        try {
            FileInputStream inNhanVien = new FileInputStream(fileName);
            ObjectInputStream outNhanVien = new ObjectInputStream(inNhanVien);
            try {
                for (int i=0;(objNhaVien = outNhanVien.readObject())!=null;i++) {
                    
                    DS_NhanVien=Arrays.copyOf(DS_NhanVien, i+1);
                    DS_NhanVien[i]=new NhanVien();
                    DS_NhanVien[i] =(NhanVien) objNhaVien;  
                }
            } catch (Exception e) {
            }
            inNhanVien.close();
            outNhanVien.close();
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
            System.out.format("%15s | ", DS_NhanVien[i].getHoten());
            System.out.format("%25s |", DS_NhanVien[i].getNgaysinh());
            System.out.format("%25s |", DS_NhanVien[i].getGioitinh());
            System.out.format("%25s |", DS_NhanVien[i].getDienthoai());
               
    }
        MangNhanVien=new NhanVien[0];
        while(true){
           //System.out.print("\nNhap so luong Nhan Vien:");
            try {
                //soluongNhanVien=Integer.parseInt(sc.nextLine());
                int gt=MangNhanVien.length;
                MangNhanVien=Arrays.copyOf(MangNhanVien,MangNhanVien.length+1);
                sc.nextLine();
                for(int i=gt;i<MangNhanVien.length;i++){
                    System.out.print("\n==============================");
                    MangNhanVien[i]=new NhanVien();
                    String a;
                    haha:   
                     
                   do{
                   System.out.print("\nNhap ma Nha Nhan Vien:");
                   a=sc.nextLine();
                   for(int j=0;j<DS_NhanVien.length;j++){
                       if(a.equals(DS_NhanVien[j].getMaNhanVien())){
                           System.out.print("\nMa Nhan Vien  da co...");
                           continue haha;
                       }
                      
                    }
                    break haha;
                    }while(true);
                    
                    MangNhanVien[i].setMaNhanVien(a);
                    System.out.print("Nhap ho ten Nhan Vien:");
                    MangNhanVien[i].setHoten(sc.nextLine());
                    String ns;
                    ngaysinh:
                    while(true){
                       System.out.print("\nNhap ngay sinh:");
                       ns=sc.nextLine();
                       if(Check.ngay(ns)){
                           break ngaysinh;
                       }
                       else{System.out.print("\nNgay sinh khong hop le");
                           continue ngaysinh;
                       } 
                    }
                    MangNhanVien[i].setNgaysinh(ns);
                    System.out.print("Nhap Gioi tinh Nhan Vien:");
                    MangNhanVien[i].setGioitinh(sc.nextLine());
                   String dt;
                    phone:
                    while(true){
                       System.out.print("\nNhap Phone Nhan vien:");
                       dt=sc.nextLine();
                       if(Check.sdt(dt)){
                           break phone;
                       }
                       else{
                           System.out.print("\nPhone khong hop le");
                           continue phone;
                       } 
                    }
                    MangNhanVien[i].setDienthoai(dt);
                    
                }
               break; 
            } catch (NumberFormatException e) {
                System.out.print("\nLoi So luong....Nhap lai....");
            }
            
        }
               File file = new File("DS_NhanVien.txt");
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
            for(int i=0;i<MangNhanVien.length;i++){
            oOut.writeObject(MangNhanVien[i]);}
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
    public void XuatMang(){
         System.out.format("\n%5s%18s%20s%22s%20s\n", "Ma Nhan Vien", "Ten Nhan Vien","Ngay sinh", "Gioi tinh", "Phone");
        for (int i = 0; i < MangNhanVien.length; i++) {
            System.out.format("%5s | ", MangNhanVien[i].getMaNhanVien());
            System.out.format("%15s | ", MangNhanVien[i].getHoten());
            System.out.format("%20s |", MangNhanVien[i].getNgaysinh());
            System.out.format("%25s | ", MangNhanVien[i].getGioitinh());
            System.out.format("%20s |\n ", MangNhanVien[i].getDienthoai());
    } 
}
    public void SuaNhanVien(){
        Object objNhanVien;
        NhanVien DS_NhanVien[] =null ;
        DS_NhanVien=new NhanVien[0];
        String fileName = "DS_NhanVien.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(objNhanVien = oIn.readObject())!=null;i++) {
                    
                    DS_NhanVien=Arrays.copyOf(DS_NhanVien, i+1);
                    DS_NhanVien[i]=new NhanVien();
                    DS_NhanVien[i] =(NhanVien) objNhanVien;
                    
                   
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
      System.out.format("\n%5s%18s%28s%28s%25s\n", "Ma Nhan Vien", "Ten Nhan Vien","Ngay Sinh","Gioi Tinh","Phone");
        for(int i=0;i<DS_NhanVien.length;i++){
            System.out.format("\n%5s | ", DS_NhanVien[i].getMaNhanVien());
            System.out.format("%15s | ", DS_NhanVien[i].getHoten());
            System.out.format("%25s |", DS_NhanVien[i].getNgaysinh());
            System.out.format("%25s |", DS_NhanVien[i].getGioitinh());
            System.out.format("%25s |", DS_NhanVien[i].getDienthoai());           
    }
         //----------------------------------------------------doc file danh sach Nhan Vien--------------------------------------
        boolean check=false;
        String ma;
        haha:
        do{
            System.out.print("\nNhap ma Nhan vien Can thay doi:");
            ma=sc.nextLine();
            for(int j=0;j<DS_NhanVien.length;j++){
                if(ma.equals(DS_NhanVien[j].getMaNhanVien())){
                    break haha;
                }
            }
            System.out.print("\nMa Nhan Vien Khong ton tai...");
        }while(true);
        System.out.println(" =============== Menu ===============");
        System.out.println("\nChon thong tin muon sua");
        System.out.println("1.Ma Nha Nhan Vien");
        System.out.println("2.Ten Nhan Vien");
        System.out.println("3.Ngay sinh");
        System.out.println("4.Gioi Tinh");
        System.out.println("5.Phone");
        hihi:
        while (true) {
        int luachon = 0;
        System.out.print("Nhap lua chon cua ban:");
        try {
              luachon = sc.nextInt();
        } 
        catch (InputMismatchException ex) {
            System.out.println("\nLua chon khong hop le...Nhap lai:");
         }
              sc.nextLine();
                for (int i = 0; i < DS_NhanVien.length; i++) {
                        if (ma.equals(DS_NhanVien[i].getMaNhanVien())) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma Nhan Vien thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < DS_NhanVien.length; j++) {
                                            if (x.equals(DS_NhanVien[j].getMaNhanVien())) {
                                                System.out.println("\nMa Nhan Vien da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    DS_NhanVien[i].setMaNhanVien(x);
                                    break hihi;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten Nhan Vien can thay doi:");
                                    String x = sc.nextLine();
                                    DS_NhanVien[i].setHoten(x);
                                    break hihi;
                                }
                                case 3: {
                                    String ns;
                                    ngaysinh:
                                    while(true){
                                       System.out.print("\nNhap ngay sinh Can Thay doi:");
                                       ns=sc.nextLine();
                                       if(Check.ngay(ns)){
                                           break ngaysinh;
                                       }
                                       else{System.out.print("\nNgay sinh khong hop le");
                                           continue ngaysinh;
                                       } 
                                    }
                                    DS_NhanVien[i].setNgaysinh(ns);
                                    break hihi;
                                }
                                case 4:{
                                    System.out.print("\nNhap gioi tinh can thay doi...");
                                    DS_NhanVien[i].setGioitinh(sc.nextLine());
                                    break hihi;
                                }
                                case 5:{
                                String dt;
                                phone:
                                while(true){
                                   System.out.print("\nNhap Phone Nhan vien:");
                                   dt=sc.nextLine();
                                   if(Check.sdt(dt)){
                                       break phone;
                                   }
                                   else{
                                       System.out.print("\nPhone khong hop le");
                                       continue phone;
                                   } 
                                }
                                DS_NhanVien[i].setDienthoai(dt);
                                }
                                break hihi;
                                default:{
                                    System.out.println("\nNhap sai Lua Chon...Nhap lai lua chon cua ban");
                                    continue hihi;
                                }
                            } 
                        }
                    } 
                
                break;  
            }
        try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_NhanVien.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_NhanVien.length;i++){
        oos.writeObject(DS_NhanVien[i]);
    }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
        }
       
    
 public void xoaNhanVien(){
      Object objNhanVien;
        NhanVien DS_NhanVien[] =null ;
        DS_NhanVien=new NhanVien[0];
        String fileName = "DS_NhanVien.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(objNhanVien = oIn.readObject())!=null;i++) {
                    
                    DS_NhanVien=Arrays.copyOf(DS_NhanVien, i+1);
                    DS_NhanVien[i]=new NhanVien();
                    DS_NhanVien[i] =(NhanVien) objNhanVien;
                    
                   
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
      System.out.format("\n%5s%18s%28s%28s%25s\n", "Ma Nhan Vien", "Ten Nhan Vien","Ngay Sinh","Gioi Tinh","Phone");
        for(int i=0;i<DS_NhanVien.length;i++){
            System.out.format("\n%5s | ", DS_NhanVien[i].getMaNhanVien());
            System.out.format("%15s | ", DS_NhanVien[i].getHoten());
            System.out.format("%25s |", DS_NhanVien[i].getNgaysinh());
            System.out.format("%25s |", DS_NhanVien[i].getGioitinh());
            System.out.format("%25s |", DS_NhanVien[i].getDienthoai());          
    }
        //-----------------------------------------------------------------------------------------
         if(DS_NhanVien.length==0){
            System.out.print("\nKhong Co Nha Cung Cap Nao...");
            return;
        }
    
        boolean check=false;
        int m;
        nhapma:
        while(true){
            System.out.print("\nNhap Ma Nha Cung Cap can Xoa:");
            String ma=sc.nextLine();
            for(int i=0;i<DS_NhanVien.length;i++){
                if(ma.equals(DS_NhanVien[i].getMaNhanVien())){
                    m=i;
                    check=true;
                    break nhapma;
                }
            }
            if(!check){
                System.out.println("\n>>Ma Nha Cung Cap khong ton tai,...Vui long nhap lai.");
                continue nhapma;
            }
        }
        for(int i=m;i<DS_NhanVien.length-1;i++)
        DS_NhanVien[i]=DS_NhanVien[i+1];
        DS_NhanVien = Arrays.copyOf(DS_NhanVien,DS_NhanVien.length-1);    
        
        //------------------------------------------------------------------------------------------
              try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_NhanVien.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_NhanVien.length;i++){
        oos.writeObject(DS_NhanVien[i]);
    }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
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
public void ghifileMangNhanVien() throws IOException{   
       File file = new File("DS_NhanVien.txt");
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
            for(int i=0;i<MangNhanVien.length;i++){
            oOut.writeObject(MangNhanVien[i]);}
            oOut.flush();
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
     }
    public  void docfileMangNhanVien(){
        Object objNhanVien;
        NhanVien DS_NhanVien[] =null ;
        DS_NhanVien=new NhanVien[0];
        String fileName = "DS_NhanVien.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(objNhanVien = oIn.readObject())!=null;i++) {
                    
                    DS_NhanVien=Arrays.copyOf(DS_NhanVien, i+1);
                    DS_NhanVien[i]=new NhanVien();
                    DS_NhanVien[i] =(NhanVien) objNhanVien;
                    
                   
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
      System.out.format("\n%5s%18s%28s%28s%25s\n", "Ma Nhan Vien", "Ten Nhan Vien","Ngay Sinh","Gioi Tinh","Phone");
        for(int i=0;i<DS_NhanVien.length;i++){
            System.out.format("\n%5s | ", DS_NhanVien[i].getMaNhanVien());
            System.out.format("%15s | ", DS_NhanVien[i].getHoten());
            System.out.format("%25s |", DS_NhanVien[i].getNgaysinh());
            System.out.format("%25s |", DS_NhanVien[i].getGioitinh());
            System.out.format("%25s |", DS_NhanVien[i].getDienthoai());          
    }
    }     
 public void ThongTinNhanVien(String manv){
     //manv=sc.nextLine();
     Object objNhanVien;
        NhanVien DS_NhanVien[] =null ;
        DS_NhanVien=new NhanVien[0];
        String fileName = "DS_NhanVien.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(objNhanVien = oIn.readObject())!=null;i++) {
                    
                    DS_NhanVien=Arrays.copyOf(DS_NhanVien, i+1);
                    DS_NhanVien[i]=new NhanVien();
                    DS_NhanVien[i] =(NhanVien) objNhanVien;
                    
                   
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
         for(int i=0;i<DS_NhanVien.length;i++){
            // System.out.print("\n"+DS_NhanVien[i].getMaNhanVien());
             if(DS_NhanVien[i].getMaNhanVien().equals(manv)==true){
                
                  System.out.format("\n%5s%18s%28s%28s%25s\n", "Ma Nhan Vien", "Ten Nhan Vien","Ngay Sinh","Gioi Tinh","Phone");
            System.out.format("\n%5s | ", DS_NhanVien[i].getMaNhanVien());
            System.out.format("%15s | ", DS_NhanVien[i].getHoten());
            System.out.format("%25s |", DS_NhanVien[i].getNgaysinh());
            System.out.format("%25s |", DS_NhanVien[i].getGioitinh());
            System.out.format("%25s |", DS_NhanVien[i].getDienthoai());
            break;
             }
         }
 }
 public void SuaThongTinNhanVien(String manv){
      Object objNhanVien;
        NhanVien DS_NhanVien[] =null ;
        DS_NhanVien=new NhanVien[0];
        String fileName = "DS_NhanVien.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(objNhanVien = oIn.readObject())!=null;i++) {
                    
                    DS_NhanVien=Arrays.copyOf(DS_NhanVien, i+1);
                    DS_NhanVien[i]=new NhanVien();
                    DS_NhanVien[i] =(NhanVien) objNhanVien;
                    
                   
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
      System.out.format("\n%5s%18s%28s%28s%25s\n", "Ma Nhan Vien", "Ten Nhan Vien","Ngay Sinh","Gioi Tinh","Phone");
        for(int i=0;i<DS_NhanVien.length;i++){
            System.out.format("\n%5s | ", DS_NhanVien[i].getMaNhanVien());
            System.out.format("%15s | ", DS_NhanVien[i].getHoten());
            System.out.format("%25s |", DS_NhanVien[i].getNgaysinh());
            System.out.format("%25s |", DS_NhanVien[i].getGioitinh());
            System.out.format("%25s |", DS_NhanVien[i].getDienthoai());          
    }
        for(int i=0;i<DS_NhanVien.length;i++){
          if(manv.equals(DS_NhanVien[i].getMaNhanVien())){
              haha:
            while(true){
                   try {
                    System.out.println(" =============== Menu ===============");
                    System.out.println("\nChon thong tin muon sua");
                    System.out.println("1.Ten Nhan Vien");
                    System.out.println("2.Ngay Sinh");
                    System.out.println("3.Gioi Tinh");
                    System.out.println("4.Phone");
                    int luachon;
                    System.out.print("\nNhap lua chon:");
                    luachon=sc.nextInt();
                    sc.nextLine();
                    switch(luachon){
                        case 1: 
                            System.out.print("\nNhap ten sinh vien can sua:");
                             DS_NhanVien[i].setHoten(sc.nextLine());
                             break;
                        case 2:
                            String ns;
                            ngaysinh:
                            while(true){
                               System.out.print("\nNhap ngay sinh:");
                               ns=sc.nextLine();
                               if(Check.ngay(ns)){
                                   break ngaysinh;
                               }
                               else{System.out.print("\nNgay sinh khong hop le");
                                   continue ngaysinh;
                               } 
                            }
                            DS_NhanVien[i].setNgaysinh(ns);
                            break;
                        case 3:
                            System.out.print("\nNhap gioi tinh");
                            DS_NhanVien[i].setGioitinh(sc.nextLine());
                            break;
                        case 4:
                            String dt;
                            phone:
                            while(true){
                               System.out.print("\nNhap Phone Nhan vien:");
                               dt=sc.nextLine();
                               if(Check.sdt(dt)){
                                   break phone;
                               }
                               else{
                                   System.out.print("\nPhone khong hop le");
                                   continue phone;
                               } 
                             }  
                            DS_NhanVien[i].setDienthoai(dt);
                            break;
                    }
                    break haha;
                } catch (Exception e) {
                    System.out.print("\nSai..");
                    continue haha;
                }
                }
          }
 }
           try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_NhanVien.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_NhanVien.length;i++){
        oos.writeObject(DS_NhanVien[i]);
    }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
        
 }
     public static void main(String[] args) throws IOException{
        MangNhanVien a=new MangNhanVien();NhanVien[]b=null;
           a.NhapMang();
           // a.XuatMang();
           //a.SuaNhanVien();
            //a.ghifileMangNhanVien();
            //a.xoaNhanVien();
            a.docfileMangNhanVien();
           // System.out.print("\nn-------------------------------");
            //a.ThongTinNhanVien("2");
     }  
}