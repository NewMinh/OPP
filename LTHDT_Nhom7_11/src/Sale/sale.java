package Sale;

import java.io.Serializable;
import java.util.Scanner;
import DungChung.Kiemtraloi;

public class sale implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1029581317806945152L;
	private double ptmkm;
	private String MaKM;
	private double dieukien;
	private transient Kiemtraloi KT = new Kiemtraloi();
	private transient Scanner sc = new Scanner(System.in);
	public sale()
	{
		this.ptmkm=0;
		this.MaKM=null;
	}
	public sale(String MaKM,double ptmkm,double dieukien)
	{
		this.ptmkm=ptmkm;
		this.MaKM=MaKM;
		this.dieukien=dieukien;
	}
	public double getPtmkm() {
		return ptmkm;
	}
	public void setPtmkm(double ptmkm) {
		this.ptmkm =ptmkm ;
	}
	public void setPtmkm() {
		this.ptmkm =KT.KiemTraNhapptkm() ;
	}
	public String getMaKM() {
		return MaKM;
	}
	public void setMaKM(String maKM) {
		MaKM = maKM;
	}
	
	public double getDieukien() {
		return dieukien;
	}
	public void setDieukien(double dieukien) {
		this.dieukien = dieukien;
	}
	public void setDieukien() {
		this.dieukien = KT.KiemTraNhapdk();
	}
	public void setMaKM()
	{
		while(true)
        {
        	System.out.println("Nhập mã khuyến mãi KM-SSS: (VD: KM-011)");
        	this.MaKM = sc.nextLine();
        	if(MaKM.matches("KM-"+"[0-9]{3}"))
        	{
        		break;
        	}
        }
	}
	public void nhapsale()
	{
		setPtmkm();
		setDieukien();
	}
	public void Copy(sale a){
        this.MaKM=a.getMaKM();
        this.ptmkm=a.getPtmkm();
        this.dieukien=a.getDieukien();
    }
	@Override
    public String toString() {
        return "{ " + "MaKM=" + MaKM + ", phan tram ma km=" + ptmkm + ",dieu kien sale="+dieukien+" }";
    }
    
    public void XuatKM() {
        System.out.printf("%s%20s%20s\n",MaKM,ptmkm,dieukien);
    }
}
