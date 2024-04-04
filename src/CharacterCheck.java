import java.util.Scanner;

public class CharacterCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);

        if (ch >= 'A' && ch <= 'Z') {
            System.out.println(1+" Uppercase alphabet ");
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println(0+" Lowercase alphabet");
        } else {
            System.out.println(-1+" Not an alphabet");
        }
    }
}
