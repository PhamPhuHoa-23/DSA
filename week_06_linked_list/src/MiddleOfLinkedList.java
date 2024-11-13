public class MiddleOfLinkedList {
    // https://leetcode.com/problems/middle-of-the-linked-list/description/

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(middleNode(head).val);
    }
}
