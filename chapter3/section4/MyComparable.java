/*
    인터페이스
    - 추상 메서드만을 가진 순수한 추상 클래스
    - static final 데이터 멤버(상수)를 가질 수 있음
    - 예시
        public interface Payable {
            public double calcSalary();
            public boolean salaried();
            public static final double DEDUCTIONS = 25.5;
        }

        * Payable 인터페이스를 구현(implements)하는 클래스는
          메서드 calcSalary와 salaried를 실제로 구현해야 한다.
        public class Professor implements Payable {
            ...
            public boolean calcSalary(){ .... }
            public boolean salaried(){ .... }
        }

    추상 메서드로만 구성된 추상 클래스는 인터페이스와 완전히 동일한가?
    - 완벽하게 같지는 않다.
    - 추상 클래스와 달리 인터페이스는 다중 상속이 가능하다.

    다중 상속(multiple inheritance)
    - Java에서는 다중 상속을 허용하지 않는다.
    - 하지만 하나의 클래스가 여러 개의 Interface를 implement하는 것은 가능
 */

public interface MyComparable {
    public int compareTo(Object o);
}
