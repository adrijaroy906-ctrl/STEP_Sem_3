import java.util.Scanner;

public class WordReverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String reverse = new StringBuilder(word).reverse().toString();

        System.out.println(reverse);

        if (word.equals(reverse))
            System.out.println("palindrome");
        else
            System.out.println("not a palindrome");

        sc.close();
    }
}
