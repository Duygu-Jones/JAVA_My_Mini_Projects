package Proje01Eng_depo_yonetimifinal;


import java.util.*;

public class Methods extends ProductList {

    static Scanner scan = new Scanner(System.in); //başta yazıp ve statik yaparsak aşağıda tekrar yazmamıza gerek kalmaz

    public static int productId = 1000;

    public static Map<Integer, ProductList> productListMap = new HashMap<>(); // Key ınteger value class ismi

    public static void start() throws InterruptedException { //runnerda çalıştırma methodumuz

        System.out.println();
        System.out.println("   ----- TEAM 02 DEPO YÖNETİM PANELİNE HOŞ GELDİNİZ -----    ");
        System.out.println("******************".repeat(2));
        System.out.println("******************".repeat(2));
        System.out.println("ÜRÜN LİSTELEME ------------------ 1");
        System.out.println("ÜRÜN TANIMLAMA ------------------ 2");
        System.out.println("ÜRÜN STOK GİRİŞİ ---------------- 3");
        System.out.println("ÜRÜNÜ RAFA YERLEŞTİR ------------ 4");
        System.out.println("ÜRÜN STOK ÇIKIŞI ---------------- 5");
        System.out.println("ÇIKIŞ --------------------------- 0");
        System.out.println("******************".repeat(2));
        System.out.println("******************".repeat(2));

        System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz = ");
        String secim = scan.next();


        switch (secim) {
            case "1":
                listProducts();
                start(); // listeden sonra menü gelsin diye
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
                //ÜRÜNÜ RAFA KOY/RAFLARI DÜZENLE
                break;
            case "5":
                removeStockAndId();
                //DEPODAN ÜRÜN ÇIKIŞI
                break;
            case "0":
                System.out.println("İyi Günler");
                System.exit(0);
                break;
            default:
                System.out.println("Lütfen geçerli bir seçim giriniz.");
                start();

        }
    }

    static void listProducts() {
        Set<Map.Entry<Integer, ProductList>> productEntrySet = productListMap.entrySet();
        System.out.println(); //DUMMY
        System.out.println("                        --- DEPO STOK MODÜLÜ --- ");
        System.out.println("  ID     |    İSİM    |    MARKA    |    BİRİM    |    MİKTAR    |    RAF  ");
        for (Map.Entry<Integer, ProductList> each : productEntrySet) {
            Integer entryKey = each.getKey();
            System.out.printf("%-14d %-12s %-13s %-14s %-12s %-10s\n", entryKey, productListMap.get(entryKey).getProductName(),
                    productListMap.get(entryKey).getBrand(), productListMap.get(entryKey).getUnit(), productListMap.get(entryKey).getStockAmount(),
                    productListMap.get(entryKey).getShelf());

        }
    }


    public static <Product> void bringProduct(int productId, Map<Integer, Product> productListMap) {
        //ekleme-çıkarma-değişiklik sonrası ürünün güncel halini
        // görebilmek için yazdığımız method
        Product product = productListMap.get(productId);
        System.out.println("  ID     |    İSİM    |    MARKA    |    BİRİM    |    MİKTAR    |    RAF  ");
        Integer entryKey = productId;
        System.out.printf("%-14d %-12s %-13s %-14s %-12s %-10s\n", productId, Methods.productListMap.get(productId).getProductName(),
                Methods.productListMap.get(productId).getBrand(), Methods.productListMap.get(productId).getUnit(), Methods.productListMap.get(productId).getStockAmount(),
                Methods.productListMap.get(productId).getShelf());

    }

    public static void addProduct() throws InterruptedException {
        //ürün ekleme
        System.out.println(" --- ÜRÜN EKLEME MODÜLÜ ---");
        System.out.println("Lütfen ürün ismini giriniz.");
        scan.nextLine(); //dummy
        String productName = scan.nextLine();

        System.out.println("Lütfen markasını giriniz.");
        String brand = scan.nextLine();

        System.out.println("Lütfen birimi giriniz (Çuval, kavanoz, paket, koli, teneke)");
        String unit = scan.nextLine();
        int stockAmount = 0;
        String shelf = null;


        ProductList product = new ProductList(productName, brand, stockAmount, unit, shelf);
        productListMap.put(productId, product); //Map'e eklendi
        System.out.println("Ürününüz eklendi. Son eklenen ürün: ");
        bringProduct(productId, productListMap); // productId üzerinden yazdırma yaptık.
        Thread.sleep(1000); // ufak bir beklemeden sonra ana menü tekrar geri gelir.
        productId++; //her urun kayıt edilirken ID yi bir artır
        start();
    }


    public static void manageStockAmountAndShelf() {
        System.out.println("--- STOK GÜNCELLEME MODÜLÜ --- " +
                "\nLütfen güncellemek istediğiniz ürünün Id'sini giriniz. Ana menü için 0'a basınız.");

        do {
            try {
                int findId = scan.nextInt();

                if (findId != 0) {
                    if (productListMap.containsKey(findId)) {
                        System.out.println("Miktarı giriniz.");
                        int defaultStock = 0;

                        boolean flag = true; // işaretleme bayrağı, markette döngüye girmek-çıkmak için gerekli olan boolean flag olarak isimlendirilir.
                        do {
                            try {
                                defaultStock = scan.nextInt();
                                flag = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Hatalı giriş yaptınız, lütfen geçerli miktar giriniz.");
                                scan.nextLine(); // dummy
                            }
                        } while (flag);    //başa döndür diyoruz
                        if (defaultStock < 0) {
                            System.out.println("Miktar negatif değer olamaz.");
                        } else {
                            productListMap.get(findId).setStockAmount(defaultStock + productListMap.get(findId).getStockAmount());
                            System.out.println("Ürün miktarı güncellendi. Güncel stok: " + productListMap.get(findId).getStockAmount());
                        }

                    } else {
                        System.out.println("Aradığınız ürün sistemde bulunmamaktadır.");
                    }
                    manageStockAmountAndShelf(); // tekrar başa döndür
                } else {
                    start(); // 0'a basınca ana menüye dön
                }
            } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
                System.out.println("Hatalı giriş yaptınız, lütfen geçerli bir ürün Id'si giriniz. Çıkış için 0'a basınız.");
                scan.nextLine(); // dummy
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }


    public static void manageAndPutShelf() throws InterruptedException {
        System.out.println(" --- RAF DÜZENLEME MODÜLÜ ---\nLütfen bir seçim yapınız." +
                "\nRafa ürün yerleştir/Rafları düzenle --------- 1" +
                "\nAna Menü ------------------------------------ 0");
        String secim = scan.next();
        switch (secim) {
            case "1":
                putToShelf();
                break;
            case "0":
                start();
                break;
            default:
                System.out.println("Lütfen geçerli bir seçim giriniz.");
                manageAndPutShelf();

        }

    }


    public static void putToShelf() {
        System.out.println("--- RAFA ÜRÜN EKLEME MODÜLÜ ---" +
                "\n Lütfen ürünün Id'sini giriniz. Menüye dönmek için 0'a basınız.");

        do {
            try {
                int findId = scan.nextInt();


                if (findId != 0) {
                    if (productListMap.containsKey(findId)) {

                        System.out.println("********* RAFLAR *********" +
                                "\nGIDA --------- 1" +
                                "\nTEMİZLİK ----- 2" +
                                "\nKOZMETİK ----- 3" +
                                "\nGİYİM -------- 4" +
                                "\nELEKTRONİK --- 5");
                        System.out.println("**************************\nRaf numarasını giriniz.");

                        int shelf = 0;
                        boolean flag = true;

                        do {
                            try {
                                shelf = scan.nextInt();
                                flag = false;
                                switch (shelf) {
                                    case 1:
                                        productListMap.get(findId).setShelf("GIDA");
                                        System.out.println("Ürün Rafa yerleştirildi");
                                        bringProduct(findId, productListMap); // bu methodla eklediğimiz ürünü çağırıp raftaki görünümüne baktık.
                                        break;
                                    case 2:
                                        productListMap.get(findId).setShelf("TEMİZLİK");
                                        System.out.println("Ürün Rafa yerleştirildi");
                                        bringProduct(findId, productListMap); // bu methodla eklediğimiz ürünü çağırıp raftaki görünümüne baktık.
                                        break;
                                    case 3:
                                        productListMap.get(findId).setShelf("KOZMETİK");
                                        System.out.println("Ürün Rafa yerleştirildi");
                                        bringProduct(findId, productListMap); // bu methodla eklediğimiz ürünü çağırıp raftaki görünümüne baktık.

                                        break;
                                    case 4:
                                        productListMap.get(findId).setShelf("GİYİM");
                                        System.out.println("Ürün Rafa yerleştirildi");
                                        bringProduct(findId, productListMap); // bu methodla eklediğimiz ürünü çağırıp raftaki görünümüne baktık.

                                        break;
                                    case 5:
                                        productListMap.get(findId).setShelf("ELEKTRONİK");
                                        System.out.println("Ürün Rafa yerleştirildi");
                                        bringProduct(findId, productListMap); // bu methodla eklediğimiz ürünü çağırıp raftaki görünümüne baktık.
                                        System.out.println();


                                        break;
                                    default:
                                        System.out.println("Geçerli bir raf numarası giriniz.");

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Hatalı giriş yaptınız, lütfen geçerli seçim giriniz.");
                                scan.nextLine(); // bunu atmazsak sonsuz döngüye giriyor
                            }

                        } while (flag);

                        putToShelf();

                    } else {
                        System.out.println("Aradığınız ürün sistemde bulunmamaktadır.");
                        putToShelf(); // tekrar başa döndür
                        scan.nextLine();
                    }
                } else {
                    start(); // 0'a basınca bir üst menüye dön
                    scan.nextLine();
                }
            } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
                System.out.println("Hatalı giriş yaptınız, lütfen geçerli bir ürün Id'si giriniz.");
                scan.nextLine(); // dummy
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (true);


    }

    public static void removeStockAndId() {

        System.out.println("--- ÜRÜN STOK ÇIKIŞ MODÜLÜ ---");
        System.out.println("Ürün Id'sini sistemden kaldırma --- 1 ");
        System.out.println("Stok çıkışı ----------------------- 2 ");
        System.out.println("Ana menü -------------------------  0 ");

        try {
            int select = scan.nextInt();
            switch (select) {
                case 1:
                    removeId();
                    break;

                case 2:
                    removeStock();
                    break;

                case 0:
                    start();
                    break;

                default:
                    System.out.println("Hatalı giriş yaptınız.");
                    removeStockAndId();
                    break;
            }
        } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
            System.out.println("Hatalı giriş yaptınız. Lütfen geçerli bir seçim yapınız.");
            scan.nextLine(); // dummy
            removeStockAndId();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeId() {
        System.out.println("Sistemden kaldırılacak ürünün ID numarasını giriniz. Bir üst menüye dönmek için 0'a basınız");


        try {
            int removeId = scan.nextInt();
            if (removeId != 0) {   //0'la çıkabilmek için
                if (productListMap.containsKey(removeId)) {
                    productListMap.remove(removeId);
                    System.out.println(removeId + " numaralı ID başarıyla silindi.");
                } else {
                    System.out.println(removeId + " numaralı ID sistemde bulunmamaktadır ");

                }
                removeId();

            }
            removeStockAndId();
            scan.nextLine();

        } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
            System.out.println("Hatalı giriş yaptınız. Lütfen geçerli bir Id giriniz.");
            scan.nextLine(); // dummy
            removeId();

        }
    }


    public static void removeStock() {
        System.out.println("Lütfen çıkışını yapacağınız ürünün ID numarasını giriniz. Bir üst menüye dönmek için 0'a basınız");

        try {
            int findId = scan.nextInt();
            if (findId != 0) {

                if (productListMap.containsKey(findId)) {
                    System.out.println("Mevcut stok: " + productListMap.get(findId).getStockAmount());
                    System.out.println("Çıkarılacak miktarı giriniz.");
                    int removeAmount = scan.nextInt();
                    // do {
                    try {
                        if (removeAmount < 0) {
                            System.out.println("Stok miktari negatif değer içeremez. ");
                            removeStock();
                        }
                    } catch (InputMismatchException e) { //stoktaki exception girişini yakaladık.
                        System.out.println("Hatalı giriş yaptınız, lütfen geçerli miktar giriniz.");
                        scan.nextLine(); // dummy
                        removeStock();
                    }
                    // } while (flag);

                    if (removeAmount <= productListMap.get(findId).getStockAmount()) {
                        productListMap.get(findId).setStockAmount(productListMap.get(findId).getStockAmount() - removeAmount);
                        System.out.println("Ürün çıkışı gerçekleştirildi. Kalan Stok: " + productListMap.get(findId).getStockAmount());
                        removeStock();
                    } else {
                        System.out.println("Stokta girilen miktardan az ürün bulunmaktadır.");
                        removeStock();
                    }
                } else {
                    System.out.println("Aradığınız ürün sistemde bulunmamaktadır.");
                    removeStock();
                    scan.nextLine();
                }

            }
            removeStockAndId();
            scan.nextLine();


        } catch (InputMismatchException ex) { // id'deki exceptionı yakalıyoruz
            System.out.println("Hatalı giriş yaptınız.");
            scan.nextLine(); // dummy
            removeStock();

        }


    }
}








