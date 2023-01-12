import java.util.Objects;
import java.util.UUID;

public class HDFCUser implements BankInterface{

    private String name;
    private String accNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public HDFCUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.accNo=String.valueOf(UUID.randomUUID());
        this.rateOfInterest=7.5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        HDFCUser.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance+=amount;
        return "Transaction has been successful. Current balance"+ balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(password,enteredPassword))
        {
            if(amount>balance)
            {
                return "Insufficient funds transaction denied";
            }
            else
            {
                balance-=amount;
                return "please collect your money current balance"+ balance;
            }
        }
        else
        {
            return "Incorrect Password Transaction denied";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*rateOfInterest*years)/100;
    }
}
