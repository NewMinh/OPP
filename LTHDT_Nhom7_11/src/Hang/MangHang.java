/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hang;
import DungChung.Mang;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class MangHang implements Mang,Serializable{
     private Hang [] MangHang;
    private int SoluongHang;
    static  Scanner sc=new Scanner(System.in);
    @Override
    public void NhapMang(){
         Object obj;
        Hang DS_Hang[] =null ;
        DS_Hang=new Hang[0];
        String fileName = "DS_Hang.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(obj = oIn.readObject())!=null;i++) {
                    
                    DS_Hang=Arrays.copyOf(DS_Hang, i+1);
                    DS_Hang[i]=new Hang();
                    DS_Hang[i] =(Hang) obj;
                    
                   
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
        System.out.print("\n======================================Doc file DAnh Sach Hang=========================================\n");
      System.out.format("\n%5s%18s\n", "Ma Hang", "Ten Hang");
        for(int i=0;i<DS_Hang.length;i++){
            System.out.format("\n%5s | ", DS_Hang[i].getMaHang());
            System.out.format("%15s | ", DS_Hang[i].getTenHang());
          
               
    }   MangHang=new Hang[0];
        while(true){ 
            try {
                
                int gt=MangHang.length;
                MangHang=Arrays.copyOf(MangHang,MangHang.length+1);
                sc.nextLine();
                for(int i=gt;i<MangHang.length;i++){
                     System.out.print("\n===================================Hang  "+(i+1)+"===================================");
                    MangHang[i]=new Hang();
                    String a;
                    haha:
                   do{
                   System.out.print("\nNhap ma Hang:");
                   a=sc.nextLine();
                   for(int j=0;j<DS_Hang.length;j++){
                       if(a.equals(DS_Hang[j].getMaHang())){
                           System.out.print("\nMa Hang da co...");
                           continue haha;
                       }
                      
                    }
                    break haha;
                    }while(true);
                    MangHang[i].setMaHang(a);
                    System.out.print("\nNhap Ten Hang:");
                    MangHang[i].setTenHang(sc.nextLine());
                    
                }
                break;
            } catch (Exception e) {
                System.out.print("\nLoi so luong Hang....");
            }
        }
       //----------------------------------------------------------------------Ghi lai vao file----------------------------------------------------------
        File file = new File("DS_Hang.txt");
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
            for(int i=0;i<MangHang.length;i++){
            oOut.writeObject(MangHang[i]);}
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
        System.out.println("\n=============== DANH SACH HANG===============");
        System.out.format("%5s%18s\n", "Ma Hang", "Ten Hang");
        for (int i = 0; i < MangHang.length ; i++) {
            System.out.format("\n%5s | ", MangHang[i].getMaHang());
            System.out.format("%15s | ", MangHang[i].getTenHang());
           
            
        }
    }
    public void SuaHang(){
         Object objHang;
        Hang DS_Hang[] =null ;
        DS_Hang=new Hang[0];
        String fileHang = "DS_Hang.txt";
        try {
            FileInputStream inHang = new FileInputStream(fileHang);
            ObjectInputStream outHang = new ObjectInputStream(inHang);
            try {
                for (int i=0;(objHang = outHang.readObject())!=null;i++) {
                    
                    DS_Hang=Arrays.copyOf(DS_Hang, i+1);
                    DS_Hang[i]=new Hang();
                    DS_Hang[i] =(Hang) objHang; 
                }
            } catch (Exception e) {
            }
            inHang.close();
            outHang.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Hang=========================================\n");
      System.out.format("\n%5s%18s\n", "Ma Hang", "Ten Hang");
        for(int i=0;i<DS_Hang.length;i++){
            System.out.format("\n%5s | ", DS_Hang[i].getMaHang());
            System.out.format("%15s | ", DS_Hang[i].getTenHang());
                     
    }
        boolean check=false;
        String ma;
        haha:
        while(true){
            
            System.out.print("\nNhap ma Hang can Sua:");
            ma=sc.nextLine();
            for(int i=0;i<DS_Hang.length;i++){
                 if(ma.equals(DS_Hang[i].getMaHang())){
                     check=true;
                     break haha;
                 }
                 
            }  
            if(!check){
                     System.out.println("\n>>Nhap lai Hang muon sua.....");
                     continue haha;
                 }
        }
        System.out.println(" =============== Menu ===============");
        System.out.println("\nChon thong tin muon sua");
        System.out.println("1.Ma Hang");
        System.out.println("2.Ten Hangp");
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
                for (int i = 0; i < DS_Hang.length; i++) {
                        if (ma.equals(DS_Hang[i].getMaHang())) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma Hang thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < DS_Hang.length; j++) {
                                            if (x.equals(DS_Hang[j].getMaHang())) {
                                                System.out.println("\nMa Hang da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    DS_Hang[i].setMaHang(x);
                                    break hihi;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten Hang can thay doi:");
                                    String x = sc.nextLine();
                                    DS_Hang[i].setTenHang(x);
                                    break hihi;
                                }
                               
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
    FileOutputStream fos = new FileOutputStream("DS_Hang.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_Hang.length;i++){
        oos.writeObject(DS_Hang[i]);
    }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
        }
public void TimKiemHang(){
    Object objHang;
        Hang DS_Hang[] =null ;
        DS_Hang=new Hang[0];
        String fileHang = "DS_Hang.txt";
        try {
            FileInputStream inHang = new FileInputStream(fileHang);
            ObjectInputStream outHang = new ObjectInputStream(inHang);
            try {
                for (int i=0;(objHang = outHang.readObject())!=null;i++) {
                    
                    DS_Hang=Arrays.copyOf(DS_Hang, i+1);
                    DS_Hang[i]=new Hang();
                    DS_Hang[i] =(Hang) objHang; 
                }
            } catch (Exception e) {
            }
            inHang.close();
            outHang.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Hang=========================================\n");
      System.out.format("%5s%18s\n", "Ma Hang", "Ten Hang");
        for (int i = 0; i < DS_Hang.length ; i++) {
            System.out.format("\n%5s | ", DS_Hang[i].getMaHang());
            System.out.format("%15s | ", DS_Hang[i].getTenHang());
    }
            boolean check=false;
            
            while(true){
               
                String a;
                nhapma:
                while(true){
                    System.out.print("\nNhap Ma Hang can tim:");
                    a=sc.nextLine();
                for(int i=0;i<DS_Hang.length;i++){
                    if(a.equals(DS_Hang[i].getMaHang())){
                        DS_Hang[i].XuatHang();
                        check=true;
                        break nhapma;
                    }
                    }
                if(!check){
                        System.out.print("\nNhap sai Hang can tim...");
                        continue nhapma;
                        }
                }
            break;
            }
       }
public void ThemHang(){
    while(true){
        try {
        int gt=MangHang.length;
        int k;
        System.out.print("\nNhap so luong Hang muon them:");
        k=Integer.parseInt(sc.nextLine());
        MangHang=Arrays.copyOf(MangHang,gt+k);
        for(int i=gt;i<MangHang.length;i++){
                  System.out.print("\n============================HANG"+(i+1)+"========================================");
                 MangHang[i]=new Hang();
                    String a;
                    haha:
                    while(true){
                        System.out.print("\nNhap Ma Hang:");
                        a=sc.nextLine();
                        for(int j=0;j<i;j++){
                            if(a.equals(MangHang[j].getMaHang())){
                                continue haha;
                            }
                        }
                        break haha;
                    }
                    MangHang[i].setMaHang(a);
                    System.out.print("\nNhap ten Hang:");
                    MangHang[i].setTenHang(sc.nextLine());
                   
                }
            break;
            } 
            catch (Exception e) { 
                System.out.print("\nNhap sai So Luong them.....");
            }
        }           
    }
public void xoa(){
    Object objHang;
        Hang DS_Hang[] =null ;
        DS_Hang=new Hang[0];
        String fileHang = "DS_Hang.txt";
        try {
            FileInputStream inHang = new FileInputStream(fileHang);
            ObjectInputStream outHang = new ObjectInputStream(inHang);
            try {
                for (int i=0;(objHang = outHang.readObject())!=null;i++) {
                    
                    DS_Hang=Arrays.copyOf(DS_Hang, i+1);
                    DS_Hang[i]=new Hang();
                    DS_Hang[i] =(Hang) objHang; 
                }
            } catch (Exception e) {
            }
            inHang.close();
            outHang.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Hang=========================================\n");
     System.out.format("%5s%18s\n", "Ma Hang", "Ten Hang");
        for (int i = 0; i < DS_Hang.length ; i++) {
            System.out.format("\n%5s | ", DS_Hang[i].getMaHang());
            System.out.format("%15s | ", DS_Hang[i].getTenHang());  
    }
        if(DS_Hang.length==0){
            System.out.print("\nKhong Co Hang Nao...");
            return;
        }
    
        boolean check=false;
        int m;
        nhapma:
        while(true){
            System.out.print("\nNhap Ma Hang can Xoa:");
            String ma=sc.nextLine();
            for(int i=0;i<DS_Hang.length;i++){
                if(ma.equals(DS_Hang[i].getMaHang())){
                    m=i;
                    check=true;
                    break nhapma;
                }
            }
            if(!check){
                System.out.println("\n>>Ma Hang khong ton tai,...Vui long nhap lai.");
                continue nhapma;
            }
        }
        for(int i=m;i<DS_Hang.length-1;i++)
        DS_Hang[i]=DS_Hang[i+1];
        DS_Hang = Arrays.copyOf(DS_Hang,DS_Hang.length-1); 
        //------------------------------------------------------------Ghi ko de-------------------------------------------------------------------------------
              try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_Hang.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_Hang.length;i++){
        oos.writeObject(DS_Hang[i]);
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
public void ghifileDanhSachHang(){
    File file = new File("DS_Hang.txt");
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
            for(int i=0;i<MangHang.length;i++){
            oOut.writeObject(MangHang[i]);}
            oOut.flush();
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();   
        } catch (IOException e) {
            e.printStackTrace();  
        }    
 }
public void docfileDanhSachHang(){
    Object objHang;
        Hang DS_Hang[] =null ;
        DS_Hang=new Hang[0];
        String fileHang = "DS_Hang.txt";
        try {
            FileInputStream inHang = new FileInputStream(fileHang);
            ObjectInputStream outHang = new ObjectInputStream(inHang);
            try {
                for (int i=0;(objHang = outHang.readObject())!=null;i++) {
                    
                    DS_Hang=Arrays.copyOf(DS_Hang, i+1);
                    DS_Hang[i]=new Hang();
                    DS_Hang[i] =(Hang) objHang; 
                }
            } catch (Exception e) {
            }
            inHang.close();
            outHang.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Hang=========================================\n");
     System.out.format("%5s%18s\n", "Ma Hang", "Ten Hang");
        for (int i = 0; i < DS_Hang.length ; i++) {
            System.out.format("\n%5s | ", DS_Hang[i].getMaHang());
            System.out.format("%15s | ", DS_Hang[i].getTenHang());     
    }
    }
    public static void main(String[] args) {
        MangHang a=new MangHang();
       // a.NhapMang();
        //a.XuatMang();
       //a.xoa();
        //a.ghifileDanhSachHang();
        //a.SuaHang();
        a.docfileDanhSachHang();
        
        
        
    }
}
