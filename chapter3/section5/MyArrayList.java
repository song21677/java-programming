/*
    제네릭 프로그래밍(Generic programming)은 데이터 형식에 의존하지 않고,
    하나의 값이 여러 다른 데이터 타입들을 가질 수 있는 기술에 중점을 두어
    재사용성을 높일 수 있는 프로그래밍 방식이다.

    Generic한 변수/자료구조
    - Event ev;
    - Event [] events = new Event[capacity];
    - Object obj;

    Generic한 알고리즘(method)
    - Arrays.sort(shapes, 0, n);

    Generic 클래스
    - Generics

    T라는 가상의 타입에 의해서 parameterized된 클래스
    객체를 생성하는 시점에 가상의 타입 T를 실제하는 타입으로 지정해준다.

    2개 이상의 type parameter를 가질수도 있다.
    객체를 생성하는 시점에 가상의 타입 K와 V를 실제하는 타입으로 지정해준다.

    Program
    : Generic한 리스트 클래스를 만들기(ArrayList의 축소판)
    리스트(list)
    - 여러 개의 데이터를 저장하고,
      임의의 위치에 새로운 데이터를 추가하거나
      데이터의 삭제가 가능하고
      임의의 위치의 데이터를 읽을 수 있고,
      용량에 제한이 없고,
      ...
 */

/*
    Java API java.util은 Vector와 ArrayList라는 두 가지 유사한 기능의 클래스를 제공
    Vector보다 ArrayList가 좀 더 효율적이며 주로 사용됨
    ArrayList와는 달리 Vector 클래스는 synchronized됨, 즉 다수의 thread가 충돌없이 Vector 객체를 액세스 할 수 있음
    CopyOnWriteArrayList 클래스
 */

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int INIT_CAPACITY = 10;
    private E [] theData;
    private int size;
    private int capacity = INIT_CAPACITY;

    public MyArrayList() {
        theData = (E []) new Object [INIT_CAPACITY];
        size = 0;
    }

    public void add(int index, E anEntry) {
        if(index<0 || index>size) // error or exception
            throw new ArrayIndexOutOfBoundsException(index);
        if(size >= capacity)
            reallocate();
        for(int i=size-1; i>=index; i--)
            theData[i+1] = theData[i];
        theData[index] = anEntry;
        size++;
    }

    private void reallocate() {
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }

    public void add(E enEntry) {
        add(size, enEntry);
    }

    public E get (int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    public E set (int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    public E remove (int index) {
        if (index<0 || index>=size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for(int i=index+1; i<size; i++) {
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }
    public int size()
    {
        return size;
    }

    public int indexOf( E anEntry ) {
        for (int i=0; i<size; i++)
            if (theData[i].equals(anEntry))
                return i;
        return -1;
    }
    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<>();

        // Exception handling
        try {
            test.add(1, "Hello");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("----------");
        }

        System.out.println("**********");
    }
}
