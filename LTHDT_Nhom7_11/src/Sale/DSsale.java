package Sale;

import DungChung.Kiemtraloi;
import DungChung.docfileghifile;
import HoaDon.DSChiTietHoaDon;
import KhachHang.Khachhang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class DSsale implements Serializable,docfileghifile{
	private static final long serialVersionUID = 6529685098267757690L;
	public sale []DSKM;
    private int SLKM;
    private transient Kiemtraloi KTra = new Kiemtraloi();
    private transient Scanner sc = new Scanner(System.in);

    public DSsale() {
        this.DSKM = null;
        this.SLKM = 0;
    }

    public DSsale(sale[] DSKM, int SLKM) {
        this.DSKM = DSKM;
        this.SLKM = SLKM;
    }

    public int getSLKM() {
        return SLKM;
    }

    public void setSLKM(int SLKM) {
        this.SLKM = SLKM;
    }
    
    public void docfile(){
        DSKM=new sale[SLKM];
        /*try {
            File myObj = new File("DSKMout.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }*/
        try {
            FileInputStream fi=new FileInputStream("DSKMout.txt");
            ObjectInputStream ois=new ObjectInputStream(fi);
            while (fi.available()>0){
                DSKM=Arrays.copyOf(DSKM, DSKM.length+1);
                sale obj=(sale) ois.readObject();
                DSKM[SLKM]=obj;
                SLKM++;
            }                
            ois.close();
            fi.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void ghifile(){
        try {
            FileOutputStream f=new FileOutputStream("DSKMout.txt");
            ObjectOutputStream oos=new ObjectOutputStream(f);             
            for (int i=0;i<SLKM;i++)
                oos.writeObject(DSKM[i]);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String ListKM(){
        String s = "";
        if(SLKM == 0){
            return null;
        }
        for (int i = 0;i < SLKM;i++){
            s+= DSKM[i].getMaKM();
            if(i != SLKM-1){
                s+=',';
            }
        }
        return s;
    }
    public void XoaKM(){
        System.out.println("\nDanh sach ma sale co trong he thong la : " + ListKM());
        if(SLKM == 0){
            System.out.println("\nHe thong khong co sale nao het !!!");
            return;
        }   
        String msv;
        DSChiTietHoaDon cthd = new DSChiTietHoaDon();
        cthd.docfile();
        do{
            System.out.print("Nhap Ma HD can xoa: ");
            msv=sc.nextLine();
        } while(msv.isEmpty()||msv.matches("KM-"+"[0-9]{3}")==false);
        int kt = 0;
        for (int i=0;i<SLKM;i++)
            if (DSKM[i].getMaKM().equalsIgnoreCase(msv)){
                for (int j=i;j<SLKM-1;j++)
                    DSKM[j]=DSKM[j+1];
                SLKM--;
                kt = 1;
                break;
            }
        if (kt==0)
            System.out.println("Khong tim thay MaKM can xoa");     
    }
    public int TimkiemMa(String s){
        for (int i = 0;i < SLKM;i++){
            if(DSKM[i].getMaKM().equals(s)){
                return 1;
            }
        }
        return 0;
    }
    public void ThemNhieuKM(){
        int sl;
        sale[] sv;
        System.out.print("\nNhập số sale muốn nhập: ");
        sl=sc.nextInt();
        sv=new sale[sl];
        for (int i=0;i<sl;i++){
            System.out.printf("Nhập sale thứ %d : ", (i+1));
            sv[i]=new sale();
            sv[i].setMaKM();
            if(TimkiemMa(sv[i].getMaKM())==1) {
                do {
                    System.out.println("Ma KM da ton tai trong he thong!!!");
                    System.out.println("Vui long nhap lai !!!!!");
                    System.out.println("Danh sach Ma KM co san la: " + ListKM());
                    sv[i].setMaKM();
                } while(TimkiemMa(sv[i].getMaKM())==1);
            }
            sv[i].nhapsale();
            DSKM= Arrays.copyOf(DSKM, DSKM.length+1);
            DSKM[SLKM]=sv[i];
            SLKM++;
        }
    }
    public void XuatDSKM(){
        if(DSKM == null){
            System.out.println("Danh sach rong !!!!");
            return ;
        }
        System.out.format("%15s%20s%20s\n","\nMa KM","Phan tram","Dieu kien");
        for (int i = 0;i < SLKM;i++){
        	System.out.format("\n%5s",DSKM[i].getMaKM());
        	System.out.format("%20s",DSKM[i].getPtmkm());
        	System.out.format("%20s",DSKM[i].getDieukien());
        }
    }
    public void SuaSale(){
        if(SLKM == 0){
            System.out.println("He thong khong co khuyen mai nao het !!!");
            return;
        }
        System.out.println("Danh sach khuyen mai co trong he thong la : " + ListKM());
        
        String msv;
        do{
            System.out.print("Nhap Ma KM can sua: ");
            msv=sc.nextLine();
        } while(msv.isEmpty()||msv.matches("KM-"+"[0-9]{3}")==false);
        int i;
        for (i=0;i<SLKM;i++)
            if (DSKM[i].getMaKM().equalsIgnoreCase(msv)){
                System.out.println("Thong tin KM truoc khi sua: ");
                System.out.format("%15s%20s%20s\n","\nMa KM","Phan tram","Dieu kien");                
                DSKM[i].XuatKM();
                System.out.println("Sua Thong Tin KM");
                DSKM[i]=new sale(DSKM[i].getMaKM(),0,0);
                DSKM[i].nhapsale();
                DSKM[i].XuatKM();
                break;
            }
        if(i >= SLKM){
            System.out.println("Khong tim thay Ma KM de sua !!!");
            return;
        }
    }
    public void timkiemKM() {
        String k;
        String UName;
        do{
            do{
                System.out.println("\nNhap vao Ma KM:");
                UName=sc.nextLine();
            }while(UName.isEmpty());
            System.out.format("%15s%20s%20s\n","\nMa KM","Phan tram","Dieu kien");
            for (int i = 0;i < SLKM;i++){
                if(DSKM[i].getMaKM().toLowerCase().contains(UName.toLowerCase())){
                	System.out.format("\n%5s",DSKM[i].getMaKM());
                	System.out.format("%20s",DSKM[i].getPtmkm());
                	System.out.format("%20s",DSKM[i].getDieukien());
                    }
            }
            
                System.out.print("\nNhap 1 de tim tiep. Nhap phim bat ky de thoat" );
                k=sc.nextLine();
            }while(k.matches("1")==true);
    }
    public static void Ghi() {
        DSsale ds = new DSsale();
        ds.DSKM=new sale[4];
        ds.SLKM=4;
        
        ds.DSKM[0]=new sale("KM-001", 30,1000000);
        ds.DSKM[1]=new sale("KM-002", 20,500000);
        ds.DSKM[2]=new sale("KM-003", 10,100000);
        ds.DSKM[3]=new sale("KM-004", 5,50000);
        
        ds.ghifile();
        //ds.XuatDSKM();
        //ds.ghifile();
        //ds.XuatDSKM();
    }
    public static void main(String[] args) {
        Ghi();
    }
}
