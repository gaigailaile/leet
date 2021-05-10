//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 149 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] sCh = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < right && !isVowel(sCh[left])) left++;
            while (left < right && !isVowel(sCh[right])) right--;
            if(left < right){
                char temp = sCh[left];
                sCh[left] = sCh[right];
                sCh[right] = temp;
            }
            left++;
            right--;
        }
        return new String(sCh);
    }

    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
