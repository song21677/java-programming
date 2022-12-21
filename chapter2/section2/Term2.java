/*
    클래스는 서로 관련있는 데이터들 뿐 아니라, 그 데이터와 관련이 깊은 메서드를
    하나의 단위로 묶어두기 위한 것이다.

    이렇게 함으로써 코드의 응집도(cohesion)를 높이고 결합도(coupling)를 낮출 수 있다.

    하나의 항을 출력하고 계산하는 printTerm과 calcTerm은 class Term과 매우 연관되어 있다.
    이렇게 서로 관련성이 깊은 데이터와 메서드들을 하나의 클래스로 묶어둘 수 있다.
 */

public class Term2 {
    public int coef;
    public int expo;

    // calcTerm은 어떤 Term의 일부분이며 "자기 자신"의 값을 계산하여 반환한다.
    // 따라서 매개변수로 어떤 항을 받을 필요 없다.
    public int calcTerm(int x) {
        return (int) (coef * Math.pow(x, expo));
    }

    // printTerm은 어떤 Term의 일부분이며 "자기 자신"을 출력하는 기능을 수행한다.
    // 따라서 매개변수로 어떤 항을 받을 필요 없다.
    public void printTerm() {
        System.out.print(coef + "x^" + expo);
    }
}
