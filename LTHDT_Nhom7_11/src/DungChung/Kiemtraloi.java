package DungChung;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author acer
 */
public class Kiemtraloi implements Serializable{
	public transient Scanner scanner = new Scanner(System.in);
    protected String ma;
    
    public Kiemtraloi() {
        this.ma=null;
    }
    
    public Kiemtraloi(String ma) {
        this.ma = ma;
    }
    
    public boolean isNumber(String s){
       
            if(s.matches("[0-9]{1,}")==true){
            	return true;
            }
        
        return false;
    }
    
    public boolean Kiemtrakhoangcach(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                return false;
            }
        }
        return true;
    }
   

    public String KiemTraNgay() {
        String DauVao;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
        	System.out.print("\nNhập ngày: ");
        DauVao = scanner.nextLine();
        df.setLenient(false);
        try {
            df.parse(DauVao); 
            return DauVao;
        }
        catch (ParseException e) { 
        	System.out.print("Nhập lại với định dạng thời gian dd/MM/yyyy");
        }
        }
    }
    public double KiemTraNhapptkm() {
        double DauVao;
        System.out.print("Nhập phần trăm khuyến mãi: ");
        while (true) {
            try {
                DauVao = Double.parseDouble(scanner.nextLine());
                if (DauVao >= 0 && DauVao <= 100) {
                    return DauVao;
                } else {
                    System.out.print("Phần trăm khuyến mãi không hợp lệ ! Mời nhập lại: ");
                }
            } catch (NumberFormatException exception) {
                System.out.print("Phần trăm không đúng định dạng ! Mời nhập lại: ");
            }
        }
    }
    public double KiemTraNhapdk() {
        double DauVao;
        System.out.print("Nhập số tiền để được sale: ");
        while (true) {
            try {
                DauVao = Double.parseDouble(scanner.nextLine());
                if (DauVao >= 0) {
                    return DauVao;
                } else {
                    System.out.print("Không hợp lệ ! Mời nhập lại: ");
                }
            } catch (NumberFormatException exception) {
                System.out.print("Không đúng định dạng ! Mời nhập lại: ");
            }
        }
    }
}

