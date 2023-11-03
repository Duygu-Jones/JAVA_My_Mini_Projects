package p5_Proje01Team_depo_yonetimi.proje_depo_yonetimi_withMyNotes;

import java.util.*;

public class Methods extends ProductList {

    static Scanner scan = new Scanner(System.in); //başta yazıp ve statik yaparsak aşağıda tekrar yazmamıza gerek kalmaz

    public static int urunID = 1000;

    public static Map<Integer, ProductList> productListMap = new HashMap<>(); // Key ınteger value class ismi

    //1-) start methodu ile ana menu;
    public static void start() {

        System.out.println();
        System.out.println("   ----- TEAM 02 DEPO YÖNETİM PANELİNE HOŞ GELDİNİZ -----    ");
        System.out.println("******************".repeat(2));
        System.out.println("******************".repeat(2));
        System.out.println("ÜRÜN LİSTELEME ------------------ 1");
        System.out.println("ÜRÜN TANIMLAMA ------------------ 2");
        System.out.println("ÜRÜN STOK GİRİŞİ ---------------- 3");
        System.out.println("ÜRÜNÜ RAFA YERLEŞTİR ------------ 4");
        System.out.println("ÜRÜN STOK ÇIKIŞI ---------------- 5");
        System.out.println("ÇIKIŞ --------------------------- 6");
        System.out.println("******************".repeat(2));
        System.out.println("******************".repeat(2));

        System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz = ");
        String secim = scan.next();


        //1a-) ana menu kontrol
        switch (secim) {
            case "1":
                listProducts();
                start();
                //ÜRÜN LİSTELEME
                break;
            case "2":
                addProduct(); //classdan işlemleri çağır
                //ÜRÜN TANIMLAMA
                break;
            case "3":
                manageStockAmountAndShelf();

                //DEPOYA ÜRÜN GİRİŞİ
                break;
            case "4":
                manageAndPutShelf();
                //ÜRÜNÜ RAFA KOY VE RAFLARI DÜZENLE
                break;
            case "5":
                removeStockAndId();

                //DEPODAN ÜRÜN ÇIKIŞI
                break;
            case "6":
                System.out.println("İyi Günler");
                System.exit(0);
                break;
            default:
                System.out.println("Lütfen geçerli bir seçim giriniz.");
                start();

        }
    }

    //2-) urun listesi olusturma methodu--> map kullanildi printF ile urunler listelendi
    static void listProducts() {
        Set<Map.Entry<Integer, ProductList>> productEntrySet = productListMap.entrySet();
        System.out.println(); //DUMMY
        System.out.println("                        --- DEPO STOK MODÜLÜ --- ");
        System.out.println("  ID     |    İSİM    |    MARKA    |    BİRİM    |    MİKTAR    |    RAF  ");
        for (Map.Entry<Integer, ProductList> each : productEntrySet) {

            Integer entryKey = each.getKey();
            System.out.printf("%-14d %-12s %-13s %-14s %-12s %-10s\n", entryKey,
                    productListMap.get(entryKey).getProductName(),
                    productListMap.get(entryKey).getBrand(),
                    productListMap.get(entryKey).getUnit(),
                    productListMap.get(entryKey).getStockAmount(),
                    productListMap.get(entryKey).getShelf());

        }
    }

    //2a-) urun listesi tekrar methodu????
    static void listProducts1() {
        Set<Map.Entry<Integer, ProductList>> productEntrySet = productListMap.entrySet();
        System.out.println(); //DUMMY
        System.out.println("  ID     |    İSİM    |    MARKA    |    BİRİM    |    MİKTAR    |    RAF  ");
        for (Map.Entry<Integer, ProductList> each : productEntrySet) {
            Integer entryKey = each.getKey();
            System.out.printf("%-14d %-12s %-13s %-14s %-12s %-10s\n", entryKey,
                    productListMap.get(entryKey).getProductName(),
                    productListMap.get(entryKey).getBrand(),
                    productListMap.get(entryKey).getUnit(),
                    productListMap.get(entryKey).getStockAmount(),
                    productListMap.get(entryKey).getShelf());

        }
    }


    //3-) ürün ekleme methodu;
    public static void addProduct() {

        // ÜRÜN EKLEDİKÇE EKLEME EKRANINA GERİ DÖNSÜN, ÇIKIŞ İÇİN 0'A BASILSIN. AYNI MARKA VE ÜRÜN TİPİ GİRİLDİĞİNDE MESAJ VERSİN ZATEN MEVCUT DİYE. IDSİNİ DE VEREBİLİR.
        System.out.println(" --- ÜRÜN EKLEME MODÜLÜ ---");
        //Urum ismi;
        System.out.println("Lütfen ürün ismini giriniz.");
        scan.nextLine(); //dummy
        String productName = scan.nextLine();
        //urunun markasi
        System.out.println("Lütfen markasını giriniz.");
        String brand = scan.nextLine();
        //urun birimi
        System.out.println("Lütfen birimi giriniz (Çuval, kavanoz, paket, koli, teneke)");
        String unit = scan.nextLine();
        //urun miktari
        int stockAmount = 0; //default olarak miktar 0 girildi, stock girme panelinden ayrica gidip ekleme yapilmali
        //urun rafi
        String shelf = null; //ayni sekilde raf da default null girildi, urun rafa yerlestirme panelinden istenilen rafa yerletirilmeli

        //urun ID kodlari
        ProductList product = new ProductList(productName, brand, stockAmount, unit, shelf);
        productListMap.put(urunID, product);    //ID parametre olarak yok idi; Map'e simdi eklendi
        urunID++;                               //her urun kayıt edilirken ID yi bir artır
        System.out.println("Ürününüz eklendi.");

        //her eklemeden sonra listeyi tekrar gormek icin
        listProducts1();

        //main method class ismi ile methodu link etmis olduk
        start();
    }


    //4-) stok guncelleme methodu olustur; guncellem islemi icin dongu kur
    public static void manageStockAmountAndShelf () {
        System.out.println("--- STOK GÜNCELLEME MODÜLÜ --- " +
                "\nLütfen güncellemek istediğiniz ürünün Id'sini giriniz. Ana menü için 0'a basınız.");

        do {
            try {
                int findId = scan.nextInt();

                if (findId != 0) {
                    if (productListMap.containsKey(findId)) {
                        System.out.println("Miktarı giriniz.");
                        int defaultStock = 0; //toplama etkisiz eleman 0; default 0 gir ve gelen buraya eklensin

                            boolean flag = true; // işaretleme bayrağı, markette döngüye girmek için gerekli olan boolean flag olarak isimlendirilir.
                            do {
                                try {
                                    defaultStock = scan.nextInt();
                                    flag = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Hatalı giriş yaptınız, lütfen geçerli miktar giriniz.");
                                    scan.nextLine(); // dummy
                                }
                            } while (flag); //başa döndür diyoruz

                        // miktarı negatif deger girme checked ---> Done
                        if (defaultStock<0) {
                            System.out.println("Miktar negatif sayı olamaz");
                            manageStockAmountAndShelf(); //tekrar basa gonerir, islemleri tekrarlatir
                        }else {
                            productListMap.get(findId).setStockAmount(defaultStock + productListMap.get(findId).getStockAmount());
                            System.out.println("Ürün miktarı güncellendi");

                            listProducts1();
                            System.out.println();
                        }


                    } else {
                        System.out.println("Aradığınız ürün sistemde bulunmamaktadır.");
                    }
                    manageStockAmountAndShelf(); // tekrar başa dön, ayni methodda islemleri tekrarla
                } else {
                    start(); // 0'a basınca ana menüye dön
                }
            } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
                System.out.println("Hatalı giriş yaptınız, lütfen geçerli bir ürün Id'si giriniz. Çıkış için 0'a basınız.");
                scan.nextLine(); // dummy
            }
        } while (true);
    }


    //5-) urunu rafa yerlestir secenegi icin secme methodu olustur; sadece secme islemi yapilacak---> switch
    public static void manageAndPutShelf () {
        System.out.println(" --- RAF DÜZENLEME MODÜLÜ ---\nLütfen bir seçim yapınız." +
                "\nRafa ürün yerleştir/Rafları düzenle --------- 1" +
                "\nAna Menü ------------------------------------ 0");
        String secim = scan.next();
        switch (secim) {
            case "1":
                putToShelf(); //putToShelf methoduna goturur
                break;
            case "0":
                start(); //basa don, ana menuye goturur
                break;
            default:
                System.out.println("Lütfen geçerli bir seçim giriniz."); //0 veya 1 den hicbirinni girmez ise defaulta atar
                manageAndPutShelf(); // ve ayni methodu tekrarlatir

        }

    }

    //5a-)  urunleri rafa yerlestirme dongusu;
    public static void putToShelf () {
        System.out.println("--- RAFA ÜRÜN EKLEME MODÜLÜ ---" +
                "\n Lütfen ürünün Id'sini giriniz. Menüye dönmek için 0'a basınız.");

        do { // conditon yok calisir
            try {
                int findId = scan.nextInt();

                if (findId != 0) { //conditon1
                    if (productListMap.containsKey(findId)) {
                        System.out.println("********* RAFLAR *********" +
                                "\nGIDA --------- 1" +
                                "\nTEMİZLİK ----- 2" +
                                "\nKOZMETİK ----- 3" +
                                "\nGİYİM -------- 4" +
                                "\nELEKTRONİK --- 5");
                        System.out.println("**************************\nRaf numarasını giriniz.");

                        int shelf=0;                //raf no baslangic default 0;

                        boolean flag = true;

                        do {
                            try {
                                shelf = scan.nextInt(); //secilen sayiyi shelf 'e ata;
                                flag = false;
                                switch (shelf) {    // shelf olark secilen sayi case leri
                                    case 1:         //eger 1 secilir ise
                                        productListMap.get(findId).setShelf("GIDA");
                                        System.out.println("Ürün Rafa yerleştirildi");

                                        listProducts1();//guncel lsiteyi tekrar gsterir
                                        System.out.println();// bosluk
                                        break;               //donguden cik

                                    case 2:
                                        productListMap.get(findId).setShelf("TEMİZLİK");
                                        System.out.println("Ürün Rafa yerleştirildi");

                                        listProducts1();
                                        System.out.println();
                                        break;

                                    case 3:
                                        productListMap.get(findId).setShelf("KOZMETİK");
                                        System.out.println("Ürün Rafa yerleştirildi");

                                        listProducts1();
                                        System.out.println();
                                        break;

                                    case 4:
                                        productListMap.get(findId).setShelf("GİYİM");
                                        System.out.println("Ürün Rafa yerleştirildi");

                                        listProducts1();
                                        System.out.println();
                                        break;

                                    case 5:
                                        productListMap.get(findId).setShelf("ELEKTRONİK");
                                        System.out.println("Ürün Rafa yerleştirildi");

                                        listProducts1();
                                        System.out.println();
                                        break;

                                    default:
                                        System.out.println("Geçerli bir raf numarası giriniz.");

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Hatalı giriş yaptınız, lütfen geçerli seçim giriniz.");
                                scan.nextLine(); // bunu atmazsak sonsuz döngüye giriyor ==> veya scan.close(); da olabilir--donguleri kapatmak icin
                            }

                        }while (flag); //while flag is true==> work-loop it
                        //loop her tamamlamada ayni method da basa don
                        putToShelf();

                      //  // başa döndür diyoruz---guncel lsiteyi gosterelim-----

                      //  System.out.println("Ürün Rafa yerleştirildi");
                      //  System.out.println("                       --- ÜRÜN GÜNCEL DURUM --- ");
                      //  System.out.println("  ID     |    İSİM    |    MARKA    |    BİRİM    |    MİKTAR    |    RAF  ");
                      //  Integer entryKey = findId;
                      //  System.out.printf("%-14d %-12s %-13s %-14s %-12s %-10s\n", entryKey,
                        //        productListMap.get(entryKey).getProductName(),
                        //        productListMap.get(entryKey).getBrand(),
                        //        productListMap.get(entryKey).getUnit(),
                        //        productListMap.get(entryKey).getStockAmount(),
                        //        productListMap.get(entryKey).getShelf());

                    } else {
                        System.out.println("Aradığınız ürün sistemde bulunmamaktadır.");
                        putToShelf();       // ayni methodun tekrar başina döndür
                        scan.nextLine();    // donguyu kapat--> dongu icerisinde break de olabilir,
                    }
                } else {
                   start();                 // 0'a basınca ilk menüye dön
                    scan.nextLine();        // donguyu kapat
                }
            } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
                System.out.println("Hatalı giriş yaptınız, lütfen geçerli bir ürün Id'si giriniz.");
                scan.nextLine();            // dummy-// donguyu kapat
            }
        } while (true); // while flag is true--> work it


    }

    //6-) Stock ve Id silmek icin islem secme;
    public static void removeStockAndId () {

        System.out.println("------- ÜRÜN STOK ÇIKIŞ MODÜLÜ -------");
        System.out.println("Ürün Id'sini sistemden kaldır ----- 1 ");
        System.out.println("Urun stok çıkışı ------------------ 2 ");
        System.out.println("Ana menü -------------------------  0 ");
                            //secme islemi---> switch
        try {
            int select = scan.nextInt();
            switch (select) {

                case 1:             //Ürün Id'sini sistemden kaldırma --- 1 "
                    removeId();
                    break;

                case 2:             //"Stok çıkışı ----------------------- 2 "
                    removeStock();
                    break;

                case 0:             //ana menuye don----0
                    start();
                    break;

                default:
                    System.out.println("Hatalı giriş yaptınız.");
                    removeStockAndId(); //ayni methodun basina---->don
                    break;
            }
        } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
            System.out.println("Hatalı giriş yaptınız. Lütfen geçerli bir seçim yapınız.");
            scan.nextLine();        // dummy-close the loop
            removeStockAndId();     //ayni methodun basina---->don

        }
    }

    //6a-) ID silmek icin islem yapma;
    public static void removeId () {
        System.out.println("Sistemden kaldırılacak ürünün ID numarasını giriniz. Bir üst menüye dönmek için 0'a basınız");

        try {
            int removeId = scan.nextInt(); //girilen ID numarasi--->removeId olarak atandi

            if (removeId != 0) {   //0'la çıkabilmek için
                if (productListMap.containsKey(removeId)) {
                    productListMap.remove(removeId);
                    System.out.println(removeId + " numaralı ID başarıyla silindi.");
                } else {
                    System.out.println(removeId + " numaralı ID sistemde bulunmamaktadır ");

                }
                removeId(); //ayni methodun basina don islemi tekrarla

            }
            removeStockAndId(); //bor onceki methoda goturur
            scan.nextLine();    //loop u kapat

        } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
            System.out.println("Hatalı giriş yaptınız. Lütfen geçerli bir Id giriniz.");
            scan.nextLine(); // dummy - loopu kapatir ve bir alt satira gecirir. Note: break tamamen looptan cikarir alt satira gecmez
            removeId();     // ayni methodun basina git dedik

        }
    }

//6b-) Stock sayisi silmek icin islem yap;
    public static void removeStock () {
        System.out.println("Lütfen çıkışını yapacağınız ürünün ID numarasını giriniz. Bir üst menüye dönmek için 0'a basınız");

        try {
            int findId = scan.nextInt();
            if (findId != 0) {
                if (productListMap.containsKey(findId)) {               //ID'yi git bul
                    System.out.println("Çıkarılacak miktarı giriniz");  //miktari gir
                    int removeAmount = 0;                               // cikacak miktar icinde default gir
                    boolean flag = true;                                //dongu basina ilk condition koy-->do while icin genelde flag kullanilir

                   // do {
                        try {                                              //sadece try-catch yapilmis????
                            removeAmount = scan.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Hatalı giriş yaptınız, lütfen geçerli miktar giriniz.");
                            scan.nextLine(); // dummy
                            removeStock();   //ayni method basina don
                        }
                  // } while (flag);

                    //cikarilmak istenen stock miktari kontrolu; StockAmount - removeAmount= cikartma islemi yap
                    if (removeAmount <= productListMap.get(findId).getStockAmount()) {
                        productListMap.get(findId).setStockAmount(productListMap.get(findId).getStockAmount() - removeAmount);

                        System.out.println("Ürün çıkışı gerçekleştirildi. Kalan Stok: "+ productListMap.get(findId).getStockAmount());
                        removeStock(); //ayni method basina               //guncellenen stock miktarini da goster

                    } else {
                        System.out.println("Mevcut Stock miktarindan fazla giris yapamazsiniz");
                        System.out.println("Stokta bulunan miktar = " + productListMap.get(findId).getStockAmount());
                        removeStock();
                    }
                } else {
                    System.out.println("Aradığınız ürün sistemde bulunmamaktadır.");
                    removeStock();      //ayni method basina
                    scan.nextLine();    //loop kapat ve alt satira gec
                }

            } removeStockAndId(); //6.adim daki remove ana method basina gider
            scan.nextLine();    //loop kapat ve alt satira gec

        } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
            System.out.println("Hatalı giriş yaptınız.");
            scan.nextLine(); //loop kapat ve alt satira gec
            removeStock(); //bu method basina git

        }


    }
}








