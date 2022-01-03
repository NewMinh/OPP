/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhaCungCap;
import DungChung.Mang;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class MangNhaCungCap implements Mang,Serializable{
     private NhaCungCap [] MangNhaCungCap;
    private int SoluongNhaCungCap;
    static  Scanner sc=new Scanner(System.in);
    @Override
    public void NhapMang(){
         Object obj;
        NhaCungCap DS_NhaCungCap[] =null ;
        DS_NhaCungCap=new NhaCungCap[0];
        String fileName = "DS_NhaCungCap.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(obj = oIn.readObject())!=null;i++) {
                    
                    DS_NhaCungCap=Arrays.copyOf(DS_NhaCungCap, i+1);
                    DS_NhaCungCap[i]=new NhaCungCap();
                    DS_NhaCungCap[i] =(NhaCungCap) obj;
                    
                   
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
        System.out.print("\n======================================Doc file DAnh Sach Nha Cung Cap=========================================\n");
      System.out.format("\n%5s%18s%20s\n", "Ma Nha Cung Cap", "Ten Nha Cung Cap","Quoc Gia");
        for(int i=0;i<DS_NhaCungCap.length;i++){
            System.out.format("\n%5s | ", DS_NhaCungCap[i].getMaNhaCungCap());
            System.out.format("%15s | ", DS_NhaCungCap[i].getTenNhaCungCap());
            System.out.format("%20s |", DS_NhaCungCap[i].getQuocGia());
               
    }   MangNhaCungCap=new NhaCungCap[0];
        while(true){ 
            try {
                
                int gt=MangNhaCungCap.length;
                MangNhaCungCap=Arrays.copyOf(MangNhaCungCap,MangNhaCungCap.length+1);
                sc.nextLine();
                for(int i=gt;i<MangNhaCungCap.length;i++){
                     System.out.print("\n===================================Nhap Nha Cung  "+(i+1)+"===================================");
                    MangNhaCungCap[i]=new NhaCungCap();
                    String a;
                    haha:
                   do{
                   System.out.print("\nNhap ma Nha Cung Cap:");
                   a=sc.nextLine();
                   for(int j=0;j<DS_NhaCungCap.length;j++){
                       if(a.equals(DS_NhaCungCap[j].getMaNhaCungCap())){
                           System.out.print("\nMa Nha San Xuat da co...");
                           continue haha;
                       }
                      
                    }
                    break haha;
                    }while(true);
                    MangNhaCungCap[i].setMaNhaCungCap(a);
                    System.out.print("\nNhap Ten Nha Cung Cap:");
                    MangNhaCungCap[i].setTenNhaCungCap(sc.nextLine());
                    System.out.print("\nNhap Quoc Gia Nha Cung Cap:");
                    MangNhaCungCap[i].setQuocGia(sc.nextLine());
                }
                break;
            } catch (Exception e) {
                System.out.print("\nLoi so luong Nha San Xuat....");
            }
        }
       //----------------------------------------------------------------------Ghi lai vao file----------------------------------------------------------
        File file = new File("DS_NhaCungCap.txt");
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
            for(int i=0;i<MangNhaCungCap.length;i++){
            oOut.writeObject(MangNhaCungCap[i]);}
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
        System.out.println("\n=============== DANH SACH NHA CUNG CAP===============");
        System.out.format("%5s%18s%20s\n", "Ma Nha Cung Cap", "Ten Nha Cung Cap", "Quoc Gia");
        for (int i = 0; i < MangNhaCungCap.length; i++) {
            System.out.format("%5s | ", MangNhaCungCap[i].getMaNhaCungCap());
            System.out.format("%15s | ", MangNhaCungCap[i].getTenNhaCungCap());
            System.out.format("%17s |\n", MangNhaCungCap[i].getQuocGia());
            
        }
    }
    public void SuaNhaNhaCungCap(){
         Object objNhaCungCap;
        NhaCungCap DS_NhaCungCap[] =null ;
        DS_NhaCungCap=new NhaCungCap[0];
        String fileNhaCungCap = "DS_NhaCungCap.txt";
        try {
            FileInputStream inNhaCungCap = new FileInputStream(fileNhaCungCap);
            ObjectInputStream outNhaCungCap = new ObjectInputStream(inNhaCungCap);
            try {
                for (int i=0;(objNhaCungCap = outNhaCungCap.readObject())!=null;i++) {
                    
                    DS_NhaCungCap=Arrays.copyOf(DS_NhaCungCap, i+1);
                    DS_NhaCungCap[i]=new NhaCungCap();
                    DS_NhaCungCap[i] =(NhaCungCap) objNhaCungCap; 
                }
            } catch (Exception e) {
            }
            inNhaCungCap.close();
            outNhaCungCap.close();
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
        boolean check=false;
        String ma;
        haha:
        while(true){
            
            System.out.print("\nNhap ma Nha Cung Cap can Sua:");
            ma=sc.nextLine();
            for(int i=0;i<DS_NhaCungCap.length;i++){
                 if(ma.equals(DS_NhaCungCap[i].getMaNhaCungCap())){
                     check=true;
                     break haha;
                 }
                 
            }  
            if(!check){
                     System.out.println("\n>>Nhap lai Ma Nha Cung Cap muon sua.....");
                     continue haha;
                 }
        }
        System.out.println(" =============== Menu ===============");
        System.out.println("\nChon thong tin muon sua");
        System.out.println("1.Ma Nha Cung Cap");
        System.out.println("2.Ten Nha Cung Cap");
        System.out.println("3.Quoc Gia");
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
                for (int i = 0; i < DS_NhaCungCap.length; i++) {
                        if (ma.equals(DS_NhaCungCap[i].getMaNhaCungCap())) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma Nha Cung Cap thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < DS_NhaCungCap.length; j++) {
                                            if (x.equals(DS_NhaCungCap[j].getMaNhaCungCap())) {
                                                System.out.println("\nMa Nha Cung Cap da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    DS_NhaCungCap[i].setMaNhaCungCap(x);
                                    break hihi;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten Nha Cung Cap can thay doi:");
                                    String x = sc.nextLine();
                                    DS_NhaCungCap[i].setTenNhaCungCap(x);
                                    break hihi;
                                }
                                case 3: {
                                    System.out.print("\nNhap Quoc Gia Can Thay doi:");
                                    String x = sc.nextLine();
                                    DS_NhaCungCap[i].setQuocGia(x);
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
    FileOutputStream fos = new FileOutputStream("DS_NhaCungCap.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_NhaCungCap.length;i++){
        oos.writeObject(DS_NhaCungCap[i]);
    }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
        }
public void TimKiemNhaCungCap(){
    Object objNhaCungCap;
        NhaCungCap DS_NhaCungCap[] =null ;
        DS_NhaCungCap=new NhaCungCap[0];
        String fileNhaCungCap = "DS_NhaCungCap.txt";
        try {
            FileInputStream inNhaCungCap = new FileInputStream(fileNhaCungCap);
            ObjectInputStream outNhaCungCap = new ObjectInputStream(inNhaCungCap);
            try {
                for (int i=0;(objNhaCungCap = outNhaCungCap.readObject())!=null;i++) {
                    
                    DS_NhaCungCap=Arrays.copyOf(DS_NhaCungCap, i+1);
                    DS_NhaCungCap[i]=new NhaCungCap();
                    DS_NhaCungCap[i] =(NhaCungCap) objNhaCungCap; 
                }
            } catch (Exception e) {
            }
            inNhaCungCap.close();
            outNhaCungCap.close();
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
            boolean check=false;
            
            while(true){
               
                String a;
                nhapma:
                while(true){
                    System.out.print("\nNhap Ma Nha Cung Cap can tim:");
                    a=sc.nextLine();
                for(int i=0;i<DS_NhaCungCap.length;i++){
                    if(a.equals(DS_NhaCungCap[i].getMaNhaCungCap())){
                        DS_NhaCungCap[i].XuatNhaCungCap();
                        check=true;
                        break nhapma;
                    }
                    }
                if(!check){
                        System.out.print("\nNhap sai Ma Nha Cung Cap can tim...");
                        continue nhapma;
                        }
                }
            break;
            }
       }
public void ThemNhaSanXuat(){
    while(true){
        try {
        int gt=MangNhaCungCap.length;
        int k;
        System.out.print("\nNhap so luong Nha Cung Cap muon them:");
        k=Integer.parseInt(sc.nextLine());
        MangNhaCungCap=Arrays.copyOf(MangNhaCungCap,gt+k);
        for(int i=gt;i<MangNhaCungCap.length;i++){
                  System.out.print("\n============================Nha Cung Cap"+(i+1)+"========================================");
                 MangNhaCungCap[i]=new NhaCungCap();
                    String a;
                    haha:
                    while(true){
                        System.out.print("\nNhap Ma Nha Cung Cap:");
                        a=sc.nextLine();
                        for(int j=0;j<i;j++){
                            if(a.equals(MangNhaCungCap[j].getMaNhaCungCap())){
                                continue haha;
                            }
                        }
                        break haha;
                    }
                    MangNhaCungCap[i].setMaNhaCungCap(a);
                    System.out.print("\nNhap ten Nha Cung Cap:");
                    MangNhaCungCap[i].setTenNhaCungCap(sc.nextLine());
                    System.out.print("\nNhap Quoc Gia Nha Cung Cap");
                    MangNhaCungCap[i].setQuocGia(sc.nextLine());
                }
            break;
            } 
            catch (Exception e) { 
                System.out.print("\nNhap sai So Luong them.....");
            }
        }           
    }
public void xoa(){
    Object objNhaCungCap;
        NhaCungCap DS_NhaCungCap[] =null ;
        DS_NhaCungCap=new NhaCungCap[0];
        String fileNhaCungCap = "DS_NhaCungCap.txt";
        try {
            FileInputStream inNhaCungCap = new FileInputStream(fileNhaCungCap);
            ObjectInputStream outNhaCungCap = new ObjectInputStream(inNhaCungCap);
            try {
                for (int i=0;(objNhaCungCap = outNhaCungCap.readObject())!=null;i++) {
                    
                    DS_NhaCungCap=Arrays.copyOf(DS_NhaCungCap, i+1);
                    DS_NhaCungCap[i]=new NhaCungCap();
                    DS_NhaCungCap[i] =(NhaCungCap) objNhaCungCap; 
                }
            } catch (Exception e) {
            }
            inNhaCungCap.close();
            outNhaCungCap.close();
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
        if(DS_NhaCungCap.length==0){
            System.out.print("\nKhong Co Nha Cung Cap Nao...");
            return;
        }
    
        boolean check=false;
        int m;
        nhapma:
        while(true){
            System.out.print("\nNhap Ma Nha Cung Cap can Xoa:");
            String ma=sc.nextLine();
            for(int i=0;i<DS_NhaCungCap.length;i++){
                if(ma.equals(DS_NhaCungCap[i].getMaNhaCungCap())){
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
        for(int i=m;i<DS_NhaCungCap.length-1;i++)
        DS_NhaCungCap[i]=DS_NhaCungCap[i+1];
        DS_NhaCungCap = Arrays.copyOf(DS_NhaCungCap,DS_NhaCungCap.length-1); 
        //------------------------------------------------------------Ghi ko de-------------------------------------------------------------------------------
              try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_NhaCungCap.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_NhaCungCap.length;i++){
        oos.writeObject(DS_NhaCungCap[i]);
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
public void ghifileDanhSachNhaCungCap(){
    File file = new File("DS_NhaCungCap.txt");
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
            for(int i=0;i<MangNhaCungCap.length;i++){
            oOut.writeObject(MangNhaCungCap[i]);}
            oOut.flush();
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();   
        } catch (IOException e) {
            e.printStackTrace();  
        }    
 }
public void docfileDanhSachNhaCungCap(){
    Object objNhaCungCap;
        NhaCungCap DS_NhaCungCap[] =null ;
        DS_NhaCungCap=new NhaCungCap[0];
        String fileNhaCungCap = "DS_NhaCungCap.txt";
        try {
            FileInputStream inNhaCungCap = new FileInputStream(fileNhaCungCap);
            ObjectInputStream outNhaCungCap = new ObjectInputStream(inNhaCungCap);
            try {
                for (int i=0;(objNhaCungCap = outNhaCungCap.readObject())!=null;i++) {
                    
                    DS_NhaCungCap=Arrays.copyOf(DS_NhaCungCap, i+1);
                    DS_NhaCungCap[i]=new NhaCungCap();
                    DS_NhaCungCap[i] =(NhaCungCap) objNhaCungCap; 
                }
            } catch (Exception e) {
            }
            inNhaCungCap.close();
            outNhaCungCap.close();
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
    }
    public static void main(String[] args) {
        MangNhaCungCap a=new MangNhaCungCap();
        //a.NhapMang();
        //a.XuatMang();
       //a.xoa();
        //a.ghifileDanhSachNhaCungCap();
        a.SuaNhaNhaCungCap();
        a.docfileDanhSachNhaCungCap();
        
        
        
    }
}
