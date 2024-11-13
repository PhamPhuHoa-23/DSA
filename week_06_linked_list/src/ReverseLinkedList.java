public class ReverseLinkedList {
//    https://leetcode.com/problems/reverse-linked-list/description/

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head = reverseList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
