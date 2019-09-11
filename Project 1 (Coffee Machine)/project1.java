import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many cups of coffee you will need: ");
        int coffeeNumbers = scanner.nextInt();
        System.out.println("For " + coffeeNumbers +  " cups of coffee you will need:");
        System.out.println(coffeeNumbers*200 + " ml of water");
        System.out.println(coffeeNumbers*50 + " ml of milk");
        System.out.println(coffeeNumbers*15 + " g of coffee beans");
    }
}
