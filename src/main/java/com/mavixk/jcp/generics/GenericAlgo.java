package com.mavixk.jcp.generics;

import java.util.Comparator;
import java.util.List;

public class GenericAlgo {
  public static void main(String[] args){

  }

  /**
   * here sort list param has no wildcards
   * as it is read-in/read-out List<T>
   * @param list
   * @param <T>
   */
  public static <T> void sort(List<T> list){
    //todo add sorting logic later
  }

  /**
   * sort method with comparator
   * @param list
   * @param comparator
   * @param <T>
   */
  public static <T> void sort(List<T> list, Comparator<? super T> comparator){
    //todo add sorting logic laster
  }

  /**
   * Generic binary search
   * @param list
   * @param key
   * @param <T>
   * @return
   */
  public static <T> int bsearch(List<? extends Comparable<? super T>> list, T key){
    int l = 0;
    int r = list.size() - 1;
    int mid = -1;
    while(l <= r){
      mid = l + (r -l)/2;
      if(list.get(mid).compareTo(key) == 0)
        return mid;
      else if(list.get(mid).compareTo(key) < 0)
        l = mid + 1;
      else
        r = mid -1;
    }
    return -1;
  }
}
