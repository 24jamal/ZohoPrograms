class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindIntersectionInList {

    public static Node intersectionList(Node head1, Node head2) {

        Node dummy = new Node(0);
        Node tail = dummy;

        Node ptr1 = head1;
        Node ptr2 = head2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data == ptr2.data) {
                tail.next = new Node(ptr1.data);
                // System.out.println(ptr1.data);
                tail = tail.next;

                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            else if (ptr1.data < ptr2.data) {
                ptr1 = ptr1.next;
            }

            else {
                ptr2 = ptr2.next;
            }

        }

        return dummy.next;

    }

    public static void printlist(Node header) {
        Node temp = header;

        System.out.println("InterSection List");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);

        Node tempNode1 = head1;

        while (tempNode1 != null) {
            System.out.println(tempNode1.data);
            tempNode1 = tempNode1.next;
        }

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        System.out.println();
        Node tempNode2 = head2;

        while (tempNode2 != null) {
            System.out.println(tempNode2.data);
            tempNode2 = tempNode2.next;
        }
        Node header = intersectionList(head1, head2);

        printlist(header);

    }
}