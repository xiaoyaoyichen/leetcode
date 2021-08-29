package 中等.森林中的兔子;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 781. 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 说明:
 *
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 */
public class NumRabbits {
    /**
     * 方法：贪心
     * 思路
     *
     * 两只相同颜色的兔子看到的其他同色兔子数必然是相同的。反之，若两只兔子看到的其他同色兔子数不同，那么这两只兔子颜色也不同。
     *
     * 因此，将 answers 中值相同的元素分为一组，对于每一组，计算出兔子的最少数量，然后将所有组的计算结果累加，就是最终的答案。
     *
     * 例如，现在有 13 只兔子回答 5。假设其中有一只红色的兔子，那么森林中必然有 6 只红兔子。
     * 再假设其中还有一只蓝色的兔子，同样的道理森林中必然有 6 只蓝兔子。
     * 为了最小化可能的兔子数量，我们假设这 12 只兔子都在这 13 只兔子中。那么还有一只额外的兔子回答 5，这只兔子只能是其他的颜色，
     * 这一颜色的兔子也有 6 只。因此这种情况下最少会有 18 只兔子。
     *
     * 一般地，如果有 x 只兔子都回答 y，则至少有 ceil(x / (y + 1) 种不同的颜色，且每种颜色有 （y+1） 只兔子，
     * 因此兔子数至少为 ceil(x / (y + 1) * （y+1）
     *
     * 我们可以用哈希表统计 answers 中各个元素的出现次数，对每个元素套用上述公式计算，并将计算结果累加，即为最终答案。
     *
     * @param answers
     * @return num
     */
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int answer : answers) {
            count.put(answer, count.getOrDefault(answer, 0) + 1);
        }
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int x = entry.getValue();
            int y = entry.getKey();
            num += (x + y) / (y + 1) * (y + 1);
        }
        return num;
    }
}
