package p4_RestaurantBillGenerator;

//3.adim: yiyecek objesi olusturma;
//Task 2-Restauranttaki yiyecekler bir listte tutulsun.
       // Yiyeceklerin kodu, ismi ve ücreti olsun.

public class Dish { //POJO CLASS1; Javanin en ilkel classlari denir
                    //field (kalem-alan) leri / cosntructor lari / getter-setter methodlari / toString methodunu icerirler
                    //burada olusturulan objeler diger class (DishService Class) tan kullanilarak bazi islmeler yapilir

                    //yiyecekler objelerini-kaliplarini olusturmak icin olusturulan bu classta;
                    //bir kere listeye eklenecek bu yiyecekler, tekrar degistirilemez, guncellenemez
                    //yiyeceklerin ozellikleri okunsun fakat daha sonra degistirelemesin, ulasilabilir-gosterilebir fakat guncellenemz olacak

    //bunun icin field'larin erisim type'i private olsun ve encapsulation yapilsin;
    //her bir yemegin icerecegi ozellikler; -code, name, price-  olacak==> variable olusturalim;
    private int code;
    private String name;
    private double price;

    //NOTES; uygulamamizda menuye yeni yiyecek ekleme, fiyat guncellemesi gibi islemler admin yetkisinde olacak uyg.dir
            //bu yuzden biz bu uyg da sadece calisanlarin ulasabilecegi bilgileri girecegiz==> sonuc olark degistirilemeyen sadece goruntulenebilen method lar olmali


    //ilk basta yiyecekleri 1 kere bu classtan set etmemiz gerekiyor, diger classlardan edilmeyecek
    // fakat diger class lardan goruntulenebilmesi icin GETTER etmeliyiz hepsini
    // yiyecekleri olusturulurken fieldlar set edilsin;
    //bunun icin 1-) constructor olusturalim (defoult ile set edilemez bu yuzden parametreli olmali)


    //parametreli const.
    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    //non-parametric const.
    public Dish() {
    }


    //GETTER'lar: gorunur olmaya izin verir, degistirmeye degil
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    //toString ile override ederek kullan: class imizdan olusturdugumuz objelerin
    //           field isimlerini ve degerlerini string bir ifadeye donusturmek icin kullanilir
    //toString olusturulmaz ise eger, variable print edildiginde referans no'lari yazdirilir
    @Override
    public String toString() {
        return "Dish{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }



    //field; bir alan, class icerisnde yer alan bir degiskendir; mesela: araba class i icerisnde yer alan, marka, yil, bgGucu gibi alt siniflar da diyebilirz
    // restarount da menu uygulamasi icerisinde yer alan kateegoriler, baslangiclar-ana yemekler- kahvalti-icecekler....vs gibi ayri degiskenler- kalemler








}/////
