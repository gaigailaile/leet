import java.math.BigInteger;
import java.util.*;

class Solution {

    public static int findShortestSubArray(int[] nums) {
        //哈希表 key为数字 val为长度为3的数组 new int[]{count,start,end} 0 放个数 1放开始节点 2放结束节点
        HashMap<Integer,int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else {
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int minLine = 0,maxCount = 0;
        for(Map.Entry<Integer,int[]> entry : map.entrySet()){
            int[] arr = entry.getValue();
            if(arr[0] > maxCount){
                maxCount = arr[0];
                minLine = arr[2] - arr[1] + 1;
            }else if(arr[0] == maxCount){
                if(minLine > arr[2] - arr[1] + 1){
                    minLine = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLine;
    }

    public static void main(String[] args) {
        findShortestSubArray(new int[]{1,2,2,3,1});
    }
}
