package com.mavixk.jcp;

import com.mavixk.jcp.generics.GetMaxGeneric;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetMaxGenericTest {
  @Test
  public void testGetMax(){
    try{
      Class<?> c = GetMaxGenericTest.class;
      Method m = c.getMethod("testGetMax");
      Annotation[] a = m.getAnnotations();
      for(Annotation anno:a) {
        System.out.println(anno);
        Annotation[] b = anno.annotationType().getAnnotations();
        for(Annotation ano: b)
          System.out.println(ano);
      }
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    List<Integer> a = Arrays.asList(23, 34, 21, 67, 43);
    assertEquals(67, GetMaxGeneric.getMax(a, 0, a.size()));
  }
}
