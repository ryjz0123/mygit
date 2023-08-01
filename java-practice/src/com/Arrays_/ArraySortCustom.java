package com.Arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortCustom {
    public static void main(String[] args) {
        int arr[] = {1,-1,2,0,8,19};
        //bubble01(arr);
        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i1 - i2;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    //冒泡完成
    public static void bubble01(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) { //排序次数
            int temp = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] < arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //冒泡 + 定制完成
    public static void bubble02(int[] arr, Comparator c) {
        for (int i = 0; i < arr.length - 1; i++) { //排序次数
            int temp = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (c.compare(arr[j],arr[j+1]) > 0 ){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
