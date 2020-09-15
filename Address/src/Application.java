import java.io.*;
import java.util.Scanner;

public class Application extends Address {

    public static void main(String[] args) {
        System.out.print("Street: ");
        String street = new Scanner(System.in).nextLine();
        System.out.print("Street number: ");
        Integer streetNumber = new Scanner(System.in).nextInt();
        System.out.print("City: ");
        String city = new Scanner(System.in).nextLine();
        System.out.print("Zip code: ");
        Integer zipCode = new Scanner(System.in).nextInt();

        try {
            Address address = new Address(street, streetNumber, city, zipCode);
            System.out.println(address);

        } catch (ZipCodeLengthNotAccepted e) {

            System.out.println(e.getMessage());

        }


    }
}
