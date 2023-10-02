package list;

public class CycleDetection {
    public boolean hasCylce(ListNode head)
    {
        if(head == null) return false;
        ListNode turtoise = head;
        ListNode hare = head;

        while (turtoise != null && hare != null && hare.next != null)
        {

            turtoise = turtoise.next;
            hare = hare.next.next;
            if (turtoise == hare) return true;

        }
        return false;
    }

    private class ListNode {
        ListNode next;
        int value;
        ListNode(int x)
        {
            value = x;
            next = null;
        }
    }
}
