package doan;

import KhachHang.DSKhachHang;
import NhaCungCap.MangNhaCungCap;

import java.util.Scanner;

import DungChung.Kiemtraloi;
import Hang.MangHang;
import HoaDon.DSChiTietHoaDon;
import HoaDon.DSHoaDon;
import Sale.DSsale;
import SanPham.DanhSachSanPham;

public class maintest {
	private Scanner sc = new Scanner(System.in);
	private Kiemtraloi KT = new Kiemtraloi();
	DSKhachHang DSKH;
	DSChiTietHoaDon DSCTHD;
	DSHoaDon DSHD;
	DSsale DSKM;
	MangNhaCungCap MNCC;
	DanhSachSanPham DSSP;
	MangHang MH;
	public maintest()
	{
        this.DSKH = new DSKhachHang();
        this.DSHD = new DSHoaDon();
        this.DSKM = new DSsale();
        this.DSCTHD = new DSChiTietHoaDon();
        this.DSSP=new DanhSachSanPham();
	}
	public void HD(){
        System.out.println("\n     QUAN LY HOA DON");
        System.out.println("");
        System.out.println("1.Them Hoa Don");
        System.out.println("2.Sua Hoa Don");
        System.out.println("3.Xoa Hoa Don");
        System.out.println("4.Tim Kiem Hoa Don");
        System.out.println("5.Xem TTCT cua 1 Hoa Don");
        System.out.println("6.Xem Danh Sach Hoa Don");
        System.out.println("7.Xem tat ca chi tiet HD");
        System.out.println("8.Thoat");
    }
	public void Sale(){
        System.out.println("\n     QUAN LY SALE");
        System.out.println("");
        System.out.println("1.Them Sale");
        System.out.println("2.Sua Sale");
        System.out.println("3.Xoa Sale");
        System.out.println("4.Tim Kiem Sale");
        System.out.println("5.Xem Danh Sach Sale");
        System.out.println("6.Thoat");
    }
	public void KH()
	{
		System.out.println("\n     QUAN LY KHACH HANG");
        System.out.println("");
        System.out.println("1.Them khach hang");
        System.out.println("2.Sua khach hang");
        System.out.println("3.Xoa khach hang");
        System.out.println("4.Tim Kiem khach hang");
        System.out.println("5.Xem Danh Sach khach hang");
        System.out.println("6.Thoat");
	}
	public void QuanLySale() {
        while(true){
        	String tmp="t";
        	Sale();
        	DSKM = new DSsale();
        	DSKM.docfile();
            	while(tmp.matches("[1-6]{1}")==false){
                    System.out.print("NHAP VAO LUA CHON : ");
                    tmp=sc.nextLine();
                }
            switch(Integer.parseInt(tmp)){
                case 1:{
                    DSKM.ThemNhieuKM();
                    DSKM.ghifile();
                    break;
                }
                case 2:{
                	DSKM.SuaSale();
                    DSKM.ghifile();
                    break;
                }
                case 3:{
                	DSKM.XoaKM();
                    DSKM.ghifile();
                    break;
                }
                case 4: {
                    DSKM.timkiemKM();
                    break;
                }
                case 5:{
                    DSKM.XuatDSKM();
                    break;
                }
                case 6:{
                	return;
                }
            }
        }
    }
	 public void QuanLyHD() {
	        while(true){
	        	String tmp="t";
	        	HD();
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
	        	DSSP.docfile();
	            	while(tmp.matches("[1-8]{1}")==false){
	                    System.out.print("NHAP VAO LUA CHON : ");
	                    tmp=sc.nextLine();
	                }
	            switch(Integer.parseInt(tmp)){
	                case 1:{
	                    DSHD.ThemNhieuHoaDon(DSCTHD,DSKH,DSSP);
	                    DSHD.ghifile();
	                    break;
	                }
	                case 2:{
	                    DSHD.SuaHoaDon(DSCTHD);
	                    DSHD.ghifile();
	                    break;
	                }
	                case 3:{
	                    DSHD.XoaHoaDon(DSCTHD);
	                    DSHD.ghifile();
	                    break;
	                }
	                case 4: {
	                    DSHD.timkiemHD();
	                    break;
	                }
	                case 5:{
	                    DSCTHD.XuatdsCTHD();
	                    break;
	                }
	                case 6:{
	                    DSHD.XuatDSHoaDon();
	                    break;
	                }
	                case 7:{
	                	DSCTHD.XuatTCCTHoaDon();
	                	break;
	                }
	                case 8: {
	                	return;
	                }
	               
	            }
	        }
	    }
	 public void QuanLyKH() {
	        while(true){
	        	String tmp="t";
	        	KH();
	        	DSKH = new DSKhachHang();
	        	DSKH.docfile();
	            	while(tmp.matches("[1-6]{1}")==false){
	                    System.out.print("NHAP VAO LUA CHON : ");
	                    tmp=sc.nextLine();
	                }
	            switch(Integer.parseInt(tmp)){
	                case 1:{
	                    DSKH.ThemNhieuKhachHang();
	                    DSKH.ghifile();
	                    break;
	                }
	                case 2:{
	                	DSKH.SuaKH();
	                    DSKH.ghifile();
	                    break;
	                }
	                case 3:{
	                	DSKH.XoaKhachHang();
	                    DSKH.ghifile();
	                    break;
	                }
	                case 4: {
	                    DSKH.timkiemkh();
	                    break;
	                }
	                case 5:{
	                    DSKH.XuatDSKhachHang();
	                    break;
	                }
	                case 6:{
	                	return;
	                }
	            }
	        }
	    }
	 public void chay()
	 {
		 while(true){
	        	String tmp="t";
	        	System.out.println("1.Quan ly HD");
	        	System.out.println("2.Quan ly KH");
	        	System.out.println("3.Quan ly Sale");
	        	System.out.println("4.Thoat");
	            	while(tmp.matches("[1-4]{1}")==false){
	                    System.out.print("NHAP VAO LUA CHON : ");
	                    tmp=sc.nextLine();
	                }
	            switch(Integer.parseInt(tmp)){
	                case 1:{
	                	QuanLyHD();
	                    break;
	                }
	                case 2:{
	                	QuanLyKH();
	                    break;
	                }
	                case 3:{
	                	QuanLySale();
	                    break;
	                }
	                case 4: {
	                    return;
	                }
	                
	            }
	        }
	 }
	public static void main(String[] args) {
        maintest mm = new maintest();
        mm.chay();
    }
}
