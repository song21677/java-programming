/*
    클래스는 타입이며, 실체가 아니다.
    따라서 클래스의 데이터 필드에 데이터를 저장할 수는 없고,
    클래스의 멤버 메서드를 실행할 수도 없다.

    new 명령으로 해당 클래스 타입의 객체를 만든 후,
    그 객체에 데이터를 저장하고, 그 객체의 멤버 메서드를 실행하는 것이다.

    여기에는 하나의 예외가 존재하는데 그것이 static 멤버이다.

    non-static vs static
    - non-static 멤버:
      클래스 안에 존재하지 않으며 객체에는 존재한다.
    - static 멤버:
      클래스 안에 실제로 존재하며 객체에는 존재하지 않는다.
 */
public class Test {
    static int s = 0;
    int t = 0;

    public static void print1()
    {
        System.out.println("s = " + s);
        // ★ 왜 static 메서드에서 같은 클래스의 non-static 멤버를 액세스 할 수 없는가?
        // 객체를 생성하기 전엔 실체가 없으므로 접근할 수 없다.
        // System.out.println("t = " + t);
    }

    // print2 함수는 t와 같이 non-static으로 객체를 생성해야 접근할 수 있다.
    // 따라서 객체를 생성한 뒤 호출되는 print2 함수는 t에 접근할 수 있다.
    public void print2()
    {
        System.out.println("s = " + s);
        System.out.println("t = " + t);
    }

    public static void main(String []args)
    {
        s = 100;
        // t = 100;
        print1();
        // print2();

        Test test1 = new Test();
        test1.t = 100;
        test1.print2();
    }
}
