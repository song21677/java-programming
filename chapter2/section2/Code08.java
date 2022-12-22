/*
    Program:
    앞에서 작성한 다항식 프로그램을 수정된 class Term3과
    class Polynomial3을 사용하도록 변경한 프로그램
 */

import java.util.Scanner;

public class Code08 {
    static Polynomial3[] polys = new Polynomial3[100];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("create")) {
                char name = kb.next().charAt(0);
                polys[n] = new Polynomial3(name);
                // 생성자에서 name을 초기화하고,
                // Term2 객체를 생성해줬기 때문에 다음 코드는 필요 없다.
                // polys[n].name = name;
                // polys[n].terms = new Term2[100];
                n++;
            } else if (command.equals("add")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                } else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();
                    polys[index].addTerm(c, e);
                }
            } else if (command.equals("calc")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynominal exists.");
                } else {
                    int x = kb.nextInt();
                    int result = polys[index].calcPolynominal(x);
                    System.out.println(result);
                }
            } else if (command.equals("print")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynominal exists.");
                } else {
                    polys[index].printPolynominal();
                }
            } else if (command.equals("exit"))
                break;
        }
        kb.close();
    }

    private static int find(char name) {
        for (int i = 0; i < n; i++)
            if (polys[i].name == name)
                return i;
        return -1;
    }
}
