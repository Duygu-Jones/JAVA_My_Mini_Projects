package proje01Tr_depo_yonetimi_hocanin;

import java.util.*;

public class Depo_Islemler {


        static Scanner input = new Scanner(System.in);

        public static Map<Integer, Urun_Tanimlama> urunListesiMap = new HashMap<Integer, Urun_Tanimlama>();

        public static int urunID =0;

        public static void girisPaneli(){
            System.out.println("===========================\nDEPO YONETIM PANELI\n" + "===============================\n" +
                    "1-BULUNDURULACAK URUNUNLERI TANIMLAMA\n2-URUNLERI LISTELE\n3-DEPOYA URUN GIRISI YAP\n4-URUNU RAFA YERLESTIR\n" +
                    "5-DEPODAN URUN CIKISI\n6-SISTEMDEN CIK");
            System.out.println("Lutfen yapmak istediginiz islemi seciniz: ");

            String secim = input.next().toUpperCase(Locale.ROOT);
            switch (secim){
                case "1":
                    urunTanimla();
                    girisPaneli();
                    break;
                case "2":
                    urunListele();
                    girisPaneli();
                    break;
                case "3":
                    urunGirisi();
                    girisPaneli();
                    break;
                case "4":
                    urunRafaYerlestir();
                    girisPaneli();
                    break;
                case "5":
                    urunCikisi();
                    girisPaneli();
                    break;
                case "6":
                    cikis();
                    break;
                default:
                    System.out.println("Hatali giris yaptiniz, lutfen tekrar deneyiniz");
                    girisPaneli();
                break;
            }



        }

    public static void urunTanimla(){
        System.out.println("**************Urun Tanimlama Sayfasi*****************");
        System.out.println("Urunun ismini giriniz");
        input.nextLine();
        String urunIsmi = input.nextLine();

        System.out.println("Urunun Markasini giriniz: ");
        String urunMarkasi= input.nextLine();

        System.out.println("Birimi giriniz: ");
        String urunBirimi = input.nextLine();

        System.out.println("Urun miktarini giriniz");
        int urunMiktari =0;

        System.out.println("Urunu rafini giriniz");
        String urunRafi = null ;

        Urun_Tanimlama urunler = new Urun_Tanimlama(urunIsmi, urunMarkasi, urunBirimi, urunMiktari, urunRafi);
        urunListesiMap.put(urunID, urunler);

        urunID++;

    }

    public static void urunListele(){

        Set<Map.Entry<Integer, Urun_Tanimlama> >urunlerEntrySeti = urunListesiMap.entrySet();

        System.out.println("---------------------------- URUN LISTESI ----------------------------------");
        System.out.println("ID       Ismi      Marka          Birim        Miktar      Raf" +
                "\n----------------------------------------------------");

        for (Map.Entry<Integer, Urun_Tanimlama> e : urunlerEntrySeti){
            Integer entryKey = e.getKey();
            System.out.printf("%-4d   %-15s    %-15s    %-6s     %-6d     %-  6s\n", entryKey, urunListesiMap.get(entryKey).getUrunIsmi(),
                    urunListesiMap.get(entryKey).getUrunMarkasi(), urunListesiMap.get(entryKey).getUrunBirimi(),
                    urunListesiMap.get(entryKey).getUrunMiktari(), urunListesiMap.get(entryKey).getUrunRafi());
        }

    }



    public static void urunGirisi(){
        System.out.println("**************************** Urun Giris Sayfasi ***************************");
        System.out.println("Guncellemek istediginiz urun ID giriniz: ");
        int arananID = input.nextInt();
        if(urunListesiMap.keySet().contains(arananID)){
            System.out.println("Miktar giriniz");

            int guncelMiktar= 0;
            boolean flag = true;
            do{
                try {
                    if(flag == true){
                        input.nextLine();
                    }
                    guncelMiktar = input.nextInt();
                    input.nextLine();
                    flag= false;

                }catch (Exception e){
                    System.out.println("Lutfen gecerli miktar girisi yapiniz");
                }
            }while (flag);
        }



    }


    public static void urunRafaYerlestir(){
    //listeden urunu sececegiz ve id numarasina gore urunu rafa koyacagiz.


    }


    public static void urunCikisi(){
    //listeden urunu sececegiz ve urunun cikis yapcagiz. burada urun listesinden sadece miktarda degisiklik yapilacak.
    // urun adedi 0dan az olamaz. 0 olunca urun tanimlamasi silinmesin. sadece miktari 0 olsun.
    //===> yaptigimiz tum degisiklikler listede de gorunsun


    }

    public static void cikis(){


    }








}