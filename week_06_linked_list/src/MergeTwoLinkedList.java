public class MergeTwoLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l1.next = new ListNode(3);
        l2.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
