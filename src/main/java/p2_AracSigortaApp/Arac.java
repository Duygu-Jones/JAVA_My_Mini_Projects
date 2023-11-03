package p2_AracSigortaApp;
import java.util.Scanner;

    /*
       Tarife dönemi:Aralık 2023,Haziran 2023
          1.dönem :Haziran 2023               2.dönem:Aralık 2023
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750
 */
    public class Arac {

        public String type;//otomobil

        public int prim;//tarife dönemi , tipine hesapla


        //5.prim hesaplama
        public void countPrim(int term) {

            //tipe göre hesapla
            switch (this.type) {

                case "otomobil":
                    this.prim = term == 1 ? 2000 : 2500;
                    break;
                case "kamyon":
                    this.prim = term == 1 ? 3000 : 3500;
                    break;
                case "otobüs":
                    countBusPrim(term);
                    break;
                case "motosiklet":
                    this.prim = term == 1 ? 1500 : 1750;
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    this.prim = 0;
                    break;

            }

        }

        //6. otobüs tipine göre prim hesaplama
        public void countBusPrim(int term) {
            Scanner inp = new Scanner(System.in);
            System.out.println("Otobüs tipini seçiniz: ");
            System.out.println("1. 18-30 Koltuk arası ");
            System.out.println("2. 31 Koltuk ve üzeri ");
            int busType = inp.nextInt();
            switch (busType) {
                case 1:
                    this.prim = term == 1 ? 4000 : 4500;
                    break;
                case 2:
                    this.prim = term == 1 ? 5000 : 5500;
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    this.prim = 0;
                    break;
            }
        }
    }

