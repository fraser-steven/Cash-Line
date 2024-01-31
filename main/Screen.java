import java.io.IOException;

public class Screen {
    
    public static void main(String[] args) throws IOException {

        options options = new options();
        introduction();
        options.mainMenu();

    }

    public static void introduction() {

        System.out.println("Welcome to the Cash Line");
    }
}
