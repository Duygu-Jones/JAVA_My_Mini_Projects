package RestaurantCafeBillGenerator;

import java.util.Scanner;

public class RestaurantCafeBillGenerator {

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

        start();

    }

    public static void start(){
        Scanner inp = new Scanner(System.in);
        OrderService orderService = new OrderService();
        DishService dishService;
        int option;

        do{
            option=getOption(inp);
            switch (option){
                case 1: //restaurant daki yemekler DishService i
                    dishService=new DishService();
                    break;
                case 2: //cafe icin
                    dishService=new CafeDishService();
                    break;
                case 0: //tam cikis
                    System.out.println("Sistemden cikis yapildi");
                    dishService=null;
                    break;
                default:
                    System.out.println("Hatali giris");
                    dishService=null;
                    break;
            }
            getSelectionMenu(dishService, orderService);

        }while (option!=0);
    }
    public static int getOption(Scanner scan){
        System.out.println("Merhaba, ");
        System.out.println("1-Restaurant");
        System.out.println("2-Cafeteria");
        System.out.println("0-CIKIS");
        System.out.println("Seciminiz : ");
        return scan.nextInt();
    }



    public static void getSelectionMenu(DishService dishService, OrderService orderService){          // methodu
        Scanner input = new Scanner(System.in);     //scanner objesi

        if(dishService!=null) {

            int select = -1;
            while (select != 0) {
                System.out.println("---------------------------------------------------"); //menu baslangici
                System.out.println(" *** Lezzet Restaurant ve Cafe Siparis Uygulamasi *** ");
                System.out.println("1-Menu");
                System.out.println("2-Siparis Gir");
                System.out.println("3-Siparis Iptal");
                System.out.println("4-Hesap olustur");
                System.out.println("0-CIKIS");      //kullaniciya mesajlar verildi
                System.out.println("Seciminiz : " + select);

                select = input.nextInt();           //yapacagi secimi sisteme aliriz
                System.out.println("---------------------------------------------------"); // menunun sonu

                //2a- secimi kontrol etmek icin; Switch kullanalim

                switch (select) {
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

    }








}/////
