import java.util.Scanner;

// Lesson: 입출력과 배열 선언 그리고 함수, 문자열 비교
// Program: 이름과 전화번호 입력받고 출력하기

// 1) 키보드 입력과 배열 선언
public class Code01 {
    // 전역변수
    static int n = 0;

    // 배열 선언
    static String [] names = new String [1000];
    static int [] numbers = new int [1000];
    public static void main(String args[]) {
        // 입력
        Scanner sc = new Scanner(System.in);

        // 지역변수
        int k = sc.nextInt(); // scanf("%d", &k);
        for (int i=0; i<k; i++) {

            // 문자열 입력 받기
            names[i] = sc.next(); // scanf("%s", ...);
            // 정수 입력 받기
            numbers[i] = sc.nextInt();

        }
        sc.close();

        for(int i=0; i<k; i++) {
            // 출력
            // '+' 연산자 양쪽에 한 곳이라도 문자가 있다면 문자열 2개를 합치는 것으로 해석
            System.out.println("Name: " + names[i] + ", Numbers: " + numbers[i]);
        }
    }
}

