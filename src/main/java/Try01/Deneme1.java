package Try01;

import java.util.Scanner;

public class Deneme1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("******************".repeat(2));

        System.out.println("Lütfen ürün ismini giriniz.");

        scan.nextLine(); //dummy

        String productName = scan.nextLine();
        System.out.println("Name: "+productName);

    }
}
