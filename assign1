import java.util.*;

class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        StringBuilder result = new StringBuilder();

        for (int i = customerName.length() - 1; i >= 0; i--)
            result.append(customerName.charAt(i));

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverseCustomerName(name));
    }
}
