package parking;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
public class Parking {

    public static void main(String[] args) {
        int mesta=5;
        int slmesta=5;
        int izbor;
        vozilo v[]=new vozilo[mesta]; 
        
        boolean [] zafateno=new boolean[5];
        for(int i=0; i<mesta; i++)
            zafateno[i]=false;
        
        Scanner s=new Scanner(System.in);
        
        do{
        System.out.println("=======================================");
        System.out.println("DOBREDOJDOVTE!!! "+"\n"+
                "======================================="+"\n"
                +"Odberete usluga: "+"\n"+
              "1) Za parkiranje "+"\n"+
                "2) Za izlez "+"\n"+
                "3) Za lista na parkirani "+"\n"+
                "4) Za lista na slobodni mesta "+"\n"+
                "0) Izlez");
        System.out.println("=======================================");
         izbor=s.nextInt();
         
         switch(izbor){
             case 1:
                 //parkiraj
                 System.out.println("=======================================");
                 System.out.println("POVELETE");
                 System.out.println("=======================================");
                 if(slmesta>0){
                  System.out.println();   
                 System.out.println("Odberi mesto: ");
                 for(int i=0; i<mesta; i++){
                     if(zafateno[i]==false)
                         System.out.println("Mesto: "+i);
                 }
                 int m=s.nextInt();
                 v[m]=vozilo.vlez();
                 zafateno[m]=true;
                 slmesta--;
                 }
                 else
                     System.out.println("vo momentov nemame slobodni mesta!!!");
                 break;
             
             case 2:
                 //izlezi
                 System.out.println("=======================================");
                 System.out.println("IZLEZ OD PARKINGOT");
                 System.out.println("=======================================");
                 System.out.println("Broj na mesto na parkirano vozilo: ");
                 int mestoi=s.nextInt();
                 Date d1=new Date();
                 SimpleDateFormat fdt=new SimpleDateFormat("HH:mm");
                 System.out.println("Voziloto izleglo vo "+fdt.format(d1)+" chasot!!!");
                 int v1=Integer.parseInt(v[mestoi].getVreme().substring(0, 2));
                 int v2=Integer.parseInt(v[mestoi].getVreme().substring(3, 5));
                 int v3=v1*60+v2;
                 int v4=Integer.parseInt(fdt.format(d1).substring(0, 2));
                 int v5=Integer.parseInt(fdt.format(d1).substring(3, 5));
                 int v6=v4*60+v5;
                 System.out.println("Voziloto bilo vnatre: "+(v6-v3)+" minuti");
                 zafateno[mestoi]=false;
                 v[mestoi]=null;
                 slmesta++;
                 System.out.println("=======================================");
                 System.out.println("DOVIDUVANJE");
                 System.out.println("=======================================");
                 break;
                 
             case 3:
                 //Lista na parkirani
                 System.out.println("=======================================");
                 System.out.println("LISTA NA KORISNICI");
                 System.out.println("=======================================");
                 for(int i=0; i<5; i++)
                     if(zafateno[i]==true){
                     System.out.println("Mesto: "+(i+1)+"\n"
                             +"INFORMACII ZA KORISNIK:"+"\n"+v[i].getMarka()+"\n"+v[i].getRegBroj()+"\n"+v[i].getVreme());
                 }
                 break;
                 
             case 4:
                 //Lista na slobodni mesta
                 System.out.println("=======================================");
                 System.out.println("LISTA NA SLOBODNI MESTA");
                 System.out.println("=======================================");
                 System.out.println("Imame vkupno "+slmesta+" slobodni mesta");
                 for(int i=0; i<5; i++)
                     if(zafateno[i]==false){
                        System.out.println("Mesto: "+i+" SLOBODNO!!!");}
                     else{
                         System.out.println("Mesto: "+i+" ZAFATENO :(");
                     }
                 
                 break;
                 
             case 0:
                 break;
                 
             default:
                 System.out.println("Pogreshen izbor, obidete se povtorno");
                 break;
         }
    }while(izbor!=0);
    
}
}