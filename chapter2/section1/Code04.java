import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Program
// Code03에서 사전순으로 정렬하여 출력한다.

public class Code04 {
    static Person1 [] members = new Person1[100];;
    static int n = 0;
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            while(in.hasNext()) {
                String nm = in.next();
                String nb = in.next();

                members[n] = new Person1();
                members[n].name = nm;
                members[n].number = nb;
                n++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file");
        }
        bubbleSort();
        for(int i=0; i<n; i++)
            System.out.println(members[i].name + " " + members[i].number);

    }
    private static void bubbleSort() {
        for (int i=n-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if(members[j].name.compareTo(members[j+1].name) > 0) {  // compare names of j-th and (j+1)-th person
                    // swap two persons
                    // 이름과 전화번호를 각각 안바꿔줘도 된다.
                    // *참조하는 대상만 바꿔주면 된다.
                    Person1 tmp = members[j];
                    members[j] = members[j+1];
                    members[j+1] = tmp;

                    // 클래스를 만들지 않았다면?
//                    String tmpstr = names[j];
//                    names[j] = names[j+1];
//                    names[j+1] = tmpstr;
//
//                    int tmp = numbers[j];
//                    numbers[j] = numbers[j+1];
//                    numbers[j+1] = tmp;
                }
            }
        }
    }
}
