import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
    double getFee(double amount);
    String getMode();
}

class CashPayment implements PaymentMode {
    public double getFee(double amount) {
        return 0;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getMode() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    public double getFee(double amount) {
        return amount * 0.02;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getMode() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    public double getFee(double amount) {
        return 0;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getMode() {
        return "UPI";
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            amounts[i] = sc.nextDouble();

            if (mode.equalsIgnoreCase("Cash"))
                payments[i] = new CashPayment();
            else if (mode.equalsIgnoreCase("Card"))
                payments[i] = new CardPayment();
            else
                payments[i] = new UpiPayment();
        }

        for (int i = 0; i < n; i++) {
            double fee = payments[i].getFee(amounts[i]);
            double processed = payments[i].processPayment(amounts[i]);

            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                    payments[i].getMode(), amounts[i], fee, processed);

            total += processed;
        }

        System.out.printf("Total Amount Processed: %.1f%n", total);
        sc.close();
    }
}
