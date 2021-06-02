//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1382 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        //单调栈
        int n = heights.length;
        //left存放当前元素的左边界坐标（左边界坐标: 左边最近的小于当前元素的坐标）
        int[] left = new int[n];
        //right存放当前元素的右边界坐标（右边界坐标: 右边最近的小于当前元素的坐标）
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; i++){
            //寻找当前元素的左坐标，小于当前元素的
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]){
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; i--){
            //寻找当前元素的右坐标
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]){
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            //求面积
            ans = Math.max(ans,(right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
