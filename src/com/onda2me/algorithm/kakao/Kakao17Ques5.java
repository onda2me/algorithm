package com.onda2me.algorithm.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/*

뉴스 클러스터링(난이도: 중)

자카드 유사도는 집합 간의 유사도를 검사하는 여러 방법 중의 하나로 알려져 있다.    
두 집합 A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.    
예를 들어 집합 A = {1, 2, 3}, 집합 B = {2, 3, 4}라고 할 때, 교집합 A ∩ B = {2, 3}, 합집합 A ∪ B = {1, 2, 3, 4}이 되므로, 집합 A, B 사이의 자카드 유사도 J(A, B) = 2/4 = 0.5가 된다.    
집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.    

자카드 유사도는 원소의 중복을 허용하는 다중집합에 대해서 확장할 수 있다.     
다중집합 A는 원소 “1”을 3개 가지고 있고, 다중집합 B는 원소 “1”을 5개 가지고 있다고 하자.    
이 다중집합의 교집합 A ∩ B는 원소 “1”을 min(3, 5)인 3개, 합집합 A ∪ B는 원소 “1”을 max(3, 5)인 5개 가지게 된다.    
다중집합 A = {1, 1, 2, 2, 3}, 다중집합 B = {1, 2, 2, 4, 5}라고 하면, 교집합 A ∩ B = {1, 2, 2}, 합집합 A ∪ B = {1, 1, 2, 2, 3, 4, 5}가 되므로, 자카드 유사도 J(A, B) = 3/7, 약 0.42가 된다.    

이를 이용하여 문자열 사이의 유사도를 계산하는데 이용할 수 있다. 
문자열 “FRANCE”와 “FRENCH”가 주어졌을 때, 이를 두 글자씩 끊어서 다중집합을 만들 수 있다.    
각각 {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}가 되며, 교집합은 {FR, NC}, 합집합은 {FR, RA, AN, NC, CE, RE, EN, CH}가 되므로, 두 문자열 사이의 자카드 유사도 J("FRANCE", "FRENCH") = 2/8 = 0.25가 된다.    

### 입력 형식
1. 입력으로는 str1과 str2의 두 문자열이 들어온다.    
2. 각 문자열의 길이는 2 이상, 1,000 이하이다.    
3. 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다. 
4. 예를 들어 “ab+”가 입력으로 들어오면, “ab”만 다중집합의 원소로 삼고, “b+”는 버린다.
5. 다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. “AB”와 “Ab”, “ab”는 같은 원소로 취급한다.

###  출력 형식
입력으로 들어온 두 문자열의 자카드 유사도를 출력한다.    
유사도 값은 0에서 1 사이의 실수이므로, 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.   

###  예제 입출력    

| str1 | str2 | answer |    
| --- | --- | --- |    
| FRANCE | french | 16384 |    
| handshake | shake hands | 65536 |    
| aa1+aa2 | AAAA12 | 43690 |    
| E=M*C^2 |  e=m*c^2 | 65536 |    

# 문제원본
https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/

*/
public class Kakao17Ques5 {    
   
    public static void main(String[] args) {

        // 입력정보 
        solution("FRANCE",	"french",	16384);
        solution("handshake",	"shake hands",	65536);
        solution("aa1+aa2",	"AAAA12",	43690);
        solution("E=M*C^2",	"e=m*c^2",	65536);            
    }


    private static void solution(String str1, String str2, int answer) {

        ArrayList<String> list1 = stringToList(str1);       // 문자열1을 List로 변환
        ArrayList<String> list2 = stringToList(str2);       // 문자열2를 List로 변환

        ArrayList<String> isList = getIntersection(list1, list2);   // 교집합
        ArrayList<String> unList = getUnion(list1, list2, isList);  // 합집합
        
        int isSize      = (isList == null || isList.size() == 0) ? 1 : isList.size();   // 교집합 크기
        int unionSize   = (unList == null || unList.size() == 0) ? 1 : unList.size();   // 합집합 크기
        int factor     = (isSize * 65536) / unionSize;

        // 출력 결과
        // unionSize : 1, isSize : 1 => 65536 == 65536     -> true
        System.out.println("unionSize : " + unionSize +", isSize : " + isSize + " => " + factor + " == " + answer +" \t-> " + (factor == answer));
    }

    /**
     * 문자열을 두개의 문자로 구성된 List로 변환한다.
     * 영문자로만 구성된 경우에만 List에 추가한다.
     * 확인이 쉽게 오름차순 정렬한다.
     * 
     * @param str 문자열
     * @return ArrayList<String> 두개의 문자로 구성된 List
     */
    private static ArrayList<String> stringToList(String str) {

        ArrayList<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile("^[a-zA-Z]*$");     // 영어 대소문자로만 구성
        String tmpStr = null;

        for(int i=0; i<str.length()-1; i++) {
    
            tmpStr = str.substring(i, i+2);         // 두개의 문자로 구성된 문자열로 만든다.

            if(p.matcher(tmpStr).find()) {          // 문자열이 영어 대소문자로만 구성되었는지 확인한다.
                list.add(tmpStr.toUpperCase());
            }
        }
    
        Collections.sort(list);                     // 오름차순 정렬
        return list;
    }

    /**
     * 두 리스트의 교집합을 구한다.
     * @param list1
     * @param list2
     * @return
     */
    private static ArrayList<String> getIntersection(ArrayList<String> list1, ArrayList<String> list2) {

        ArrayList<String> list = new ArrayList<String>();

        for(String s1 : list1) {
            for(String s2 : list2) {

                // 두 리스트의 문자열이 같을 경우 교집합
                if(s1.equals(s2)) {
                    list.add(s2);     
                    break;               
                } 
            }          
        }
        return list;
    }

    /**
     * 두 리스트의 합집합을 구한다.
     * list1에서 교집합 부분을 뺀뒤, list2와 합친다.
     * 
     * @param list1
     * @param list2
     * @param isList
     * @return
     */
    private static ArrayList<String> getUnion(ArrayList<String> list1, ArrayList<String> list2, ArrayList<String> isList) {

        ArrayList<String> list = new  ArrayList<String>();
        boolean isUnion = true;

        for(String s1 : list1) {           
            for(String is : isList) {
                
                if(s1.equals(is)) {
                    isUnion = false;
                    break;               
                } 
            }

            if(isUnion) {
                list.add(s1);
            }

            isUnion = true;                       
        }

        list.addAll(list2);
        return list;
    }    
}

    /*
    
    1) 숫자만 : ^[0-9]*$
    2) 영문자만 : ^[a-zA-Z]*$
    3) 한글만 : ^[가-힣]*$
    4) 영어 & 숫자만 : ^[a-zA-Z0-9]*$
    5) E-Mail : ^[a-zA-Z0-9]+@[a-zA-Z0-9]+$
    6) 휴대폰 : ^01(?:0|1|[6-9]) - (?:\d{3}|\d{4}) - \d{4}$
    7) 일반전화 : ^\d{2,3} - \d{3,4} - \d{4}$
    8) 주민등록번호 : \d{6} \- [1-4]\d{6}
    9) IP 주소 : ([0-9]{1,3}) \. ([0-9]{1,3}) \. ([0-9]{1,3}) \. ([0-9]{1,3})

    */


