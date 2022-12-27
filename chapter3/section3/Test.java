/*
    class Object
    - 클래스 Object는 Java에서 모든 클래스의 superclass이다.
    - class Object의 멤버 메서드
        - Method
            - boolean equals(Object obj): Compares this object to its argument.
            - int hashCode(): Returns an integer hash code value for this object.
            - String toString(): Returns a string that textually represents the objects.
            - Class<?> getClass(): Returns a unique object that identifies the class of this object.

    1) toString()
    - 만약 toString 메서드를 따로 만들어주지 않은 클래스의 객체에 대해서
      toString() 메서드를 호출하면 다음과 같은 String이 반환된다.
      클래스 이름@객체의 hash code

    2) class Class
    - 모든 클래스는 하나의 Class 객체를 가진다.
    - 이 객체는 각각의 클래스에 대해서 유일(unique)하다.
    - 메서드 getClass()는 Object 클래스가 제공하는 메서드이며,
      이 유일한 Class 객체를 반환한다.
    - 앞 페이지의 예에서 만약 this.getCalss() == obj.getClass()가 true라면
      우리는 비교 대상인 두 객체 (this와 obj)가 동일한 클래스의 객체임을 알 수 있다.

    3) Wrapper class
        1) 기본 타입의 데이터를 하나의 객체로 포장해주는 클래스
            - Integer, Double, Character, Boolean 등
                - 다형성에 의해 non-primitive type의 데이터는 super class 객체에 의해 참조될 수 있다.
                  하지만, int, double, char 등의 primitive type 데이터는 객체가 아니므로 저장할 수 없다.
                  때때로 primitive type 데이터를 객체로 만들어야 할 경우가 있는데,
                  이때 Integer, Double, Character 등의 wrapper class를 이용한다.

        2) 데이터 타입간의 변환 기능을 제공
            - 예시
              String str = "1234";
              int d = Integer.parseInt(str);
 */

public class Test {
    public int a = 10;
    public double x = 1.23;

    public String toString()
    {
        return a + " " + x;
    }

//    // Object의 equals method override
//    // 객체의 실내용(x값) 비교
//    public boolean equals(Object other)
//    {
//        // type casting
//        // 다형성으로 인해 Test 객체를 Object로 받을 수 있지만,
//        // Object에는 a와 x 변수가 없으므로 type casting해줘야 한다.
//        Test other2 = (Test)other;
//        return a == other2.a && x == other2.x;
//    }
    public static void main(String[] args) {
        Test test = new Test();
        Test test2 = new Test();
        test2.a = 10;
        test2.x = 1.23;

        // Object의 method
        System.out.println(test.toString());

        // equals method를 override하지 않으면
        //내용이 같더라도 객체가 다르므로 no가 출력된다.
        if(test.equals(test2))
            System.out.println("yes");
        else
            System.out.println("no");

        Object [] array = new Object [100];
        int a = 20;
        // wrapping
        // Integer age = new Integer(a);
        // array[0] = age;

        // autoboxing
        // a는 정수여서 Integer 객체로 wrapping 해줘야한다.
        // 원리로는 다음 코드가 성립하지 않지만, Java 컴파일러가 자동으로 Integer 객체로 변환해준다.
        array[0] = a;

        // aray[0]에 저장된 것은 Integer 타입일지라도
        // 타입변환을 해주지 않으면 컴파일러가 오류로 판정한다.
        // 또한, Java 컴파일러가 자동으로 정수로 변환해준다. (auto unboxing)
        int b = (Integer)array[0];
        // int b = age.intValue();     // unwrapping
        System.out.println(b);

        String str = "1234";
        int c = Integer.parseInt(str);
        System.out.println(c);
    }
}
