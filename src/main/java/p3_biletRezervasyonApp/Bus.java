package p3_biletRezervasyonApp;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    //2-
    public String numberPlate;

    public List <String> seats = new ArrayList<>();


    //3-Otobusu olustururken plaka ve koltuk nolar set edilsin
    public Bus(String plaka){
        this.numberPlate = plaka;
        for (int i = 1; i<33; i++){  //otobusun koltuk numaralarini string type da olusturmak icin
            //this.seats.add(String.valueOf(i));
            this.seats.add(i+" ");                      //her iki method da int degeri stronge cevirir
        }

    }

}
