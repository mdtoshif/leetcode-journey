/**
 * Problem: Remove Duplicates from Sorted List (#83)
 * Day: 21-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Two Pointers)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * Although there is a while loop inside another while loop,
 * it is NOT O(N²).
 *
 * 'dupli' only moves forward and never moves backward.
 * Across the entire algorithm, both pointers together
 * traverse the list at most O(N) times.
 *
 * ------------------------------------------------------------
 *
 * Space Complexity:
 * O(1)
 *
 * No extra data structure is used.
 *
 * ------------------------------------------------------------
 *
 * Brute Force:
 * - Store all values in a TreeSet.
 * - Build a new linked list from the unique values.
 *
 * Time Complexity : O(N log N)
 * Space Complexity: O(N)
 *
 * ------------------------------------------------------------
 **/

public ListNode deleteDuplicates(ListNode head) {

    // Empty list or single-node list
    if (head == null || head.next == null)
        return head;

    ListNode temp = head;
    ListNode dupli = head;

    while (temp != null) {

        // Skip all duplicate nodes
        while (dupli != null && temp.val == dupli.val) {
            dupli = dupli.next;
        }

        // Connect current node to the next distinct node
        temp.next = dupli;

        // Move to the next distinct node
        temp = temp.next;
    }

    return head;


    // ---------------- Brute Force ----------------
    /*
    // Ordered Set
    Set<Integer> set = new TreeSet<>();

    ListNode temp = head;

    while (temp != null) {
        set.add(temp.val);
        temp = temp.next;
    }

    List<Integer> li = new ArrayList<>(set);

    ListNode newHead = new ListNode(li.get(0));
    temp = newHead;

    for (int i = 1; i < set.size(); i++) {

        ListNode newNode = new ListNode(li.get(i));

        temp.next = newNode;
        temp = temp.next;
    }

    return newHead;
    */
}