package p4_RestaurantCafeBillGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//10-) orderla ilgili islemlerin olusturuldugu class
public class OrderService {
    Scanner input= new Scanner(System.in); //siparisleri kullanicidan alacagiz, burada bir kez olusturduk ki asagida her bir method icin ayri ayri olusturmayalim diye



    //girilen orderlari hepsini bir arada bir listede tutmak gerekir--> liste olusturalim (Order class'indan bir orderList olustur)
    public List<Order> orderList = new ArrayList<>(); // bu class, bu orderList,(garson) diyelim; sadece bir masanin siparisleri icin hazirlaniyor:)



 //11.adim)  siparis girmek icin method olusturma;   //sadece siparis olusturacak herhangi bir deger dondurmeyecek =>void
         //1.adim; ihtiyaclar;
         // siparisi girmek icin urun kodu -> dishCode
        // tekrarli urun adetleri girmek icin looop==> bir kosul olmadan donguye girmesi icin do-while kullanalim
    public void createOrder(DishService dishService){ //run class da  olsturulan objeyi parametre olarak girdik-direk calsitirir= kisa yol obje olusturmak yerine ayni objei kullan
        int dishCode;           //siparis girilebilmesi icin bir dishCode adinda int bir variable atadik

        do {
            System.out.println("Lutfen urun kodunu giriniz (CIKIS icin 0) : ");
            dishCode = input.nextInt();                             // bu kod ile dish objesine gider, buradaki yemeklerden secim yapar
            Dish dish = dishService.findDishByCode(dishCode); //static bir method olmadigi icin class ismi.method seklinde cagirlamaz, const icine parametresi girildi
            if(dish != null){
                System.out.println("Adet giriniz: ");
                int number = input.nextInt();      //3 adet girin
                //bu yemek daha once siparis edilmis mi--> kontrol edelim ----> 13.adim
                Order order = findOrderByDish(dish); //null veya mevcut siparis dondurecek==> order variable ilk defa olsuturuldu burada ve dish in tum ozellikleri atandi
                if(order!=null) {
                    //bu yemek daha once 2 adet siparis edilmis demektir; siparis adedini guncelle ozamn
                    order.setNumberOfDish(order.getNumberOfDish()+number); // 5 oldu
                    order.setOrderPrice();
                }else {
                    //yeni siparis olusutur, daha once siparis edilmemis
                    order=new Order(dish, number); //order variable icin const olustur, parametre olark dish ve number gir; order'a atamis olduk
                    order.setOrderPrice(); //order variable dish ve number sayesinde getOrderPrice ozleligini almis oldu
                    this.orderList.add(order); //orderList de bu order'i eklemis olduk
                }

            }
           //siparis olusunca altta siparis listesi gotuntulensin ---->14.adimi yap ve gel buraya lsiteyi ekle
            listOrders();

        }while (dishCode !=0); //deger 0 olmadigi surece devam etsin>> 0 cikis icin kod olarak kullanilmsti; 0 girilirse donguden cikar


    }


    //13.adim- yemek bilgisi ile order bulma
    public Order findOrderByDish (Dish dish){
        for(Order order:this.orderList){
            if(order.getDish().equals(dish)){
                return order;
            }
        } //esleslme olmazsa;
        return null;
    }

    //14-siparisleri yazdiralim
    public void listOrders(){
        this.orderList.forEach(order->  //for-each dongu seklinde yazmak yerine lambda expr olarka gosterdik bu sefer
                System.out.printf("Sipariş kodu:%-5s  Lezzet kodu:%-4s Lezzet Adı:%-20s Adet:%-2s  Tutar:%-5s\n",
                        order.getOrderCode(),order.getDish().getCode(),order.getDish().getName(),
                        order.getNumberOfDish(), order.getOrderPrice()));
    }




    //15.adim hesabi olusturma: herbir siparisin turarini toplayali
    public void printBill(){
        double total=0;
        System.out.println("    Lezzet Restaurant Lezzet Fişi     ");
        listOrders(); //14.adimdaki list
        for (Order order:this.orderList){
            //total = total+order.getOrderPrice()
            total+=order.getOrderPrice();
        }
        System.out.println("Toplam tutar : "+total);
        System.out.println("Afiyet olsun...Yine bekleriz:)");
        //adisyon kapatıldı, listeyi boşaltalım, yeni masaya geçilebilir.
        this.orderList.clear();
    }

    //16.adim) siparisin beli bir miktari yada tamamini iptal etme
    public void deleteOrder(){
        System.out.println("Lutfen iptal etmek istediginiz siparisin siparis kodunu giriniz: ");
        int code = input.nextInt(); //1003 nolu siparis codu verildi diyelim

        boolean isFound=true;
        for (Order order: this.orderList){
            if (order.getOrderCode()==code){ //adana kebabi 9 adet girilmis--> (bir ksimini veya tamamini iptal edebilir
                System.out.println("Iptal etmek istediginiz miktari giriniz: ");
               int number = input.nextInt(); //3 adetini iptal edelim

                if(number>0 && number<order.getNumberOfDish()){
                    order.setNumberOfDish(order.getNumberOfDish()-number); //9-3= 6 adet kalan
                    order.setOrderPrice();
                    System.out.println("Siparisinizin "+ number+ " adedi iptal edildi : "+ order.getDish().getName());
                } else if (number==order.getNumberOfDish()) {
                    this.orderList.remove(order);
                    System.out.println("Siparisiniz iptal edildi : "+ order.getDish().getName());
                }else {
                    System.out.println("Hatali giris!");
                }
                isFound=true;
                break;


            }else {
                isFound=false;
            }

        }if(!isFound){
            System.out.println("Iptal islmi basarisiz, siparis kodu gecersiz");
        }
        System.out.println("    Mevcut Siparişler   ");
        listOrders();
    }






















}///////
