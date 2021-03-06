package com.github.mrkinghh.offer;


public class Solution7 {
  public static BinaryTreeNode construct(int[] pre, int[] in) {
    if (pre == null || in == null) {
      return null;
    }

    return coreConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
  }

  public static BinaryTreeNode coreConstruct(int[] pre, int preStart, int preEnd,
                                             int[] in, int inStart, int inEnd) {
    int root = pre[preStart];
    BinaryTreeNode node = new BinaryTreeNode(root);
    //如果只有一个节点，则直接返回根节点
    if (preStart == preEnd) {
      if (inStart == inEnd) {
        return node;
      } else {
        System.out.println("不合法输入...");
      }
    }

    int index = 0;
    //遍历中序，找到值为root的下标
    for (int i = inStart; i <= inEnd; i++) {
      if (in[i] == root) {
        index = i;
        break;
      }
    }
    //在中序遍历中计算root左边有几个数
    int leftLen = index - inStart;
    int leftPreEnd = preStart + leftLen;
    //如果有左子树，才需要去构建。左子树长度大于0，说明有左子树
    if (leftLen > 0) {
      //递归构建左子树
      node.left = coreConstruct(pre, preStart + 1, leftPreEnd, in, inStart, index - 1);
    }

    //如果有右子树，才需要去构建。右子树长度大于0，说明有右子树
    if (index < inEnd) {
      //递归构建右子数
      node.right = coreConstruct(pre, leftPreEnd + 1, preEnd, in, index + 1, inEnd);
    }

    return node;
  }

  public static void preOrder(BinaryTreeNode root) {
    if (root != null) {
      System.out.println(root.data);
      preOrder(root.left);
      preOrder(root.right);
    }
  }

}
