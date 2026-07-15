class Node {
    int data;
    Node next;

    Node() {}

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    public Node addTwoNumbers(Node head1, Node head2) {

        Node dummy = new Node();
        Node curr = dummy;
        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {

            int sum = carry;

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;

            Node temp = new Node();
            temp.data = sum % 10;
            curr.next = temp;
            curr = temp;
        }

        return dummy.next;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Solution obj = new Solution();
        Node ans = obj.addTwoNumbers(head1, head2);

        print(ans);
    }
}