package HoaDon;

import DungChung.Kiemtraloi;
import DungChung.docfileghifile;
import Sale.DSsale;
import SanPham.DanhSachSanPham;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class DSChiTietHoaDon implements Serializable,docfileghifile{
    CTHoaDon []DSCTHD;
    private int SLCTHD;
    private transient Kiemtraloi KTra = new Kiemtraloi();
    private transient Scanner sc = new Scanner(System.in);

    public DSChiTietHoaDon() {
        this.DSCTHD = null;
        this.SLCTHD = 0;
    }

    public DSChiTietHoaDon(CTHoaDon[] DSCTHD, int SLCTHD) {
        this.DSCTHD = DSCTHD;
        this.SLCTHD = SLCTHD;
    }
    
    public void docfile(){
        DSCTHD=new CTHoaDon[SLCTHD];
        try {
            FileInputStream fi=new FileInputStream("DSCTHDout.txt");
            ObjectInputStream ois=new ObjectInputStream(fi);
            while (fi.available()>0){
                DSCTHD=Arrays.copyOf(DSCTHD, DSCTHD.length+1);
                CTHoaDon obj=(CTHoaDon) ois.readObject();
                DSCTHD[SLCTHD]=obj;
                SLCTHD++;
            }                
            ois.close();
            fi.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }    
    }
    
    public void ghifile(){
        try {
            FileOutputStream f=new FileOutputStream("DSCTHDout.txt");
            ObjectOutputStream oos=new ObjectOutputStream(f);             
            for (int i=0;i<SLCTHD;i++)
                oos.writeObject(DSCTHD[i]);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public double ThemCTHD(String x,DanhSachSanPham DSSP) {
        int sl;
        CTHoaDon sv;        
        DSsale DSKM=new DSsale();
        DSKM.docfile();
        double sum=0;
        int k = 0;
        String s;
        do {          
                s = "";
                sv=new CTHoaDon();
                sv.setMaHD(x);
                do {
                sv.setMaSP();
                }while(DSSP.laySLSP(sv.getMaSP(),DSSP)==-1);
                sv.setSoLuong();
                //sv.setGia(1000);
                while(sv.getSoLuong() > DSSP.laySLSP(sv.getMaSP(),DSSP)||sv.getSoLuong() <= 0) {
                        System.out.println("Trong kho khong du san pham!!!");
                        System.out.println("Chi con:" + DSSP.laySLSP(sv.getMaSP(),DSSP) + " SP!!!");
                        System.out.println("Nhap lai so luong: ");
                        sv.setSoLuong();
                    }
                sv.setGia(DSSP.layGia(sv.getMaSP(),DSSP));
                sum += sv.getSoLuong() * sv.getGia();
                DSCTHD= Arrays.copyOf(DSCTHD, DSCTHD.length+1);
                DSCTHD[SLCTHD]=sv;
                SLCTHD++;
                System.out.println("Ban co muon nhap them chi tiet hoa don khong??? 1(Yes) / 2(No) ");
                s = sc.nextLine();
                if(s.matches("[1-2]{1}")==false) System.out.println("Vui long nhap dung yeu cau !!!");
                else k = Integer.parseInt(s);
        } while(s.matches("1")==true);
        double sapxep[]=new double[DSKM.DSKM.length];
        for(int i=0;i<DSKM.DSKM.length;i++)
        {
        	sapxep[i]=DSKM.DSKM[i].getDieukien();
        }
        double tg;
        for(int i = 0; i < sapxep.length-1; i++){
            for(int j = i + 1; j < sapxep.length; j++){
                if(sapxep[i] < sapxep[j]){
                    tg = sapxep[i];
                    sapxep[i] = sapxep[j];
                    sapxep[j] = tg;        
                }
            }
        }
        /*for(int i=0;i<sapxep.length;i++)
        {
        	System.out.println(sapxep[i]);
        }*/
        int g=sapxep.length-1;
        double pt=-1;
        while(g!=-1) {
        	if(sum>sapxep[g])
        	{
        		for(int i=0;i<DSKM.DSKM.length;i++)
                {
                	if(sapxep[g]==DSKM.DSKM[i].getDieukien())
                	{
                		pt=DSKM.DSKM[i].getPtmkm();
                		break;
                	}
                }
        	}
        	else System.out.print(""); g--;
        }
        if(pt==-1)
        {
        	System.out.println("Thanh tien: "+sum);
        	return sum;
        }
        else 
        {
        	System.out.println("Thanh tien truoc khi ap dung khuyen mai: "+sum);
        	sum=sum-(sum*pt/100.0);
        	System.out.println("Thanh tien sau khi ap dung khuyen mai: "+sum);
        	return sum;
        }
    }
    
    
    public int Xoa(String x,String y){        
        for (int i=0;i<SLCTHD;i++)
            if (DSCTHD[i].getMaHD().equalsIgnoreCase(x) &&DSCTHD[i].getMaSP().equalsIgnoreCase(y)){
                for (int j=i;j<SLCTHD-1;j++)
                    DSCTHD[j]=DSCTHD[j+1];
                SLCTHD--;   
            }
        int g=SLCTHD;
        if(g>SLCTHD)
        {
        	return 1;
        }
        else return 0;
    }
    
    public void XoaCTHD(String MaHD){
        int i = 0;
        while(i < SLCTHD){
            while(i < SLCTHD && DSCTHD[i].getMaHD().equals(MaHD)){
                for (int j = i;j < SLCTHD-1;j++){
                    DSCTHD[j].Copy(DSCTHD[j+1]);
                }
                SLCTHD--;
            }
            i++;
        }
    }
    
    public void XuatTCCTHoaDon(){
    	System.out.printf("%-12s%-12s%-12s%-20s\n","Ma HD","Ma SP", "Gia","So luong");
        for (int i = 0;i < SLCTHD;i++){
                System.out.printf("%-12s%-12s%-12s%-20s\n",DSCTHD[i].getMaHD(),DSCTHD[i].getMaSP(),DSCTHD[i].getGia(),DSCTHD[i].getSoLuong());
        }
    }
    
    public void TimkiemtheoID(){
    	DSHoaDon HD = new DSHoaDon();
        if(SLCTHD == 0){
            System.out.println("He thong khong co chi tiet hoa don nao het !!!");
            return;
        }
        System.out.println("Danh sach ma hoa don co trong he thong la : " + HD.ListHD());
        
        int kt=0;
        String msv;
        do{
            System.out.print("Nhap Ma HD cua chi tiet hd can tim: ");
            msv=sc.nextLine();
        } while(msv.isEmpty()||msv.matches("HD-"+"[0-9]{3}")==false);
        for (int i=0;i<SLCTHD;i++)
            if (DSCTHD[i].getMaHD().equalsIgnoreCase(msv)){
                kt=1;
                System.out.printf("%-12s%-12s%-12s%-20s\n","Ma HD","Ma SP", "Gia","So luong");
                DSCTHD[i].XuatCThoadon();
                break;
            }
        if (kt==0)
            System.out.println("Khong tim thay Ma KH do");
    }
    public double SuaCTHD(String msv, int kt,Hoadon[] DSHD,double sum){
        DSsale DSKM=new DSsale();
        DSKM.docfile();
        if(kt==1)
        {
        	for (int e=0;e<DSHD.length;e++)
                if (DSHD[e].getMaHD().equalsIgnoreCase(msv)){
                	double sapxep[]=new double[DSKM.DSKM.length];
                    for(int i=0;i<DSKM.DSKM.length;i++)
                    {
                    	sapxep[i]=DSKM.DSKM[i].getDieukien();
                    }
                    double tg;
                    for(int i = 0; i < sapxep.length-1; i++){
                        for(int j = i + 1; j < sapxep.length; j++){
                            if(sapxep[i] < sapxep[j]){
                                tg = sapxep[i];
                                sapxep[i] = sapxep[j];
                                sapxep[j] = tg;        
                            }
                        }
                    }
                    /*for(int i=0;i<sapxep.length;i++)
                    {
                    	System.out.println(sapxep[i]);
                    }*/
                    int g=sapxep.length-1;
                    double pt=-1;
                    while(g!=-1) {
                    	if(sum>sapxep[g])
                    	{
                    		for(int i=0;i<DSKM.DSKM.length;i++)
                            {
                            	if(sapxep[g]==DSKM.DSKM[i].getDieukien())
                            	{
                            		pt=DSKM.DSKM[i].getPtmkm();
                            		break;
                            	}
                            }
                    	}
                    	else System.out.print(""); g--;
                    }
                    if(pt==-1)
                    {
                    	System.out.println("Thanh tien: "+sum);
                    	return sum;
                    	
                    }
                    else 
                    {
                    	System.out.println("Thanh tien truoc khi ap dung khuyen mai: "+sum);
                    	sum=sum-(sum*pt/100.0);
                    	System.out.println("Thanh tien sau khi ap dung khuyen mai: "+sum);
                    	return sum;
                    }
                }
        }
        return -1;
    }
    
    public void Xuat1dsCTHD(String s){
        double sum = 0;
        System.out.printf("%-12s%-12s%-12s%-20s\n","Ma HD","Ma SP","Don Gia","So Luong");
        for (int j=0;j<SLCTHD;j++){
            if (DSCTHD[j].getMaHD().equals(s)){
                DSCTHD[j].XuatCThoadon();
                sum = DSCTHD[j].getSoLuong()*DSCTHD[j].getGia();
                System.out.printf("Gia tong cua cthd: %f", sum);
                System.out.print("\n");
            }            
        }
    }
    
    public void XuatdsCTHD(){ 
       
        DSHoaDon HD = new DSHoaDon();
        HD.docfile();
        String s;
        double tong=0;
        double sum = 0;
        int k=0;
        do{
            DSHoaDon DSHD=new DSHoaDon();
            DSHD.docfile();
            do {
                System.out.println("Danh sach Ma HD co san la: " +HD.ListHD());
                System.out.print("Nhap ma HD can xem chi tiet: ");
                
                s=sc.nextLine();
                if(HD.TimkiemMa(s)==0) System.out.println("Ma HD ban nhap khong dung!!!");
            } while(HD.TimkiemMa(s)==0);
            if (DSHD.TimkiemMa(s)==1){
                System.out.printf("%-12s%-12s%-12s%-20s\n","Ma HD","Ma SP","Don Gia","So Luong");
                for (int j=0;j<DSCTHD.length;j++){
                    if (DSCTHD[j].getMaHD().equals(s)){
                        tong+=DSCTHD[j].getSoLuong()*DSCTHD[j].getGia();
                        sum = DSCTHD[j].getSoLuong()*DSCTHD[j].getGia();
                        DSCTHD[j].XuatCThoadon();
                        System.out.printf("Gia tong cua cthd: %f", sum);
                        System.out.print("\n");
                        sum = 0;
                    }            
                }
                System.out.println("Tong chi phi: "+tong);
            }
            else
                System.out.println("Khong co ma phieu nhap can xem chi tiet. Moi nhap lai");
            k=DSHD.TimkiemMa(s);
        }while (k!=1);
    }
    public static void Ghi() {
        DSChiTietHoaDon ds = new DSChiTietHoaDon();
        ds.DSCTHD=new CTHoaDon[6];
        ds.SLCTHD=6;
        
        ds.DSCTHD[0]=new CTHoaDon("HD-001", "01",2500000, 50);
        ds.DSCTHD[1]=new CTHoaDon("HD-002", "02",5000000, 25);
        ds.DSCTHD[2]=new CTHoaDon("HD-003", "03",1200000, 12);
        ds.DSCTHD[3]=new CTHoaDon("HD-004", "04",2000000, 10);
        ds.DSCTHD[4]=new CTHoaDon("HD-004", "02",2000000, 2);
        ds.DSCTHD[5]=new CTHoaDon("HD-004", "03",2000000, 12);
        
        ds.ghifile();
        //ds.XuatdsCTHD();
    }
    public static void main(String[] args) {
    	DSChiTietHoaDon ds = new DSChiTietHoaDon();
        ds.docfile();
        ds.XuatTCCTHoaDon();
        
    }
}

