class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

public class BusRoute {
    static Node build(String[] stops) {
        Node head = new Node(stops[0]);
        Node temp = head;

        for (int i = 1; i < stops.length; i++) {
            temp.next = new Node(stops[i]);
            temp = temp.next;
        }

        return head;
    }

    static void printRoute(Node head) {
        Node temp = head;
        int count = 0;
        String first = head.data, last = "";

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            last = temp.data;
            count++;
            temp = temp.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count +
                ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        String[] stops = {"Tambaram", "Guindy", "TNagar", "Central"};
        Node head = build(stops);
        printRoute(head);
    }
}
