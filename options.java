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
    HashMap<Integer, account> data = new HashMap<Integer, account>();

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

    
}
