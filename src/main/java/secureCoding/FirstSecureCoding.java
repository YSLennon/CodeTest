package secureCoding;

import java.util.Scanner;

public class FirstSecureCoding {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;
        while(true){
            System.out.println("첫 번째 숫자: ");
            int x = scanner.nextInt();
            System.out.println("두 번째 숫자: ");
            int y = scanner.nextInt();
            try{
                System.out.println("결과 값: ");
                System.out.println(x/y);
                break;
            }catch (Exception e){
                System.out.println("어이, 제대로 입력해라");
            } finally {
                cnt++;
                System.out.println(cnt+"번째 시도");
            }
            
        }
    }
}
