// N: number of all nodes; k: number of ListNode tail in lists
// insertion for heap is O(logk), since there is N nodes
// so the time complexity is O(Nlogk)

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
     
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            }
            
            if (right == null) {
                return -1;
            }
            
            return left.val - right.val;
        }
    };
    
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				heap.offer(lists.get(i));				
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode pointer = dummy;
		while (!heap.isEmpty()) {
			// the smaller one
			ListNode node = heap.poll();
			pointer.next = node;
			pointer = pointer.next;
			if (node.next != null) {
				heap.offer(node.next);
			}
		}
		
		return dummy.next;		
	}
}


// private class ListNodeComparator implements Comparator<ListNode> {
// 	@Override
// 	public int compare(ListNode left, ListNode right) {
// 		// 1. left < right, return a negative (compare(1, 2) == -1, -1代表后者更大)；
// 		// 2. left > right, return a positive (compare(1, 2) == 1, 1代表前者更大);
// 		// 3. left == right, return 0;
// 		if (left == null) {
// 			return 1;
// 		}

// 		if (right == null) {
// 			return -1;
// 		}

// 		return left.val - right.val;
// 	}
// }
