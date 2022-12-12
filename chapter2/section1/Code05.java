import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Program
// 평면상에 좌표축에 평행한 n개의 직사각형에 관한 데이터(data.txt)를 입력 받은 후
// 면적이 작은 것부터 큰 것 순으로 정렬하여 출력한다.

public class Code05 {

    static MyRectangle1 [] rects = new MyRectangle1 [100];
    static int n=0;

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("data.txt"));
            while(in.hasNext()) {
                rects[n] = new MyRectangle1();
                rects[n].lu = new MyPoint1();
                rects[n].lu.x = in.nextInt();
                rects[n].lu.y = in.nextInt();
                rects[n].width = in.nextInt();
                rects[n].height = in.nextInt();
                n++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file.");
            System.exit(1);
        }
        bubbleSort();

        for(int i=0; i<n; i++)
            System.out.println(rects[i].lu.x + " " + rects[i].lu.y + " " + rects[i].width + " " + rects[i].height);
    }

    private static void bubbleSort() {
        for(int i = n-1; i>=0; i--) {
            for(int j=0; j<i; j++) {
                if(calcArea(rects[j]) > calcArea(rects[j+1])) {
                    MyRectangle1 tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }
            }
        }
    }

    public static int calcArea(MyRectangle1 r) {
        return r.width * r.height;
    }
}
