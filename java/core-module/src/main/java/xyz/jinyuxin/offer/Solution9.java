package xyz.jinyuxin.offer;

import java.util.Stack;

/**
 * 面试题9：两个栈实现一个队列
 * */
public class Solution9 {

  private static Stack<Number> stack1 = new Stack<>();
  private static Stack<Number> stack2 = new Stack<>();

  public static void main(String[] args) {
    appandTail(1);
    System.out.println(deleteHead());
    appandTail(2);
    appandTail(2.3);
    appandTail(2.5);
    System.out.println(deleteHead());
    System.out.println(deleteHead());
    System.out.println(deleteHead());
  }

  public static  <T extends Number> void appandTail(T elem) {
    stack1.push(elem);
  }

  public static <T extends Number> T deleteHead() {
    if (stack2.empty()) {
      while(!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }

    if (stack2.empty()) {
      throw new RuntimeException("queue is empty");
    }
    return (T) stack2.pop();
  }
}