/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Input: head = [1,1,1,2,3]
Output: [2,3]

*/

class Solution 
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null)
        {
            return head;
        }
        
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        
        ListNode curr = head;
        ListNode prev = fakehead;
        
        while(curr != null)
        {
            while(curr.next != null && curr.val == curr.next.val)
            {
                curr = curr.next;
            }
            
            if(prev.next == curr)
            {
                prev = curr;
            }
            else
            {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return fakehead.next;
    }
}
