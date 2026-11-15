class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

public class LateComers {
    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);

        if (head == null)
            return newNode;

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node("Asha");
        head.next = new Node("Ravi");

        head = addFirst(head, "Neha");
        head = addLast(head, "Kiran");
        head = addFirst(head, "Mohan");

        display(head);
    }
}
