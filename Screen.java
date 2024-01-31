import java.io.IOException;

public class Screen {
    
    public static void nain(String[] args) throws IOException {

        Options options = new Options();
        introduction();
        options.mainMenu();

    }

    public static void introduction() {

        System.out.println("Welcome to the Cash Line");
    }
}
