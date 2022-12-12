public class Code02 {
    public static void main(String[] args) {
        Person1 first;
        first = new Person1();

        first.name = "John";
        first.number = "01012345678";

        System.out.println("Name: " + first.name + ", Number: " + first.number);

        // first와 second는 동일한 객체를 참조하게 된다.
        Person1 second = first;
        // Name: John, Number: 01012345678 출력
        System.out.println("Name: " + second.name + ", Number: " + second.number);

        second.name = "Tom";
        // Name: Tom, Number: 01012345678 출력
        System.out.println("Name: " + first.name + ", Number: " + first.number);

        // *Person1은 프리미티브 타입이 아니므로, members 배열의 각 칸은 Person1 타입의 참조변수이다.
        Person1 [] members = new Person1 [100];
        members[0] = first;
        members[1] = second;
        // Name: Tom, Number: 01012345678 출력
        System.out.println("Name: " + members[0].name + ", Number: " + members[0].number);
        // Name: Tom, Number: 01012345678 출력
        System.out.println("Name: " + members[1].name + ", Number: " + members[1].number);

        members[2] = new Person1();
        // 위 코드를 써주지 않으면, NullPointerException이 발생한다.
        // *객체를 생성하지 않으면, 참조변수에는 null이 들어가기 때문에!
        members[2].name = "David";
        members[2].number = "01023456789";
        // Name: David, Number: 01023456789 출력
        System.out.println("Name: " + members[2].name + ", Number: " + members[2].number);

    }
}
