package SanPham;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import DungChung.Mang;
import NhaCungCap.MangNhaCungCap;
import NhaCungCap.NhaCungCap;
import Hang.Hang;
import Hang.MangHang;
import PhieuNhap.MangPhieuNhap;
import java.io.DataOutputStream;
import java.io.File;
public class DanhSachSanPham implements Mang{

    private SanPham []hh;
    private Laptop[] lt;
    private BanPhim[] bp;
    private CPU[] cp;
    private Chuot[] ch;
    private ManHinh[] mh;
    private int n, k,m;
    private int SLSP;
   
    Scanner sc = new Scanner(System.in);

    public DanhSachSanPham() {
    }
      
    
    @Override   
    public void NhapMang() {
        //=========================================================Doc file nha cung cap===================================
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
//         for(int i=0;i<DSNhaCungCap.length;i++){
//             DSNhaCungCap[i].XuatNhaCungCap();
//         }
/////////////////////////////////////////////////////Doc file Nha san xuat///////////////////////////////////////////////////////////////
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
        System.out.format("%5s%20s\n", "Ma Hang", "Ten Hang" );
        for (int i = 0; i < DS_Hang.length; i++) {
            System.out.format("\n%5s | ", DS_Hang[i].getMaHang());
            System.out.format("%20s | ", DS_Hang[i].getTenHang());
    }
//         for(int i=0;i<DSNhaSanXuat.length;i++){
//             DSNhaSanXuat[i].XuatNhaSanXuat();
//         }
//=======================================================================================================================================
       int dem = 0, diem = 0;
        while (true) {
            System.out.print("\nNhap so luong San Pham: ");
            try {
                n = Integer.parseInt(sc.nextLine());
                lt = new Laptop[0];
                cp = new CPU[0];
                bp = new BanPhim[0];
                ch = new Chuot[0];
                mh = new ManHinh[0];

                for (int i = 0; i < n; i++) {
                    System.out.println("***** Hang hoa" + (i + 1) + " *****");
                    System.out.println(" =============== Menu Nhập=============== ");
                    System.out.println("\nBan chon cai nao:");
                    System.out.println("1-Laptop");
                    System.out.println("2-CPU");
                    System.out.println("3-BanPhim");
                    System.out.println("4-Chuot");
                    System.out.println("5-ManHinh");
                    System.out.println(" ==================================== ");
                    choice:
                    while (true) {
                        int t = 0;
                        System.out.print("Nhap lua Chon:");
                        try {
                            t = sc.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("\nLua chon sai....Vui long nhap lai:");
                        }
                        sc.nextLine();
                        switch (t) {
                            case 1: {
                                int gt=lt.length;
                                lt=Arrays.copyOf(lt,lt.length+1);
                                for(int k=gt;k<lt.length;k++){
                                String a;
                               
                                lt[k] = new Laptop();
                                
                                nhapma:
                                while (true) {
                                    System.out.print("\nMa san pham: ");
                                    a = sc.nextLine();
                                    for (int j = 0; j < k; j++) {
                                        if (a.equals(lt[j].getMaSanPham())) {
                                            System.out.println("\nMa san pham da co....");
                                            continue nhapma;
                                        }
                                    }
                                    break nhapma;
                                }
                                lt[k].setMaSanPham(a);
                                System.out.print("\nTen San Pham");
                                lt[k].setTenSanPham(sc.nextLine());
                                lt[k].setLoaihang(lt[k].loai());
                                dem++;
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap Ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mahang.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                lt[k].setMaHang(mahang);
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
                                    System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                } while (true);
                                lt[k].setMaNhaCungCap(mancc);
                                int x = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nSo luong:");
                                    try {
                                        x = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nNhap sai so luong...Nhap lai:");
                                        sc.nextLine();
                                    }
                                }
                                lt[k].setSoluong(x);
                                int y = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia Nhap:");
                                    try {
                                        y = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nGia Nhap bi Sai:");
                                        sc.nextLine();
                                    }
                                }
                                lt[k].setGianhap(y);
                                int z = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia ban ");
                                    try {
                                        z = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\n>>Nhap lai:i");
                                        sc.nextLine();
                                    }
                                }
                                lt[k].setGiaban(z);
                                sc.nextLine();
                                break choice;
                            }
                            }
                            case 2: {
                                int gt=cp.length;
                                cp=Arrays.copyOf(cp,cp.length+1);
                                for(int k=gt;k<cp.length;k++){
                                
                                
                                String a;
                                nhapma:
                                cp[k] = new CPU();
                                System.out.print("\nMa san pham: ");
                                nhapma:
                                while (true) {
                                    a = sc.nextLine();
                                    for (int j = 0; j < k; j++) {
                                        if (a.equals(cp[j].getMaSanPham())) {
                                            System.out.println("\nMa san pham da co:");
                                            continue nhapma;
                                        }
                                    }
                                    break nhapma;
                                }
                                cp[k].setMaSanPham(a);
                                System.out.print("\nTen San Pham");
                                cp[k].setTenSanPham(sc.nextLine());
                                cp[k].setLoaihang(cp[k].loai());
                                dem++;
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap Ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mahang.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    cp[k].setMaHang(mahang);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Nha Cung Cap:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DS_NhaCungCap.length; p++) {
                                            if (mancc.equals(DS_NhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                    } while (true);
                                    cp[k].setMaNhaCungCap(mancc);
                               
                                int x = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nSo luong:");
                                    try {
                                        x = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nNhap sai so luong...Nhap lai:");
                                        sc.nextLine();
                                    }
                                }
                                cp[k].setSoluong(x);
                                int y = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia Nhap:");
                                    try {
                                        y = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nGia Nhap bi Sai:");
                                        sc.nextLine();
                                    }
                                }
                                cp[k].setGianhap(y);
                                int z = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia ban ");
                                    try {
                                        z = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\n>>Nhap lai:i");
                                        sc.nextLine();
                                    }
                                }
                                cp[k].setGiaban(z);
                                sc.nextLine();
                                break choice;
                            }
                            }
                            case 3: {
                                int gt=bp.length;
                                bp=Arrays.copyOf(bp,bp.length+1);
                                for(int k=gt;k<bp.length;k++){
                                
                                
                                String a;
                                nhapma:
                                bp[k] = new BanPhim();
                                System.out.print("\nMa san pham: ");
                                nhapma:
                                while (true) {
                                    a = sc.nextLine();
                                    for (int j = 0; j < k; j++) {
                                        if (a.equals(bp[j].getMaSanPham())) {
                                            System.out.println("\nMa san pham da co:");
                                            continue nhapma;
                                        }
                                    }
                                    break nhapma;
                                }
                                bp[k].setMaSanPham(a);
                                System.out.print("\nTen San Pham");
                                bp[k].setTenSanPham(sc.nextLine());
                                bp[k].setLoaihang(bp[k].loai());
                                dem++;
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap Ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mahang.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    bp[k].setMaHang(mahang);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Nha Cung Cap:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DS_NhaCungCap.length; p++) {
                                            if (mancc.equals(DS_NhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                    } while (true);
                                    bp[k].setMaNhaCungCap(mancc);
                               
                                int x = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nSo luong:");
                                    try {
                                        x = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nNhap sai so luong...Nhap lai:");
                                        sc.nextLine();
                                    }
                                }
                                bp[k].setSoluong(x);
                                int y = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia Nhap:");
                                    try {
                                        y = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nGia Nhap bi Sai:");
                                        sc.nextLine();
                                    }
                                }
                                bp[k].setGianhap(y);
                                int z = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia ban ");
                                    try {
                                        z = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\n>>Nhap lai:i");
                                        sc.nextLine();
                                    }
                                }
                                bp[k].setGiaban(z);
                                sc.nextLine();
                                break choice;
                            }
                            }
                            case 4: {
                                int gt=ch.length;
                                ch=Arrays.copyOf(ch,ch.length+1);
                                for(int k=gt;k<ch.length;k++){
                                
                                
                                String a;
                                nhapma:
                                ch[k] = new Chuot();
                                System.out.print("\nMa san pham: ");
                                nhapma:
                                while (true) {
                                    a = sc.nextLine();
                                    for (int j = 0; j < k; j++) {
                                        if (a.equals(ch[j].getMaSanPham())) {
                                            System.out.println("\nMa san pham da co:");
                                            continue nhapma;
                                        }
                                    }
                                    break nhapma;
                                }
                                ch[k].setMaSanPham(a);
                                System.out.print("\nTen San Pham");
                                ch[k].setTenSanPham(sc.nextLine());
                                ch[k].setLoaihang(ch[k].loai());
                                dem++;
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap Ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mahang.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    ch[k].setMaHang(mahang);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Nha Cung Cap:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DS_NhaCungCap.length; p++) {
                                            if (mancc.equals(DS_NhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                    } while (true);
                                    ch[k].setMaNhaCungCap(mancc);
                               
                                int x = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nSo luong:");
                                    try {
                                        x = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nNhap sai so luong...Nhap lai:");
                                        sc.nextLine();
                                    }
                                }
                                ch[k].setSoluong(x);
                                int y = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia Nhap:");
                                    try {
                                        y = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nGia Nhap bi Sai:");
                                        sc.nextLine();
                                    }
                                }
                                ch[k].setGianhap(y);
                                int z = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia ban ");
                                    try {
                                        z = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\n>>Nhap lai:i");
                                        sc.nextLine();
                                    }
                                }
                                ch[k].setGiaban(z);
                                sc.nextLine();
                                break choice;
                            }
                            }
                            case 5: {
                                int gt=mh.length;
                                mh=Arrays.copyOf(mh,mh.length+1);
                                for(int k=gt;k<mh.length;k++){
                                
                                
                                String a;
                                nhapma:
                                mh[k] = new ManHinh();
                                System.out.print("\nMa san pham: ");
                                nhapma:
                                while (true) {
                                    a = sc.nextLine();
                                    for (int j = 0; j < k; j++) {
                                        if (a.equals(mh[j].getMaSanPham())) {
                                            System.out.println("\nMa san pham da co:");
                                            continue nhapma;
                                        }
                                    }
                                    break nhapma;
                                }
                                mh[k].setMaSanPham(a);
                                System.out.print("\nTen San Pham");
                                mh[k].setTenSanPham(sc.nextLine());
                                mh[k].setLoaihang(mh[k].loai());
                                dem++;
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap Ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DS_Hang.length; p++) {
                                            if (mahang.equals(DS_Hang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    mh[k].setMaHang(mahang);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Nha Cung Cap:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DS_NhaCungCap.length; p++) {
                                            if (mancc.equals(DS_NhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                    } while (true);
                                    mh[k].setMaNhaCungCap(mancc);
                               
                                int x = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nSo luong:");
                                    try {
                                        x = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nNhap sai so luong...Nhap lai:");
                                        sc.nextLine();
                                    }
                                }
                                mh[k].setSoluong(x);
                                int y = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia Nhap:");
                                    try {
                                        y = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\nGia Nhap bi Sai:");
                                        sc.nextLine();
                                    }
                                }
                                mh[k].setGianhap(y);
                                int z = 0;
                                sl:
                                while (true) {
                                    System.out.print("\nGia ban ");
                                    try {
                                        z = sc.nextInt();
                                        break sl;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("\n>>Nhap lai:i");
                                        sc.nextLine();
                                    }
                                }
                                mh[k].setGiaban(z);
                                sc.nextLine();
                                break choice;
                            }
                            }
                            default: {
                                System.out.println("\nLua chon khong hop le vui long nhap lai:");
                                continue choice;
                            }
                        }
                    }
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("\nNhap so luong Sai....Nhap lai:");
            } catch (InputMismatchException ex) {
                System.out.println("\nSai...Nhap lai:");
            }
        }
    }
    @Override
    public void XuatMang() {
        System.out.println("\n=============== DANH SACH SAN PHAM LAPTOP ===============");
        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:");  
        for (int i = 0; i < lt.length; i++) {
            System.out.format("%5s | ", lt[i].getMaSanPham());
            System.out.format("%15s | ", lt[i].getTenSanPham());
            System.out.format("%17s |", lt[i].getLoaihang());
            System.out.format("%22s | ", lt[i].getMaHang());
            System.out.format("%22s | ", lt[i].getMaNhaCungCap());
            System.out.format("%17d | ", lt[i].getSoluong());
            System.out.format("%17d | ", lt[i].getGianhap());
            System.out.format("%17d |\n", lt[i].getGiaban());
        }
        System.out.println("\n=============== DANH SACH SAN PHAM CPU ===============");
        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:"); 
        for (int i = 0; i < cp.length; i++) {
            System.out.format("%5s | ", cp[i].getMaSanPham());
            System.out.format("%15s | ", cp[i].getTenSanPham());
            System.out.format("%17s | ", cp[i].getLoaihang());
            System.out.format("%22s | ", cp[i].getMaHang());
            System.out.format("%22s | ", cp[i].getMaNhaCungCap());
            System.out.format("%17d | ", cp[i].getSoluong());
            System.out.format("%17d | ", cp[i].getGianhap());
            System.out.format("%17d |\n", cp[i].getGiaban());
        }
        System.out.println("\n=============== DANH SACH SAN PHAM BANPHIM ===============");
        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:"); 
        for (int i = 0; i < bp.length; i++) {
            System.out.format("%5s | ", bp[i].getMaSanPham());
            System.out.format("%15s | ", bp[i].getTenSanPham());
            System.out.format("%17s | ", bp[i].getLoaihang());
            System.out.format("%22s | ", bp[i].getMaHang());
            System.out.format("%22s | ", bp[i].getMaNhaCungCap());
            System.out.format("%17d | ", bp[i].getSoluong());
            System.out.format("%17d | ", bp[i].getGianhap());
            System.out.format("%17d |\n", bp[i].getGiaban());
        }
        System.out.println("\n=============== DANH SACH SAN PHAM CHUOT ===============");
        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:"); 
        for (int i = 0; i < ch.length; i++) {
            System.out.format("%5s | ", ch[i].getMaSanPham());
            System.out.format("%15s | ", ch[i].getTenSanPham());
            System.out.format("%17s | ", ch[i].getLoaihang());
            System.out.format("%22s | ", ch[i].getMaHang());
            System.out.format("%22s | ", ch[i].getMaNhaCungCap());
            System.out.format("%17d | ", ch[i].getSoluong());
            System.out.format("%17d | ", ch[i].getGianhap());
            System.out.format("%17d |\n", ch[i].getGiaban());
        }
        System.out.println("\n=============== DANH SACH SAN PHAM MANHINH ===============");
        System.out.format("%5s%18s%20s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:"); 
        for (int i = 0; i < mh.length; i++) {
            System.out.format("%5s | ", mh[i].getMaSanPham());
            System.out.format("%15s | ", mh[i].getTenSanPham());
            System.out.format("%17s | ", mh[i].getLoaihang());
            System.out.format("%22s | ", mh[i].getMaHang());
            System.out.format("%22s | ", mh[i].getMaNhaCungCap());
            System.out.format("%17d | ", mh[i].getSoluong());
            System.out.format("%17d | ", mh[i].getGianhap());
            System.out.format("%17d |\n", mh[i].getGiaban());
        }
    }
    public void them() {
         //=========================================================Doc file nha cung cap===================================
        FileInputStream fin=null;
         try {
             fin=new FileInputStream("DS_NhaCungCap.txt");
         } catch (FileNotFoundException e) {
             System.out.print("\nKhong tim thay file");
         }
         ObjectInputStream oss=null;
         NhaCungCap[]DSNhaCungCap=null;
         try {
             oss= new ObjectInputStream(fin);
         } catch (IOException e) {
             Logger.getLogger(MangNhaCungCap.class.getName()).log(Level.SEVERE, null, e);
         }
         try {
             DSNhaCungCap=(NhaCungCap[]) oss.readObject();
         } catch (IOException | ClassNotFoundException e) {
             System.out.print("\nLoi doc file 1");
         }
         try {
            oss.close();
        } catch (IOException ex) {
            System.out.println("Rong 3");
        }
         System.out.print("\n==================================DOC FILE Nha Cung Cap==================================");
         System.out.format("\n%5s%18s%20s\n", "Ma Nha Cung Cap", "Ten Nha Cung Cap", "Quoc Gia");
//         for(int i=0;i<DSNhaCungCap.length;i++){
//             DSNhaCungCap[i].XuatNhaCungCap();
//         }
/////////////////////////////////////////////////////Doc file Ma Hang///////////////////////////////////////////////////////////////
    FileInputStream in=null;
         try {
             in=new FileInputStream("DS_Hang.txt");
         } catch (FileNotFoundException e) {
             System.out.print("\nKhong tim thay file");
         }
         ObjectInputStream ok=null;
         Hang[]DSMaHang=null;
         try {
             ok= new ObjectInputStream(in);
         } catch (IOException e) {
             Logger.getLogger(Hang.class.getName()).log(Level.SEVERE, null, e);
         }
         try {
             DSMaHang=(Hang[]) ok.readObject();
         } catch (IOException | ClassNotFoundException e) {
             System.out.print("\nLoi doc file 1");
         }
         try {
            ok.close();
        } catch (IOException ex) {
            System.out.println("Rong 3");
        }
         System.out.print("\n==================================DOC FILE==================================");
         
         System.out.format("\n%5s%18s%20s\n", "Ma Hang", "Ten Hang", "Quoc Gia");
//         for(int i=0;i<DSMaHang.length;i++){
//             DSMaHang[i].XuatMaHang();
//         }
//=======================================================================================================================================
    
            while(true){  
            try{  
                int v=1;   
                    System.out.println("********** HANG HOA¨ "+v +" **********");
                    phong:
                    while(true){
                        int t=0;    
                    System.out.println(" =============== Menu Them San Pham =============== ");
                    System.out.println("\nBan chon Thêm cai nao:");
                    System.out.println("1-Laptop");
                    System.out.println("2-CPU");
                    System.out.println("2-Chuot");
                    System.out.println("2-BanPhim");
                    System.out.println("2-ManHinh");
                    System.out.println("0-Thoat");
                    System.out.println(" ==================================== ");
                        System.out.print("Nhap lua chon muon them:");  
                        try{
                            t=sc.nextInt();                   
                        }
                        catch(InputMismatchException ex){
                            System.out.println("\nLua chon sai..!");
                        }
                        sc.nextLine();//bá»? qua bá»™ nhá»› Ä‘á»‡m
                        switch(t){
                            case 1:{
                                int gt=lt.length;int dem=0;
                                lt=Arrays.copyOf(lt,lt.length+1);
                                for(int i=gt;i<lt.length;i++){
                                lt[i]=new Laptop();
                                String a;
                                nhapma:
                                while(true){
                                    System.out.println("Ma San Pham:");
                                    a=sc.nextLine();
                                    for(int j=0;j<i;j++){
                                        if(a.equals(lt[j].getMaSanPham())){
                                            System.out.print("\nSan pham da co..Vui long nhap so luong:");
                                            int o=sc.nextInt();
                                            lt[j].setSoluong(lt[j].getSoluong() + o);                                     
                                            lt=Arrays.copyOf(lt,lt.length-1);
                                            dem++;
                                            break nhapma;
                                        }      
                                    }
                                    break nhapma;
                                }
                                if(dem==0){
                                lt[i].setMaSanPham(a);
                                System.out.print("\nTen San Pham:");
                                lt[i].setTenSanPham(sc.nextLine());
                                lt[i].setLoaihang(lt[i].loai());
                                String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap Ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSMaHang.length; p++) {
                                            if (mahang.equals(DSMaHang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    lt[k].setMaHang(mahang);
                                String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DSNhaCungCap.length; p++) {
                                        if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nhan vien ko ton tai...........");
                                } while (true);
                                lt[k].setMaNhaCungCap(mancc);
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
                                lt[i].setSoluong(x);
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
                                lt[i].setGianhap(y);
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
                                lt[i].setGiaban(z);
                                sc.nextLine();                                
                            }     
                            }
                            }
                            continue phong;
                            case 2:{
                                int gt=cp.length;int dem=0;
                                cp=Arrays.copyOf(cp,cp.length+1);
                                for(int i=gt;i<cp.length;i++){
                                cp[i]=new CPU();
                                String a;
                                nhapma:
                                while(true){
                                    System.out.println("Ma San Pham:");
                                    a=sc.nextLine();
                                    for(int j=0;j<i;j++){
                                        if(a.equals(cp[j].getMaSanPham())){//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                            System.out.println("\nSan pham da co..Vui long nhap so luong:");
                                            int o=sc.nextInt();
                                            cp[j].setSoluong(cp[j].getSoluong() + o);
                                            System.out.println("\nSo luong:"+cp[i].Soluong);
                                            dem++;
                                            cp=Arrays.copyOf(cp,cp.length-1);
                                            break nhapma;
                                        }      
                                    } 
                                    break nhapma;
                                }
                                if(dem==0){
                                cp[i].setMaSanPham(a);
                                System.out.print("\nTen San Pham:");
                                cp[i].setTenSanPham(sc.nextLine());
                                cp[i].setLoaihang(cp[i].loai());
                                String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap Ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSMaHang.length; p++) {
                                            if (mahang.equals(DSMaHang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    cp[k].setMaHang(mahang);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Nha Cung Cap:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DSNhaCungCap.length; p++) {
                                            if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                    } while (true);
                                    cp[k].setMaNhaCungCap(mancc);
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
                                cp[i].setSoluong(x);
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
                                cp[i].setGianhap(y);
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
                                cp[i].setGiaban(z);
                                sc.nextLine();                                 
                            }    
                            }
                            }
                            continue phong;
                            case 3:{
                                int gt=ch.length;int dem=0;
                                ch=Arrays.copyOf(ch,ch.length+1);
                                for(int i=gt;i<ch.length;i++){
                                ch[i]=new Chuot();
                                String a;
                                nhapma:
                                while(true){
                                    System.out.println("Ma San Pham:");
                                    a=sc.nextLine();
                                    for(int j=0;j<i;j++){
                                        if(a.equals(ch[j].getMaSanPham())){//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                            System.out.println("\nSan pham da co..Vui long nhap so luong:");
                                            int o=sc.nextInt();
                                            ch[j].setSoluong(ch[j].getSoluong() + o);
                                            System.out.println("\nSo luong:"+ch[i].Soluong);
                                            dem++;
                                            ch=Arrays.copyOf(ch,ch.length-1);
                                            break nhapma;
                                        }      
                                    } 
                                    break nhapma;
                                }
                                if(dem==0){
                                ch[i].setMaSanPham(a);
                                System.out.print("\nTen San Pham:");
                                ch[i].setTenSanPham(sc.nextLine());
                                ch[i].setLoaihang(ch[i].loai());
                                String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSMaHang.length; p++) {
                                            if (mahang.equals(DSMaHang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    ch[k].setMaHang(mahang);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Nha Cung Cap:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DSNhaCungCap.length; p++) {
                                            if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    ch[k].setMaNhaCungCap(mancc);
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
                                ch[i].setSoluong(x);
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
                                ch[i].setGianhap(y);
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
                                ch[i].setGiaban(z);
                                sc.nextLine();                                 
                            }    
                            }
                            }
                            continue phong;
                            case 4:{
                                int gt=bp.length;int dem=0;
                                bp=Arrays.copyOf(bp,bp.length+1);
                                for(int i=gt;i<bp.length;i++){
                                bp[i]=new BanPhim();
                                String a;
                                nhapma:
                                while(true){
                                    System.out.println("Ma San Pham:");
                                    a=sc.nextLine();
                                    for(int j=0;j<i;j++){
                                        if(a.equals(bp[j].getMaSanPham())){//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                            System.out.println("\nSan pham da co..Vui long nhap so luong:");
                                            int o=sc.nextInt();
                                            bp[j].setSoluong(bp[j].getSoluong() + o);
                                            System.out.println("\nSo luong:"+bp[i].Soluong);
                                            dem++;
                                            bp=Arrays.copyOf(bp,bp.length-1);
                                            break nhapma;
                                        }      
                                    } 
                                    break nhapma;
                                }
                                if(dem==0){
                                bp[i].setMaSanPham(a);
                                System.out.print("\nTen San Pham:");
                                bp[i].setTenSanPham(sc.nextLine());
                                bp[i].setLoaihang(bp[i].loai());
                                String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSMaHang.length; p++) {
                                            if (mahang.equals(DSMaHang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    bp[k].setMaHang(mahang);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Nha Cung Cap:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DSNhaCungCap.length; p++) {
                                            if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Nha cung cap ko ton tai...........");
                                    } while (true);
                                    bp[k].setMaNhaCungCap(mancc);
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
                                bp[i].setSoluong(x);
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
                                bp[i].setGianhap(y);
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
                                bp[i].setGiaban(z);
                                sc.nextLine();                                 
                            }    
                            }
                            }
                            continue phong;
                            case 5:{
                                int gt=mh.length;int dem=0;
                                mh=Arrays.copyOf(mh,mh.length+1);
                                for(int i=gt;i<mh.length;i++){
                                mh[i]=new ManHinh();
                                String a;
                                nhapma:
                                while(true){
                                    System.out.println("Ma San Pham:");
                                    a=sc.nextLine();
                                    for(int j=0;j<i;j++){
                                        if(a.equals(mh[j].getMaSanPham())){//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                            System.out.println("\nSan pham da co..Vui long nhap so luong:");
                                            int o=sc.nextInt();
                                            mh[j].setSoluong(mh[j].getSoluong() + o);
                                            System.out.println("\nSo luong:"+mh[i].Soluong);
                                            dem++;
                                            mh=Arrays.copyOf(mh,mh.length-1);
                                            break nhapma;
                                        }      
                                    } 
                                    break nhapma;
                                }
                                if(dem==0){
                                mh[i].setMaSanPham(a);
                                System.out.print("\nTen San Pham:");
                                mh[i].setTenSanPham(sc.nextLine());
                                mh[i].setLoaihang(mh[i].loai());
                                String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSMaHang.length; p++) {
                                            if (mahang.equals(DSMaHang[p].getMaHang())) {
                                                break hihi;
                                            }

                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    mh[k].setMaHang(mahang);
                                    String mancc;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Nha Cung Cap:");
                                        mancc = sc.nextLine();
                                        for (int p = 0; p < DSNhaCungCap.length; p++) {
                                            if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                    } while (true);
                                    mh[k].setMaNhaCungCap(mancc);
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
                                mh[i].setSoluong(x);
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
                                mh[i].setGianhap(y);
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
                                mh[i].setGiaban(z);
                                sc.nextLine();                                 
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
}
    public void xoa() {
    boolean check = false;
        int m;
        pho:
        while (true) {
            int t = 0;
            System.out.println(" =============== Menu  Xóa=============== ");
            System.out.println("\nBan chon xoa cai nao:");
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
                        for (int i = 0; i < lt.length; i++) {
                            if (a.equals(lt[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
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
                    for (int i = m; i < lt.length-1; i++) {
                        lt[i] = lt[i + 1];
                    }
                    lt = Arrays.copyOf(lt, lt.length - 1);
                    break;
                }
                
                case 2: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < cp.length; i++) {
                            if (a.equals(cp[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
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
                    for (int i = m; i < cp.length-1; i++) {
                        cp[i] = cp[i + 1];
                    }
                    cp = Arrays.copyOf(cp, cp.length - 1);
                    break;
                }
                case 3: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < ch.length; i++) {
                            if (a.equals(ch[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
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
                    for (int i = m; i < ch.length-1; i++) {
                        ch[i] = ch[i + 1];
                    }
                    ch = Arrays.copyOf(ch, ch.length - 1);
                    break;
                }
                case 4: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < bp.length; i++) {
                            if (a.equals(bp[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
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
                    for (int i = m; i < bp.length-1; i++) {
                        bp[i] = bp[i + 1];
                    }
                    bp = Arrays.copyOf(bp, bp.length - 1);
                    break;
                }
                case 5: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < mh.length; i++) {
                            if (a.equals(mh[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
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
                    for (int i = m; i < mh.length-1; i++) {
                        mh[i] = mh[i + 1];
                    }
                    mh = Arrays.copyOf(mh, mh.length - 1);
                    break;
                }
                
                default:{
                    System.out.print("\nNhap sai lua chon....");
                    continue pho;
                }
            }
        }
    }

    public void xoaSP(){
       Object obj;
        SanPham u[] =null ;
        u=new SanPham[0];
        String fileName = "DS_HangHoa.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(obj = oIn.readObject())!=null;i++) {
                    
                    u=Arrays.copyOf(u, i+1);
                    u[i]=new SanPham() {} ;
                    u[i] =(SanPham) obj;
                    
                   
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
        boolean check = false;
        String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham:");
                        a = sc.nextLine();
                        for (int i = 0; i < u.length; i++) {
                            if (a.equals(u[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
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
                    for (int i = m; i < u.length-1; i++) {
                        u[i] = u[i + 1];
                    }
                    u = Arrays.copyOf(u, u.length - 1);
           try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_Hanghoa.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(int i=0;i<u.length;i++){
            oos.writeObject(u[i]);
        }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
              
                 
    }
    public void sua() {
        //=========================================================Doc file nha cung cap===================================
        FileInputStream fin=null;
         try {
             fin=new FileInputStream("DS_NhaCungCap.txt");
         } catch (FileNotFoundException e) {
             System.out.print("\nKhong tim thay file");
         }
         ObjectInputStream oss=null;
         NhaCungCap[]DSNhaCungCap=null;
         try {
             oss= new ObjectInputStream(fin);
         } catch (IOException e) {
             Logger.getLogger(MangNhaCungCap.class.getName()).log(Level.SEVERE, null, e);
         }
         try {
             DSNhaCungCap=(NhaCungCap[]) oss.readObject();
         } catch (IOException | ClassNotFoundException e) {
             System.out.print("\nLoi doc file 1");
         }
         try {
            oss.close();
        } catch (IOException ex) {
            System.out.println("Rong 3");
        }
         System.out.print("\n==================================DOC FILE Nha Cung Cap==================================");
         System.out.format("\n%5s%18s%20s\n", "Ma Nha Cung Cap", "Ten Nha Cung Cap", "Quoc Gia");
         for(int i=0;i<DSNhaCungCap.length;i++){
             DSNhaCungCap[i].XuatNhaCungCap();
         }
/////////////////////////////////////////////////////Doc file Nha san xuat///////////////////////////////////////////////////////////////
    FileInputStream in=null;
         try {
             in=new FileInputStream("DS_MaHang.txt");
         } catch (FileNotFoundException e) {
             System.out.print("\nKhong tim thay file");
         }
         ObjectInputStream o=null;
         Hang[]DSHang=null;
         try {
             o= new ObjectInputStream(in);
         } catch (IOException e) {
             Logger.getLogger(Hang.class.getName()).log(Level.SEVERE, null, e);
         }
         try {
             DSHang=(Hang[]) o.readObject();
         } catch (IOException | ClassNotFoundException e) {
             System.out.print("\nLoi doc file 1");
         }
         try {
            o.close();
        } catch (IOException ex) {
            System.out.println("Rong 3");
        }
         System.out.print("\n==================================DOC FILE==================================");
         
         System.out.format("\n%5s%18s\n", "Ma Hang", "Ten Hang");
        for(int i=0;i<DSHang.length;i++){
           DSHang[i].XuatHang();
         }
//=======================================================================================================================================
       boolean check = false;
        String ma;
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
                case 1:{
                    nhapma:
                    while (true) {
                        for(int i=0;i<lt.length;i++){
                            lt[i].XuatSanPham();
                        }
                        System.out.print("\nNhap Ma San Pham can sua:");
                        ma = sc.nextLine();
                        for (int i = 0; i < lt.length; i++) {
                            if (ma.equals(lt[i].getMaSanPham())) {
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
                    System.out.println("3.Ma Nha Cung Cap");
                    System.out.println("4.So Luong");
                    System.out.println("5.Gia Nhap");
                    System.out.println("6.Gia Ban");
                    System.out.println("7.Ma Hang");
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
                    for (int i = 0; i < lt.length; i++) {
                        if (ma.equals(lt[i].getMaSanPham())) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma San Pham thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < lt.length; j++) {
                                            if (x.equals(lt[j].getMaSanPham())) {
                                                System.out.println("\nMa San Pham da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    lt[i].setMaSanPham(x);
                                    break haha;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten San Pham can thay doi:");
                                    String x = sc.nextLine();
                                    lt[i].setTenSanPham(x);
                                    break haha;
                                }
                                case 3: {
                                String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DSNhaCungCap.length; p++) {
                                        if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                } while (true);
                                    lt[k].setMaNhaCungCap(mancc);
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
                                    lt[i].setSoluong(x);
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
                                    lt[i].setGianhap(x);
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
                                    lt[i].setGiaban(x);
                                    break haha;
                                }
                                case 7:{
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap Ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSHang.length; p++) {
                                            if (mahang.equals(DSHang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    lt[k].setMaHang(mahang);
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
                        for(int i=0;i<cp.length;i++){
                            cp[i].XuatSanPham();
                        }
                        System.out.print("\nNhap Ma San Pham can sua:");
                        ma = sc.nextLine();
                        for (int i = 0; i < cp.length; i++) {
                            if (ma.equals(cp[i].getMaSanPham())) {
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
                    System.out.println("3.Ma Nha Cung Cap");
                    System.out.println("4.So Luong");
                    System.out.println("5.Gia Nhap");
                    System.out.println("6.Gia Ban");
                    System.out.println("7.Ma Hang");
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
                   for (int i = 0; i < cp.length; i++) {
                        if (ma.equals(cp[i].getMaSanPham())) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma San Pham can sua:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < cp.length; j++) {
                                            if (x.equals(cp[j].getMaSanPham())) {
                                                System.out.println("\nMa San Pham da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    cp[i].setMaSanPham(x);
                                    break haha;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten San Pham can thay doi:");
                                    String x = sc.nextLine();
                                    cp[i].setTenSanPham(x);
                                    break haha;
                                }
                                case 3: {
                                     String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DSNhaCungCap.length; p++) {
                                        if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                } while (true);
                                    cp[k].setMaNhaCungCap(mancc);
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
                                    cp[i].setSoluong(x);
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
                                    cp[i].setGianhap(x);
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
                                    cp[i].setGiaban(x);
                                    break haha;
                                }
                                 case 7:{
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSHang.length; p++) {
                                            if (mahang.equals(DSHang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    cp[k].setMaHang(mahang);
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
                case 3:{
                    nhapma:
                    while (true) {
                        for(int i=0;i<ch.length;i++){
                            ch[i].XuatSanPham();
                        }
                        System.out.print("\nNhap Ma San Pham can sua:");
                        ma = sc.nextLine();
                        for (int i = 0; i < ch.length; i++) {
                            if (ma.equals(ch[i].getMaSanPham())) {
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
                    System.out.println("3.Ma Nha Cung Cap");
                    System.out.println("4.So Luong");
                    System.out.println("5.Gia Nhap");
                    System.out.println("6.Gia Ban");
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
                   for (int i = 0; i < ch.length; i++) {
                        if (ma.equals(ch[i].getMaSanPham())) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma San Pham thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < ch.length; j++) {
                                            if (x.equals(ch[j].getMaSanPham())) {
                                                System.out.println("\nMa San Pham da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    ch[i].setMaSanPham(x);
                                    break haha;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten San Pham can thay doi:");
                                    String x = sc.nextLine();
                                    ch[i].setTenSanPham(x);
                                    break haha;
                                }
                                case 3: {
                                     String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DSNhaCungCap.length; p++) {
                                        if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nha Cung Cap ko ton tai...........");
                                } while (true);
                                    ch[k].setMaNhaCungCap(mancc);
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
                                    ch[i].setSoluong(x);
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
                                    ch[i].setGianhap(x);
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
                                    ch[i].setGiaban(x);
                                    break haha;
                                }
                                 case 7:{
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSHang.length; p++) {
                                            if (mahang.equals(DSHang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    ch[k].setMaHang(mahang);
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
                case 4:{
                    nhapma:
                    while (true) {
                        for(int i=0;i<bp.length;i++){
                            bp[i].XuatSanPham();
                        }
                        System.out.print("\nNhap Ma San Phamhaha can sua:");
                        ma = sc.nextLine();
                        for (int i = 0; i < bp.length; i++) {
                            if (ma.equals(bp[i].getMaSanPham())) {
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
                    System.out.println("3.Ma Nha Cung Cap");
                    System.out.println("4.So Luong");
                    System.out.println("5.Gia Nhap");
                    System.out.println("6.Gia Ban");
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
                   for (int i = 0; i < bp.length; i++) {
                        if (ma.equals(bp[i].getMaSanPham())) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma San Pham thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < bp.length; j++) {
                                            if (x.equals(bp[j].getMaSanPham())) {
                                                System.out.println("\nMa San Pham da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    bp[i].setMaSanPham(x);
                                    break haha;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten San Pham can thay doi:");
                                    String x = sc.nextLine();
                                    bp[i].setTenSanPham(x);
                                    break haha;
                                }
                                case 3: {
                                     String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DSNhaCungCap.length; p++) {
                                        if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nhan vien ko ton tai...........");
                                } while (true);
                                    bp[k].setMaNhaCungCap(mancc);
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
                                    bp[i].setSoluong(x);
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
                                    bp[i].setGianhap(x);
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
                                    bp[i].setGiaban(x);
                                    break haha;
                                }
                                 case 7:{
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSHang.length; p++) {
                                            if (mahang.equals(DSHang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    bp[k].setMaHang(mahang);
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
                case 5:{
                    nhapma:
                    while (true) {
                        for(int i=0;i<mh.length;i++){
                            mh[i].XuatSanPham();
                        }
                        System.out.print("\nNhap Ma San Pham can sua:");
                        ma = sc.nextLine();
                        for (int i = 0; i < mh.length; i++) {
                            if (ma.equals(mh[i].getMaSanPham())) {
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
                    System.out.println("3.Ma Nha Cung Cap");
                    System.out.println("4.So Luong");
                    System.out.println("5.Gia Nhap");
                    System.out.println("6.Gia Ban");
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
                   for (int i = 0; i < mh.length; i++) {
                        if (ma.equals(mh[i].getMaSanPham())) {
                            switch (luachon) {
                                case 1: {
                                    String x;
                                    nhapma:
                                    while (true) {
                                        System.out.print("\nNhap ma San Pham thay doi:");
                                        x = sc.nextLine();
                                        for (int j = 0; j < mh.length; j++) {
                                            if (x.equals(mh[j].getMaSanPham())) {
                                                System.out.println("\nMa San Pham da co....Nhap lai:");
                                                continue nhapma;
                                            }
                                        }
                                        break nhapma;
                                    }   
                                    mh[i].setMaSanPham(x);
                                    break haha;
                                }
                                case 2: {
                                    System.out.print("\nNhap Ten San Pham can thay doi:");
                                    String x = sc.nextLine();
                                    mh[i].setTenSanPham(x);
                                    break haha;
                                }
                                case 3: {
                                     String mancc;
                                hihi:
                                do{
                                    System.out.print("\nNhap ma Nha Cung Cap:");
                                    mancc = sc.nextLine();
                                    for (int p = 0; p < DSNhaCungCap.length; p++) {
                                        if (mancc.equals(DSNhaCungCap[p].getMaNhaCungCap())) {
                                            break hihi;
                                        }
                                    }
                                    System.out.print("\nMa Nhan vien ko ton tai...........");
                                } while (true);
                                    mh[k].setMaNhaCungCap(mancc);
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
                                    mh[i].setSoluong(x);
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
                                    mh[i].setGianhap(x);
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
                                    mh[i].setGiaban(x);
                                    break haha;
                                }
                                 case 7:{
                                    String mahang;
                                    hihi:
                                    do {
                                        System.out.print("\nNhap ma Hang:");
                                        mahang = sc.nextLine();
                                        for (int p = 0; p < DSHang.length; p++) {
                                            if (mahang.equals(DSHang[p].getMaHang())) {
                                                break hihi;
                                            }
                                        }
                                        System.out.print("\nMa Hang ko ton tai...........");
                                    } while (true);
                                    mh[k].setMaHang(mahang);
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
    }
    }

    public void timkiem() {
       boolean check=false;
        int m;
        pho:
        while (true) {
            int t = 0;
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
                    while (true) {System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < lt.length; i++) {
                            if (a.equals(lt[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%%5s%22s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", lt[i].getMaSanPham());
                                System.out.format("%22s | ", lt[i].getTenSanPham());
                                System.out.format("%25s | ", lt[i].getLoaihang());
                                System.out.format("%25s | ", lt[i].getMaNhaCungCap());
                                System.out.format("%25d | ", lt[i].getSoluong());
                                System.out.format("%25d | ", lt[i].getGianhap());
                                System.out.format("%25d |\n", lt[i].getGiaban());
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
                        for (int i = 0; i < cp.length; i++) {
                            if (a.equals(cp[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%22s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", cp[i].getMaSanPham());
                                System.out.format("%22s | ", cp[i].getTenSanPham());
                                System.out.format("%25s | ", cp[i].getLoaihang());
                                System.out.format("%25s | ", cp[i].getMaNhaCungCap());
                                System.out.format("%20d | ", cp[i].getSoluong());
                                System.out.format("%20d | ", cp[i].getGianhap());
                                System.out.format("%20d |\n", cp[i].getGiaban());
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
                    while (true) {
                        System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < ch.length; i++) {
                            if (a.equals(ch[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%22s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", ch[i].getMaSanPham());
                                System.out.format("%22s | ", ch[i].getTenSanPham());
                                System.out.format("%25s | ", ch[i].getLoaihang());
                                System.out.format("%25s | ", ch[i].getMaNhaCungCap());
                                System.out.format("%20d | ", ch[i].getSoluong());
                                System.out.format("%20d | ", ch[i].getGianhap());
                                System.out.format("%20d |\n", ch[i].getGiaban());
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
                
                case 4: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < bp.length; i++) {
                            if (a.equals(bp[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%22s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", bp[i].getMaSanPham());
                                System.out.format("%22s | ", bp[i].getTenSanPham());
                                System.out.format("%25s | ", bp[i].getLoaihang());
                                System.out.format("%25s | ", bp[i].getMaNhaCungCap());
                                System.out.format("%20d | ", bp[i].getSoluong());
                                System.out.format("%20d | ", bp[i].getGianhap());
                                System.out.format("%20d |\n", bp[i].getGiaban());
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
                
                case 5: {
                    String a;
                    nhapma:
                    while (true) {
                        System.out.println("Ma San Pham Can Tim:");
                        a = sc.nextLine();
                        for (int i = 0; i < mh.length; i++) {
                            if (a.equals(mh[i].getMaSanPham())) {//kt trÃ¹ng mÃ£ hÃ ng nÃ¨
                                System.out.println("\nThong Tin San Pham tim kiem:");
                                System.out.format("%5s%22s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:", "Ma Nha Cung Cap:", "So luong:", "Gia Nhap:", "Gia Ban:");
                                System.out.format("%5s | ", mh[i].getMaSanPham());
                                System.out.format("%22s | ", mh[i].getTenSanPham());
                                System.out.format("%25s | ", mh[i].getLoaihang());
                                System.out.format("%25s | ", mh[i].getMaNhaCungCap());
                                System.out.format("%20d | ", mh[i].getSoluong());
                                System.out.format("%20d | ", mh[i].getGianhap());
                                System.out.format("%20d |\n", mh[i].getGiaban());
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
                default:{
                    System.out.print("\nNhap sai lua chon....");
                    continue pho;
                }
            }
        }
    }

    public boolean KT_FileRong() {
        if (hh.length == 0) {
            return true;
        }
        return false;
    }
    public void hh(){
        int j=0;
        
        hh=new SanPham[lt.length + cp.length + ch.length + bp.length + mh.length];
        for(int i=0;i<lt.length;i++){
            hh[i]=new Laptop();     
            hh[i]=lt[i];
        }
        for(int i=lt.length;i<cp.length+lt.length;i++){
            hh[i]=new CPU();     
            hh[i]=cp[i];
        }
          for(int i=cp.length+lt.length;i<ch.length+cp.length+lt.length;i++){
            hh[i]=new Chuot();     
            hh[i]=ch[i];
        }
           for(int i=ch.length+cp.length+lt.length;i<bp.length+ch.length+cp.length+lt.length;i++){
            hh[i]=new BanPhim();     
            hh[i]=bp[i];
        }
        for(int i=bp.length+ch.length+cp.length+lt.length;i<hh.length;i++){
            hh[i]=new ManHinh();
            hh[i]=mh[j];
            j++;
        }

        
        
    }
    public void ghifile() throws IOException {
       
    
       
         try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_Hanghoa.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(int i=0;i<hh.length;i++){
            oos.writeObject(hh[i]);
        }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
      
 
 }
    public void docfile() {
        Object obj;
        SanPham u[] =null ;
        u=new SanPham[0];
        String fileName = "DS_HangHoa.txt";
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                for (int i=0;(obj = oIn.readObject())!=null;i++) {
                    
                    u=Arrays.copyOf(u, i+1);
                    u[i]=new SanPham() {} ;
                    u[i] =(SanPham) obj;
                    
                   
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
        

        System.out.format("%5s%22s%25s%25s%25s%20s%20s%20s\n", "Ma San Pham", "Ten San Pham", "Loai:","Ma Hang", "Ma Nha Cung Cap", "So luong", "Gia Nhap", "Gia Ban:");  
        for (int i = 0; i < u.length; i++) {
            System.out.format("%5s | ", u[i].getMaSanPham());
            System.out.format("%22s | ", u[i].getTenSanPham());
            System.out.format("%25s |", u[i].getLoaihang());
            System.out.format("%25s | ", u[i].getMaHang());
            System.out.format("%25s | ", u[i].getMaNhaCungCap());
            System.out.format("%20d | ", u[i].getSoluong());
            System.out.format("%20d | ", u[i].getGianhap());
            System.out.format("%20d |\n", u[i].getGiaban());
        }
        
    }
//public+"\nMa san Pham:" void gop(){
//    hh=new SanPham[Da.length+Tu.length];
//    System.out.print("\nChieu dai:"+hh.length);
//    for(int i=0;i<Da.length;i++){  
//    }
//////    int j=0;
//////    for(int i=Da.length;i<hh.length;i++){
//////        hh[i]=(SanPham)Tu[j];
//////        j++;
////}
//    for(int i=0;i<hh.length;i++){
//        hh[i].XuatSanPham();
//    }
//}
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
    public void writefilehh() throws IOException {
  
        File file = new File("DS_HangHoa.txt");
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
            for(int i=0;i<hh.length;i++){
            oOut.writeObject(hh[i]);}
            oOut.flush();
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
       
        
    }
     public void docfile1() {
    	hh=new SanPham[SLSP];
        try {
            FileInputStream fi=new FileInputStream("DS_HangHoa.txt");
            ObjectInputStream ois=new ObjectInputStream(fi);
            while (fi.available()>0){
                hh=Arrays.copyOf(hh, hh.length+1);
                SanPham obj=(SanPham) ois.readObject();
                hh[SLSP]=obj;
                SLSP++;
            }                
            ois.close();
            fi.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int laySLSP(String masp,DanhSachSanPham ds)
        {
        	for(int i=0;i<ds.hh.length;i++)
        	{
        		if(masp.matches(ds.hh[i].getMaSanPham())==true)
        		{
        			return ds.hh[i].getSoluong();
        		}
        	}
        	for(int i=0;i<ds.bp.length;i++)
        	{
        		if(masp.matches(ds.bp[i].getMaSanPham())==true)
        		{
        			return ds.bp[i].getSoluong();
        		}
        	}
        	for(int i=0;i<ds.ch.length;i++)
        	{
        		if(masp.matches(ds.ch[i].getMaSanPham())==true)
        		{
        			return ds.ch[i].getSoluong();
        		}
        	}
        	for(int i=0;i<ds.cp.length;i++)
        	{
        		if(masp.matches(ds.cp[i].getMaSanPham())==true)
        		{
        			return ds.cp[i].getSoluong();
        		}
        	}
        	for(int i=0;i<ds.lt.length;i++)
        	{
        		if(masp.matches(ds.lt[i].getMaSanPham())==true)
        		{
        			return ds.lt[i].getSoluong();
        		}
        	}
        	for(int i=0;i<ds.mh.length;i++)
        	{
        		if(masp.matches(ds.mh[i].getMaSanPham())==true)
        		{
        			return ds.mh[i].getSoluong();
        		}
        	}
        	return -1;
        }
        public int layGia(String masp,DanhSachSanPham ds)
        {
        	//DanhSachSanPham ds = new DanhSachSanPham();
        	//ds.docfile();
        	for(int i=0;i<ds.hh.length;i++)
        	{
        		if(masp.matches(ds.hh[i].getMaSanPham())==true)
        		{
        			return ds.hh[i].getGiaban();
        		}
        	}
        	for(int i=0;i<ds.bp.length;i++)
        	{
        		if(masp.matches(ds.bp[i].getMaSanPham())==true)
        		{
        			return ds.bp[i].getGiaban();
        		}
        	}
        	for(int i=0;i<ds.ch.length;i++)
        	{
        		if(masp.matches(ds.ch[i].getMaSanPham())==true)
        		{
        			return ds.ch[i].getGiaban();
        		}
        	}
        	for(int i=0;i<ds.cp.length;i++)
        	{
        		if(masp.matches(ds.cp[i].getMaSanPham())==true)
        		{
        			return ds.cp[i].getGiaban();
        		}
        	}
        	for(int i=0;i<ds.lt.length;i++)
        	{
        		if(masp.matches(ds.lt[i].getMaSanPham())==true)
        		{
        			return ds.lt[i].getGiaban();
        		}
        	}
        	for(int i=0;i<ds.mh.length;i++)
        	{
        		if(masp.matches(ds.mh[i].getMaSanPham())==true)
        		{
        			return ds.mh[i].getGiaban();
        		}
        	}
        	return -1;
        }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DanhSachSanPham ds = new DanhSachSanPham();
       
        ds.NhapMang();
        //
        //ds.XuatMang();
        //ds.gop();
       // ds.them();               
        //ds.XuatMang();
        //ds.xoaSP();
     //  ds.sua();
       //ds.timkiem();
       // ds.xuat();
      
       //
       ds.hh();
       ds.writefilehh();
       //ds.ghifile();
       ds.docfile();
        //ds.xuat();
       // ds.laySLSP(masp)
       // ds.layGia("01");
        
}
}