/*
    ★ static 멤버의 용도
       - main 메서드
       - 상수 혹은 클래스 당 하나만 유지하고 있으면 되는 값(혹은 객체)
         예: Math.PI, System.out
       - 순수하게 기능만으로 정의되는 메서드. 대표적인 예로는 수학 함수들
 */
public class TestTest {
    // ★ 왜 main 메서드는 반드시 static이어야 하는가?
    // main 메서드는 프로그램의 시작이다.
    // main 메서드가 static이 아니라면 실체가 없다는 의미이므로 프로그램 또한 실행될 수 없다.
    public static void main(String[] args) {
        Test test1 = new Test();
        test1.t = 10;
        // ★ 다른 클래스에 속한 static 멤버는 어떻게 액세스하는가?
        // s는 static 멤버로 객체에 존재하지 않고 클래스에 존재한다.
        // 따라서 직접 클래스에 접근한다.
        // test1.s  = 100;
        Test.s = 100;
        test1.print2();

        // t는 non-static 멤버로 test2는 새로운 객체이기에 초기값인 0이 출력된다.
        Test test2 = new Test();
        Test.print1();
        test2.print2();
    }
}
