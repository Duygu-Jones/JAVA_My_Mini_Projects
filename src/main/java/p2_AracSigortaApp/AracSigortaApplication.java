package p2_AracSigortaApp;

        /*
        Proje: Araç Sigorta Prim Hesaplama
               Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                            -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
        ​
               Tarife dönemi:Aralık 2023,Haziran 2023
                  1.dönem :Haziran 2023               2.dönem:Aralık 2023
                  otomobil: 2000                       otomobil: 2500
                  kamyon:   3000                       kamyon:   3500
                  otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
                  motosiklet: 1500                     motosiklet: 1750
        ​
                1-Tekrar tekrar kullanılan bir seçim menüsü(form) gösterelim.
                2-Tarife dönemi bilgisi,araç tipi bilgilerini kullanıcıdan alalım.
                3-Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü(form) gösterilsin.
                4-Menüde yeni işlem veya çıkış için seçenek sunulsun .
                5-tarife dönemi ve araç tipine göre sigorta primi hesaplansın.
         */

import java.util.Scanner;

public class AracSigortaApplication {
    public static void main(String[] args) {

        //1.uygulamayı başlatan bir metod
        start();

    }

    public static void start(){

        //2.kullanıcıdan bilgi alma
        Scanner inp=new Scanner(System.in);
        boolean isAgain;

        //3.tekrar tekrar menü gösterilsin
        do {
            System.out.println("--- Zorunlu Araç Sigorta Primi Hesaplama ---");
            System.out.println("Tarife dönemi  seçiniz: ");
            System.out.println("1. Haziran 2023");
            System.out.println("2. Aralık 2023");
            int term=inp.nextInt();
            String termName=term==1 ? "Haziran 2023" : "Aralık 2023";

            int select;
            //tarife dönemi doğru girilirse işleme devam et hatalı ise uyarı mesajı ver yeniden form göster
            if (term==1 || term==2){
                //4.arac objesi oluşturalım
                Arac arac=new Arac();//default
                System.out.println("Araç tipini giriniz :");
                System.out.println("otomobil, kamyon, otobüs, motosiklet");
                arac.type=inp.next();//kamyon
                arac.countPrim(term);//prim set edildi
                //prim=0 ise hatalı giriş yeni işlem seçeneği
                //prim>0 ise hesaplama başarılı , sonucu görüntüle
                if(arac.prim>0){
                    System.out.println("---------------------------------");
                    System.out.println("Araç tipi : "+arac.type);
                    System.out.println("Tarife dönemi : "+termName);
                    System.out.println("Aracınızın ilgili dönem sigorta primi : "+arac.prim);
                    System.out.println("---------------------------------");

                    System.out.println("Yeni işlem için 1, ÇIKIŞ için 0 seçiniz : ");
                    select=inp.nextInt();

                    isAgain=select==1 ? true : false;

                }else{
                    System.out.println("Hesaplama başarısız, tekrar deneyiniz.");
                    System.out.println("Yeni işlem için 1, ÇIKIŞ için 0 seçiniz : ");
                    select=inp.nextInt();

                    isAgain=select==1 ? true : false;
                }

            }else{//hatalı girişte
                System.out.println("Hatalı giriş!");
                isAgain=true;
            }

        }while (isAgain);

        System.out.println("İyi günler dileriz...");

    }

}