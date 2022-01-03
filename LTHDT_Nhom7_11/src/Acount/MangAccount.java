/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acount;

import DungChung.Mang;
import NhanVien.NhanVien;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class MangAccount implements Mang{
    private Account[] MangAcount;
    @Override
    public void NhapMang()  {
        Scanner sc=new Scanner(System.in);
        //=========================================================== Doc file Mang Nhan Vien===============================================
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
        //===============================================================Doc file Mang Account======================================================
        Object objAccount;
        Account DS_Account[] =null ;
        DS_Account=new Account[0];
        String fileAccount = "DS_Account.txt";
        try {
            FileInputStream inAccount = new FileInputStream(fileAccount);
            ObjectInputStream outAccount = new ObjectInputStream(inAccount);
            try {
                for (int i=0;(objAccount = outAccount.readObject())!=null;i++) {
                    
                    DS_Account=Arrays.copyOf(DS_Account, i+1);
                    DS_Account[i]=new Account();
                    DS_Account[i] =(Account) objAccount;
                    
                   
                }
            } catch (Exception e) {
            }
            inAccount.close();
            outAccount.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Doc file Danh Sach Account=========================================\n");
      System.out.format("\n%5s%18s%28s\n", "Username", "Password","Ma Nhan Vien");
        for(int i=0;i<DS_Account.length;i++){
            System.out.format("\n%5s | ", DS_Account[i].getUsername());
            System.out.format("%15s | ", DS_Account[i].getPass());
            System.out.format("%25s |", DS_Account[i].getManv());}
      //==================================================================================================================================
      MangAcount=new Account[0];
      while(true){
          int gt=MangAcount.length;
          MangAcount=Arrays.copyOf(MangAcount, MangAcount.length+1);
          for(int i=gt;i<MangAcount.length;i++){
              MangAcount[i]=new Account();
              String user;
              sc.nextLine();
              user:
                nhapma:
                while (true) {
                System.out.print("\nUSERNAME: ");
                user = sc.nextLine();
                for (int j = 0; j < DS_Account.length; j++) {
                 if (user.equals(DS_Account[j].getUsername())) {
                             System.out.println("\nUSERNAME da co....");
                             continue nhapma;
                              }
                             }
                  break nhapma;
               }
              MangAcount[i].setUsername(user);
              String manv;
              manv:
              while(true){
                  hihi:
                       do{
                        System.out.print("\nNhap ma Nhan Vien cua Account:");
                         manv=sc.nextLine();
                           for(int k=0;k<DS_NhanVien.length;k++){
                             if(!manv.equals(DS_NhanVien[k].getMaNhanVien())){
                                    break hihi;
                              }
                            }
                            System.out.print("\nMa Nhan vien ko ton tai...........");
                        }while(true);
                  int dem=0;
                   for(int j=0;j<DS_Account.length;j++){
                       if(manv.equals(DS_Account[j].getManv())){
                           dem++;
                       }
                   }
                   if(dem==0){
                       break manv;
                   }
                   System.out.print("\nMa Nhan Vien Da co tai khoan roi...Vui long nhap Ma Nhan Vien moi....");
                   continue manv;    
              }
              MangAcount[i].setManv(manv);
              System.out.print("\nNhap Password cua Account:");
              MangAcount[i].setPass(sc.nextLine());
              
          }
          break;
      }
      File file = new File("DS_Account.txt");
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
            for(int i=0;i<MangAcount.length;i++){
            oOut.writeObject(MangAcount[i]);}
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
        System.out.format("\n%5s%18s%28s\n", "Username", "Password","Ma Nhan Vien");
        for(int i=0;i<MangAcount.length;i++){
            System.out.format("\n%5s | ", MangAcount[i].getUsername());
            System.out.format("%15s | ", MangAcount[i].getPass());
            System.out.format("%25s |", MangAcount[i].getManv());}
    }
    public void SuaAccount(){
        Object objAccount;
        Account DS_Account[] =null ;
        DS_Account=new Account[0];
        String fileAccount = "DS_Account.txt";
        try {
            FileInputStream inAccount = new FileInputStream(fileAccount);
            ObjectInputStream outAccount = new ObjectInputStream(inAccount);
            try {
                for (int i=0;(objAccount = outAccount.readObject())!=null;i++) {
                    DS_Account=Arrays.copyOf(DS_Account, i+1);
                    DS_Account[i]=new Account();
                    DS_Account[i] =(Account) objAccount;      
                }
            } catch (Exception e) {
            }
            inAccount.close();
            outAccount.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Nhan Vien=========================================\n");
      System.out.format("\n%5s%18s%28s\n", "Username", "Password","Ma Nhan Vien");
        for(int i=0;i<DS_Account.length;i++){
            System.out.format("\n%5s | ", DS_Account[i].getUsername());
            System.out.format("%15s | ", DS_Account[i].getPass());
            System.out.format("%25s |", DS_Account[i].getManv());
                    
    }
        Scanner sc=new Scanner(System.in);
        //-------------------------------------------------------------------------------------
        String a;
        nhapma:
        do{
            System.out.print("\nNhap Ma nhan Vien Can thay doi Account:");
            a=sc.nextLine();
            for(int i=0;i<DS_Account.length;i++){
                if(a.equals(DS_Account[i].getManv())) break nhapma;
            }
        }while(true);
        haha:
        while(true){
            for(int i=0;i<DS_Account.length;i++){
                if(a.equals(DS_Account[i].getManv())) {
                    hihi:
                    while(true){
                         System.out.print("\n---------MENU ACCOUNT-------------");
                         System.out.print("\n1.Sua USERNAME");
                         System.out.print("\n2.Thay doi PASSWORD");
                         System.out.print("\n0.Tro Ve");
                         int luachon;
                         try {
                            System.out.print("\nNhap lua chon:");
                           luachon = Integer.parseInt(sc.nextLine());
                           hehe:
                           do{
                               if(luachon<0||luachon>2){
                                   System.out.print("\nNhap sai...");
                                   continue hihi;
                               }
                               else if(luachon==1){
                               String user;                               
                                sc.nextLine();
                                user:
                                  nhapma:
                                  while (true) {
                                  System.out.print("\nUSERNAME: ");
                                  user = sc.nextLine();
                                  for (int j = 0; j < DS_Account.length; j++) {
                                   if (user.equals(DS_Account[j].getUsername())) {
                                               System.out.println("\nMa san pham da co....");
                                               continue nhapma;
                                                }
                                               }
                                    break nhapma;
                                 }
                                DS_Account[i].setUsername(user);
                                break hehe;
                               }
                               else if(luachon==2){
                                   String pass;
                                   String repass;
                                   nunu:
                                   do{  
                                       System.out.print("\nNhap PASSWORD NEW:");
                                       pass=sc.nextLine();
                                       System.out.print("\nNhap Lai PASSWORD NEW:");
                                       repass=sc.nextLine();
                                       if(pass == null ? repass == null : pass.equals(repass)){
                                           break nunu;
                                       }
                                       System.out.print("\nPASS KO DUNG...");
                                       
                                   }while(true);
                                   DS_Account[i].setPass(pass);
                                    break hehe;
                               }
                               else break haha;
                           }while(true);
                        } catch (Exception e) {
                            continue hihi;
                        }
                               
                    }
                }
            }
        }
               try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_Account.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_Account.length;i++){
        oos.writeObject(DS_Account[i]);
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
    public void ghifileMangAccount() throws IOException{   
       File file = new File("DS_Account.txt");
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
            for(int i=0;i<MangAcount.length;i++){
            oOut.writeObject(MangAcount[i]);}
            oOut.flush();
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
     }
     public  void docfileMangAccount(){
        Object objAccount;
        Account DS_Account[] =null ;
        DS_Account=new Account[0];
        String fileAccount = "DS_Account.txt";
        try {
            FileInputStream inAccount = new FileInputStream(fileAccount);
            ObjectInputStream outAccount = new ObjectInputStream(inAccount);
            try {
                for (int i=0;(objAccount = outAccount.readObject())!=null;i++) {
                    DS_Account=Arrays.copyOf(DS_Account, i+1);
                    DS_Account[i]=new Account();
                    DS_Account[i] =(Account) objAccount;      
                }
            } catch (Exception e) {
            }
            inAccount.close();
            outAccount.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Nhan Vien=========================================\n");
      System.out.format("\n%5s%18s%28s\n", "Username", "Password","Ma Nhan Vien");
        for(int i=0;i<DS_Account.length;i++){
            System.out.format("\n%5s | ", DS_Account[i].getUsername());
            System.out.format("%15s | ", DS_Account[i].getPass());
            System.out.format("%25s |", DS_Account[i].getManv());
                    
    }
}
public void XoaAccount(){
     Object objAccount;
        Account DS_Account[] =null ;
        DS_Account=new Account[0];
        String fileAccount = "DS_Account.txt";
        try {
            FileInputStream inAccount = new FileInputStream(fileAccount);
            ObjectInputStream outAccount = new ObjectInputStream(inAccount);
            try {
                for (int i=0;(objAccount = outAccount.readObject())!=null;i++) {
                    DS_Account=Arrays.copyOf(DS_Account, i+1);
                    DS_Account[i]=new Account();
                    DS_Account[i] =(Account) objAccount;      
                }
            } catch (Exception e) {
            }
            inAccount.close();
            outAccount.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Nhan Vien=========================================\n");
      System.out.format("\n%5s%18s%28s\n", "Username", "Password","Ma Nhan Vien");
        for(int i=0;i<DS_Account.length;i++){
            System.out.format("\n%5s | ", DS_Account[i].getUsername());
            System.out.format("%15s | ", DS_Account[i].getPass());
            System.out.format("%25s |", DS_Account[i].getManv());
                    
    }
     //----------------------------------------------------------------------------------------------------------------
      if(DS_Account.length==0){
            System.out.print("\nKhong Co Nha Cung Cap Nao...");
            return;
        }
      Scanner sc=new Scanner(System.in);
        boolean check=false;
        int m;
        nhapma:
        while(true){
            System.out.print("\nNhap Ma Nhan Vien Cua ACCOUNT can Xoa:");
            String ma=sc.nextLine();
            for(int i=0;i<DS_Account.length;i++){
                if(ma.equals(DS_Account[i].getManv())){
                    m=i;
                    check=true;
                    break nhapma;
                }
            }
            if(!check){
                System.out.println("\n>>Ma Nhan Vien Cua ACCOUNT khong ton tai,...Vui long nhap lai.");
                continue nhapma;
            }
        }
        for(int i=m;i<DS_Account.length-1;i++)
        DS_Account[i]=DS_Account[i+1];
        DS_Account = Arrays.copyOf(DS_Account,DS_Account.length-1);    
        
        //------------------------------------------------------------------------------------------
              try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_Account.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_Account.length;i++){
        oos.writeObject(DS_Account[i]);
    }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
}
public void SuaACNV(String manv){
     Object objAccount;
        Account DS_Account[] =null ;
        DS_Account=new Account[0];
        String fileAccount = "DS_Account.txt";
        try {
            FileInputStream inAccount = new FileInputStream(fileAccount);
            ObjectInputStream outAccount = new ObjectInputStream(inAccount);
            try {
                for (int i=0;(objAccount = outAccount.readObject())!=null;i++) {
                    DS_Account=Arrays.copyOf(DS_Account, i+1);
                    DS_Account[i]=new Account();
                    DS_Account[i] =(Account) objAccount;      
                }
            } catch (Exception e) {
            }
            inAccount.close();
            outAccount.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        System.out.print("\n======================================Danh Sach Nhan Vien=========================================\n");
      System.out.format("\n%5s%18s%28s\n", "Username", "Password","Ma Nhan Vien");
        for(int i=0;i<DS_Account.length;i++){
            System.out.format("\n%5s | ", DS_Account[i].getUsername());
            System.out.format("%15s | ", DS_Account[i].getPass());
            System.out.format("%25s |", DS_Account[i].getManv());
                    
    }
     Scanner sc=new Scanner(System.in);
    haha:
        while(true){
            for(int i=0;i<DS_Account.length;i++){
                if(manv.equals(DS_Account[i].getManv())) {
                    hihi:
                    while(true){
                         System.out.print("\n---------MENU ACCOUNT-------------");
                         System.out.print("\n1.Sua USERNAME");
                         System.out.print("\n2.Thay doi PASSWORD");
                         System.out.print("\n0.Tro Ve");
                         int luachon;
                         try {
                            System.out.print("\nNhap lua chon:");
                           luachon = Integer.parseInt(sc.nextLine());
                           hehe:
                           do{
                               if(luachon<0||luachon>2){
                                   System.out.print("\nNhap sai...");
                                   continue hihi;
                               }
                               else if(luachon==1){
                                String user;                               
                                sc.nextLine();
                                user:
                                  nhapma:
                                  while (true) {
                                  System.out.print("\nMa USERNAME can doi: ");
                                  user = sc.nextLine();
                                  for (int j = 0; j < DS_Account.length; j++) {
                                   if (user.equals(DS_Account[j].getUsername())) {
                                               System.out.println("\nUSERNAME da co....");
                                               continue nhapma;
                                                }
                                    }
                                    break nhapma;
                                 }
                                DS_Account[i].setUsername(user);
                                break hehe;
                               }
                               else if(luachon==2){
                                   String pass;
                                   String repass;
                                   nunu:
                                   do{  
                                       System.out.print("\nNhap PASSWORD NEW:");
                                       pass=sc.nextLine();
                                       System.out.print("\nNhap Lai PASSWORD NEW:");
                                       repass=sc.nextLine();
                                       if(pass == null ? repass == null : pass.equals(repass)){
                                           break nunu;
                                       }
                                       System.out.print("\nPASS KO DUNG...");
                                       
                                   }while(true);
                                   DS_Account[i].setPass(pass);
                                    break hehe;
                               }
                               else break haha;
                           }while(true);
                        } catch (Exception e) {
                            continue hihi;
                        }
                               
                    }
                }
            }
        }
               try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("DS_Account.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for(int i=0;i<DS_Account.length;i++){
        oos.writeObject(DS_Account[i]);
    }
        fos.close();
        oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
    }
}
 public static void main(String[] args) throws IOException {
           MangAccount a=new MangAccount();
        a.NhapMang();
         //  a.XuatMang();
         // a.ghifileMangAccount();
         // a.SuaAccount();
         // a.SuaACNV("1");
          // a.XoaAccount();
           a.docfileMangAccount();
        }
    
}
