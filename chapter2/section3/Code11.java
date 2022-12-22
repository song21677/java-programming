/*
    Program:
    앞에서 작성한 다항식 프로그램을
    오직 main 메서드만 static이 되도록 수정하고
    모든 데이터 멤버를 private로 바꾼 후, public 멤버를 최소화한 프로그램
 */

/*
    access modifier
    - public: 클래스 외부에서 접근이 가능하다.
    - private: 클래스 내부에서만 접근이 가능하다.
    - default: 동일 패키지에 있는 다른 클래스에서 접근 가능하다.
    - protected: 동일 패키지의 다른 클래스와 다른 패키지의 하위클래스에서도 접근 가능하다.

    데이터 캡슐화
    - 모든 데이터 멤버를 private으로 만들고 필요한 경우에 public한 get/set 메서드를 제공한다.
    - 이렇게 하면 객체가 제공해주는 메서드를 통하지 않고서는 객체 내부의 데이터에 접근할 수가 없다.
    - 이것을 data encapsulation, information hiding, abstract data type이라고 부른다.
 */

import java.util.Scanner;

public class Code11 {
    private Polynomial3[] polys = new Polynomial3[100];
    private int n = 0;

    public void processCommand()
    {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("create")) {
                char name = kb.next().charAt(0);
                polys[n] = new Polynomial3(name);
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

    private int find(char name) {
        for (int i = 0; i < n; i++)
            if (polys[i].getName() == name)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Code11 app = new Code11();
        app.processCommand();
    }
}