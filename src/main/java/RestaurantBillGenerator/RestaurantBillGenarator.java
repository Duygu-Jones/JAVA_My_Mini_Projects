package RestaurantBillGenerator;

import java.util.Scanner;

public class RestaurantBillGenarator {
    /*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       Task 1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       Task 2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

      Task 3-Yiyecek menüsü gösterme, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       Task 4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
         Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/

    /*
   ÖDEV: Şirket büyüdü, cafe kısmı açıldı.
   Aynı uygulama cafe kısmında da kullanılsın.
   Cafede farklı menü var.
   Dish dish1=new Dish(401,"Tiramisu",35.0);
   Dish dish2=new Dish(402,"Dondurma",25.0);
   Dish dish3=new Dish(402,"Profiterol",25.0);
   Dish dish4=new Dish(403,"Kahve",17.5);
   Dish dish5=new Dish(404,"Çay",7.5);
   Dish dish6=new Dish(405,"Portakal Suyu",25.5);
   Uygulama başladığında restaurant/cafe seçeneği olsun.

*/

    public static void main(String[] args) {

        //Uygulamanin ihtiyaclari, calisma prensibini burada olusturalim;
        // yukardan baslayip asagi dogru bu runner classta, diger classlardan alinan obje ve methodlar ile calisir, uygulama butunlesir

        //1) methodlarin runnerlari; starter calisir

        getSelectionMenu();


    }


    //1.adim) Task-3- uygulamamizi baslatmak ve kullaniciya bir islem secim menusu sunmak icin bir method tanimlanir
    public static void getSelectionMenu(){          // methodu
        Scanner input = new Scanner(System.in);     //scanner objesi

        //3-yiyecekler icin Class==> Dish Class olusturuldu

        //7-Servis objelerini ===> DishServis ve OrderService Class da olusturuldu
        DishService dishService = new DishService();    // Servis objesi ile DishService class tan constructor cagrilir ve method tekrarli kullanilir buradan

        OrderService orderService = new OrderService();




     //2.adim) Task-3- tekrar tekrar menuyu gosterelim
        int select = -1;  //defoult deger -1 //0 girmiyoruz, 0 cikis icin kullaniacagi icin anlamlidir, burada anlamsiz bir baslangic icin bir deger girilmesi yeterli
        while (select !=0){
            System.out.println("---------------------------------------------------"); //menu baslangici
            System.out.println(" *** Lezzet Restaurant Siparis Uygulamasi *** ");
            System.out.println("1-Menu");
            System.out.println("2-Siparis Gir");
            System.out.println("3-Siparis Iptal");
            System.out.println("4-Hesap olustur");
            System.out.println("0-CIKIS");      //kullaniciya mesajlar verildi
            System.out.println("Seciminiz : " + select);

            select = input.nextInt();           //yapacagi secimi sisteme aliriz
            System.out.println("---------------------------------------------------"); // menunun sonu

            //2a- secimi kontrol etmek icin; Switch kullanalim

            switch (select){
                case 1: //menu listele
                    dishService.showMenu();
                    break;
                case 2: //siparis gir
                    orderService.createOrder(dishService);
                    break;
                case 3: //siparis iptal
                    orderService.deleteOrder();
                    break;
                case 4: //hesap fisi olusturalim
                    orderService.printBill();
                    break;
                case 0:
                    System.out.println("Iyi gunler dileriz....");
                    break;
                default:
                    System.out.println("hatali giris!");
                    break;

            }


            //3.adim) Task-2- yiyecekler icin class olusturalim; class isimi; ==>   Dish class
            // yiyecekler (ortak ozellikleri iceren) icin objeler- kaliplar olusturalim=======>

        }

    }








}/////
