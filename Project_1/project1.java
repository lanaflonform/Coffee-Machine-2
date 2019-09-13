import java.util.Scanner;

public class CoffeeMachine {

    // Class variables
    private int water, milk, coffeeBeans, cups, money;
    private Scanner scanner;
    private int checkWater = 0;
    private int checkMilk = 0;
    private int checkCoffeeBeans = 0;
    private int checkCups = 0;
    private boolean flag = true;
    private String wanted;
    private  int[] productList = {water, milk, coffeeBeans, cups, money};
    private String[] str = {"water", "milk", "coffee beans", "disposable cups"};

    // Default Constructor
    private CoffeeMachine() {
        this.scanner = new Scanner(System.in);
        this.productList[0] = 400;
        this.productList[1] = 540;
        this.productList[2] = 120;
        this.productList[3] = 9;
        this.productList[4] = 550;
    }

    // Choose coffee Type
    private  void buyCoffee(){
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        this.wanted = scanner.next();
    }

    //
    private void buyProcess(){
        this.buyCoffee();
        switch (this.wanted) {
            case "1":
                if (this.productList[0] < 250) {
                    this.checkWater = 1;
                    break;
                } else if (this.productList[2] < 16) {
                    this.checkCoffeeBeans = 1;
                    break;
                } else if (this.productList[3] <= 0) {
                    this.checkCups = 1;
                    break;
                } else {
                    this.productList[0] -= 250;
                    this.productList[2] -= 16;
                    this.productList[3] -= 1;
                    this.productList[4] += 4;
                }
                break;
            case "2":
                if (this.productList[0] < 350) {
                    this.checkWater = 1;
                    break;
                } else if (this.productList[1] < 75) {
                    this.checkMilk = 1;
                    break;
                } else if (this.productList[2] < 20) {
                    this.checkCoffeeBeans = 1;
                    break;
                } else if (this.productList[3] <= 0) {
                    this.checkCups = 1;
                    break;
                } else {
                    this.productList[0] -= 350;
                    this.productList[1] -= 75;
                    this.productList[2] -= 20;
                    this.productList[4] += 7;
                    this.productList[3] -= 1;
                }
                break;
            case "3":
                if (this.productList[0] < 200) {
                    this.checkWater = 1;
                    break;
                } else if (this.productList[1] < 100) {
                    this.checkMilk = 1;
                    break;
                } else if (this.productList[2] < 12) {
                    this.checkCoffeeBeans = 1;
                    break;
                } else if (this.productList[3] <= 0) {
                    this.checkCups = 1;
                    break;
                } else {
                    this.productList[0] -= 200;
                    this.productList[1] -= 100;
                    this.productList[2] -= 12;
                    this.productList[3] -= 1;
                    this.productList[4] += 6;
                }
                break;
        }
        checkProducts();
    }

    private void resetCheckers(){
        this.checkWater = 0;
        this.checkMilk = 0;
        this.checkCoffeeBeans = 0;
        this.checkCups = 0;
    }

    private void checkProducts(){
        if(this.checkCoffeeBeans == 0 && this.checkCups == 0 && this.checkMilk == 0 && this.checkWater == 0){
            System.out.println("I have enough resources, making you a coffee!");
        }else{
            if(this.checkWater == 1){
                System.out.println("Sorry, not enough water!");
            }else if(this.checkMilk == 1){
                System.out.println("Sorry, not enough milk!");
            }else if(this.checkCoffeeBeans == 1){
                System.out.println("Sorry, not enough coffee beans!");
            }else{
                System.out.println("Sorry, not enough disposable cups!");
            }
        }

        resetCheckers();
    }

    private void fill(){

        int x;
        for(int i = 0; i<4; i++){
            System.out.print("Write how many ml of " + str[i] + " do you want to add: ");
            x = scanner.nextInt();
            this.productList[i] += x;
        }
    }

    // Give All money
    private void take(){
        System.out.println("I gave you $" + this.productList[4]);
        this.productList[4] = 0;
    }

    private void remaining(){
        System.out.println("The coffee machine has:");
        for(int i = 0; i<4; i++){
            System.out.println(this.productList[i] + " of " + this.str[i]);
        }
        if(this.productList[4] > 0) {
            System.out.println("$" + this.productList[4] + " of money");
        }else{
            System.out.println(this.productList[4] + " of money");
        }
    }

    private void exit(){
        this.flag = false;
    }


    private void process(){
        while(this.flag) {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            System.out.println();
            switch (action) {
                case "buy":
                    this.buyProcess();
                    break;
                case "fill":
                    this.fill();
                    break;
                case "take":
                    this.take();
                    break;
                case "remaining":
                    this.remaining();
                    break;
                case "exit":
                    this.exit();
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }


    // Main Method
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.process();
    }
}





