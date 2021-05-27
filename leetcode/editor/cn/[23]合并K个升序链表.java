//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1317 👎 0


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
    public ListNode mergeKLists(ListNode[] lists) {
        //k 个链表我们两两合并即可
        ArrayList<ListNode> result = new ArrayList<>();
        for (ListNode node : lists){
            result.add(node);
        }
        return mergeKLists(result);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists){
        if(lists == null || lists.size() == 0) return null;
        if(lists.size() == 1) return lists.get(0);
        if((lists.size() & 1) == 1) lists.add(null);
        ArrayList<ListNode> result = new ArrayList<>();
        for (int i = 0; i < lists.size(); i += 2){
            result.add(mergeTwo(lists.get(i),lists.get(i + 1)));
        }
        return mergeKLists(result);
    }

    //合并两个有序链表
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode l = res;

        while (l1 != null && l2 != null) {
            if(l1.val > l2.val){
                l.next = l2;
                l2 = l2.next;
            }else {
                l.next = l1;
                l1 = l1.next;
            }
            l = l.next;
        }

        l.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
