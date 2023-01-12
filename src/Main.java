import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Name,Balance,Password");
        String name=sc.next();
        double balance=sc.nextDouble();
        String password=sc.next();
        //SBIUser sbi=new SBIUser(name,balance,password);
        HDFCUser hdfc=new HDFCUser(name,balance,password);

        //addmoney
        System.out.println("enter the amount you want to add");
        int add=sc.nextInt();
        String message= hdfc.addMoney(add);
        System.out.println(message);

        //withdraw money
        System.out.println("enter the amount you want to withdraw");
        int money=sc.nextInt();
        System.out.println("enter the password");
        String pass=sc.next();
        System.out.println(hdfc.withdrawMoney(money,pass));

        //ROI
        System.out.println("enter the no of years to calculate");
        int year=sc.nextInt();
        System.out.println(hdfc.calculateInterest(year));


    }
}