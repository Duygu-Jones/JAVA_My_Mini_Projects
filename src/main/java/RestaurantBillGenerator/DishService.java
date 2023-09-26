package RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;

//4- Dish objeleri ile ilgili islemlerin yapildigi class;
public class DishService {
    // Task 4-Yiyecek menü :Listedeki yiyecekler menü şeklinde listelensin

    //Note: yazmis oldugumuz her bir class bir data type dir
    // fakat her data type bir class degildir---. primitivler de vardir class degillerdir

    //henuz database imiz olmadigi icin;
//5-yiyecekleri burada bir listeye koyalim;

    private List<Dish> dishList = new ArrayList<>(); //eleman ekleyebilmek icin listemizi olusturduk->
                                                     // sadece bu classtan ulasilsin ve duzenlenebilsin

    //5a- yiyecekleri olustur ve listeye ekle (yiyecek objelerini olustur ve listeye ekle)
                                                // (objeler constructor methodu ile olusturulur)
    public DishService(){                                                       // DishService classinin CONSTRUCTOR'i

        fillDishList(); //extracted() methodu==> fillDishList() olarak ismini degistirdik
                        // asagidaki obje ve constr. tamamini sec--> sagTik--> Refactor--> Extracted Method<<- tikla
                        // olusturulan 20 satirlik constructor ve objeleri tek bir method ile gosterir yani burada runner eder
    }

    public void fillDishList() {
        Dish dish1 = new Dish(100, "Adana Kebabi", 250.99);     //ve OBJECTS'i
        Dish dish2 = new Dish(101, "Urfa Kebabi", 200.0);
        Dish dish3 = new Dish(102, "Cokertme Kebabi", 200.0);
        Dish dish4 = new Dish(200, "Baklava", 100.0);
        Dish dish5 = new Dish(201, "Kadayif", 85.0);
        Dish dish6 = new Dish(202, "Kunefe", 75.0);
        Dish dish7 = new Dish(300, "Yayik ayrani", 30.0);
        Dish dish8 = new Dish(301, "Kola", 35.0);
        Dish dish9 = new Dish(302, "Cay", 15.0);
        Dish dish10 = new Dish(303, "Su", 7.0);

        this.dishList.add(dish1);                                                     // dishListesi'ne de bu dish1'i objectini EKLEDIK
        this.dishList.add(dish2);
        this.dishList.add(dish3);
        this.dishList.add(dish4);
        this.dishList.add(dish5);
        this.dishList.add(dish6);
        this.dishList.add(dish7);
        this.dishList.add(dish8);
        this.dishList.add(dish9);
        this.dishList.add(dish10);

        //this. keywordu, onune geldigi ismi isaret eder, ayni class icerisinde ayni isim birden fazla variable tanimlanmis ise
        // this ile belirterek bu ismin cagrilmasini saglariz==> best practice
        //best practice=> eger o classin bir field'ini kastediyorsak THIS keyword kullanilir

    }

    /*
            ***********   calisma prensibi ******************

   1) Paramsiz Constructor diger classlardan CAGRILIR ===> public DishService() {} ----> ilk cagirilan const dir
   2)-->runner olan fillDishList(); calisir    ===>  extracted(); method da denir, tum objeleri tek bir method ile RUNNER eder, ismi degistirilebilir
   3)-->  private void fillDishList(){ listesindeki oblejer okunur
   4)--> this.dishList.add(dish1-dish2....) ile bu objeler ==> private List<Dish> dishList = new ArrayList<>();     ==>NOTE; listesine eklenir
   5)--> Array ile olusturulan >dishList = calisir ve bunlari bir arrayList olarak bize yazdirir siralar

          ----------------------------------------------------
     */


    // dishService objecti olusturuldugu anda
    // dishService parametresiz constructor cagirilacagi icin ve icerisine eklenmis bu kodlar calisacak
    // yani 10 tane obje olusacak ve addList ler sayesinde Listemize bu 10 tane obje eklenmis olacak


    //neden method olustururuz; eger bir code'u tekrar tekrar kullanacak isek method olusturulur
    //yukardaki yazilan 10 farkli variable icin olusturulan code'lar aslinda 1 kez kullanilacak fakat, biz bu classtan CONSTRUCTOR'i kullanacagi tekrarli olarak
    // constuctor'i cagirdigimiz zaman bu code'larin gelmesini isteyecegiz
    //clean code yazim prensibine gore; bu kadar code'u const. icine yazmak yerine bir method olsuturulur ve o methodun icine yazilmasi daha okunabilirdir
    //ve bu method da (runner olarak constra baglanir)  const. ile birlikte tekrar tekrar kullanilir



 //6-Yemek menusunu gosterme; ==> PrintF
    public void showMenu(){
        System.out.println("         ***  Lezzetlerimiz  ***          "); //menu basligimiz
        System.out.printf("%-3s    %-20s    %-6s    \n ","Code","Name","Price");            //menu stunlar basliklari; 3-20-6 birakilan bosluk karakter sayilaridir
        System.out.printf("%-3s    %-20s    %-6s    \n ","***", "****","************");     //stunlar altinda yazilan degerlerin uzunluklarina gore stun genisligi olusuturur
        //               (" %       %       %      X\n",...) ====> \n den once her bir satir veya stunda sabit olarak gorunmesini istedigimiz X ifadesi- TL gibi ifadeleri yazariz

        for (Dish dish: dishList ) {       //DishListe mizdeki her bir dish objesini gez dedik
            System.out.printf("%-3s    %-20s    %-6s   TL\n ",dish.getCode(),dish.getName(),dish.getPrice());    //get() methodu ile olusturlan objelerin hepsini
                                                                                                                    // tek tek gezip bu stunlara yazdirmasi icin forEach loop kullandik
        }
    }


    //12- Kodu verilen yemegi listeden bulalim
    public Dish findDishByCode(int code){

        if(code ==0){
            System.out.println("Ana menuye yonlediriliyorsunuz. ");
        }else {
            for (Dish dish: dishList ) {
                if(dish.getCode()== code){
                    return dish;
                }
            }
            System.out.println("Urun Bulunamadi");
        }
        return null;
    }






    /*NOTE;    -----PRINTF;--------

    System.out.printf(""); seklinde gosterilir
    sout icerisine constructorda yazilan variable lar yazilir ve bunlar % isareti kullanilarak alt alta sirali yazilmasi sagianir==> sutun olusturu aslinda
    %10 karakterlik bir bosluk birakir
    %10s==> s string data type demektir
    %10d==> int icin kullanilir digital d'si
    boolean icin==> b
    char icin ===> c
    double ve folat icin ===> f kullanilir
    %-3s ==> sola yaslamak icin - eksi isareti sayidan once kullanilir



     */




}////
