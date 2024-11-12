package org.example;

public class AnalogClock {

    public static void main(String[] args) {
//        System.out.println(Solution.solution(1,5,5,1,5,6));
        System.out.println(Solution.solution(0,0,0,23,59,59));
//        Solution.solution(12,0,0,12,0,30);
    }

    class Solution {
        static public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
            int answer = 0;
            int prevTime = h1*3600+m1*60+s1;
            int nextTime = h2*3600+m2*60+s2;
            int duration = nextTime-prevTime;
            int cycle = duration/60;

            answer = cycle*2;
            answer -= cycle/60;
            answer += compareLocation(prevTime, nextTime);
//            boolean checkHS = ((double)prevTime % (3600*12) > (double) prevTime % 60) != ((double)nextTime % (3600*12) > (double) nextTime % 60);
//            boolean checkMS = ((double)prevTime % (3600) > (double) prevTime % 60) != ((double)nextTime % (3600) > (double) nextTime % 60);
//            System.out.println(checkHS);
//            System.out.println(checkMS);

//            if(checkHS){
//                answer += 1;
//            }
//            if(checkMS){
//                answer += 1;
//            }



            return answer;
        }
        static double locationH(int time){
            return (double) time % (3600*12);
        }
        static double locationM(int time){
            return (double) time % 3600;
        }
        static double locationS(int time){
            return (double) time % 60;
        }
        static int compareLocation(int prevTime, int nextTime){
            int value = 0;
            if((locationH(prevTime) > locationS(prevTime)) != (locationH(nextTime) > locationS(nextTime))){
                value += 1;
            } else if (locationH(prevTime) == locationS(prevTime)){
                value += 1;
            } else if (locationH(nextTime) == locationS(nextTime)){
                value += 1;
            }
            if((locationM(prevTime) > locationS(prevTime)) != (locationM(nextTime) > locationS(nextTime))){
                value += 1;
            } else if (locationM(prevTime) == locationS(prevTime) && locationS(prevTime) != locationH(prevTime)){
                value += 1;
            } else if (locationM(nextTime) == locationS(nextTime) && locationS(nextTime) != locationH(nextTime)){
                value += 1;
            }

            return value;
        }
    }
}
