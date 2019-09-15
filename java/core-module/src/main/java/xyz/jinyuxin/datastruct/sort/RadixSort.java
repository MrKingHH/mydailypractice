package xyz.jinyuxin.datastruct.sort;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
  public static void main(String[] args) {
    int[] arr = {542, 3521, 13459, 852, 742, 46, 2, 1, 633, 32};
    radixSort(arr);
    System.out.println("基数排序的最终结果是:");
    for (int x : arr) {
      System.out.println(x);
    }
  }

  public static void radixSort(int[] arr) {
    //找到待排序数组的最大数
    int max = findMax(arr);
    //通过最大的数确定分配和回收的次数
    int times = 0;
    while (max != 0) {
      max = max / 10;
      times++;
    }

    int len = arr.length;
    //初始化需要分配时需要用到的10个桶
    //每个桶都是一个队列
    Queue[] bucket = new Queue[10];
    for(int i=0;i<bucket.length;i++){
      bucket[i] = new LinkedList<Integer>() {
      };
    }

    //分配收集 time次
    for (int i = 1; i <= times; i++) {
      //对所有待排序的数字进行分配
      for (int j=0;j<len;j++) {
        //计算每个数应该放置的桶编号
        //第一次应该就是本身对10取余，其实就是除以10的零次方
        //第二次就是先除以10，再对10取余
        //第三次就是除以100，再对10取余，依次类推
        int number = arr[j] % (int) Math.pow(10, i) / (int) Math.pow(10, i-1);
        //将下标为j的数放入编号为number的桶里
        //怎么保证每个桶都是按0开始放？？？
        bucket[number].add(arr[j]);
      }
      //对待排序数字进行回收
      int count=0;
      for(int k=0;k<10;k++) {
        while(!bucket[k].isEmpty()) {
          arr[count++] = (Integer) bucket[k].remove();
        }
      }

      System.out.printf("第%d次排序的结果是:\n", i);
      for(int x:arr){
        System.out.println(x);
      }
    }
  }

  public static int findMax(int[] arr) {
    int max = 0;
    for (int x : arr) {
      if (x > max) {
        max = x;
      }
    }

    return max;
  }

}