package com.mavixk.jcp.generics;
import java.util.*;

public class CollectionV1 {
  public static int countOdd(Collection<? extends Number> c){
    int k = 0;
    for(Number val:c){
      if(val.intValue() % 2 == 1)
        k++;
    }
    return k;
  }

  public static <T extends Comparable<T>> T getMax(List<T> list,int begin,int end){
    T maxelem = list.get(begin);
    for(int i=begin+1; i < end;i++){
      T cur = list.get(i);
      if(cur.compareTo(maxelem) > 0)
        maxelem = cur;
    }
    return maxelem;
  }

  public static <T extends Comparable<T>> void swap(T[] a,T o1,T o2){
    int pos1=-1;
    int pos2 = -1;
    for(int i=0; i < a.length;i++) {
      if (a[i].equals(o1))
        pos1 = i;
      else if (a[i].equals(o2))
        pos2 = i;
    }
    T temp = a[pos1];
    a[pos1] = a[pos2];
    a[pos2] = temp;
  }

  public static <T> void printArray(T[] a){
    for(T val:a)
      System.out.print(val + " ");
    System.out.println();
  }

  public static void main(String[] args){
    List<Integer> a = Arrays.asList(2,23,29,34,76,41);
    System.out.println(countOdd(a));
    HashSet<Integer> b = new HashSet<>();
    b.add(2);
    b.add(3);
    b.add(7);
    System.out.println(countOdd(b));

    Integer[] d = {1,2,3,4,7};
    swap(d,3,7);
    printArray(d);

    String[] e = {"aws","jenkins","docker","ansible"};
    swap(e,"docker","aws");
    printArray(e);
  }
}
