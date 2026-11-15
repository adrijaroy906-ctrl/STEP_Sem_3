public class LibraryDesk {
    public static void main(String[] args) {
        String[] stack = new String[3];
        String[] queue = new String[3];

        int top = -1, front = 0, rear = -1, size = 0;

        String[] commands = {
            "RETURN B1", "RETURN B2", "RETURN B3", "RETURN B4",
            "WAIT Asha", "WAIT Ravi", "SHELVE", "SERVE",
            "SHELVE", "SHELVE", "SHELVE", "SERVE", "SERVE"
        };

        for (String cmd : commands) {
            String[] p = cmd.split(" ");

            if (p[0].equals("RETURN")) {
                if (top == 2)
                    System.out.println(p[1] + " rejected: pile is full");
                else {
                    stack[++top] = p[1];
                    System.out.println(p[1] + " placed on pile");
                }
            }

            else if (p[0].equals("SHELVE")) {
                if (top == -1)
                    System.out.println("pile is empty");
                else
                    System.out.println("shelved " + stack[top--]);
            }

            else if (p[0].equals("WAIT")) {
                if (size == 3)
                    System.out.println("line is full");
                else {
                    rear = (rear + 1) % 3;
                    queue[rear] = p[1];
                    size++;
                    System.out.println(p[1] + " joined the Line");
                }
            }

            else if (p[0].equals("SERVE")) {
                if (size == 0)
                    System.out.println("no one waiting");
                else {
                    System.out.println("serves " + queue[front]);
                    front = (front + 1) % 3;
                    size--;
                }
            }
        }
    }
}
