import java.util.List;

public class MyLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { this.val = x;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    private ListNode head;

    public MyLinkedList() {
        this.head = null;
    }

    public int get(int index) {
        if (this.head == null) {
            return -1;
        }

        ListNode curr = this.head;

        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null) {
            return curr.val;
        }

        return -1;
    }

    public void addAtHead(int val) {
        if (this.head == null) {
            this.head = new ListNode(val);
        }

        ListNode newHead = new ListNode(val, this.head);
        this.head = newHead;
    }

    public void addAtTail(int val) {
        if (this.head == null) {
            this.head = new ListNode(val, null);
        }

        ListNode curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new ListNode(val, null);
    }

    public void addAtIndex(int index, int val) {
        if (this.head == null) {
            return;
        }

        ListNode curr = this.head;

        for (int i = 0; i < index - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null) {
            ListNode newNode = new ListNode(val, curr.next);
            curr.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (this.head == null) {
            return;
        }

        ListNode curr = this.head;

        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null) {
            curr.val = curr.next.val;
            curr.next = curr.next.next;
        }
    }
}
