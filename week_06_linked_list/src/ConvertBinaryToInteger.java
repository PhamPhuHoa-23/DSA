public class ConvertBinaryToInteger {
    // https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static int getDecimalValue(ListNode head) {
        ListNode cursor = head;
        int num = 0;

        while (cursor != null) {
            num = num * 2 + cursor.val;
            cursor = cursor.next;
        }

        return num;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        System.out.println(getDecimalValue(head));
    }


}
