public class Node {
    int digit;
    Node prev;
    Node next;

    public Node(int digit)
    {
        this.digit = digit;
        this.prev = null;
        this.next = null;
    }
}
