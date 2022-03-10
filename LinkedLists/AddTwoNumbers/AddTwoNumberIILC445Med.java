/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Input: l1 = [0], l2 = [0]
Output: [0]
*/

//Stack based solution
class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null)
        {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null)
        {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode dummyNode = null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry == 1)
        {
            int sum = 0;
            
            if(!s1.isEmpty())
            {
                sum += s1.pop();
            }
            
            if(!s2.isEmpty())
            {
                sum += s2.pop();
            }
            
            sum += carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            
            temp.next = dummyNode;
            dummyNode = temp;
        }
        return dummyNode;
    }
}

/* =========================================================== */

//Solved using Reversing the list
class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
       if(l1 == null)
       {
           return l2;
       }
        
       if(l2 == null)
       {
           return l1;
       }
        
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        
        return reverse(add(c1, c2, 0));
    }
    
    private ListNode add(ListNode l1, ListNode l2, int carry)
    {
        ListNode dummyNode = new ListNode(-1);
        ListNode handler = dummyNode;
        while(l1 != null || l2 != null || carry == 1)
        {
            int sum = 0;
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            handler.next = temp;
            handler = handler.next;
        }
        return dummyNode.next;
    }
    
    private ListNode reverse(ListNode l)
    {
        ListNode prev = null;
        ListNode curr = l;
        
        while(curr != null)
        {
            ListNode forw = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
}
