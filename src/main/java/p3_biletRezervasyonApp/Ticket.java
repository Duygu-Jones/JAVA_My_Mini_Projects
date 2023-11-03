package p3_biletRezervasyonApp;

public class Ticket {
    //4-mesafe(km), seat num, fiyat, yon(tek-cift) bilgileri set edilecek




    public double distance;

    public int typeNo;          //tek-cift yon

    public String seatNo;

    private double price; //girilen bilgilere gore hesaplanacak // bu bilg sadece bu class da islem gorsun, baska bir yerde gorunmesin

    //5-Bilet fiyatini hesaplama
    public void printTicket(){
        System.out.println("*".repeat(42));
        System.out.println("---Bilet Detayi---");
        System.out.println("Otobus plakasi   :");
        System.out.println("Mesafe           :"+this.distance);
        System.out.println("Yolculuk Tipi    :"+ (this.typeNo==1? "Tek yon" : "Gidis-Donus"));
        System.out.println("Koltuk No        :"+ this.seatNo);
        System.out.println("toplam Turar     :"+this.price);
        System.out.println("Keyifli Yolculuklar dileriz...");
        System.out.println("*".repeat(42));


    }

    public void getTotalPrice(int age) {
        double total = 0;
        int seat = Integer.parseInt(seatNo);
        switch ((this.typeNo)) {

            case 1:                  //tek yon
                if (seat % 3 == 0) {
                    total = this.distance * 1.2;
                } else {
                    total = this.distance * 1;
                }
                System.out.println("Toplam Tutar: " + total);
                break;

            case 2:                 //cift yon(gidis-donus)
                if (seat % 3 == 0) {
                    total = this.distance * 2.4;
                } else {
                    total = this.distance * 2;
                }
                System.out.println("Toplam Tutar: " + total);//100

                //cift yon indirimi;
                total = total * 0.8;
                System.out.println("Cift yon indirimli Toplam Tutar: " + total);//80
                break;

        }
        //son tutardan yas indirimi
        if (age < 12) {
            total = total * 0.5;
            System.out.println("12 yas alti indirimli Toplam Tutar: " + total);//80
        } else {
            if (age > 65) {
                total = total * 0.7;//56
                System.out.println("65 yas ustu indirimli Toplam Tutar: " + total);//80
            }
            this.price = total;//56

        }

        //6-Bileti yazdirma


    }//main
} //class
