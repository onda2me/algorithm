package com.onda2me.algorithm.kakao;

import java.util.Arrays;

/*
셔틀버스(난이도: 중)
이 문제에서는 편의를 위해 셔틀은 다음과 같은 규칙으로 운행한다고 가정하자.

1.셔틀은 09:00부터 총 n회 t분 간격으로 역에 도착하며, 하나의 셔틀에는 최대 m명의 승객이 탈 수 있다.
2.셔틀은 도착했을 때 도착한 순간에 대기열에 선 크루까지 포함해서 대기 순서대로 태우고 바로 출발한다. 예를 들어 09:00에 도착한 셔틀은 자리가 있다면 09:00에 줄을 선 크루도 탈 수 있다.
3.콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각을 구하여라.

단, 콘은 게으르기 때문에 같은 시각에 도착한 크루 중 대기열에서 제일 뒤에 선다. 또한, 모든 크루는 잠을 자야 하므로 23:59에 집에 돌아간다. 따라서 어떤 크루도 다음날 셔틀을 타는 일은 없다.

# 입력 형식
1.셔틀 운행 횟수 n, 셔틀 운행 간격 t, 한 셔틀에 탈 수 있는 최대 크루 수 m, 크루가 대기열에 도착하는 시각을 모은 배열 timetable이 입력으로 주어진다.
    0 ＜ n ≦ 10
    0 ＜ t ≦ 60
    0 ＜ m ≦ 45
2.timetable은 최소 길이 1이고 최대 길이 2000인 배열로, 하루 동안 크루가 대기열에 도착하는 시각이 HH:MM 형식으로 이루어져 있다.
3.크루의 도착 시각 HH:MM은 00:01에서 23:59 사이이다.

# 출력 형식
1.콘이 무사히 셔틀을 타고 사무실로 갈 수 있는 제일 늦은 도착 시각을 출력한다. 도착 시각은 HH:MM 형식이며, 00:00에서 23:59 사이의 값이 될 수 있다.

입출력 예제
n	t	m	timetable	answer
1	1	5	["08:00", "08:01", "08:02", "08:03"]	"09:00"
2	10	2	["09:10", "09:09", "08:00"]	"09:09"
2	1	2	["09:00", "09:00", "09:00", "09:00"]	"08:59"
1	1	5	["00:01", "00:01", "00:01", "00:01", "00:01"]	"00:00"
1	1	1	["23:59"]	"09:00"
10	60	45	["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"] "18:00"

# 문제원본
https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/

*/
public class Kakao17Ques4 {    
   
    public static void main(String[] args) {

        // 입력정보 
        solution(1,	1,	5, new String[]{"08:00", "08:01", "08:02", "08:03"}, "09:00");
        solution(2,	10,	2, new String[]{"09:10", "09:09", "08:00"},	"09:09");
        solution(2,	1,	2, new String[]{"09:00", "09:00", "09:00", "09:00"},	"08:59");
        solution(1,	1,	5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"},	"00:00");
        solution(1,	1,	1, new String[]{"23:59"}, "09:00");
        solution(10, 60, 45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}, "18:00");

    }

    /**
     * 
     * @param n 셔틀운행횟수
     * @param t 셔틀운행간격
     * @param m 셔틀당 탑승가능 크루수
     * @param crewTimetables 크루 도착시간
     * @param answer 정답
     */
    private static void solution(int n, int t, int m, String[] crewTimetables, String answer) {
        

        int totalCnt = 0;       // 총 셔틀 탑승 인원수
        int onceCnt = 0;        // 한 셔틀당 탑승 인원수
        int lastTime = 0;       // 가장 늦은 셔틀탑승 시간
        
        int busTimes[] = getBusTimes(n, t);             // 셔틀 도착시간을 int 배열로 변환
        int crewTimes[] = getCrewTimes(crewTimetables); // 크루 도착시간을 int 배열로 변환

        // 셔틀당 탑승 인원 계산
        for(int i=0; i<busTimes.length; i++) {
            
            onceCnt = 0;

            // 셔틀에 크루 탑승 여부 계산
            for(int k=totalCnt; k<crewTimes.length; k++) {

                //lastTime = crewTimes[k];
               
                // 셔틀당 탑승인원 초과
                if(onceCnt >= m) {
                    break;
                }

                //System.out.println("total[" + totalCnt + "-"+onceCnt+"] bus["+i+"]"+busTimes[i] +", crew[" +k +"]"+crewTimes[k]);
                // 셔틀시간이 크루 도착시간보다 작을때 - 늦게 도착하여 탑승못함 다음셔틀로 스킵
                if(busTimes[i] < crewTimes[k]) {
                    break;
                }

                // 셔틀시간이 크루 도착시간보다 크거나 같을때 - 탑승가능
                if(busTimes[i] >= crewTimes[k]) {
                    onceCnt++;
                    totalCnt++;
                }
            }

            // 셔틀당 탑승인원이 작으면, 셔틀시간이 탑승가능 시간
            if(onceCnt < m) {
                lastTime = busTimes[i];   

            // 셔틀당 탑승인원을 채운경우 마지막 크루 도착시간보다 1분 빠른시간으로 설정
            } else {
                lastTime = crewTimes[totalCnt-1] - 1;
            }            
        }        
        
        // 출력결과 :: takeBusCrewCnt : 4, lastBus : 540       -> 09:00==09:00         -> true
        System.out.println("takeBusCrewCnt : " + totalCnt + ", lastBus : " + lastTime + " \t-> " + intToTime(lastTime) + "==" + answer +" \t-> " + (answer.equals(intToTime(lastTime))));
    }


    /**
     * 셔틀 도착시간을 int 배열로 변환
     * @param n 셔틀 운행횟수
     * @param t 셔틀 운행간격
     * @return int 배열
     */
    private static int[] getBusTimes(int n, int t) {

        int busTimes[] = new int[n];
        for(int i=0; i<n; i++) {

            busTimes[i] = 9*60 + t*i;
            //System.out.println("busTime["+i+"] " + busTimes[i]);
        }

        return busTimes;
    }

    /**
     * 크루 도착시간을 시간순으로 정렬 후 int 배열로 변환
     * @param crewTimetables 크루 도착시간 시간문자열 
     * @return int 배열
     */
    private static int[] getCrewTimes(String[] crewTimetables) {

        int crewTimes[] = new int[crewTimetables.length];

        Arrays.sort(crewTimetables);
        
        for(int i=0; i<crewTimetables.length; i++) {

            crewTimes[i] = timeToInt(crewTimetables[i]);
            //System.out.println("crewTimes["+i+"] " + crewTimes[i]);
        }

        return crewTimes;
    }

   
    /**
     * int형 시간을 문자열형으로 변환 (예: 540 -> 09:00)
     * 
     * @param time
     * @return
     */
    private static int timeToInt(String time) {

        int time_i = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3,5));

        return time_i;
    }

    /**
     * 시간 문자열을 int형으로 변환 (예: 09:00 -> 540)
     * @param time
     * @return
     */
    private static String intToTime(int time) {

        int hh = time/60;
        int mm = time%60;

        String time_s = ((hh < 10) ? "0"+hh : ""+hh) + ":" + ((mm < 10) ? "0"+mm : ""+mm);

        return time_s;
    }

}
