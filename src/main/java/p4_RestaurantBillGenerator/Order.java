package p4_RestaurantBillGenerator;

//Bir siparis kalemi icin olusturulan class; burada siparis objeleri olusturacagiz= > sadece siparislerin ozellilerini birarada tutan class
public class Order { //POJO CLASS2
    /*
     Task 4-Devami= Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                          Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                          Her bir yiyecek siparişi için tutar hesaplansın    */

    private static int count =999;  // 1.adim)) objelerden bagimsiz, fakat her obje icin ayri calisacak bir count variable olusturduk.SAYAC. orjinal degeri sabit 999 atadik
                                                 // order ile kullandigimizda her sipariste 1 artacak yani 1000 ile baslayacak
    //count, orderCode olusutracak sayactir, orderCode variable ni ve diger parametreli olusturalim;
    private int orderCode;
    private Dish dish;             //data type Dish olan yeni bir variable; dish adi altinda Dish classdan gelecek objeler yer alacak- bize sadece isim olarak dish degil yemegin ozellilleri de lazim
    private int numberOfDish;
    private double orderPrice;


    //8-yemekler ve yemek adedini kullanarak baslangicta order objemiz olusturalim

    //dish ismi ==> Dish class inda olusturulan objelerin kullanildigi yeni ad, bu objeler burada dish adi ile kullaniliyor
    //yemegin fiyatini hesaplamak icin istenilen parametreler; dish ve numberOfDish ==> hangi yemek ve kac adet
    public Order(Dish dish, int numberOfDish) { //paramli constr.
        count++;                 //2.adim)) ilk siparis 1000 olacak ve sirayla devam edecek
        this.orderCode= count;   //3.adim))
        this.dish = dish;
        this.numberOfDish = numberOfDish;
    }

    //9-) orderPrice i hesaplamak icin bir method olusturalim==>   //yuardaki const. kullan, bunun icin yemegin kendisi "dish" alalim ve yemek adedi "numberOfDish"  ile carpalim
    public void setOrderPrice(){        //method                  //heryerden hesaplama yapilabilir olmasi icin==>  public ve orderPrice variableni set()-> guncelle set et dedik
        this.orderPrice = this.dish.getPrice() * this.numberOfDish; // okunusu:>>>>>> bu classtaki orderPrice variable ni set et = bu classdaki
                                                                  // dish objesinin fiyatini getir ve bu class da olusturulan numberofdish sayisi ile carp
                                                                  //  ve this.orderPrice variablena ata <<<<<<<    dedik
    }


    //hangi variablelar icin getter ve setter ihtiyacimiz var bakalim

//    private int orderCode; // otomatik olarak olustutulacak hicbir sey yapmaya gerek yok===> No setter, yes Getter
//    private Dish dish;     // personel menude yemek ekleme cikarma yapamaz, chef veya admin yetkilidir ===> No setter, yes Getter
//    private int numberOfDish; // personel yemek sayisini siparislerde ekleme cikarma yapacak ihtiyac var ===> YES Setter- sayiyi tekrar set edebilmeli + yes Getter
//    private double orderPrice; // orderPrice icin custom bir method olusturduk tekrar set edilmesine gerek yok ===> No setter, yes Getter


     //sadece numberOfDish icin SETTER methodu olusturalim; memegin adedi sonradan girilebilir guncellenebilir olmali
    public void setNumberOfDish(int numberOfDish) {
        this.numberOfDish = numberOfDish;
    }


    //GETTER methodu ise hepsi icin olsuturulmali ki cagirip degerleri gorelim kullanalim diye; otomatik yap
    public int getOrderCode() {
        return orderCode;
    }

    public Dish getDish() {
        return dish;
    }

    public int getNumberOfDish() {
        return numberOfDish;
    }

    public double getOrderPrice() {
        return orderPrice;
    }







}////
