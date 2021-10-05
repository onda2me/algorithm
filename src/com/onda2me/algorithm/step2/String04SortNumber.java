package com.onda2me.algorithm.step2;

import java.util.Arrays;
import java.util.Comparator;

/*

소트인사이드

### 문제설명 
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

### 입력
첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

### 출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

### 예제    

입    력 |  출    력     
----- | -----  
2143  | 4321
724953 | 975432

### 문제원본    
[https://www.acmicpc.net/problem/1427](https://www.acmicpc.net/problem/1427){: target="_blank"}

*/
public class String04SortNumber {    

    public static void main(String[] args) {

        // 입력정보
        solution("2143", "4321");
        solution("724953", "975432");
    }

    /**
     * 숫자로 구성된 문자열을 내림차순으로 정렬한다.
     * 
     */
    private static void solution(String str, String answer) {

        int arr[] = new int[str.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // System.out.println("before ------");
        // print(arr);

        // 방법1 정렬
        arr = case1(arr);

        // 방법2 정렬
        // arr = case2(arr);

        // System.out.println("after ------");
        print(arr);
            
    }

    /**
     * 방법1 : Java 내장함수 Arrays.sort 기능을 이용하여 정렬한다.
     * int[] -> Integer[] -> int[] 변환 과정을 거친다.
     * @param arr 
     * @return
     */
    private static int[] case1(int arr[]) {
        Integer obj[] = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(obj, Comparator.reverseOrder());
           
        return Arrays.stream(obj).mapToInt(i->i).toArray();
    }

    /**
     * 방법2: Array 값을 비교하여 값을 치환하는 방법으로 정렬한다.
     * @param arr
     * @return
     */
    private static int[] case2(int arr[]) {
        int temp = 0;

        for(int i=0; i<arr.length; i++) {

            for(int k=0; k<arr.length; k++) {

                if(arr[i] > arr[k] && i != k) {
                    temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
        } 
        
        return arr;
    }

    /**
     * int[] 값 출력을 위한 함수
     * @param arr
     */
    private static void print(int arr[]) {
        
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    /**
     * Integer[] 값 출력을 위한 함수
     * @param arr
     */
    private static void print(Integer arr[]) {

        
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i].intValue());
        }
        System.out.println("");
    }
}

                