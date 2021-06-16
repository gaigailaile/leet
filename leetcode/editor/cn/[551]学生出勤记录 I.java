//给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符： 
//
// 
// 'A' : Absent，缺勤 
// 'L' : Late，迟到 
// 'P' : Present，到场 
// 
//
// 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。 
//
// 你需要根据这个学生的出勤记录判断他是否会被奖赏。 
//
// 示例 1: 
//
// 输入: "PPALLP"
//输出: True
// 
//
// 示例 2: 
//
// 输入: "PPALLL"
//输出: False
// 
// Related Topics 字符串 
// 👍 72 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkRecord(String s) {
        //定义aCount记录A的个数，lCount记录L的连续个数
        int aCount = 0,lCount = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'A') {
                aCount++;
                lCount = 0;
            }else if(ch == 'L'){
                lCount++;
            }else {
                lCount = 0;
            }

            if(aCount > 1 || lCount > 2){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
