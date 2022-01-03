package Acount;

import java.io.Serializable;
import java.util.Scanner;

public class Account implements Serializable{
    private String username;
    private String pass;
    private String Manv;
    public Account(){
        this.username=null;
        this.pass=null;
        this.Manv=null;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getManv() {
        return Manv;
    }
    public void setManv(String Manv) {
        this.Manv = Manv;
    }
    
  
    
}

