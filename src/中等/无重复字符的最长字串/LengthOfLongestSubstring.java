package 中等.无重复字符的最长字串;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    //HashSet法
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        Set<Character> tempSet = new HashSet<>();
        /**
         * 滑动窗口法:tempSet为滑动窗口，i为左边界，j为右边界，初始i，j都为0。
         * 初始滑动窗口大小为0
         */
        //max为最大字串长度，初始为0
        int max = 0, i = 0, j = 0;
        while (i < l && j < l){
            /**
             * 注意：滑动窗口移除元素时，总是先移除最左边的元素，然后窗口左边界右移，
             * 此时，再去判断缩小的滑动窗口中是否还存在与s[j]相同的元素，
             * 如果不存在，那么将s[j]放入滑动窗口，继续右移右边界，直到字符串末尾；
             * 如果存在，那么继续移除最左边的元素，右移左边界，直到滑动窗口中不存在与s[j]相同的元素
             */
            if (!tempSet.contains(s.charAt(j))){
                //如果s[j]不存在于滑动窗口中，就将s[j]放入滑动窗口
                tempSet.add(s.charAt(j));
                //计算当前滑动窗口长度
                int windowLength = j - i + 1;
                //取当前最大子串长度与滑动窗口长度的最大值为新的最大字串长度
                max = Math.max(max, windowLength);
                //窗口右边界右移一位
                j++;
            } else{
                //如果s[j]存在于滑动窗口中，说明s[j]与滑动窗口中某个字符相同
                //滑动窗口移除掉最左边的元素
                tempSet.remove(s.charAt(i));
                //滑动窗口左边界右移一位
                i++;
            }
            //如果滑动窗口左边界到字符串末尾的长度还没有当前最长字串长度大，那么当前最长字串长度就是最大长度
            if (l - i + 1 < max){
                break;
            }
        }
        return max;
    }

    //HashMap法
    public int lengthOfLongestSubstring2(String s) {
        int l = s.length();
        //tempMap key为字符值，value是字符在字符串s中的位置，最小从1开始
        Map<Character, Integer> tempMap = new HashMap<>();
        //max为最大字串长度
        int max = 0;
        //优化的滑动窗口法：i为左边界，j为右边界，初始i和j都为0；
        for (int i = 0, j = 0; j < l; j++){
            if (tempMap.containsKey(s.charAt(j))){
                //如果map里面已经存在了与s[j]相同的元素，
                // 那么就将左边界置为当前左边界与s[j]相同元素的所在位置的较大者
                i = Math.max(tempMap.get(s.charAt(j)), i);
            }
            //计算当前最大字串长度与滑动窗口长度的较大者作为新的最大字串长度
            max = Math.max(max, j - i + 1);
            //将当前字符的值存入map中，value记录当前字符在字符串s中的位置
            tempMap.put(s.charAt(j), j + 1);
            //如果滑动窗口左边界到字符串末尾的长度还没有当前最长字串长度大，那么当前最长字串长度就是最大长度
            if (l - i + 1 < max){
                break;
            }
        }
        return max;
    }

    //最开始自己的解法
    // 在寻找相同字符在临时字符串的位置时的方法比较笨，影响了时间复杂度
    public int lengthOfLongestSubstring3(String s) {
        int l = s.length();
        char[] charArray = s.toCharArray();
        int max = 0;
        String result = "";
        String temp = "";
        for (int i = 0; i < l; i++) {
            //寻找当前字符是否已经在临时字符串（滑动窗口）
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == charArray[i]) {
                    //如果已经存在
                    if (temp.length() > max) {
                        //并且当前字符串长度大于最大字串长度，那么更新最大字串长度
                        max = temp.length();
                        result = temp;
                    }
                    //将字符串s的游标放到相同字符位置的下一个字符，继续进行遍历
                    i = i - temp.length() + j + 1;
                    temp = "";
                    break;
                }
            }
            temp = temp + charArray[i];
            //如果到了字符串s的末尾并且临时字符串长度大于最长字串长度，那么更新字串长度
            if (i == l - 1 && temp.length() > max) {
                max = temp.length();
                result = temp;
            }

        }
        System.out.println(result);
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring maxLength = new LengthOfLongestSubstring();
        String[] s = {"abcabcbb", "bbbbb", "pwwkew", "aab"};
        for (int i = 0; i < s.length; i++) {
            int max = maxLength.lengthOfLongestSubstring3(s[i]);
            System.out.println(max);
        }
    }
}
