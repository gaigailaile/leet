//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 281 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //继续优化只是用一个数组结题
        List<Integer> res = new ArrayList<>();
        res.add(1);
        //从第二层开始
        for (int i = 1; i <= rowIndex; i++){
            for(int j = i; j > 0; j--){
                if(j == 0 || j == i){
                    res.add(1);
                }else {
                    //收尾除外位置的数值只与j和j-1有关
                    // 我们从后向前计算此时集合中j-1的数值为上一行的数值
                    res.set(j,res.get(j-1) + res.get(j));
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
