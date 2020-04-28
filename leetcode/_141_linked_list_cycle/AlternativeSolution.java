package leetcode._141_linked_list_cycle;

public class AlternativeSolution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (!nodeSet.add(curr)) {
                return true;
            }
            curr = curr.next;
        }
        
        return false;
    }
}