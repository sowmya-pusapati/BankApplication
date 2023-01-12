import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{

    private String Name;
   private String AccNo;
    private double balance;
    private String password;
   private static double ROI;

    public SBIUser(String name, double balance, String password) {
        Name = name;
        this.balance = balance;
        this.password = password;

        this.ROI=6.5;
        this.AccNo= String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAccNo() {
        return AccNo;
    }

    public void setAccNo(String accNo) {
        AccNo = accNo;
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

    public static double getROI() {
        return ROI;
    }

    public static void setROI(double ROI) {
        SBIUser.ROI = ROI;
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }

    @Override
    public String addMoney(int amount) {
        balance+=amount;
        return "Added successfully current balance"+ balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredpassword) {
        if(Objects.equals(password,enteredpassword))
        {
            if(amount>balance)
            {
                return "Insufficient funds";
            }
            else {
                balance-=amount;
                return "current balance"+balance;
            }
        }
        else {
            return "Incorrect password!";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance+years+ROI)/100;
    }
}
