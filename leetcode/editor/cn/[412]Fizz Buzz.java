//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 96 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        //模拟法
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            boolean divBy3 = (i % 3 == 0);
            boolean divBy5 = (i % 5 == 0);
            if(divBy3 && divBy5) {
                res.add("FizzBuzz");
            }else if(divBy3){
                res.add("Fizz");
            }else if(divBy5){
                res.add("Buzz");
            }else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
