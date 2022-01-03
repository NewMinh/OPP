/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhieuNhap;

import DungChung.Mang;
import NhaCungCap.MangNhaCungCap;
import NhaCungCap.NhaCungCap;
import Hang.MangHang;
import Hang.Hang;
import SanPham.DanhSachSanPham;
import SanPham.BanPhim;
import SanPham.SanPham;
import SanPham.CPU;
import SanPham.Chuot;
import SanPham.Laptop;
import SanPham.ManHinh;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MangChiTietPhieuNhap implements Mang{
    private ChiTietPhieuNhap[] MangCTPN;
    private int  SoluongCTPN;
    @Override
    public void NhapMang() {
       Object objHang;
        Hang DS_Hang[] =null ;
        DS_Hang=new Hang[0];
        String DSMH = "DS_Hang.txt";
        try {
            FileInputStream inHang = new FileInputStream(DSMH);
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
        System.out.print("\n======================================Danh Sac Hang=========================================\n");
      
        System.out.format("%5s%18s\n", "Ma Hang", "Ten Hang" );
        for (int i = 0; i < DS_Hang.length; i++) {
            System.out.format("\n%5s | ", DS_Hang[i].getMaHang());
            System.out.format("%15s | ", DS_Hang[i].getTenHang());
    }
    
        //========================================================Doc file Mang Phieu Nhap==========================================================
       Object obj;
        PhieuNhap u[] =null ;
        u=new PhieuNhap[0];
        String fileName = "DS_PhieuNhap.txt";
        try {
            FileInputStream PN = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(PN);
            try {
                for (int i=0;(obj = oIn.readObject())!=null;i++) {
                    
                    u=Arrays.copyOf(u, i+1);
                    u[i]=new PhieuNhap();
                    u[i] =(PhieuNhap) obj;
                    
                   
                }
            } catch (Exception e) {
            }
            PN.close();
            oIn.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
       System.out.print("\n======================================Mang Phieu Nhap=========================================\n");
      for(int i=0;i<u.length;i++){
           u[i].XuatPhieuNhap();
       }///////////////================== Nha cung Cap===============================================================================================
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
        //========================================================Doc file KHo==========================================================
        Object objSanPham;
        SanPham Kho[] =null ;
        Kho=new SanPham[0];
        String fileSanPham = "DS_HangHoa.txt";
        try {
            FileInputStream fin = new FileInputStream(fileSanPham);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(objSanPham = oIn.readObject())!=null;i++) {
                    
                    u=Arrays.copyOf(u, i+1);
                    Kho[i]=new SanPham() {} ;
                    Kho[i] =(SanPham) objSanPham;
                    
                   
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

        System.out.print("\n================================Doc File================================================\n");
        for(int i=0;i<Kho.length;i++){
        Kho[i].XuatSanPham();
       
        }
        Scanner sc=new Scanner(System.in);
       
        
        //==================================================================================================================================
        MangCTPN=new ChiTietPhieuNhap[0];
         while(true){  
            try{  
                int v=1;   
                    System.out.println("********** HANG HOA¨ "+v +" **********");
                    phong:
                    while(true){
                        int t=0;    
                    System.out.println(" =============== Menu Nhập=============== ");
                    System.out.println("\nBan chon cai nao:");
                    System.out.println("1-Laptop");
                    System.out.println("2-CPU");
                    System.out.println("3-BanPhim");
                    System.out.println("4-Chuot");
                    System.out.println("5-ManHinh");
                    System.out.println("0-Kết thúc");
                    
                    System.out.println(" ==================================== ");
                        System.out.print("Nhap lua chon muon Nhap:");  
                        try{
                            t=Integer.parseInt(sc.nextLine());                   
                        }
                        catch(InputMismatchException ex){
                            System.out.println("\nLua chon sai..!");
                            continue phong;
                        }
                        sc.nextLine();//bá»? qua bá»™ nhá»› Ä‘á»‡m
                        switch(t){
                            case 1:{
                                int gt=Kho.length;int dem=0;
                                Kho=Arrays.copyOf(Kho,Kho.length+1);
                                for(int i=gt;i<Kho.length;i++){
                                Kho[i]=new ManHinh();
                                String a;
                                nhapma:
                                while(true){
                                    System.out.println("Ma San Pham:");
                                    a=sc.nextLine();
                                    for(int j=0;j<i;j++){
                                        if(a.equals(Kho[j].getMaSanPham()) && Kho[j].loai().equals(Kho[i].loai())){
                                            System.out.print("\nSan pham da co..Vui long nhap so luong:");
                                            int o=sc.nextInt();
                                            Kho[j].setSoluong(Kho[j].getSoluong() + o);                                     
                                            Kho=Arrays.copyOf(Kho,Kho.length-1);
                                            dem++;
                                            int n=MangCTPN.length;
                                            MangCTPN=Arrays.copyOf(MangCTPN,MangCTPN.length+1);
                                            sc.nextLine();
                                            for(int p=n;p<MangCTPN.length;p++){
                                                
                                                MangCTPN[p]=new ChiTietPhieuNhap();
//                                                String macc;
//                                                hihi:
//                                                do{
//                                                    System.out.print("\nNhap ma Phieu Nhap cua Chi Tiet Phieu Nhap:");
//                                                    macc=sc.nextLine();
//                                                    for(int k=0;k<u.length;k++){
//                                                        if(macc.equals(u[k].getMaPhieuNhap())){
//                                                            break hihi;
//                                                        }
//
//                                                    }
//                                                    System.out.print("\nMa Nha Cung Cap ko ton tai...........");
//                                                }while(true);
                                                MangCTPN[p].setMaPhieuNhap(u[u.length-1].getMaPhieuNhap());
                                                MangCTPN[p].setMaSanPham(a);
                                                MangCTPN[p].setLoai(Kho[j].loai());
                                                MangCTPN[p].setSoluong(o);
                                                MangCTPN[p].setGiaNhap(Kho[j].getGianhap());
                                                MangCTPN[p].setDongia(o*MangCTPN[p].getGiaNhap());
                                                       
                                                
                                            }
                                                    
                                            break nhapma;
                                        }      
                                    }
                                    break nhapma;
                                }
                                if(dem==0){
                                Kho[i].setMaSanPham(a);
                                System.out.print("\nTen San Pham:");
                                Kho[i].setTenSanPham(sc.nextLine());
                                Kho[i].setLoaihang(Kho[i].loai());
                                String mansx;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mansx = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mansx.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    Kho[i].setMaHang(mansx);
                                String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DS_NhaCungCap.length; p++) {
                                        if (mancc.equals(DS_NhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nha Cung cap ko ton tai...........");
                                } while (true);
                                Kho[i].setMaNhaCungCap(mancc);
                                int x=0;
                                sl:
                                while(true){                                           
                                    System.out.print("\nNhap so luong:");                
                                    try{
                                       x=sc.nextInt();
                                       break sl;
                                    }
                                    catch(InputMismatchException ex){
                                        System.out.println("\nNhap sai so luong....");
                                        sc.nextLine();
                                    }                           
                                }
                                Kho[i].setSoluong(x);
                                int y=0;
                                sl:
                                while(true){                                           
                                    System.out.print("\nNhap Gia Nhap:");                
                                    try{
                                       y=sc.nextInt();
                                        break sl;
                                    }
                                    catch(InputMismatchException ex){
                                        System.out.println("\nNhap sai gia nhap: ");;
                                        sc.nextLine();
                                    }                           
                                }
                                Kho[i].setGianhap(y);
                                int z=0;
                                sl:
                                while(true){                                           
                                    System.out.print("\nGia Ban:");                
                                    try{
                                       z=sc.nextInt();
                                        break sl;
                                    }
                                    catch(InputMismatchException ex){
                                        System.out.println("\nNhap Sai gia nhap:");
                                        sc.nextLine();
                                    }                           
                                }
                                Kho[i].setGiaban(z);
                                sc.nextLine(); 
                                   int n=MangCTPN.length;
                                            MangCTPN=Arrays.copyOf(MangCTPN,MangCTPN.length+1);
                                            sc.nextLine();
                                            for(int p=n;p<MangCTPN.length;p++){
                                                MangCTPN[p]=new ChiTietPhieuNhap();
//                                                String macc;
//                                                hihi:
//                                                do{
//                                                    System.out.print("\nNhap ma Phieu Nhap cua Chi Tiet Phieu Nhap:");
//                                                    macc=sc.nextLine();
//                                                    for(int k=0;k<u.length;k++){
//                                                        if(macc.equals(u[k].getMaPhieuNhap())){
//                                                            break hihi;
//                                                        }
//
//                                                    }
//                                                    System.out.print("\nMa Nha Cung Cap ko ton tai...........");
//                                                }while(true);
                                                MangCTPN[p].setMaPhieuNhap(u[u.length-1].getMaPhieuNhap());
                                                MangCTPN[p].setMaSanPham(a);
                                                MangCTPN[p].setLoai(Kho[i].loai());
                                                MangCTPN[p].setSoluong(x);
                                                MangCTPN[p].setGiaNhap(y);
                                                MangCTPN[p].setDongia((MangCTPN[p].getSoluong())*(MangCTPN[p].getGiaNhap()));
                                                
                                            }
                            }     
                            }
                            }
                            continue phong;
                            case 2:{
                                int gt=Kho.length;int dem=0;
                                Kho=Arrays.copyOf(Kho,Kho.length+1);
                                for(int i=gt;i<Kho.length;i++){
                                Kho[i]=new Laptop();
                                String a;
                                nhapma:
                                while(true){
                                    System.out.println("Ma San Pham:");
                                    a=sc.nextLine();
                                    for(int j=0;j<i;j++){
                                        if(a.equals(Kho[j].getMaSanPham()) &&Kho[j].loai().equals(Kho[i].loai())){//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                            System.out.println("\nSan pham da co..Vui long nhap so luong:");
                                            int o=sc.nextInt();
                                            Kho[j].setSoluong(Kho[j].getSoluong() + o);
                                           
                                            dem++;
                                            Kho=Arrays.copyOf(Kho,Kho.length-1);
                                               int n=MangCTPN.length;
                                                MangCTPN=Arrays.copyOf(MangCTPN,MangCTPN.length+1);
                                                sc.nextLine();
                                                for(int p=n;p<MangCTPN.length;p++){
                                                MangCTPN[p]=new ChiTietPhieuNhap();
//                                                String macc;
//                                                hihi:
//                                                do{
//                                                    System.out.print("\nNhap ma Phieu Nhap cua Chi Tiet Phieu Nhap::");
//                                                    macc=sc.nextLine();
//                                                    for(int k=0;k<u.length;k++){
//                                                        if(macc.equals(u[k].getMaPhieuNhap())){
//                                                            break hihi;
//                                                        }
//
//                                                    }
//                                                    System.out.print("\nMa Nha Cung Cap ko ton tai...........");
//                                                }while(true);
                                                MangCTPN[p].setMaPhieuNhap(u[u.length-1].getMaPhieuNhap());
                                                MangCTPN[p].setMaSanPham(a);
                                                MangCTPN[p].setLoai(Kho[j].loai());
                                                MangCTPN[p].setSoluong(o);
                                                MangCTPN[p].setGiaNhap(Kho[j].getGianhap());
                                                MangCTPN[p].setDongia(o*(MangCTPN[p].getGiaNhap()));
                                          
                                                
                                            }
                                            break nhapma;
                                        }      
                                    } 
                                    break nhapma;
                                }
                                if(dem==0){
                                Kho[i].setMaSanPham(a);
                                System.out.print("\nTen San Pham:");
                                Kho[i].setTenSanPham(sc.nextLine());
                                Kho[i].setLoaihang(Kho[i].loai());
                                String mansx;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mansx = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mansx.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    Kho[i].setMaHang(mansx);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DS_NhaCungCap.length; p++) {
                                            if (mancc.equals(DS_NhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    Kho[i].setMaNhaCungCap(mancc);
                                int x=0;
                                sl:
                                while(true){                                           
                                    System.out.print("\nNhap so luong:");                
                                    try{
                                       x=sc.nextInt();
                                       break sl;
                                    }
                                    catch(InputMismatchException ex){
                                        System.out.println("\nNhap sai so luong....");
                                        sc.nextLine();
                                    }                           
                                }
                                Kho[i].setSoluong(x);
                                int y=0;
                                sl:
                                while(true){                                           
                                    System.out.print("\nNhap Gia Nhap:");                
                                    try{
                                       y=sc.nextInt();
                                        break sl;
                                    }
                                    catch(InputMismatchException ex){
                                        System.out.println("\nNhap sai gia nhap ");
                                        sc.nextLine();
                                    }                           
                                }
                                Kho[i].setGianhap(y);
                                int z=0;
                                sl:
                                while(true){                                           
                                    System.out.print("\nGia Ban:");                
                                    try{
                                       z=sc.nextInt();
                                        break sl;
                                    }
                                    catch(InputMismatchException ex){
                                        System.out.println("\nNhap Sai gia nhap");
                                        sc.nextLine();
                                    }                           
                                }
                                Kho[i].setGiaban(z);
                                sc.nextLine(); 
                                         int n=MangCTPN.length;
                                            MangCTPN=Arrays.copyOf(MangCTPN,MangCTPN.length+1);
                                            sc.nextLine();
                                            for(int p=n;p<MangCTPN.length;p++){
                                                MangCTPN[p]=new ChiTietPhieuNhap();
//                                                String macc;
//                                                hihi:
//                                                do{
//                                                    System.out.print("\nNhap ma Phieu Nhap cua Chi Tiet Phieu Nhap:");
//                                                    macc=sc.nextLine();
//                                                    for(int k=0;k<u.length;k++){
//                                                        if(macc.equals(u[k].getMaPhieuNhap())){
//                                                            break hihi;
//                                                        }
//
//                                                    }
//                                                    System.out.print("\nMa Nha Cung Cap ko ton tai...........");
//                                                }while(true);
                                                MangCTPN[p].setMaPhieuNhap(u[u.length-1].getMaPhieuNhap());
                                                MangCTPN[p].setMaSanPham(a);
                                                MangCTPN[p].setLoai(Kho[i].loai());
                                                MangCTPN[p].setSoluong(x);
                                                MangCTPN[p].setGiaNhap(y);
                                                MangCTPN[p].setDongia((MangCTPN[p].getSoluong())*(MangCTPN[p].getGiaNhap()));
                                                
                                            }
                            }    
                            }
                            }
                            continue phong;
                            case 0:
                                break phong;
                            default:{
                                System.out.println("\nChon sai....\n");
                                continue phong;
                            }
                        }                                               
                    } 
                break;              
            }
            catch(NumberFormatException ex){
                System.out.println("\nSai");
            }
            catch(InputMismatchException ex){
                System.out.println("\nSAi");
            }
        }
         //========================================================Ghi vao kho=======================================================================
            try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_HangHoa.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Kho);
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
  //======================================================================================xuat kho=====================================================
  
        
       
        //------------------------------------------------------------------------------------------------------------------------------------
        File file = new File("DS_ChiTietPhieuNhap.txt");
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
            for(int i=0;i<MangCTPN.length;i++){
            oOut.writeObject(MangCTPN[i]);}
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
       System.out.print("\n========================================================Mang Chi Tiet Phieu Nhap================================================\n");
    
        for(int i=0;i<MangCTPN.length;i++){
            
            System.out.format("\n%5s | ", MangCTPN[i].getMaPhieuNhap());
            System.out.format("%15s | ", MangCTPN[i].getMaSanPham());
            System.out.format("%22s | ", MangCTPN[i].getLoai());
             System.out.format("%22s | ", MangCTPN[i].getSoluong());
           
    }
}
public void timkiemChiTietPhieuNhap(){
    Scanner sc=new Scanner(System.in);
    Object objPN;
        ChiTietPhieuNhap DS_ChiTietPhieuNhap[] =null ;
        DS_ChiTietPhieuNhap=new ChiTietPhieuNhap[0];
        String CTPX = "DS_ChiTietPhieuNhap.txt";
        try {
            FileInputStream inCTPX = new FileInputStream(CTPX);
            ObjectInputStream outCTPN = new ObjectInputStream(inCTPX);
            try {
                for (int i=0;(objPN = outCTPN.readObject())!=null;i++) {
                    
                    DS_ChiTietPhieuNhap=Arrays.copyOf(DS_ChiTietPhieuNhap, i+1);
                    DS_ChiTietPhieuNhap[i]=new ChiTietPhieuNhap();
                    DS_ChiTietPhieuNhap[i] =(ChiTietPhieuNhap) objPN;
                    
                   
                }
            } catch (Exception e) {
            }
            inCTPX.close();
            outCTPN.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Doc file Danh Sach Chi Tiet Phieu Nhap=========================================\n");
      System.out.format("%5s%13s%22s%22s", "Ma Phieu Nhap", "Ma San Pham","Loai","So luong");
        for(int i=0;i<DS_ChiTietPhieuNhap.length;i++){
            System.out.format("\n%5s | ", DS_ChiTietPhieuNhap[i].getMaPhieuNhap());
            System.out.format("%15s | ", DS_ChiTietPhieuNhap[i].getMaSanPham());
            System.out.format("%25s |", DS_ChiTietPhieuNhap[i].getLoai());
            System.out.format("%25s |", DS_ChiTietPhieuNhap[i].getSoluong());           
    }
//-----------------------------------------------------------------------------------------------------------------
if(DS_ChiTietPhieuNhap.length==0) {
    System.out.print("\nKhong co Chi Tiet Phieu Nhap Nao");
    return;
}
    try {
        String t;
        sc.nextLine();int s=0;
        haha:
       do { 
           hihi:
            do{
            System.out.print("\nNhap Ma Phieu Xuat Can Xem Chi Tiet:");
            
            t=sc.nextLine();
            System.out.print("\n");
              for(int i=0;i<DS_ChiTietPhieuNhap.length;i++){
                if(t.equals(DS_ChiTietPhieuNhap[i].getMaPhieuNhap())){
                        break hihi;
                }
              }
              System.out.print("\nMa Phieu Nhap Khong Dung");
            }
             while(true);
            System.out.format("\n%5s%18s%20s%20s\n", "Ma San Pham", "Loai", "So luong","Tong Tien Nhap");
           
            for(int i=0;i<DS_ChiTietPhieuNhap.length;i++){
                if(t.equals(DS_ChiTietPhieuNhap[i].getMaPhieuNhap())){
                    
                    System.out.format("\n%5s | ", DS_ChiTietPhieuNhap[i].getMaSanPham());
                    System.out.format("%15s | ", DS_ChiTietPhieuNhap[i].getLoai());
                    System.out.format("%18s | ", DS_ChiTietPhieuNhap[i].getSoluong());
                    s=(int) (s+(DS_ChiTietPhieuNhap[i].getDongia())); 
                } 
            }
            System.out.format("%18s | ", s);
            break;     
        } while(true);  
    } catch (Exception e) {
       // System.out.print("\n");
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
public void ghifileMangChiTietPhieuNhap() throws IOException{   
       File file = new File("DS_ChiTietPhieuNhap.txt");
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
            for(int i=0;i<MangCTPN.length;i++){
            oOut.writeObject(MangCTPN[i]);}
            oOut.flush();
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
     }
  public  void docfileMangChiTietPhieuNhap(){
        Object objPN;
        ChiTietPhieuNhap DS_ChiTietPhieuNhap[] =null ;
        DS_ChiTietPhieuNhap=new ChiTietPhieuNhap[0];
        String CTPX = "DS_ChiTietPhieuNhap.txt";
        try {
            FileInputStream inCTPN = new FileInputStream(CTPX);
            ObjectInputStream outCTPN = new ObjectInputStream(inCTPN);
            try {
                for (int i=0;(objPN = outCTPN.readObject())!=null;i++) {
                    
                    DS_ChiTietPhieuNhap=Arrays.copyOf(DS_ChiTietPhieuNhap, i+1);
                    DS_ChiTietPhieuNhap[i]=new ChiTietPhieuNhap();
                    DS_ChiTietPhieuNhap[i] =(ChiTietPhieuNhap) objPN;
                    
                   
                }
            } catch (Exception e) {
            }
            inCTPN.close();
            outCTPN.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Doc file Danh Sach Chi Tiet Phieu Nhap=========================================\n");
      System.out.format("%5s%13s%22s%22s", "Ma Phieu Nhap", "Ma San Pham","Loai","So luong");
        for(int i=0;i<DS_ChiTietPhieuNhap.length;i++){
            System.out.format("\n%5s | ", DS_ChiTietPhieuNhap[i].getMaPhieuNhap());
            System.out.format("%15s | ", DS_ChiTietPhieuNhap[i].getMaSanPham());
            System.out.format("%25s |", DS_ChiTietPhieuNhap[i].getLoai());
            System.out.format("%25s |", DS_ChiTietPhieuNhap[i].getSoluong());           
    }
    } 
  public void XoaSanpham(){
       FileInputStream FileIn = null;
        try {
            
            FileIn = new FileInputStream("DS_HangHoa.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Ko tim thay file !!!");
        }

        ObjectInputStream ois = null;
        SanPham[]Kho=null;
        try {
            ois = new ObjectInputStream(FileIn);
        } catch (IOException ex) {
            Logger.getLogger(DanhSachSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }// ko bÃ­t

        try {
             Kho=  (SanPham[]) ois.readObject();
            
        } catch (IOException ex) {
            System.out.println("Loi 3");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi 4");
        }
        try {
            ois.close();
        } catch (IOException ex) {
            System.out.println("Rong 3");
        }
        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:");  
        for (int i = 0; i < Kho.length; i++) {
            System.out.format("%5s | ", Kho[i].getMaSanPham());
            System.out.format("%15s | ", Kho[i].getTenSanPham());
            System.out.format("%17s |", Kho[i].getLoaihang());
            System.out.format("%22s | ", Kho[i].getMaHang());
            System.out.format("%22s | ", Kho[i].getMaNhaCungCap());
            System.out.format("%17d | ", Kho[i].getSoluong());
            System.out.format("%17d | ", Kho[i].getGianhap());
            System.out.format("%17d |\n", Kho[i].getGiaban());
        }
        //-------------------------------------------------------------------------------------------------------------
        Scanner sc=new Scanner(System.in);
          boolean check = false;
        int m;
        pho:
        while (true) {
            int t = 0;
            System.out.println(" =============== Menu Sửa =============== ");
            System.out.println("\nBan chon sua cai nao:");
            System.out.println("1-Laptop");
            System.out.println("2-CPU");
            System.out.println("3-Chuot");
            System.out.println("4-BanPhim");
            System.out.println("5-ManHinh");
            System.out.println("0-Thoat");
            System.out.println(" ==================================== ");
            System.out.print("Nhap lua chon:");
            try {
                t = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\nLua chon sai..!");
            }
            sc.nextLine();//bá»? qua bá»™ nhá»› Ä‘á»‡m
            switch (t) {
                case 0:
                break pho;
                case 1: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) && Kho[i].loai().equals("")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                m = i;
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    for (int i = m; i < Kho.length-1; i++) {
                        Kho[i] = Kho[i + 1];
                    }
                    Kho = Arrays.copyOf(Kho, Kho.length - 1);
                    break;
                }
                
                case 2: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) &&Kho[i].loai().equals("")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                m = i;
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    for (int i = m; i < Kho.length-1; i++) {
                        Kho[i] = Kho[i + 1];
                    }
                    Kho = Arrays.copyOf(Kho, Kho.length - 1);
                    break;
                }
                default:{
                    System.out.print("\nNhap sai lua chon....");
                    continue pho;
                }
                case 3: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) && Kho[i].loai().equals("")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                m = i;
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    for (int i = m; i < Kho.length-1; i++) {
                        Kho[i] = Kho[i + 1];
                    }
                    Kho = Arrays.copyOf(Kho, Kho.length - 1);
                    break;
                }
                case 4: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) && Kho[i].loai().equals("")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                m = i;
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    for (int i = m; i < Kho.length-1; i++) {
                        Kho[i] = Kho[i + 1];
                    }
                    Kho = Arrays.copyOf(Kho, Kho.length - 1);
                    break;
                }
                case 5 : {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) && Kho[i].loai().equals("")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                m = i;
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    for (int i = m; i < Kho.length-1; i++) {
                        Kho[i] = Kho[i + 1];
                    }
                    Kho = Arrays.copyOf(Kho, Kho.length - 1);
                    break;
                }
            }
        }
          try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_Hanghoa.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Kho);
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
  }
  public void SuaSanPham(){
      FileInputStream FileIn = null;
        try {
            
            FileIn = new FileInputStream("DS_HangHoa.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Ko tim thay file !!!");
        }

        ObjectInputStream ois = null;
        SanPham[]Kho=null;
        try {
            ois = new ObjectInputStream(FileIn);
        } catch (IOException ex) {
            Logger.getLogger(DanhSachSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }// ko bÃ­t

        try {
             Kho=  (SanPham[]) ois.readObject();
            
        } catch (IOException ex) {
            System.out.println("Loi 3");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi 4");
        }
        try {
            ois.close();
        } catch (IOException ex) {
            System.out.println("Rong 3");
        }
        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:");  
        for (int i = 0; i < Kho.length; i++) {
            System.out.format("%5s | ", Kho[i].getMaSanPham());
            System.out.format("%15s | ", Kho[i].getTenSanPham());
            System.out.format("%17s |", Kho[i].getLoaihang());
            System.out.format("%22s | ", Kho[i].getMaHang());
            System.out.format("%22s | ", Kho[i].getMaNhaCungCap());
            System.out.format("%17d | ", Kho[i].getSoluong());
            System.out.format("%17d | ", Kho[i].getGianhap());
            System.out.format("%17d |\n", Kho[i].getGiaban());
        }
        //-----------------------------------------------------------------------------------------------------------------------------
        
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
         //---------------------------------------------------------------------------------------------
       Object objHang;
        Hang DS_Hang[] =null ;
        DS_Hang=new Hang[0];
        String DSMH = "DS_Hang.txt";
        try {
            FileInputStream inHang = new FileInputStream(DSMH);
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
       System.out.format("\n%5s%18s%20s\n", "Ma Nha San Xuat", "Ten Nha San Xuat");
        for(int i=0;i<DS_Hang.length;i++){
            System.out.format("\n%5s | ", DS_Hang[i].getMaHang());
            System.out.format("%15s | ", DS_Hang[i].getTenHang());
         
               
    }
        //-------------------------------------------------------------------------------------------------------------------------
        Scanner sc=new Scanner(System.in);
          boolean check = false;
        String ma;
       pho:
        while (true) {
            try {
                
            
            int t;
            System.out.println(" =============== Menu Sửa =============== ");
            System.out.println("\nBan chon sua cai nao:");
            System.out.println("1-Laptop");
            System.out.println("2-CPU");
            System.out.println("3-Chuot");
            System.out.println("4-BanPhim");
            System.out.println("5-ManHinh");
            System.out.println("0-Thoat");
            System.out.println(" ==================================== ");
            System.out.print("Nhap lua chon:");
            try {
                t = Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException ex) {
                System.out.println("\nLua chon sai..!");
                continue;
            }
            sc.nextLine();//bá»? qua bá»™ nhá»› Ä‘á»‡m
            switch (t) {
                case 0:
                    break pho;
                case 1:{
                    nhapma:
                    while (true) {
                        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Nha San Xuat", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:");  
                        for(int i=0;i<Kho.length;i++){
                            Kho[i].XuatSanPham();
                        }
                        System.out.print("\nNhap Ma San Pham can sua:");
                        ma = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (ma.equals(Kho[i].getMaSanPham())&& Kho[i].loai().equals("Do An")) {
                            check = true;
                            break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.println("\n>>Nhap lai Ma San Pham.");
                            continue nhapma;
                        }       
                    }
                    System.out.println(" =============== Menu ===============");
                    System.out.println("\nChon thong tin muon sua");
                    System.out.println("1.Ma San Pham");
                    System.out.println("2.Ten San Pham");
                    System.out.println("3.Ma Hang");
                    System.out.println("4.So Luong");
                    System.out.println("5.Gia Nhap");
                    System.out.println("6.Gia Ban");
                    System.out.println("7.Nha San Xuat");
                    System.out.println("___________________________________________");
                    haha:
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
                    for (int i = 0; i < Kho.length; i++) {
                        if (ma.equals(Kho[i].getMaSanPham()) &&Kho[i].loai().equals("")) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma San Pham thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < Kho.length; j++) {
                                            if (x.equals(Kho[j].getMaSanPham()) && Kho[j].loai().equals("")) {
                                                System.out.println("\nMa San Pham da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    Kho[i].setMaSanPham(x);
                                    break haha;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten San Pham can thay doi:");
                                    String x = sc.nextLine();
                                    Kho[i].setTenSanPham(x);
                                    break haha;
                                }
                                case 3: {
                                String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DS_NhaCungCap.length; p++) {
                                        if (mancc.equals(DS_NhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nha Cung cap ko ton tai...........");
                                } while (true);
                                    Kho[i].setMaNhaCungCap(mancc);
                                    break haha;
                                }       
                                case 4: {
                                    int x = 0;
                                    sl:
                                    while (true) {
                                        System.out.print("\nNhap vao so luong can thay doi:");
                                        try {
                                            x = sc.nextInt();
                                            break sl;
                                        } catch (InputMismatchException ex) {
                                            System.out.println("\nSai so luong");
                                            sc.nextLine();
                                        }
                                    }      
                                    Kho[i].setSoluong(x);
                                    break haha;
                                }
                                case 5: {
                                    int x = 0;
                                    sl:
                                    while (true) {
                                        System.out.print("\nNhap Gia Nhap can thay doi:");
                                        try {
                                            x = sc.nextInt();
                                            break sl;
                                        } catch (InputMismatchException ex) {
                                            System.out.println("\n>>Gia Nhap bi sai...Nhap lai Gia Nhap:");
                                            sc.nextLine();
                                        }
                                    }
                                    Kho[i].setGianhap(x);
                                    break haha;
                                }
                                case 6: {
                                    int x = 0;
                                    sl:
                                    while (true) {
                                        System.out.print("\nNhap Gia Ban can thay doi:");
                                        try {
                                        x = sc.nextInt();
                                        break sl;
                                        } catch (InputMismatchException ex) {
                                            System.out.println("\nSai Gia Ban...Nhap lai gia Ban:");
                                             sc.nextLine();
                                        }
                                    }
                                    Kho[i].setGiaban(x);
                                    break haha;
                                }
                                case 7:{
                                    String mansx;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mansx = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mansx.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    Kho[i].setMaHang(mansx);
                                    break haha;
                                }
                                default: {
                                    System.out.println("\nNhap sai Lua Chon...Nhap lai lua chon cua ban");
                                    continue haha;
                                }
                            }
                        }
                    }
                }
            } break;
                case 2:{
                    nhapma:
                    while (true) {
                        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:");  
                        for(int i=0;i<Kho.length;i++){
                            Kho[i].XuatSanPham();
                        }
                        System.out.print("\nNhap Ma San Pham can sua:");
                        ma = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (ma.equals(Kho[i].getMaSanPham()) &&Kho[i].loai().equals("Thuc Uong")) {
                            check = true;
                            break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.println("\n>>Nhap lai Ma San Pham.");
                            continue nhapma;
                        }       
                    }
                    System.out.println(" =============== Menu ===============");
                    System.out.println("\nChon thong tin muon sua");
                    System.out.println("1.Ma San Pham");
                    System.out.println("2.Ten San Pham");
                    System.out.println("3.Ma Hang");
                    System.out.println("4.So Luong");
                    System.out.println("5.Gia Nhap");
                    System.out.println("6.Gia Ban");
                    System.out.println("7.Nha San Xuat");
                    System.out.println("___________________________________________");
                    haha:
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
                    for (int i = 0; i < Kho.length; i++) {
                        if (ma.equals(Kho[i].getMaSanPham()) &&Kho[i].loai().equals("Thuc Uong")) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma San Pham thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < Kho.length; j++) {
                                            if (x.equals(Kho[j].getMaSanPham())&& Kho[j].loai().equals("Thuc Uong")) {
                                                System.out.println("\nMa San Pham da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    Kho[i].setMaSanPham(x);
                                    break haha;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten San Pham can thay doi:");
                                    String x = sc.nextLine();
                                    Kho[i].setTenSanPham(x);
                                    break haha;
                                }
                                case 3: {
                                     String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DS_NhaCungCap.length; p++) {
                                        if (mancc.equals(DS_NhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nhan vien ko ton tai...........");
                                } while (true);
                                    Kho[i].setMaNhaCungCap(mancc);
                                    break haha;
                                }       
                                case 4: {
                                    int x = 0;
                                    sl:
                                    while (true) {
                                        System.out.print("\nNhap vao so luong can thay doi:");
                                        try {
                                            x = sc.nextInt();
                                            break sl;
                                        } catch (InputMismatchException ex) {
                                            System.out.println("\nSai so luong");
                                            sc.nextLine();
                                        }
                                    }      
                                    Kho[i].setSoluong(x);
                                    break haha;
                                }
                                case 5: {
                                    int x = 0;
                                    sl:
                                    while (true) {
                                        System.out.print("\nNhap Gia Nhap can thay doi:");
                                        try {
                                            x = sc.nextInt();
                                            break sl;
                                        } catch (InputMismatchException ex) {
                                            System.out.println("\n>>Gia Nhap bi sai...Nhap lai Gia Nhap:");
                                            sc.nextLine();
                                        }
                                    }
                                    Kho[i].setGianhap(x);
                                    break haha;
                                }
                                case 6: {
                                    int x = 0;
                                    sl:
                                    while (true) {
                                        System.out.print("\nNhap Gia Ban can thay doi:");
                                        try {
                                        x = sc.nextInt();
                                        break sl;
                                        } catch (InputMismatchException ex) {
                                            System.out.println("\nSai Gia Ban...Nhap lai gia Ban:");
                                             sc.nextLine();
                                        }
                                    }
                                    Kho[i].setGiaban(x);
                                    break haha;
                                }
                                 case 7:{
                                    String mansx;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mansx = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mansx.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    Kho[i].setMaHang(mansx);
                                    break haha;
                                }
                                default: {
                                    System.out.println("\nNhap sai Lua Chon...Nhap lai lua chon cua ban");
                                    continue haha;
                                }
                            }
                        }
                    }
                }
            }
             break;
        }
    }catch (Exception e) {
        System.out.print("\nSai");
            }
        }
        //-----------------------------------------------------------------------------------------------------------------------------
         try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_Hanghoa.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Kho);
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
  }
  public void TimKiemSanPham(){
      FileInputStream FileIn = null;
        try {
            
            FileIn = new FileInputStream("DS_HangHoa.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Ko tim thay file !!!");
        }

        ObjectInputStream ois = null;
        SanPham[]Kho=null;
        try {
            ois = new ObjectInputStream(FileIn);
        } catch (IOException ex) {
            Logger.getLogger(DanhSachSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }// ko bÃ­t

        try {
             Kho=  (SanPham[]) ois.readObject();
            
        } catch (IOException ex) {
            System.out.println("Loi 3");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi 4");
        }
        try {
            ois.close();
        } catch (IOException ex) {
            System.out.println("Rong 3");
        }
        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:");  
        for (int i = 0; i < Kho.length; i++) {
            System.out.format("%5s | ", Kho[i].getMaSanPham());
            System.out.format("%15s | ", Kho[i].getTenSanPham());
            System.out.format("%17s |", Kho[i].getLoaihang());
            System.out.format("%22s | ", Kho[i].getMaHang());
            System.out.format("%22s | ", Kho[i].getMaNhaCungCap());
            System.out.format("%17d | ", Kho[i].getSoluong());
            System.out.format("%17d | ", Kho[i].getGianhap());
            System.out.format("%17d |\n", Kho[i].getGiaban());
        }
        //-----------------------------------------------------------------------------------------------------------------------------
        Scanner sc=new Scanner(System.in);
         boolean check=false;
        //int m;
        
        pho:
        while (true) {
            try {
                
            
             int  t;
            System.out.println(" =============== Menu Tim kiếm=============== ");
            System.out.println("\nBan chon tim cai nao:");
            System.out.println("1-Laptop");
            System.out.println("2-CPU");
            System.out.println("3-Chuot");
            System.out.println("4-BanPhim");
            System.out.println("5-ManHinh");
            System.out.println("0-Thoat");
            System.out.println(" ==================================== ");
            System.out.print("Nhap lua chon:");
            try {
                t = Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException ex) {
                System.out.println("\nLua chon sai..!");
                continue pho;
            }
           
           // sc.nextLine();//bá»? qua bá»™ nhá»› Ä‘á»‡m
            switch (t) {
                case 0:
                break pho;
                case 1: {
                    String a;
                    nhapma:
                    while (true) {System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) &&Kho[i].loai().equals("Laptop")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Hang","Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", Kho[i].getMaSanPham());
                                System.out.format("%15s | ", Kho[i].getTenSanPham());
                                System.out.format("%17s | ", Kho[i].getLoaihang());
                                System.out.format("%22s | ", Kho[i].getMaHang());
                                System.out.format("%22s | ", Kho[i].getMaNhaCungCap());
                                System.out.format("%17d | ", Kho[i].getSoluong());
                                System.out.format("%17d | ", Kho[i].getGianhap());
                                System.out.format("%17d |\n", Kho[i].getGiaban());
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    
                    break ;
                }
                
                case 2: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) && Kho[i].loai().equals("CPU")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Hang","Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", Kho[i].getMaSanPham());
                                System.out.format("%15s | ", Kho[i].getTenSanPham());
                                System.out.format("%17s | ", Kho[i].getLoaihang());
                                System.out.format("%22s | ", Kho[i].getMaHang());
                                System.out.format("%22s | ", Kho[i].getMaNhaCungCap());
                                System.out.format("%17d | ", Kho[i].getSoluong());
                                System.out.format("%17d | ", Kho[i].getGianhap());
                                System.out.format("%17d |\n", Kho[i].getGiaban());
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    break;
                }
                case 3: {
                    String a;
                    nhapma:
                    while (true) {System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) &&Kho[i].loai().equals("Chuot")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Hang","Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", Kho[i].getMaSanPham());
                                System.out.format("%15s | ", Kho[i].getTenSanPham());
                                System.out.format("%17s | ", Kho[i].getLoaihang());
                                System.out.format("%22s | ", Kho[i].getMaHang());
                                System.out.format("%22s | ", Kho[i].getMaNhaCungCap());
                                System.out.format("%17d | ", Kho[i].getSoluong());
                                System.out.format("%17d | ", Kho[i].getGianhap());
                                System.out.format("%17d |\n", Kho[i].getGiaban());
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    
                    break ;
                }case 4: {
                    String a;
                    nhapma:
                    while (true) {System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) &&Kho[i].loai().equals("Ban Phim")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Hang","Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", Kho[i].getMaSanPham());
                                System.out.format("%15s | ", Kho[i].getTenSanPham());
                                System.out.format("%17s | ", Kho[i].getLoaihang());
                                System.out.format("%22s | ", Kho[i].getMaHang());
                                System.out.format("%22s | ", Kho[i].getMaNhaCungCap());
                                System.out.format("%17d | ", Kho[i].getSoluong());
                                System.out.format("%17d | ", Kho[i].getGianhap());
                                System.out.format("%17d |\n", Kho[i].getGiaban());
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    
                    break ;
                }
                case 5: {
                    String a;
                    nhapma:
                    while (true) {System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < Kho.length; i++) {
                            if (a.equals(Kho[i].getMaSanPham()) &&Kho[i].loai().equals("Man hinh")) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Hang","Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", Kho[i].getMaSanPham());
                                System.out.format("%15s | ", Kho[i].getTenSanPham());
                                System.out.format("%17s | ", Kho[i].getLoaihang());
                                System.out.format("%22s | ", Kho[i].getMaHang());
                                System.out.format("%22s | ", Kho[i].getMaNhaCungCap());
                                System.out.format("%17d | ", Kho[i].getSoluong());
                                System.out.format("%17d | ", Kho[i].getGianhap());
                                System.out.format("%17d |\n", Kho[i].getGiaban());
                                check = true;
                                break nhapma;
                            }
                        }
                        if (!check) {
                            System.out.print("\nNhap sai ma vui long nhap lai..");
                            continue nhapma;
                        }
                    }
                    
                    break ;
                }
                default:{
                    System.out.print("\nNhap sai lua chon....");
                    continue pho;
                }
            }
        }catch (Exception e) {
            System.out.print("\nSAi");
            }
        }
  }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        MangChiTietPhieuNhap a=new MangChiTietPhieuNhap();
       //a.NhapMang();
       // a.XuatMang();
        // a.TimKiemSanPham();
       a.docfileMangChiTietPhieuNhap();
      
      
      // a.XoaSanpham();
      //a.SuaSanPham();
     // a.TimKiemSanPham();
        //a.ghifileMangChiTietPhieuNhap();
        // a.timkiemChiTietPhieuNhap();
    }   
}
