public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle(int w, int h) {
        super("Rectangle");
        width = w;
        height = h;
    }

    // 추상 클래스의 computerArea를 구현
    // 함부로 return type을 바꿔선 안된다.
    // 추상 클래스의 computerArea는 직사각형, 원 등 모두 커버해야 하므로
    // double 반환형을 가져야 한다.
    public double computerArea() {
        // 결과 값이 int이므로 double로 type 변환해줘야 한다.
        return (double)width*height;
    }

    public double computerPerimeter() {
        return 2.0*(width + height);
    }

    public String toString() {
        return "Rectangle: width is " + width + ", height is " + height;
    }
}
