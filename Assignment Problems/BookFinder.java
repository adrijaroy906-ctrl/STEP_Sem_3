class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

public class BookFinder {
    static void find(Node head, String id) {
        int position = 1, first = -1, count = 0;

        while (head != null) {
            if (head.data.equals(id)) {
                if (first == -1)
                    first = position;

                count++;
            }

            head = head.next;
            position++;
        }

        if (count == 0)
            System.out.println(id + " not found");
        else
            System.out.println(id + " first at position " +
                               first + ", copies: " + count);
    }

    public static void main(String[] args) {
        Node head = new Node("B12");
        head.next = new Node("B87");
        head.next.next = new Node("B30");
        head.next.next.next = new Node("B07");
        head.next.next.next.next = new Node("B45");
        head.next.next.next.next.next = new Node("B07");

        find(head, "B07");
        find(head, "B99");
    }
}
