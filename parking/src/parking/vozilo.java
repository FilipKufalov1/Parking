package parking;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class vozilo {
    
    private String marka;
    private String RegBroj;
    private String vreme;
    private int mesto;
    
    private static Scanner s=new Scanner(System.in);

    public vozilo() {
    }

    public vozilo(String marka, String RegBroj, String vreme) {
        this.marka = marka;
        this.RegBroj = RegBroj;
        this.vreme = vreme;
    }
    
    public static vozilo vlez(){
        System.out.println("Marka: ");
        String marka=s.nextLine();
        System.out.println("Registracija: ");
        String RegBroj=s.nextLine();
        Date sega=new Date();
        SimpleDateFormat fdt=new SimpleDateFormat("HH:mm");
        String vreme=fdt.format(sega);
        return new vozilo(marka, RegBroj, vreme);
    }

   

    public String getMarka() {
        return marka;
    }

    public String getRegBroj() {
        return RegBroj;
    }

    public String getVreme() {
        return vreme;
    }
    
    
}
