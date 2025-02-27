import java.util.Scanner;

public class TestBangunDatar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("panjang: ");
        double panjang = sc.nextDouble();
        System.out.println("lebar: ");
        double lebar = sc.nextDouble();

        PersegiPanjang p1 = new PersegiPanjang(panjang, lebar);
        p1.luasTotal();
    }

}
