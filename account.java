import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class account {
    
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'£'###,##0.00")

    public account() {

    }

    public account(int customerNumber, int pinNumber) {

        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;

    }

    public account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {

        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;

    }

    public int setCustomerNumber(int customerNumber) {

        this.customerNumber = customerNumber
        return customerNumber;
    }

    public int getCustomerNumber() {
        
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {

        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {

        return pinNumber;
    }

    public double getCheckingBalance() {

        return checkingBalance;
    }

    public double getSavingBalance() {

        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {

        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {

        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {

        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {

        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void calcCheckingTransfer(double amount) {

        checkingBalance = (checkingBalance - amount);
        savingBalance = (savingBalance + amount);
    }

    public void calcSavingTransfer(double amount) {

        savingBalance = (savingBalance - amount);
        checkingBalance = (checkingBalance + amount);
    }

  


}
