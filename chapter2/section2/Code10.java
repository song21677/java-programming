import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
   Program:
   입력으로 하나의 직교 다각형(모든 변이 x-축 혹은 y-축과 평행한 다각형)과
   또 하나의 점 P가 주어질 때 그 점이 다각형의 내부에 있는지 외부에 있는지 판단하는 프로그램

   입력 형식
   8        // 꼭짓점의 개수
   0 0      // 첫 번째 꼭짓점의 x및 y좌표
   16 0     // 두 번째 꼭짓점의 x및 y좌표
   16 18    // ,,,
   10 18
   10 6     // 꼭짓점들은 시계방향 순서로
   6 6      // 제공된다.
   6 12
   0 12     // 마지막 꼭짓점의 x및 y좌표
   7 7      // 테스트할 점 p의 좌표

   문제를 단순화하기 위해서 점 p는 다각형의 경계상에 있지 않고,
   또한 다각형에는 p와 동일한 x혹은 y좌표를 가진 꼭짓점은 없다고 가정한다.
   (꼭짓점의 좌표값은 모두 짝수, 검사할 점 p의 좌표값은 홀수로 가정한다.)
 */
public class Code10 {
   public static void main(String [] args) {
       try {
           Scanner in = new Scanner(new File("data2.txt"));
           int n = in.nextInt();
           OrthoPolygon thePolygon = new OrthoPolygon(n);
           for (int i=0; i<n; i++)
               thePolygon.addVertex(in.nextInt(), in.nextInt());
           MyPoint2 thePoint = new MyPoint2(in.nextInt(), in.nextInt());
           in.close();
           if(thePolygon.contains(thePoint))
               System.out.println("Yes");
           else
               System.out.println("No");
       } catch (FileNotFoundException e) {
           System.out.println("No data file exists.");
           System.exit(1);
       }
   }
}
