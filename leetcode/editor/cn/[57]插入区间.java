//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 105 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 105 
// 
// Related Topics 排序 数组 
// 👍 418 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //从左向右移动
        List<int[]> resList = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        int index = 0;
        //先将左侧不重合部分放入答案集合
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            resList.add(intervals[index++]);
        }
        //处理重合部分
        while (index < intervals.length && intervals[index][0] <= newInterval[1]){
            left = Math.min(intervals[index][0],left);
            right = Math.max(intervals[index][1],right);
            index++;
        }
        resList.add(new int[]{left,right});
        //如果右边还有区间 放入结果集
        while (index < intervals.length) {
            resList.add(intervals[index++]);
        }

        //将list转型int[][]
        int[][] res = new int[resList.size()][2];

        for(int i = 0; i < resList.size(); i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
