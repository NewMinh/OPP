package DungChung;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Check {
    public static boolean ngay(String x){
        String pattern="dd/mm/yyyy";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        simpleDateFormat.setLenient(false);
        try{
            simpleDateFormat.parse(x);
            return true;
        }
        catch(ParseException ex){
            return false;
        }
    }
    public static boolean sdt(String x){        
        try{
            String pattern="\\d{10}";
            if(x.matches(pattern )) return true;
        }
        catch(Exception ex){            
        }
        return false;
    }
   
}
