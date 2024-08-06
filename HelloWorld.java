import java.util.Scanner;

public class HelloWorld {

    public static void main (String[] args ) {

        System.out.println("HelloWorld");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome de usuario:");
        String usuario = scanner.next();
        System.out.println("seu usuario é: " + usuario);

    }
}