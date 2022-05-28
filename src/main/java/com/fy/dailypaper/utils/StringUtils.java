package com.fy.dailypaper.utils;

public class StringUtils {
     /**
      * 验证字符串是否为空(不空的为true)*/
     public static boolean isNoyEmpty(String... strs){
         boolean r=true;
         for (String s:strs){
             if(s==null || s.length()==0){
                 r=false;
                 break;
             }
         }
         return r;
     }
}
