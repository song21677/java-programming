public class Polynomial3 {
    public char name;
    public Term3[] terms;
    public int nTerms = 0;

    // 생성자가 반드시 매개변수를 받아야하는 것은 아니다.
    // 생성자는 객체에게 필요한 초기화 작업을 하기에
    // 배열 terms를 생성하였다.
    public Polynomial3() {
       nTerms = 0;
       terms = new Term3 [100];
    }

    // 생성자는 여러개일 수 있다.
    // char type인 name을 매개변수로 받아 초기화시켜주는 생성자
    public Polynomial3(char name) {
        this.name = name;
        nTerms = 0;
        terms = new Term3 [100];
    }

    public void addTerm(int c, int e) {
        int index = findTerm(e);
        if (index != -1) {
            terms[index].coef += c;
        } else {
            int i = nTerms - 1;
            while (i >= 0 && terms[i].expo < e) {
                terms[i + 1] = terms[i];
                i--;
            }
            // 생성자에서 초기화해주기 때문에 추가적인 코드는 필요 없다.
            terms[i + 1] = new Term3(c, e);
            // terms[i + 1].coef = c;
            // terms[i + 1].expo = e;
            nTerms++;
            System.out.println(terms[i+1].coef + "x^" + terms[i+1].expo);
        }
    }

    public int findTerm(int e) {
        for (int i = 0; i < nTerms && terms[i].expo >= e; i++)
            if (terms[i].expo == e)
                return i;
        return -1;
    }

    public int calcPolynominal(int x) {
        int result = 0;
        for (int i = 0; i < nTerms; i++)
            result += terms[i].calcTerm(x);
        return result;
    }

    public void printPolynominal() {
        for (int i = 0; i < nTerms; i++) {
            terms[i].printTerm();
            System.out.print("+");
        }
        System.out.println();
    }
}
