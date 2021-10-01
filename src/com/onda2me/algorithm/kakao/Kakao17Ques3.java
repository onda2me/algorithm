package com.onda2me.algorithm.kakao;

import java.util.LinkedList;

/*
# 캐시(난이도: 하)
캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.

# 입력 형식
1.캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
2.cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
3.cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
4.각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 도시 이름은 최대 20자로 이루어져 있다.

# 출력 형식
입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.

# 조건
1.캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
2.cache hit일 경우 실행시간은 1이다.
3.cache miss일 경우 실행시간은 5이다.

# 입출력 예제
캐시크기(cacheSize)	도시이름(cities)	실행시간
3,"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 50
3,"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, 21
2,"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 60
5,"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 52
2,"Jeju", "Pangyo", "NewYork", "newyork"}, 16
0,"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 25

# 문제원본
https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/

*/
public class Kakao17Ques3 {    
   
    public static void main(String[] args) {

        // 입력정보 
        solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 50);
        solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, 21);
        solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 60);
        solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 52);
        solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}, 16);
        solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 25);
	}

    private static void solution(int cacheSize, String[] cities, int runTime) {
        
        // 간단한 LRU MAP - LinkedList
        LinkedList<String> lurList = new LinkedList<String>();
        int totalTime = 0;

        // cities 정보를 캐시에 저장하고, 실행시간 계산
        for(String key : cities) {

            if(lurList.contains(key.toUpperCase())) {
                totalTime += 1;
            } else {
                lurList.addLast(key.toUpperCase());
                totalTime += 5;
            }

            // 주어진 캐시크기 초과시 첫번째 캐시 삭제
            if(lurList.size() > cacheSize) {
                lurList.removeFirst();
            }
        }

        System.out.println(totalTime + "==" + runTime +" \t--> " + (totalTime==runTime));
    }

}
