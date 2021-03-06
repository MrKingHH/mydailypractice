package com.github.mrkinghh.leetcode;

/**
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution771 {
  /**
   * 考虑更高的空间性能，使用byte数组。ASCII码中字母的跨度为65~122，所以定义数组长度为58最节省。
   */
  public static int numJewelsInStones(String J, String S) {
    if (J == null || J.length() == 0) {
      return 0;
    }
    if (S == null || S.length() == 0) {
      return 0;
    }

    int num = 0;
    //A=65 z=122 122-65+1=58
    byte[] byteArr = new byte[58];
    //记录J里面的字符
    for (char ch : J.toCharArray()) {
      byteArr[ch - 65] = 1;
    }
    for (char ch : S.toCharArray()) {
      if (byteArr[ch - 65] == 1) {
        num++;
      }
    }
    return num;
  }
}
