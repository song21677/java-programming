import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Lesson: 입출력과 배열 선언 그리고 함수, 문자열 비교
// Program: 이름과 전화번호 입력받고 출력하기

// 2) 파일 입력과 함수, 문자열 비교
public class Code02 {
    public static void main(String args[]) {

        int n = 0;
        String [] names = new String [1000];
        int [] numbers = new int [1000];

        // 입력
        try {
            Scanner sc = new Scanner(new File("input.txt")); // FILE * fp = fopen(...)

            // 파일은 끝이 있으므로 입력 개수 필요 x.
            while(sc.hasNext()) {
                names[n] = sc.next();
                numbers[n] = sc.nextInt();
                n++;
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.print("No file");
            System.exit(1);
        }

        // 인자 전달
        bubbleSort(n, names, numbers);

        for(int i=0; i<n; i++)
            // 출력
            System.out.println("Name: " + names[i] + ", Numbers: " + numbers[i]);
    }

    // 무조건 call-by-value
    // 매개변수에 복사
    static public void bubbleSort(int n, String [] names, int [] numbers)
    {
        for(int i=n-1; i>0; i--) {
            for(int j=0; j<i; j++) {

                // 문자열 비교 함수
                // 1) compareTo
                // "abcd".compareTo("abcd") => 0
                // "abcd".compareTo("ab") => 2
                // "abcd".compareTo("a") => 3
                // "abcd".compareTo("c") => -2
                // "abcd".compareTo("abfd") => -3
                // "abcd".compareTo("ABCD") => 32

                // 2) equals
                // "abcd".equals("abcd") => true
                if(names[j].compareTo(names[j+1]) > 0) {
                    String tmpstr = names[j];
                    names[j] = names[j+1];
                    names[j+1] = tmpstr;

                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
            }
        }
    }
}

