package 中等.两数相加;

import 链表.ListNode;
import 链表.ListNodeUtils;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    //递归方法
   public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode result = addTwoNumbers(l1, l2, new ListNode(0));
        return result;
    }

    //循环方法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (true){
            if (l1 == null && l2 == null){
                break;
            }
            if (l1 == null){
                l1 = new ListNode(0);
            }
            if (l2 == null){
                l2 = new ListNode(0);
            }
            int x =  l1.val;
            int y =  l2.val;
            int temp = x + y + current.val;
            if (temp >= 10){
                current.val = temp - 10;
                current.next = new ListNode(1);
            } else {
                current.val = temp;
                if (l1.next == null && l2.next == null){
                    break;
                }
                current.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        ListNodeUtils.printList(result);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, ListNode result){
        if (l1 == null && l2 == null){
            return result;
        }
        if (l1 == null){
            l1 = new ListNode(0);
        }
        if (l2 == null){
            l2 = new ListNode(0);
        }
        int temp = result.val + l1.val + l2.val;
        if (temp >= 10){
            result.val = temp - 10;
            result.next = new ListNode(1);
        } else {
            result.val = temp;
            if (l1.next == null && l2.next == null){
                return result;
            }
            result.next = new ListNode(0);
        }
        addTwoNumbers(l1.next, l2.next, result.next);
        return result;
    }



}

