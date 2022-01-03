package DungChung;
import java.io.Serializable;
import java.util.Scanner;
public class ConNguoi implements Serializable{
    private String hoten;
    private String ngaysinh;
    private String gioitinh;
    private String dienthoai;
    static Scanner sc=new Scanner(System.in);
public ConNguoi(){
    this.hoten=null;
    this.gioitinh=null;
    this.ngaysinh=null;
    this.dienthoai=null;
}
public ConNguoi(String hoten,String ngaysinh,String gioitinh,String dienthoai,String diachi){
    this.hoten=hoten;
    this.gioitinh=gioitinh;
    this.ngaysinh=ngaysinh;
    this.dienthoai=dienthoai;

}
public void nhap(){
    
    System.out.println("Nhap hoten:");
    hoten=sc.nextLine();
    System.out.println("Nhap gioi tinh:");
    gioitinh=sc.nextLine();
    System.out.println("Nhap ngay sinh:");
    ngaysinh=sc.nextLine();
    System.out.println("Nhap sdt:\t");
    dienthoai=sc.nextLine();
  
}
public void xuat(){
    System.out.print(""+hoten+"\t"+gioitinh+"\t"+ngaysinh+"\t"+dienthoai);
}

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }


}


