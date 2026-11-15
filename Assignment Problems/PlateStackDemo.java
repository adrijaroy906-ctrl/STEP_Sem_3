class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

class PlateStack {
    Node top;
    int size = 0;

    void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate +
                " -> top " + top.data + ", size " + size);
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }

        String plate = top.data;
        top = top.next;
        size--;

        System.out.println("pop -> " + plate + ", size " + size);
    }

    void peek() {
        if (isEmpty())
            System.out.println("stack is empty");
        else
            System.out.println("peek -> " + top.data);
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class PlateStackDemo {
    public static void main(String[] args) {
        PlateStack s = new PlateStack();

        s.push("P1");
        s.push("P2");
        s.peek();
        s.pop();
        s.push("P3");
        s.pop();
        s.pop();
        s.pop();

        System.out.println("isEmpty -> " + s.isEmpty());
    }
}
