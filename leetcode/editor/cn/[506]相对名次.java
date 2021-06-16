//给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal",
// "Silver Medal", "Bronze Medal"）。 
//
// (注：分数越高的选手，排名越靠前。) 
//
// 示例 1: 
//
// 
//输入: [5, 4, 3, 2, 1]
//输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and 
//"Bronze Medal").
//余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。 
//
// 提示: 
//
// 
// N 是一个正整数并且不会超过 10000。 
// 所有运动员的成绩都不相同。 
// 
// 👍 74 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < score.length; i++){
            cache.put(score[i],i);
        }

        Arrays.sort(score);
        String[] res = new String[score.length];
        for (int i = score.length - 1; i >=0; i--){
            if(i == score.length - 1){
                res[cache.get(score[i])] = "Gold Medal";
            }else if(i == score.length - 2){
                res[cache.get(score[i])] = "Silver Medal";
            }else if(i == score.length - 3){
                res[cache.get(score[i])] = "Bronze Medal";
            }else {
                res[cache.get(score[i])] = Integer.toString(score.length - i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
