import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class Standard extends Delivery {
    Standard(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 5 + 0.5 * weight + 0.1 * distance;
    }
}

class Express extends Delivery {
    Express(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 15 + weight + 0.2 * distance;
    }
}

class International extends Delivery {
    double customs;

    International(double w, double d, double customs) {
        super(w, d);
        this.customs = customs;
    }

    double calculateFee() {
        return 25 + 2 * weight + 0.5 * distance + customs;
    }
}

class DeliveryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery d;

            if (type.equals("STANDARD"))
                d = new Standard(weight, distance);
            else if (type.equals("EXPRESS"))
                d = new Express(weight, distance);
            else
                d = new International(weight, distance, sc.nextDouble());

            double fee = d.calculateFee();
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
