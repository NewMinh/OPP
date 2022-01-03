/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acount;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Login {
    public static String MaNhanVien;
    public String check(){
        Scanner sc=new Scanner(System.in);
        //=======================================================Doc file Danh Sach Account========================================
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
        String user;
        String pass;
        String manv;
        sc.nextLine();
        hihi:
        do{
            System.out.print("\n*******************DANG NHAP*********************");
            System.out.print("\nUSERNAME:");
            user=sc.nextLine();
            System.out.print("\nPASSWORD:");
            pass=sc.nextLine();
            
            for(int j=0;j<DS_Account.length;j++){
                if(user.equals(DS_Account[j].getUsername()) && pass.equals(DS_Account[j].getPass())){
                    manv=DS_Account[j].getManv();
                    break hihi;
                }   
            }
            System.out.print("\nThong tin tai khoan or mat khau khong chinh xac..");
        }while(true);
        //System.out.print("\nMa nhan vien"+manv);
        MaNhanVien = manv;
        return manv;
       
    }
    public static void main(String[] args) {
       Login a=new Login();
      System.out.print("+"+a.check());
      
    }
    
}
