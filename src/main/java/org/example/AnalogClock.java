package org.example;

public class AnalogClock {

    public static void main(String[] args) {
//        System.out.println(Solution.solution(1,5,5,1,5,6));
//        System.out.println(Solution.solution(0,0,0,23,59,59));
//        System.out.println(Solution.solution(12,0,0,12,0,30));
        System.out.println(Solution.solution(11, 58, 59, 11, 59, 0));
//        Solution.solution(1,5,5,1,5,6);

    }

    class Solution {
        static public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
            int answer = 0;
            int prevTime = h1*3600+m1*60+s1;
            int nextTime = h2*3600+m2*60+s2;
            int a = 12*3600;
//            System.out.println(compareLocation(2*a-1,2*a));
            for(int i = prevTime ; i < nextTime ; i++){
                answer += compareLocation(i, i+1);
            }

            return answer;
        }
        static double locationH(int time){
            return (double) time/120 % 360;
        }
        static double locationM(int time){
            return (double) time/10 % 360;
        }
        static double locationS(int time){
            return (double) time*6 % 360;
        }
        static int compareLocation(int prevTime, int nextTime){
            int value = 0;
            if (locationH(prevTime) == locationS(prevTime) && locationM(prevTime) == locationS(prevTime)){
                return 1;
            }

            if((locationH(prevTime) > locationS(prevTime)) && (locationH(nextTime) < locationS(nextTime))){
                value += 1;
            } else if((locationH(prevTime) > locationS(prevTime)) && (locationH(nextTime) == locationS(nextTime))){
                value += 1;
            } else if (locationH(prevTime) == locationS(prevTime)){
                value += 1;
            }
            if((locationM(prevTime) > locationS(prevTime)) && (locationM(nextTime) < locationS(nextTime))){
                value += 1;
            } else if((locationM(prevTime) > locationS(prevTime)) && (locationM(nextTime) == locationS(nextTime))){
                value += 1;
            } else if (locationM(prevTime) == locationS(prevTime)){
                value += 1;
            }

            return value;
        }
    }
}
