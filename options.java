import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class options {
    
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'£'###,##0.00");
    HashMap<Integer, Account> data = new HashMap<Integer, Account>();

    public void getLogin() throws IOException{

        boolean end = false;
        int customerNumber = 0;
        int pinNumber = 0;
        while(!end) {

            try {

                System.out.println("\nEnter your customer number");
                customerNumber = menuInputinput.nextInt();
                System.out.println("\nEnter your pin number");
                pinNumber = menuInput.nextInt();
                Iterator it = data.entrySet().iterator();
                while(it.hasNext()) {

                    Map.Entry pair = (Map.Entry) it.next();
                    Account acc = (Account) pair.getValue();
                    if(data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {

                        getAccountType(acc);
                        end = true;
                        break;
                    }
                }
                if(!end) {

                    System.out.println("\nWrong customer number or pin number");
                }
            } catch(InputMismatchException e) {

                System.out.println("\nInvalid entry. Must only contain number");
            }
        }
    }

    public void getAccountType(Account acc) {

        boolean end = false;
        while(!end) {

            try {

                System.out.println("\nSelect the account you want to access: ");
                System.out.println("Option 1: Checking Account");
                System.out.println("Option 2: Savings Account");
                System.out.println("Option 3: Exit");
                System.out.println("\n Please enter your choice");

                int selection = menuInput.nextInt();
                switch(selection) {

                    case 1:

                            getChecking(acc);
                            break;

                    case 2:

                            getSaving(acc);
                            break;

                    case 3:

                            end = true;
                            break;

                    default:

                            System.out.println("\nInvalid choice");
                }
            } catch(InputMismatchException e) {

                    System.out.println("\nInvalid choice");
                    menuInput.next();
            }
        }
    }

    public void getChecking(Account acc) {

        boolean end = false;
        while(!end) {

            try {

                System.out.println("\nChecking Account");
                System.out.println("Option 1 - View Balance");
                System.out.println("Option 2 - Withdraw Funds");
                System.out.println("Option 3 - Deposit Funds");
                System.out.println("Option 4 - Transfer Funds");
                System.out.println("Option 5 - Exit");
                System.out.println("\nPlease enter your choice");

                int selection = menuInput.nextInt();
                switch(selection) {

                    case 1: 
                            System.out.println("\nCheckings Account Balance: " + moneyFormat.format(acc.getCheckingBalance()));
                            break;
                    case 2:
                            acc.getCheckingWithdrawInput();
                            break;
                    case 3:
                            acc.getCheckingDepositInput();
                            break;
                    case 4:
                            acc.getTransferInput("Checkings");
                            break;
                    case 5: 
                            end = true;
                            break;
                    default:
                            System.out.println("\nInvalid Choice");
            
                }
            } catch(InputMismatchException e) {
                
                System.out.println("\nInvalid Choice");
                menuInput.next();
            }
        }
    }

    public void getSaving(Account acc) {

        boolean end = false;
        while(!end) {

            try {

                System.out.println("\nChecking Account");
                System.out.println("Option 1 - View Balance");
                System.out.println("Option 2 - Withdraw Funds");
                System.out.println("Option 3 - Deposit Funds");
                System.out.println("Option 4 - Transfer Funds");
                System.out.println("Option 5 - Exit");
                System.out.println("\nPlease enter your choice");

                int selection = menuInput.nextInt();
                switch(selection) {

                    case 1: 
                            System.out.println("\Savings Account Balance: " + moneyFormat.format(acc.getSavingBalance()));
                            break;
                    case 2:
                            acc.getSavingWithdrawInput();
                            break;
                    case 3:
                            acc.getSaveingDepositInput();
                            break;
                    case 4:
                            acc.getTransferInput("Savings");
                            break;
                    case 5: 
                            end = true;
                            break;
                    default:
                            System.out.println("\nInvalid Choice");
            
                }
            } catch(InputMismatchException e) {
                
                System.out.println("\nInvalid Choice");
                menuInput.next();
            }
        }
    }

    public void createAccount() throws IOException {

        int cust_num = 0;
        boolean end = false;
        while(!end) {

            try {

                System.out.println("\nEnter your customer number");
                cust_num = menuInput.nextInt();
                Iterator it = data.entrySet().iterator();
                while(it.hasNext()) {

                    Map.Entry pair = (Map.Entry) it.next();
                    if(!data.containsKey(cust_num)) {

                        end = true;

                    }
                }

                if(!end) {

                    System.out.println("\nThis customer number is already registered");
                }
            } catch(InputMismatchException e) {

                System.out.println("\nInvalid Choice");
                menuInput.next();
            }
        }
        System.out.println("Enter PIN to be registered");
        int pin = menuInput.nextInt();
        data.put(cust_num, new Account(cust_num, pin));
        System.out.println("\nYour new account has been successfully registered!");
        System.out.println("\nRedirecting to login...........");
        getLogin();
    }

    public void mainMenu() throws IOException {

        data.put(64646, new Account(64646, 75757, 2222, 4444));
        data.put(777, new Account(777, 777, 20000, 40000));
        boolean end = false;
        while(!end) {

            try {

                System.out.println("\nOption 1 - Login");
                System.out.println("\nOption 2 - Create Account");
                int choice = menuInput.nextInt();
                switch(choice) {

                    case 1:
                            getLogin();
                            end = true;
                            break;
                    case 2:
                            createAccount();
                            end = true;
                            break;
                    default:
                            System.out.println("\nInvalid choice");
                }
            } catch(InputMismatchException e) {

                System.out.println("\nInvalid Choice");
                menuInput.next();
            }
        }

        System.out.println("\nThank you for using this Cash Line");
        menuInput.close();
        System.exit(0);
    }
}

