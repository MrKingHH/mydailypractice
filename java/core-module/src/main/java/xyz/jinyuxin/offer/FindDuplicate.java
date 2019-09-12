package xyz.jinyuxin.offer;

import java.util.ArrayList;
import java.util.Iterator;

public class FindDuplicate {

  public static void main(String[] args) {
    int[] arr = {2,3,1,1,2,5,3};
    ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
    removeDuplcate(arr, arrayList);
  }

  public static void removeDuplcate(int[] arr, ArrayList<Integer> duplication) {
    if (arr== null || arr.length <= 0) {
      return ;
    }
    int len = arr.length;
    for (int i=0;i<len;i++) {
      if (arr[i]<0 || arr[i] > len-1) {
        return ;
      }
    }

    for (int i=0;i<len;i++) {
      while(arr[i] != i) {
        if(arr[i] == arr[arr[i]]) {
          duplication.add(arr[i]);
          break;
        }
        //exchage
        int temp = arr[i];
        arr[i] = arr[temp];
        arr[temp] = temp;
      }
    }
    Iterator it = duplication.iterator();
    while (it.hasNext()) {
      int x = (Integer) it.next();
      System.out.println(x);
    }
  }

}