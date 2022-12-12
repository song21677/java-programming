import java.util.Scanner;

// Program
// $ create f   다항함수 f=0을 정의한다.
// $ add f 2 3  f(x)에 2x^3을 더한다. 따라서 f(x)=2x^3이 된다.
// $ add f -1 1 f(x)=2x^3-x이 된다.
// $ add f 5 0  f(x)=2x^3-x+5이 된다.
// $ add f 2 1  f(x)=2x^3-x+5+2x=2x^3+x+5이 된다.
// $ calc f 2   x=2일 때 다항함수 f의 값, 즉 f(2)=23을 계산하여 출력한다.
// 23
// $ print f    차수에 관한 내림차순으로 정렬하여 다음과 같이 출력한다.
// 2x^3+x+5     동일한 차수의 항은 하나로 합쳐져야 한다.
// $ create g   다른 다항 함수 g를 정의한다.
// ....
// $ exit

public class Code06 {
    static Polynomial [] polys = new Polynomial [100];
    static int n = 0;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("create")) {
                // 문자 입력받기
                char name = kb.next().charAt(0);
                polys[n] = new Polynomial();
                polys[n].name = name;
                polys[n].terms = new Term [100];
                n++;
            }
            else if(command.equals("add")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();
                    addTerm(polys[index], c, e);
                }
            }
            else if(command.equals("calc")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynominal exists.");
                }
                else {
                    int x = kb.nextInt();
                    int result = calcPolynominal(polys[index], x);
                    System.out.println(result);
                }
            }
            else if(command.equals("print")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynominal exists.");
                }
                else {
                    printPolynominal(polys[index]);
                }
            }
            else if(command.equals("exit"))
                break;
        }
        kb.close();
    }

    private static int calcPolynominal(Polynomial p, int x) {
        int result = 0;
        for(int i=0; i<p.nTerms; i++)
            result += calcTerm(p.terms[i], x);
        return result;
    }

    private static int calcTerm(Term term, int x) {
        return (int) (term.coef * Math.pow(x, term.expo));
    }

    private static void printPolynominal(Polynomial p) {
        for (int i=0; i<p.nTerms; i++) {
            printTerm(p.terms[i]);
            System.out.print("+");
        }
        System.out.println();
    }

    private static void printTerm(Term term) {
        System.out.print(term.coef + "x^" + term.expo);
    }

    private static void addTerm(Polynomial p, int c, int e) {
        int index = findTerm(p, e);
        if(index != -1) {
            p.terms[index].coef += c;
        } else {
            int i = p.nTerms-1;
            // 들어갈 위치 찾기(exponent가 더 낮은 term들은 뒤로 밀기)
            while(i>=0 && p.terms[i].expo<e) {
                p.terms[i+1] = p.terms[i];
                i--;
            }
            p.terms[i+1] = new Term();
            p.terms[i+1].coef = c;
            p.terms[i+1].expo = e;
            p.nTerms++;
        }
    }
    private static int find(char name) {
        for(int i=0; i<n; i++)
            if(polys[i].name == name)
                return i;
        return -1;
    }

    private static int findTerm(Polynomial p, int e) {
        // 내림차순으로 정렬되어 있으므로 exponent가 e보다 작은 term은 볼 필요가 없다.
        for (int i=0; i<p.nTerms && p.terms[i].expo >= e; i++)
            if(p.terms[i].expo == e)
                return i;
        return -1;
    }
}
