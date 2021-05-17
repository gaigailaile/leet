//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 927 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //思路想根据左区间排序，然后进行合并
        if(intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals,(x,y) -> x[0] - y[0]);
        int[][] res = new int[intervals.length][2];
        //结果res的角标
        int index = -1;
        for(int[] interval : intervals){
            //如果角标小于0 或者 当前左区间大于之前的右区间将当前区间放入结果集
            if(index < 0 || res[index][1] < interval[0]){
                res[++index] = interval;
            }else {
                //合并
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
