/*
    Computer가 가지고 있는 데이터 멤버를 그대로 가지고 있고
    screenSize와 weight를 추가적으로 가지고 있는 Notebook 클래스

    IS-A 관계: A Notebook is a Computer
    super/base/parent) class: Computer
    sub/extended/child class: Notebook

   'extends super class'를 사용하면 super class의 모든 멤버(데이터, 함수)들을 상속 받는다.
 */
public class Notebook extends Computer {
    public double screenSize;
    public double weight;

    public Notebook( String man, String proc, int ram, int disk, double speed, double screen, double weight) {
        /*
            모든 서브 클래스의 생성자는 먼저 수퍼클래스의 생성자를 호출한다.
                1. super(...)를 통해 명시적으로 호출해 주거나,
                2. 그렇지 않을 경우에는 자동으로 no-parameter 생성자가 호출된다.

            흔한 오류:
                슈퍼클래스에 no-parameter 생성자가 없는데, 서브클래스의 생성자에서
                super(...) 호출을 안해주는 경우

                아래 코드를 추가하지 않으면, Computer에 default constructor가 없기에
                다음과 같은 에러가 발생한다.
                There is no default constructor available in 'Computer'.
         */
        super(man, proc, ram, disk, speed);

        // Computer의 default constructor이 생성되어 초기화를 해줘야 할 경우
//        manufacturer = man;
//        processor = proc;
//        ramSize = ram;
//        diskSize = disk;
//        processorSpeed = speed;
        screenSize = screen;
        this.weight = weight;
    }

    // Computer의 toString() 메서드를 override한 Notebook의 toString() 메서드.
    public String toString() {
        String result = super.toString() +
                "\nScreen Size: " + screenSize + " inches" +
                "\nWeight: " + weight + " kg";
        return result;
    }

    public static void main(String [] args) {
        /*
            ★★★ 다형성(Polymorphism):
            super class type의 변수가 sub class type의 객체를 참조할 수 있다.
            (다형성은 strong typing의 원리를 깨는 객체의 특징이다.)

            strong typing의 원리:
            변수의 타입과 실제로 저장되는 타입은 같아야 된다.
         */

        Computer test = new Notebook("Dell", "i5", 4, 1000, 3.2, 15.6, 1.2);
        // Notebook test2 = new Computer(...); (x)

//        Notebook의 default constructor가 실행될 경우
//        test.manufacturer = "Dell";
//        test.processor = "i5";
//        test.ramSize = 4;
//        test.diskSize = 1000;
//        test.processorSpeed = 3.2;
//        test.screenSize = 15.6;
//        test.weight = 1.2;

        System.out.println(test.computerPower());

        /*
            ★★ 누구의 toString 함수가 호출될까? java에서는 dynamic binding!

            static binding vs.dynamic binding
            static: super class
            dynamic: sub class
         */

        System.out.println(test.toString());
    }
}
