import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Program
// 데이터 파일(input.txt)로부터 사람들의 이름과 전화번호를 입력받아
// 배열 members에 저장한 후,
// 입력된 순서대로 출력한다.

public class Code03 {
    static Person1 [] members = new Person1[100];
    static int n = 0;
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            while(in.hasNext()) {
                String nm = in.next();
                String nb = in.next();

                // *members 배열 원소들은 Person1 타입이므로 참조(주소)를 저장해야 한다.
                // *따라서, 참조할 이름 없는 Person1 객체를 생성해주고, 그 객체의 주소를 저장한다.
                members[n] = new Person1();
                members[n].name = nm;
                members[n].number = nb;
                n++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file");
        }
        for(int i=0; i<n; i++)
            System.out.println(members[i].name + " " + members[i].number);

    }
}
