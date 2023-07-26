import java.util.*; 

public class ATMMachine {
    public static void main(String args[]) {
     ATM obj = new ATM();
      obj.checkPin();
    }
}
class ATM {
    Scanner sc = new Scanner(System.in);
    private float balance;
    private String userID = abcd1234;
    private int PIN = 973302;
    int i=0;
    float arr[] = new float[50];
    void checkPin() {
        System.out.println("PLEASE ENTER YOUR PIN :");
        int enteredPin = sc.nextInt();
        if(enteredPin == PIN) {
            menu();
        }else {
            System.out.println("ENTERED PIN IS NOT CORRECT");
                checkPin();
        }
    }
    void menu() {
        System.out.println("PLEASE ENTER YOUR CHOICE");
      System.out.println("1. Transaction History");
      System.out.println("2. Withdraw");
      System.out.println("3. Deposit");
      System.out.println("4. Transfer");
      System.out.println("5. Exit");
      int choice = sc.nextInt();
      if(choice == 1){
        transHis();
      }else if(choice == 2){
        withdraw();
      }else if(choice == 3) {
        deposit();
      }else if(choice == 4){
        transfer();
      }else if(choice == 5) {
        System.out.println("Thankyou for using our ATM.");
        sc.close();
        System.exit(0);
      }else {
        System.out.println("PLEASE ENTER A VALID CHOICE");
      }
    }

    void deposit() {
        System.out.println("PLEASE ENTER THE AMOUNT TOY WANT TO DEPOSIT");
        float amt = sc.nextFloat();
        balance = balance + amt ;
        System.out.println("Money deposited successfully. Your Bank Balance is : " + balance);
        if(i<50){
            arr[i] = amt;
            i++ ;
        }
        menu();
    }

    void withdraw() {
        System.out.println("Enter the amount you want to withdraw");
        float amt = sc.nextFloat();
        if(amt > balance){
            System.out.println("Invalid amount entered. Your Bank Balance is Rs " + balance);
        }else{
            balance = balance - amt;
            System.out.println("Money withdrawl successfully. Your Bank Balance is Rs " + balance);
        }
        if(i<50) {
            arr[i] = -amt ;
            i++ ;
        }
        menu();
    }

    void tranfer() {
        System.out.println("Please enter the userID of the person you want to transfer money");
        String str = sc.nextLine();
        System.out.println("Enter the amount to tranfer");
        int n = sc.nextInt();
        if(n > balance){
            System.out.println("Invalid amount entered. Your Bank Balance is Rs " + balance);
        }else{
            balance = balance - n;
            System.out.println("Rs " + n + " is successfully transferred to userID " + str + ". Your Bank Balance is Rs " + balance);
        }
    }

    void transHis() {
       for(int i=0; i<50 ;i++){
        System.out.println(arr[i]);
      }
       
    }
}