// 모든 프리미티브 타입의 변수는 보통 변수로, 변수 자체에 값이 저장된다.
// 프리미티브 타입이 아닌 모든 변수는 참조 변수로,
// 실제 데이터가 저장될 "객체"는 new 명령으로 따로 만들어야 하고,
// 참조변수에는 그 객체의 주소를 저장한다.

public class Code01 {
    public static void main(String[] args) {
        // Person1은 프리미티브 타입이 아니므로,
        // first라는 이름의 변수는 참조 변수이다.
        // 변수를 선언하면, 아직 객체는 생성되지 않고 변수 first만 만들어진다.
        // 이때 이 변수의 값은 null이다.
        Person1 first;

        // new Person1()명령에 의해 이름 없는 "Person1 객체"가 만들어지고
        // first에 그 주소를 저장한다.
        first = new Person1(); // object

        // first가 가리키고 있는 Person1 타입의 객체의 name과
        // number라는 이름의 필드에 각각 데이터를 저장한다.
        first.name = "John";
        first.number = "01012345678";

        // Name: John, Number: 01012345678 출력
        System.out.println("Name: " + first.name + ", Number: " + first.number);

        Person1 [] members = new Person1 [100];
        members[0] = first;
        members[1] = new Person1();
        members[1].name = "David";
        members[1].number = "01023456789";
    }
}
