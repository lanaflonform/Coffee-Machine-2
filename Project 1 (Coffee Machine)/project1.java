import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeans = scanner.nextInt();
        System.out.print("Write how many cups of coffee you will need: ");
        int coffee = scanner.nextInt();
        int res = water / 200;
        if (res > milk / 50){
            res = milk / 50;
        }
        if (res > coffeeBeans / 15){
            res = coffeeBeans / 15;
        }
        if(res == coffee){
            System.out.println("Yes, I can make that amount of coffee");
        }else if(res < coffee){
            System.out.println("No, I can make only " + res + " cup(s) of coffee");
        }else{
            System.out.println("Yes, I can make that amount of coffee (and even " + (res-coffee) + " more than that)");
        }
    }
}



