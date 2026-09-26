import java.util.*;
import java.time.*;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidity();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidity());
    }
}

class Basic extends Plan {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    int getValidity() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    int getValidity() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    int getValidity() {
        return 365;
    }
}

class RenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(" ");

            String type = data[0];
            String name = data[1];
            LocalDate date = LocalDate.parse(data[2]);

            Plan p;

            if (type.equals("BASIC"))
                p = new Basic(name, date);
            else if (type.equals("STANDARD"))
                p = new Standard(name, date);
            else
                p = new Premium(name, date);

            System.out.println(name + ": " + p.getRenewalDate());
        }
    }
}
