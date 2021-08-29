package 链表;

public class ListNodeUtils {

    public static void printList(ListNode head)
    {
        while (head != null)
        {
            if (head.next == null){
                System.out.println(head.val);
            }

            else{
                System.out.print(head.val + " --> ");
            }
            head = head.next;
        }
    }
}
