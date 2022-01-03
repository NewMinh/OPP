/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import Acount.Login;
import Acount.MangAccount;
import Hang.Hang;
import NhaCungCap.MangNhaCungCap;
import Hang.MangHang;
import NhanVien.MangNhanVien;
import PhieuNhap.MangChiTietPhieuNhap;
import PhieuNhap.MangPhieuNhap;
import HoaDon.DSChiTietHoaDon;
import HoaDon.DSHoaDon;
import KhachHang.DSKhachHang;
import Sale.DSsale;
import SanPham.DanhSachSanPham;
import java.io.IOException;
import java.util.Scanner;
public class main {
    DSHoaDon DSHD;
    DSChiTietHoaDon DSCTHD;
    DSKhachHang DSKH;
    DSsale DSKM;
    DanhSachSanPham DSSP;
    
    
    public main(){
        this.DSKH = new DSKhachHang();
        this.DSHD = new DSHoaDon();
        this.DSKM = new DSsale();
        this.DSCTHD = new DSChiTietHoaDon();
        this.DSSP = new DanhSachSanPham();
    }

    public void run() throws IOException {
        Scanner sc=new Scanner(System.in);
        
        MangNhanVien DSNhanVien=new MangNhanVien();
        Login Login=new Login();
        MangHang Hang=new MangHang();
        MangNhaCungCap NhaCungCap=new MangNhaCungCap();
        MangPhieuNhap PhieuNhap=new MangPhieuNhap();
        MangChiTietPhieuNhap ChiTietPhieuNhap=new MangChiTietPhieuNhap();
        DSHoaDon HoaDon=new DSHoaDon();
        DSChiTietHoaDon ChiTietHoaDon=new DSChiTietHoaDon();
        MangAccount Account =new MangAccount();
        DanhSachSanPham Kho=new DanhSachSanPham();
        String a=Login.check();
       
       
        if(a.equals("admin")){
            login:
            while(true){
                
                int luachon;
                luachon:
                while(true){
                System.out.print("\n-------------MENU ADMIN------------------\n");
                System.out.print("\n1.Nhân Viên");
                System.out.print("\n2.Account");
                System.out.print("\n3.Phiếu nhập");
                System.out.print("\n4.Hóa đơn");
                System.out.print("\n5.Xem Kho Hàng");
                System.out.print("\n6.Xem Hãng");
                System.out.print("\n7.Xem Nhà Cung Cấp");
                System.out.print("\n8.Sale");
                System.out.print("\n9.Xem Khach Hang");
                System.out.print("\n0.Thoát");
                System.out.print("\nNhập lựa chọn của bạn:");
                    try {
                       luachon = Integer.parseInt(sc.nextLine());
                       hihi:
                       do{
                           if(luachon<0 ||luachon>9){
                               System.out.print("\nLựa chọn sai...");
                               continue luachon;
                           }
                           else if(luachon==1){
                               
                               int luachon1;
                               luachon1:
                               while(true){
                               System.out.print("\n---------MENU NHÂN VIÊN-------------");
                               System.out.print("\n1.Xem Danh Sách Nhân Viên");
                               System.out.print("\n2.Sửa Nhân Viên");
                               System.out.print("\n3.Xoá Nhân Viên");
                               System.out.print("\n4.Thêm Nhân Viên");
                               System.out.print("\n0.Trở về");
                                   System.out.print("\nNhập lựa chọn:");
                                   
                                   try {
                                       luachon1=Integer.parseInt(sc.nextLine());
                                    
                                   if(luachon1<0||luachon1>4){
                                       System.out.print("\nLựa chọn sai....");
                                       continue luachon1;
                                   }
                                   else if(luachon1==1){
                                       System.out.print("\nDanh Sách Nhân Viên");
                                       DSNhanVien.docfileMangNhanVien();
                                       continue luachon1;
                                       
                                   }
                                    else if(luachon1==2){
                                       System.out.print("\nSửa Nhân Viên");
                                       DSNhanVien.SuaNhanVien();
                                       continue luachon1;
                                   }
                                     else if(luachon1==3){
                                       System.out.print("\nXoá Nhân Viên");
                                       DSNhanVien.xoaNhanVien();
                                       continue luachon1;
                                   }
                                    else if(luachon1==4){
                                       System.out.print("\nThêm Nhân Viên");
                                       DSNhanVien.NhapMang();
                                       continue luachon1;
                                   }
                                   
                                    else if(luachon1==0) {
                                        System.out.print("\nBack");
                                        break luachon;
                                    }
                                        
                               
                               }catch (Exception e) {
                                   System.out.print("\nSai lựa chọn..");
                                      continue luachon1; 
                                   }
                               }  
                           }
                           else if(luachon==2){
                               int luachon2;
                               luachon2:
                               while(true){
                               System.out.print("\n---------MENU ACCOUNT-------------");
                               System.out.print("\n1.Xem Danh Sách ACCOUNT");
                               System.out.print("\n2.Xoá Account");
                               System.out.print("\n3.Thêm Account");
                               System.out.print("\n4.Sửa Account");
                               System.out.print("\n0.Trở Về");
                               System.out.print("\nNhập Lựa chọn:");
                                   try {
                                       
                                    
                                   luachon2=Integer.parseInt(sc.nextLine());
                                   if(luachon2<0||luachon2>4){
                                       System.out.print("\nLựa chọn sai....");
                                       continue luachon2;
                                   }
                                   else if(luachon2==1){
                                       System.out.print("\nDanh Sách Account");
                                       Account.docfileMangAccount();
                                   }
                                    else if(luachon2==2){
                                       System.out.print("\nXoá Account");
                                       Account.XoaAccount();
                                   }
                                     else if(luachon2==3){
                                       System.out.print("\nThêm Account");
                                       Account.NhapMang();
                                   }
                                    else if(luachon2==4){
                                       System.out.print("\nSửa Account");
                                       Account.SuaAccount();
                                   }
                                   
                                   else continue luachon;
                               }catch (Exception e) {
                                   System.out.print("\nNhập sai...");
                                   continue luachon2;
                               }       
                               }
                           }
                           else if(luachon==3){
                               int luachon3;
                               luachon3:
                               while(true){
                                   System.out.print("\n---------MENU PHIẾU NHẬP-------------");
                               System.out.print("\n1.Xem Danh Sách Phiếu Nhập");
                               System.out.print("\n2.Xem Chi Tiết Phiếu Nhập");
                               System.out.print("\n3.Nhập Hàng");
                               System.out.print("\n0.Trở Về");
                               System.out.print("\nNhập Lựa chọn:");
                                   try {
                                       
                                   
                                   luachon3=Integer.parseInt(sc.nextLine());
                                   if(luachon3<0||luachon3>3){
                                       System.out.print("\nLựa Chọn sai....");
                                       continue luachon3;
                                   }
                                   else if(luachon3==1){
                                       System.out.print("\nDanh Sách Phiếu Nhập");
                                       PhieuNhap.readfileMangPhieuNhap();
                                       continue luachon3;
                                   }
                                    else if(luachon3==2){
                                       System.out.print("\nXem Chi Tiết Phiếu Nhập");
                                       ChiTietPhieuNhap.timkiemChiTietPhieuNhap();
                                       continue luachon3;
                                   }
                                     else if(luachon3==3){
                                       System.out.print("\nNhập Hàng");
                                       PhieuNhap.NhapMang();
                                       ChiTietPhieuNhap.NhapMang();
                                       continue luachon3;
                                   }
                                   else continue luachon;
                               }
                                catch (Exception e) {
                                    System.out.print("\nNhập sai....");
                                    continue luachon3;
                                       }  
                               }
                           }
                           else if(luachon==4){
                               int luachon4;
                               luachon4:
                               while(true){
                                   
                                    DSKH = new DSKhachHang();
                                    DSKH.docfile();
	        	DSHD = new DSHoaDon();
	        	DSHD.docfile();
	        	DSHD = new DSHoaDon();
	        	DSHD.docfile();
	        	DSKM = new DSsale();
	        	DSKM.docfile();
	        	DSCTHD = new DSChiTietHoaDon();
	        	DSCTHD.docfile();
                        DSSP = new DanhSachSanPham();
	        	DSSP.docfile1();
                                   System.out.print("\n---------MENU HOÁ DƠN-------------");
                               System.out.print("\n1.Xem Danh Sach Hóa đơn");                              
                               System.out.print("\n2.Xem Chi Tiết Hóa Đơn");
                               System.out.print("\n3.Tạo Hóa Đơn"); 
                               System.out.print("\n4.Xem tat ca các chi tiết hóa đơn");
                               System.out.print("\n5.Sua Hoa Don");
                               System.out.print("\n0.Trở Về");
                               System.out.print("\nNhập Lựa chọn:");
                                   try {
                                       
                                   
                                   luachon4=Integer.parseInt(sc.nextLine());
                                   if(luachon4<0||luachon4>5){
                                       System.out.print("\nLựa Chọn sai....");
                                       continue luachon4;
                                   }
                                   else if(luachon4==1){
                                       System.out.print("\nDanh Sách Hóa Đơn");
                                       DSHD.XuatDSHoaDon();
                                       continue luachon4;
                                   }
                                    else if(luachon4==2){
                                       System.out.print("\nXem Chi Tiết Hóa Đơn");
                                       DSCTHD.XuatdsCTHD();;
                                       continue luachon4;
                                   }
                                     else if(luachon4==3){
                                       System.out.print("\nTạo Hóa Đơn");
                                       DSHD.ThemNhieuHoaDon(DSCTHD,DSKH,DSSP);
                                        DSHD.ghifile();
                                       HoaDon.docfile();
                                       continue luachon4;
                                   }
                                     else if(luachon4==4){
                                       System.out.println("\nXem tất cả Chi Tiết Hóa Đơn");
                                       DSCTHD.XuatTCCTHoaDon();
                                       continue luachon4;
                                     } 
                                     else if(luachon4==5){
                                       System.out.print("\nSua hoa don");
                                       DSHD.SuaHoaDon(DSCTHD);
                                       DSHD.ghifile();
                                       continue luachon4;
                                     }    
                                   else continue luachon;
                               } catch (Exception e) {
                                   System.out.print("\nSai Lựa chọn..");
                                   continue luachon4;
                                   }
                               }
                           }
                           else if(luachon==5){
                               Kho.docfile();
                                int luachon4;
                               luachon4:
                               while(true){
                               System.out.print("\n---------MENU KHO HANG-------------");
                               System.out.print("\n1.Xóa");
                               System.out.print("\n2.Sửa");
                               System.out.print("\n3.Tìm kiếm");
                              
                               System.out.print("\n0.Trở Về");
                               System.out.print("\nNhập Lựa chọn:");
                                   try {
                                       
                                   
                                   luachon4=Integer.parseInt(sc.nextLine());
                                   if(luachon4<0||luachon4>3){
                                       System.out.print("\nLựa Chọn sai....");
                                       continue luachon4;
                                   }
                                   else if(luachon4==1){
                                       Kho.xoaSP();
                                     
                                       continue luachon4;
                                   }
                                    else if(luachon4==2){
                                       
                                       Kho.sua();
                                       continue luachon4;
                                   }
                                     else if(luachon4==3){
                                        Kho.timkiem();
                                       continue luachon4;
                                   }
                                    
                                   else break luachon;
                               } catch (Exception e) {
                                   System.out.print("\nSai lựa chọn...");
                                   continue luachon4;
                                   }
                               }
                           } 
                               
                               
                       
                           else if(luachon==6){
                               int luachon4;
                               luachon4:
                               while(true){
                               System.out.print("\n---------MENU HÃNG-------------");
                               System.out.print("\n1.Xem Danh Sách Hãng");
                               System.out.print("\n2.Xoá Hãng");
                               System.out.print("\n3.Thêm Hãng");
                               System.out.print("\n4.Sử0a Hãng");
                               System.out.print("\n5.Tìm Hãng");
                               System.out.print("\n0.Trở Về");
                               System.out.print("\nNhập Lựa chọn:");
                                   try {
                                       
                                   
                                   luachon4=Integer.parseInt(sc.nextLine());
                                   if(luachon4<0||luachon4>5){
                                       System.out.print("\nLựa Chọn sai....");
                                       continue luachon4;
                                   }
                                   else if(luachon4==1){
                                       Hang.docfileDanhSachHang();
                                     
                                       continue luachon4;
                                   }
                                    else if(luachon4==2){
                                       
                                       Hang.xoa();
                                       continue luachon4;
                                   }
                                     else if(luachon4==3){
                                        Hang.NhapMang();                                   
                                       continue luachon4;
                                   }
                                     else if(luachon4==4){
                                       Hang.SuaHang();
                                     }
                                     else if(luachon4==5){
                                         Hang.TimKiemHang();
                                     }
                                   else break luachon;
                               } catch (Exception e) {
                                   System.out.print("\nSai lựa chọn...");
                                   continue luachon4;
                                   }
                               }
                           } 
                           else if(luachon==7){
                               int luachon4;
                               luachon4:
                               while(true){
                               System.out.print("\n---------MENU NHÀ CUNG CẤP-------------");
                               System.out.print("\n1.Xem Danh Sách Nhà Cung Cấp");
                               System.out.print("\n2.Xoá Nhà Cung Cấp");
                               System.out.print("\n3.Thêm Nhà Cung Cấp");
                               System.out.print("\n4.Sửa Nha Cung Cấp");
                               System.out.print("\n5.Tìm Kiếm Nhà Cung Cấp");
                               System.out.print("\n0.Trở Về");
                                   System.out.print("\nNhập Lựa chọn:");
                                   try {
                                       
                                   
                                   luachon4=Integer.parseInt(sc.nextLine());
                                   if(luachon4<0||luachon4>5){
                                       System.out.print("\nLựa Chọn sai....");
                                       continue luachon4;
                                   }
                                   else if(luachon4==1){
                                       
                                      NhaCungCap.docfileDanhSachNhaCungCap();
                                       continue luachon4;
                                   }
                                    else if(luachon4==2){
                                       
                                        NhaCungCap.xoa();
                                       continue luachon4;
                                   }
                                     else if(luachon4==3){
                                         NhaCungCap.NhapMang();                                   
                                       continue luachon4;
                                   }
                                     else if(luachon4==4){
                                        NhaCungCap.SuaNhaNhaCungCap();
                                     }
                                     else if(luachon4==5){
                                         NhaCungCap.TimKiemNhaCungCap();
                                     }
                                   else continue luachon;
                               }catch (Exception e) {
                                   System.out.print("\nSai lựa chọn..");
                                   continue luachon4;
                                   }
                               }
                           }
                            else if(luachon==8){
                               
                               int luachon8;
                               luachon8:
                               while(true){
                                   DSKM = new DSsale();
                                    DSKM.docfile();
                               System.out.print("\n---------MENU SALE-------------");
                              
                                System.out.println("");
                                System.out.println("1.Them Sale");
                                System.out.println("2.Sua Sale");
                                System.out.println("3.Xoa Sale");
                                System.out.println("4.Tim Kiem Sale");
                                System.out.println("5.Xem Danh Sach Sale");
                                System.out.println("0.Thoat");
                                   System.out.print("\nNhập lựa chọn:");
                                   
                                   try {
                                       luachon8=Integer.parseInt(sc.nextLine());
                                    
                                   if(luachon8<0||luachon8>6){
                                       System.out.print("\nLựa chọn sai....");
                                       continue luachon8;
                                   }
                                   else if(luachon8==1){
                                       System.out.print("\nThem Sale");
                                       DSKM.ThemNhieuKM();
                                        DSKM.ghifile();

                                       continue luachon8;
                                       
                                   }
                                    else if(luachon8==2){
                                       System.out.print("\nSửa Sale");
                                       DSKM.SuaSale();
                                        DSKM.ghifile();
                                       continue luachon8;
                                   }
                                     else if(luachon8==3){
                                       System.out.print("\nXoá Sale");
                                       DSKM.XoaKM();
                                        DSKM.ghifile();
                                       continue luachon8;
                                   }
                                    else if(luachon8==4){
                                       System.out.print("\nTim kiem Sale");
                                       DSKM.timkiemKM();
                                       continue luachon8;
                                   }
                                     else if(luachon8==5){
                                       System.out.print("\n Danh Sach Sale");
                                       DSKM.XuatDSKM();
                                       continue luachon8;
                                   }
                                   
                                    else if(luachon8==0) {
                                        System.out.print("\nBack");
                                        break luachon;
                                    }
                                        
                               
                               }catch (Exception e) {
                                   System.out.print("\nSai lựa chọn..");
                                      continue luachon8; 
                                   }
                               }  
                           }
                            else if(luachon==9){
                               int luachon4;
                               luachon4:
                               while(true){
                                   
                                    DSKH = new DSKhachHang();
                                    DSKH.docfile();
	        	
                                   System.out.print("\n---------MENU KHACH HANG-------------");
                               System.out.print("\n1.Xem Danh Sach Khach Hang");
                               System.out.print("\n2.Xoa Khach Hang");
                               System.out.print("\n3.Tim kiem Khach hang");
                               System.out.print("\n4.Them Khach hang");
                               System.out.print("\n0.Trở Về");
                               System.out.print("\nNhập Lựa chọn:");
                                   try {
                                       
                                   
                                   luachon4=Integer.parseInt(sc.nextLine());
                                   if(luachon4<0||luachon4>4){
                                       System.out.print("\nLựa Chọn sai....");
                                       continue luachon4;
                                   }
                                   else if(luachon4==1){
                                       System.out.print("\nDanh Sách Khach Hang");
                                       DSKH.XuatDSKhachHang();
                                       continue luachon4;
                                   }
                                    else if(luachon4==2){
                                       System.out.print("\nXoa Khach Hang");
                                       DSKH.XoaKhachHang();
                                       DSKH.ghifile();
                                       continue luachon4;
                                   }
                                     else if(luachon4==3){
                                       System.out.print("\nTim Kiem Khach Hang");
                                       DSKH.timkiemkh();
                                       continue luachon4;
                                   }
                                     else if(luachon4==4){
                                       System.out.print("\nThem Khach Hang");
                                       DSKH.ThemNhieuKhachHang();
                                       DSKH.ghifile();
                                       continue luachon4;
                                   }
                                   else continue luachon;
                               } catch (Exception e) {
                                   System.out.print("\nSai Lựa chọn..");
                                   continue luachon4;
                                   }
                               }
                           }
                           else if(luachon==0) break login;
                       }while(true);
                       
                    } catch (Exception e) {
                        continue luachon;
                  }  
                }        
            }  
        }
        else{
           login:
            while(true){
                
                int luachon;
                luachon:
                while(true){
                System.out.print("\n-------------MENU NHÂN VIÊN------------------\n");
                System.out.print("\n1.INFOMATION");
                System.out.print("\n2.Account");
                System.out.print("\n3.Phiếu Nhập");
                System.out.print("\n4.Hóa Đơn");
                System.out.print("\n5.Xem Kho Hàng");
                System.out.print("\n0.Thoát");
                    System.out.print("\nNhập lựa chọn cuả bạn:");
                    try {
                       luachon = Integer.parseInt(sc.nextLine());
                       hihi:
                       do{
                           if(luachon<0 ||luachon>5){
                               System.out.print("\nLựa chọn sai...");
                               continue luachon;
                           }
                           else if(luachon==1){
                              DSNhanVien.ThongTinNhanVien(a);
                                int luachon1;
                                haha:
                                while(true){
                                System.out.print("\n-------------MENU NHÂN VIÊN------------------\n");
                                System.out.print("\n1.Sửa Thông Tin");
                                System.out.print("\n0.Trở Về");
                                 System.out.print("\nNhập lựa chọn cuả bạn:");
                                    try {
                                        luachon1 = Integer.parseInt(sc.nextLine());
                                          olo:
                                           do{
                                             if(luachon1<0 ||luachon1>1){
                                                System.out.print("\nlựa chọn sai...");
                                                 continue haha;
                                             }
                                             else if(luachon1==1){
                                                 DSNhanVien.SuaThongTinNhanVien(a);
                                                 break haha;
                                             }
                                             else break haha;
                                           }while(true);
                                    } catch (Exception e) {
                                        System.out.print("\nNhập sai lựa chọn...");
                                        continue haha;
                                    }
                                }
                              continue luachon;
                           }
                           else if(luachon==2){
                               Account.SuaACNV(a);
                               continue luachon;
                           }
                           else if(luachon==3){
                               int luachon3;
                               luachon3:
                               while(true){
                               System.out.print("\n---------MENU PHIẾU NHẬP-------------");
                               System.out.print("\n1.Xem Danh Sách Phiếu Nhập");
                               System.out.print("\n2.Xem Chi Tiết Phiếu Nhập");
                               System.out.print("\n3.Nhập Hàng");
                               System.out.print("\n0.Trở Về");
                                   System.out.print("\nNhập lựa chọn:");
                                   try {   
                                   luachon3=Integer.parseInt(sc.nextLine());
                                   if(luachon3<0||luachon3>3){
                                       System.out.print("\nLựa chọn sai....");
                                       continue luachon3;
                                   }
                                   else if(luachon3==1){
                                       System.out.print("\nDanh Sách Phiếu Nhập");
                                       PhieuNhap.readfileMangPhieuNhap();
                                       continue luachon3;
                                   }
                                    else if(luachon3==2){
                                       System.out.print("\nXem Chi Tiết Phiếu Nhập");
                                       ChiTietPhieuNhap.timkiemChiTietPhieuNhap();
                                       continue luachon3;
                                   }
                                     else if(luachon3==3){
                                       System.out.print("\nNhập Hàng");
                                       PhieuNhap.NhapMang();
                                       ChiTietPhieuNhap.NhapMang();
                                       continue luachon3;
                                   }
                                   else continue luachon;
                               }catch (Exception e) {
                                   System.out.print("\nSai lựa chọn..");
                                   continue luachon3;
                                   }
                               }
                           }
                           else if(luachon==4){
                               int luachon4;
                               luachon4:
                               while(true){
                                   System.out.print("\n---------MENU HOÁ ĐƠN-------------");
                               System.out.print("\n1.Xem Danh Sach Hóa Đơn");
                               System.out.print("\n2.Xem Chi Tiết Hóa Đơn");
                               System.out.print("\n3.Tạo Hóa Đơn");                              
                               System.out.print("\n0.Trở Về");
                                   System.out.print("\nNhập Lựa chọn:");
                                   try {
                                       
                                    
                                   luachon4=sc.nextInt();
                                   if(luachon4<0||luachon4>4){
                                       System.out.print("\nLựa Chọn sai....");
                                       continue luachon4;
                                   }
                                   else if(luachon4==1){
                                       System.out.print("\nDanh Sách Hóa Đơn");
                                       HoaDon.XuatDSHoaDon();
                                       continue luachon4;
                                   }
                                    else if(luachon4==2){
                                       System.out.print("\nXem Chi Tiết Hóa Đơn");
                                       ChiTietHoaDon.XuatdsCTHD();
                                       continue luachon4;
                                   }
                                     else if(luachon4==3){
                                       System.out.print("\nTạo Hóa Đơn");
                                       PhieuNhap.NhapMang();
                                       DSHD.ThemNhieuHoaDon(DSCTHD,DSKH,DSSP);
                                        DSHD.ghifile();
                                        
                                       continue luachon4;
                                   }
                                   else continue luachon;
                               }catch (Exception e) {
                                   continue luachon4;
                                   }
                               }
                           }
                           else if(luachon==5){
                              Kho.docfile();
                               continue luachon;
                               
                           }
                           else if(luachon==0) break login;
                       }while(true);
                       
                    } catch (Exception e) {
                        continue luachon;
                    }
                   
                }
                    
                
            }
        
        
    }
    }  
    public static void main(String[] args) throws IOException {
        main a = new main();
        a.run();
    }
}
 