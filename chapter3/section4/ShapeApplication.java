/*
    Program
    : 사각형, 원, 직각삼각형 등의 도형들을 입력받아 저장하고
      면적과 둘레 길이를 계산하고 정렬해 보여주는 기능을 가진 Shape 프로그램

    실행 예
    $ add R 1 2
    $ add C 5
    $ show
      1. Rectangle: width is 1, height is 2
      2. Circle: radius is 5
    $ show detail
      1. Rectangle: width is 1, height is 2
          - The area is 2.0
          - The perimeter is 6.0
      2. Circle: radius is 5
          - The area is 78.53981633974483
          - The perimeter is 31.41592653589793
 */
import java.util.Scanner;

public class ShapeApplication {
    private int capacity = 10;
    private Shape [] shapes = new Shape [capacity];
    private int n = 0;
    private Scanner kb = new Scanner(System.in);

    public void processCommand() {
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("add"))
                handleAdd();
            else if(command.equals("show") || command.equals("showdetail"))
                handleShow(command.equals("showdetail"));
            else if(command.equals("sort"))
            // Arrays.sort(shapes, 0, n);
                bubbleSort(shapes, n);
            else if(command.equals("exit"))
                break;
        }
        kb.close();
    }

    private void bubbleSort(MyComparable[] data, int size) {
        for(int i=size-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if(data[j].compareTo(data[j+1]) > 0) {
                    MyComparable tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
    }

//     // 이 정렬 메서드는 오직 Shape 데이터들을 정렬하는 용도로만 사용가능하다.
//     // 즉, generic하지 않다.
//    private void bubbleSort() {
//        for(int i=n-1; i>0; i--) {
//            for(int j=0; j<i; j++) {
//                if(shapes[j].computerArea() > shapes[j+1].computerArea()) {
//                    Shape tmp = shapes[j];
//                    shapes[j] = shapes[j+1];
//                    shapes[j+1] = tmp;
//                }
//            }
//        }
//    }

    private void handleShow(boolean detailed) {
        for (int i=0; i<n; i++) {
            System.out.println((i + 1) + ". " + shapes[i].toString());
            if (detailed) {
                System.out.println("    The area is " + shapes[i].computerArea());
                System.out.println("    The perimeter is " + shapes[i].computerPerimeter());
            }
        }
    }
    private void handleAdd() {
        String type = kb.next();
        switch(type) {
            case "R":
                addShape(new Rectangle(kb.nextInt(), kb.nextInt()));
                break;
            case "C":
                addShape(new Circle(kb.nextInt()));
                break;
            case "T":
                // omitted
        }
    }

    private void addShape(Shape shape) {
        if(n >= capacity)
            reallocate();
        shapes[n++] = shape;
    }

    private void reallocate() {
        capacity *= 2;
        Shape[] tmp = new Shape[capacity];
        System.arraycopy(shapes, 0, tmp, 0, shapes.length);
        shapes = tmp;
    }

    public static void main(String[] args) {
        ShapeApplication app = new ShapeApplication();
        app.processCommand();
    }
}
