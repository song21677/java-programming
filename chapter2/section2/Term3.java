/*
    생성자:
        - 클래스와 동일한 이름을 가지며 return 타입이 없는 메서드
          객체를 생성할 때 자동으로 실행된다.
        - new 명령으로 객체가 생성될 때 자동으로 실행된다.
        - 주 목적은 객체의 데이터 필드의 값을 초기화하는 것이다.
 */

public class Term3 {
    public int coef;
    public int expo;

    // Term3의 생성자로 객체의 데이터 필드 값을 초기화시킨다.
    public Term3(int c, int e) {
        coef = c;
        expo = e;
    }

    public int calcTerm(int x) {
        return (int) (coef * Math.pow(x, expo));
    }

    public void printTerm() {
        System.out.print(coef + "x^" + expo);
    }
}
