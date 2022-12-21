/*
    Program:
    Code06을 관련된 데이터와 메서드를 묶은
    class Term2와 class Polynomial2를 사용하도록 변경한 프로그램
 */

/*
    객체:
    - "데이터" + "메서드"이다.
    - 데이터는 객체의 "정적 속성"을 표현하며, 메서드는 객체의 "기능(동적 속성)"을 표현한다.
    - 하나의 항(term)은 "계수와 차수"라는 정적 속성과 "x의 값을 주면 자신의 값을 계산해 준다",
      "화면에 출력해 준다"등의 기능을 가진다.
 */

import java.util.Scanner;

public class Code07 {
    static Polynomial2[] polys = new Polynomial2[100];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("create")) {
                // 문자 입력받기
                char name = kb.next().charAt(0);
                polys[n] = new Polynomial2();
                polys[n].name = name;


                polys[n].terms = new Term2[100];
                n++;
            } else if (command.equals("add")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                } else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();

                    // addTerm은 polys 객체에 속한 함수이다.
                    polys[index].addTerm(c, e);
                }
            } else if (command.equals("calc")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynominal exists.");
                } else {
                    int x = kb.nextInt();
                    //  calcPolynominal은 polys 객체에 속한 함수이다.
                    int result = polys[index].calcPolynominal(x);
                    System.out.println(result);
                }
            } else if (command.equals("print")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynominal exists.");
                } else {
                    // printPolynominal은 polys 객체에 속한 함수이다.
                    polys[index].printPolynominal();
                }
            } else if (command.equals("exit"))
                break;
        }
        kb.close();
    }

    // find는 하나의 항과 다항식에 관련성이 떨어진다.
    private static int find(char name) {
        for (int i = 0; i < n; i++)
            if (polys[i].name == name)
                return i;
        return -1;
    }
}
