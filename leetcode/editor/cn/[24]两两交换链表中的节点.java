//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 909 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //迭代
        ListNode res = new ListNode();
        res.next = head;
        ListNode temp = res;

        while (temp.next != null && temp.next.next != null){
            //第一个节点
            ListNode node1 = temp.next;
            //第二个节点
            ListNode node2 = temp.next.next;
            //将res的next 指向第二个节点
            temp.next = node2;
            //将第一个节点的next指向第三个节点
            node1.next = node2.next;
            //将第二个节点的next指向第一个节点，至此实现1、2节点的互换
            node2.next = node1;
            //将res移到第二个节点（原来的第一节点） 后续对后两个节点进行同样操作
            temp = node1;
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
