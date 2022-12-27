/*
    추상 클래스
    - 추상(abstract) 메서드는 선언만 있고 구현이 없는 메서드
    - 추상 메서드를 포함한 클래스는 추상 클래스
    - 추상 메서드와 추상 클래스는 키워드 abstract로 표시
    - 추상 클래스는 객체를 만들 수 없음.
    - 따라서 서브 클래스를 만드는 용도로만 사용됨
 */

// 명시적으로 Event class의 object를 만들지 않을 것이다라고 선언하는 것과 같다.
public abstract class Event implements Comparable{
    public String title;
    public Event(String title) {
        this.title = title;
    }

    public abstract boolean isRelevant(MyDate date);
    public abstract MyDate getRepresentativeDate();

    public int compareTo(Object other) {
        MyDate mine = getRepresentativeDate();
        MyDate yours = ((Event)other).getRepresentativeDate();
        return mine.compareTo(yours);
    }
}
