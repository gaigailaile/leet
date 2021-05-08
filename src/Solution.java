import java.math.BigInteger;
import java.util.*;

class Solution {
    public static boolean isIsomorphic(String s, String t) {
        //哈希表法
        HashMap<Character,Character> sMap = new HashMap<>();
        HashMap<Character,Character> tMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++){
            char sCh = s.charAt(i),tCh = t.charAt(i);
            if((sMap.containsKey(sCh) && sMap.get(sCh) != tCh) ||
                    (tMap.containsKey(tCh) && sMap.get(tCh) != sCh)) return false;
            sMap.put(sCh,tCh);
            tMap.put(tCh,sCh);
        }
        return true;
    }

    public static void main(String[] args) {
//        isIsomorphic("add","egg");
    }

}